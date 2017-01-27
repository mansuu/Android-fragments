package com.androidfragments.fragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.androidfragments.R;
import com.androidfragments.web.OpenWebView;

public class WebFragment extends Fragment {
private WebView web_view;
    private OpenWebView opneWebView ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_web, container, false);
        web_view=(WebView)view.findViewById(R.id.web_view);
        opneWebView=new OpenWebView();
        opneWebView.open(web_view,"http://www.google.co.in");
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
