package com.indiagold.crowdin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crowdin.platform.Crowdin;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textView1 , textView2 , textView3;
    Button btn;
    String langstate;
    Boolean state;


    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        state =true;

        textView1 =findViewById(R.id.tv_1);
        textView2 =findViewById(R.id.tv_2);
        textView3 =findViewById(R.id.tv_3);


        textView1.setText(getResources().getString(R.string.string_text1));
        textView2.setText(getResources().getString(R.string.string_text2 , getResources().getString(R.string.string_two)));
        textView3.setText(getResources().getString(R.string.string_text3 , getResources().getString(R.string.string_three), getResources().getString(R.string.string_four), getResources().getString(R.string.string_five)));



        btn = findViewById(R.id.btn_translate);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    LocaleHelper.setLocale(MainActivity.this,"hi");
                    Log.e("Status" , String.valueOf(state));
                    Log.e("StatusLang" , Locale.getDefault().getLanguage());
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Crowdin.wrapContext(newBase));
    }
}
