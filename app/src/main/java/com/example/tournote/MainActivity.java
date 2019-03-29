package com.example.tournote;

import android.graphics.Color;
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
        // String dạng HTML (có thể set trong XML)
//        txtEmptyNote.setText(R.string.empty_note);
        // String dạng đoạn HTML trong thẻ CDATA
//        txtEmptyNote.setText(Html.fromHtml(getString(R.string.example_for_cdata)));

        // String dạng SpannableString
        CharSequence exampleForSpannable = getText(R.string.example_for_spannable);
        Spannable spannableString = new SpannableString(exampleForSpannable);

        // Set màu đỏ cho string (1). Vị trí từ 0 đến 30
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, 30, 0);

        // Set string (2) to gấp 2 lần. Vị trí là ký tự 84
        spannableString.setSpan(new RelativeSizeSpan(2), 84, 85, 0);

        // Set cho string (3) có thể click được, đồng thời có màu xanh, khi click vào hiển thị Toast. Vị trí từ 128 đến 150
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "Will be implemented later...", Toast.LENGTH_SHORT).show();
            }
        };

        spannableString.setSpan(clickableSpan, 128, 150, 0);
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 128, 150, 0);

        // Set string (4) có thể click được, đồng thời có màu đen, to gấp rưỡi, khi click vào thì đến link. Vị trí từ 178 đến hết string
        spannableString.setSpan(new URLSpan("https://yellowcodebooks.com/"), 178,exampleForSpannable.length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 178, exampleForSpannable.length(), 0);
        spannableString.setSpan(new RelativeSizeSpan(1.5f), 178, exampleForSpannable.length(), 0);

        // Set cho ClickableSpans và URLSpans có thể hoạt động
        txtEmptyNote.setMovementMethod(LinkMovementMethod.getInstance());

        // Set spannable text vào cho TextView
        txtEmptyNote.setText(spannableString);

        // Formatting String
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String curentDate = df.format(c.getTime());
        txtEmptyNote.setText(getString(R.string.example_for_formatting_string, curentDate, 0, 3.5f));




    }
}
