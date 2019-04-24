package com.example.tournote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class SecondFragment extends Fragment {
    private static final String ARG_CONTENT = "content";

    private String mContent;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String content) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContent = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        TextView txtContent = view.findViewById(R.id.txtContent);
        if(!TextUtils.isEmpty(mContent)){
            txtContent.setText(mContent);
        }

        return view;
    }
}
