package com.example.usuario.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.Chronometer;

/**
 * Created by usuario on 16/02/18.
 */

public class BoundService extends Service {

    private Chronometer chronometer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        chronometer.start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        chronometer.stop();
    }

    @Override
    public void onCreate() {
        chronometer=new Chronometer(this);
        chronometer.setBase(SystemClock.elapsedRealtime());

    }

    //El servicio ofrece la hora actual a una Actividad
    public String getTimestamp()
    {
        long elapsedMillis=SystemClock.elapsedRealtime()-chronometer.getBase();
        int hour = (int)(elapsedMillis/3600000);
        int minutes =  (int) (elapsedMillis-hour*3600000)/60000;
        int seconds =(int) (elapsedMillis-hour*3600000-minutes*60000)/1000;
        int millis=(int)(elapsedMillis-hour*3600000-minutes*60000-seconds*1000);
        return  hour+":"+minutes+":"+minutes+":"+seconds+":"+millis;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

}
