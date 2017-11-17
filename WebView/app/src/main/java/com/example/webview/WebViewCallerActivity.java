package com.example.webview;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class WebViewCallerActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edturl;
    Button btnIr;
    Button btnIr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_caller);
        edturl = (EditText) findViewById(R.id.edtBuscar);
        btnIr = (Button) findViewById(R.id.btnBuscar);
        btnIr.setOnClickListener(this);
        btnIr2 = (Button) findViewById(R.id.btnIr2);
        btnIr2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btnIr)
        {
            try {
                openWebPage(edturl.getText().toString());
            }catch (Exception e)
            {
                Toast.makeText(this, "Error",Toast.LENGTH_SHORT);
            }
        }
        if(view ==btnIr2)
        {
            try {
                openWebActivity(edturl.getText().toString());
            }catch (Exception e)
            {
                Toast.makeText(this, "Error",Toast.LENGTH_SHORT);
            }
        }
    }
    public void openWebActivity(String url)
    {

        Bundle bld = new Bundle();
        bld.putString("url",url);
        Intent intent = new Intent(this,WebViewShow.class);
        intent.putExtra("url",bld);
        startActivity(intent);
    }
    public void openWebPage(String url) {
       // if(url.substring(0,7).equals("http://")||url.substring(0,8).equals("https://")){
        try{
            URL dir = new URL(url);
            Uri webpage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        catch (Exception e)
        {            Toast.makeText(this, "URL incorrectamente construida, no se expecifica protocolo",Toast.LENGTH_SHORT);
        }


        }
    }

