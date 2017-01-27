package com.androidfragments.web;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Himanshu on 1/27/2017.
 */

public class OpenWebView {

    public void open(WebView view, String url){
        view.loadUrl(url);
    }


}
