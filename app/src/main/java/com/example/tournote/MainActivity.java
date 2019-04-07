package com.example.tournote;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TourNote_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtEmptyNote = findViewById(R.id.activity_main_txt_empty);
        ImageView imageView = findViewById(R.id.activity_main_img_note);

        int color = ContextCompat.getColor(this, R.color.colorPrimary);
        txtEmptyNote.setTextColor(color);
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
    }
}
