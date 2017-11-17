package com.example.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewShow extends AppCompatActivity {

    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_show);
        webview =(WebView)findViewById(R.id.webView);
      String stg = getIntent().getExtras().getString("url");
        webview.loadUrl(getIntent().getExtras().getString("url").toString());

    }
}
