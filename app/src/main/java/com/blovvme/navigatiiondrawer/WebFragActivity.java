package com.blovvme.navigatiiondrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Blovvme on 8/6/17.
 */

public class WebFragActivity extends Fragment {

    EditText et;
    Button btn;
    WebView webView;
    String url = "https://google.com";

    @Nullable
    @Override
    //Borrar @Nullable que esta dentro de la funcion onCreateView
    //OnCreate if different on Fragments its gotta be writen like this
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webfrag, container, false);

//        et = (EditText) view.findViewById(R.id.et);
//        search = (Button) view.findViewById(R.id.search);
//        reset = (Button) view.findViewById(R.id.reset);
        btn = (Button) view.findViewById(R.id.btn);
        webView = (WebView) view.findViewById(R.id.webView);
       webView.setWebViewClient(new WebViewClient());

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl(url);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(url);
            }
        });


     return view;
    }

    private class MyWebViewClient extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            return true;
        }
    }

}//last key
