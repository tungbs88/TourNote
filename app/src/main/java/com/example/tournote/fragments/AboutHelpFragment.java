package com.example.tournote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;

import com.example.tournote.R;

public class AboutHelpFragment extends WebViewFragment {
    private static final String ARG_URL = "url";

    private String mUrl;

    public AboutHelpFragment() {
        // Required empty public constructor
    }

    public static AboutHelpFragment newInstance(String url) {
        AboutHelpFragment fragment = new AboutHelpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    // Nhận dữ liệu truyền vào
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrl = getArguments().getString(ARG_URL);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().loadUrl(mUrl);
        return view;
    }
}
