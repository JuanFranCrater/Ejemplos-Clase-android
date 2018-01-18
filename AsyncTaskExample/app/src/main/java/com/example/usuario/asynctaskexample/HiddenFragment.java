package com.example.usuario.asynctaskexample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import java.util.Random;

/**
 * Created by usuario on 17/01/18.
 */

public class HiddenFragment extends Fragment {

    private TaskCallbacks mCallback;
    public static final int MAX_LENGHT=2000;
    private int[] number= new int[MAX_LENGHT];
    ProgressBarTask task;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        generateNumbers();
        //Se inica la tarea
        task= new ProgressBarTask();
        task.execute();
    }

    @Override
    public void onAttach(Activity activity) {
        mCallback= (TaskCallbacks) activity;
        super.onAttach(activity);
    }

    public void cancel()
    {
        task.cancel(true);
    }

    interface TaskCallbacks
    {
        void onPreExecute();
        void onProgressUpdate(int i);
        void onCancelled();
        void onPostExecuted();
    }
    private void generateNumbers() {
        Random random=new Random();
        for(int i=0;i<MAX_LENGHT;i++)
        {
            number[i]=random.nextInt();
        }
    }

    public class ProgressBarTask extends AsyncTask<Void,Integer,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            int aux;
            for (int i=0;i<number.length-1;i++)
            {
                for(int j=i+1;j<number.length-1;j++)
                {
                    if(number[i]>number[j])
                    {
                        aux=number[i];
                        number[i]=number[j];
                        number[j]=aux;
                    }
                    if (!isCancelled())
                    {
                        publishProgress(i);
                    }else {break;}
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(mCallback!=null)
                mCallback.onPostExecuted();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(mCallback!=null)
                mCallback.onPreExecute();
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(mCallback!=null)
                mCallback.onProgressUpdate( values[0]);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            if(mCallback!=null)
                mCallback.onCancelled();
        }


    }
}
