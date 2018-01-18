package com.example.usuario.chronometro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class ReverseChronometer extends TextView implements Runnable
{
    private long overallDuration,warningDuration,startTime;

    public ReverseChronometer(Context context, @Nullable AttributeSet attributes) {
        super(context,attributes);
        TypedArray atribute=getContext().obtainStyledAttributes(attributes,R.styleable.ReverseChronometer);
        overallDuration=atribute.getInteger(R.styleable.ReverseChronometer_overallduration,60);
        warningDuration=atribute.getInteger(R.styleable.ReverseChronometer_warningduration,10);
        setText("Valor inicial: "+overallDuration);
        reset();
    }

    public void setOverallDuration(long overallDuration)
    {
        this.overallDuration=overallDuration;
    }
    public void setWarningDuration(long warningDuration)
    {
        this.warningDuration=warningDuration;
    }
    public void reset()
    {
        startTime= SystemClock.elapsedRealtime();
        setText("--:--");
        setTextColor(Color.BLACK);
    }
    @Override
    public void run(){
            long elapseSeconds=(SystemClock.elapsedRealtime()-startTime)/1000;
            if(elapseSeconds<overallDuration)
            {
                //Actualizar los tiempos
                long remainingSecond=overallDuration-elapseSeconds;
                long minutes=remainingSecond/60;
                long seconds= remainingSecond%60;
                setText(String.format("%d:%02d",minutes,seconds));

                //En el caso que no encontremos en tiempo de warning
                if(remainingSecond<warningDuration)
                {
                    setTextColor(Color.RED);
                }

                postDelayed(this,1000);
            }else{
                setText("00:00");
                setTextColor(Color.BLACK);
            }
    }

    public void stop() {
        removeCallbacks(this);
    }
}
