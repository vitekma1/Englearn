package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TranslatorActivity extends AppCompatActivity {

    EditText text;
    TextView translatedText,fromLang,toLang;
    Button btnTranslate,btnChange;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);
        btnChange=findViewById(R.id.btnChange);
        text=findViewById(R.id.text);
        fromLang=findViewById(R.id.from_lang);
        toLang=findViewById(R.id.to_lang);
        translatedText=findViewById(R.id.translated_text);
        btnTranslate=findViewById(R.id.btnTranslate);
        Button btnMenu = (Button)findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TranslatorActivity.this, HomeActivity.class));
                finish();
            }
        });
        btnChange.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            if(count==1){
                count = 0;
                fromLang.setText("Z - Čeština");
                toLang.setText("Do - Angličtina");
            }else{
                count = 1;
                fromLang.setText("Z - Angličtina");
                toLang.setText("Do - Čeština");

            }

            }

        });
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translate_api translate=new translate_api();
                translate.setOnTranslationCompleteListener(new translate_api.OnTranslationCompleteListener() {
                    @Override
                    public void onStartTranslation() {
                        // here you can perform initial work before translated the text like displaying progress bar
                    }

                    @Override
                    public void onCompleted(String text) {
                        // "text" variable will give you the translated text
                        translatedText.setText(text);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                if(count==0){
                    translate.execute(text.getText().toString(),"cs","en");
                }else{
                    translate.execute(text.getText().toString(),"en","cs");
                }

            }
        });
    }
}