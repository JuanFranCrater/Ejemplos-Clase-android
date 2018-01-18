package com.example.usuario.asynctaskexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by usuario on 17/01/18.
 */

public class HiddenActivity extends AppCompatActivity implements HiddenFragment.TaskCallbacks {

    Button btnSort,btnCancel;
    ProgressBar progressBar;
    TextView textView;
    HiddenFragment fragment;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSort=findViewById(R.id.btnSort);
        textView=findViewById(R.id.txtMessage);
        btnCancel=findViewById(R.id.btnCancel);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setMax(HiddenFragment.MAX_LENGHT);
        fm=getFragmentManager();
        if(fm.findFragmentByTag("tag")!=null)
        {
            fragment = (HiddenFragment) fm.findFragmentByTag("tag");
        }
    }


    public void onClickSort(View view)
    {
        ft= fm.beginTransaction();
        fragment=new HiddenFragment();
        ft.add(fragment,"tag");
        ft.commit();
    }

    public void onClickCancel(View view)
    {
        fragment.cancel();
        fm.popBackStack();
    }

    @Override
    public void onPreExecute() {
        btnCancel.setVisibility(View.VISIBLE);
        btnSort.setEnabled(false);
        Toast.makeText(this,"Inicio",Toast.LENGTH_SHORT).show();
        textView.setText("Operacion Iniciada");
    }

    @Override
    public void onProgressUpdate(int i) {
        progressBar.setProgress(i);
        btnCancel.setVisibility(View.VISIBLE);
        btnSort.setEnabled(false);
    }

    @Override
    public void onCancelled() {
        btnCancel.setVisibility(View.INVISIBLE);
        btnSort.setEnabled(true);
        textView.setText("Operacion Cancelada");
        Toast.makeText(this,"Cancelada",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostExecuted() {
        btnCancel.setVisibility(View.INVISIBLE);
        btnSort.setEnabled(true);
        fm.popBackStack();
        textView.setText("Operacion Terminada");
        Toast.makeText(this,"Terminada",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragment=null;
    }
}
