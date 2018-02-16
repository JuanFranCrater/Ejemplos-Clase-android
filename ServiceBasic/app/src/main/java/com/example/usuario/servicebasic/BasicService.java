package com.example.usuario.servicebasic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by usuario on 16/02/18.
 * Un servicio no debe tener interaccion con la vista
 * Se comunica con la activity -> La activity responde
 */

public class BasicService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Servicio DESTRUIDO",Toast.LENGTH_LONG).show();

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"Servicio INICIADO",Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
}
