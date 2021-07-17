package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TranslatorActivity extends AppCompatActivity {
    private Long valueTextSize;
    EditText text;
    TextView textView7,translatedText,fromLang,toLang,tvtranslate;
    Button btnTranslate,btnChange, btnDelete, btnMenu;
    int count = 0;
    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);
        btnChange=findViewById(R.id.btnChange);
        text=findViewById(R.id.text);
        fromLang=findViewById(R.id.from_lang);
        toLang=findViewById(R.id.to_lang);
        translatedText=findViewById(R.id.translated_text);
        tvtranslate=findViewById(R.id.tvtranslate);
        textView7=findViewById(R.id.textView7);
        btnTranslate=findViewById(R.id.btnTranslate);
        btnDelete=findViewById(R.id.btnDelete);
        btnMenu = (Button)findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TranslatorActivity.this, HomeActivity.class));
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                translatedText.setText("");
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

        //ziskani emailu a id prihlaseneho uzivatele
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
        }
        else{
            uid = "error";
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefTextSize = database.getReference(uid+"textSize");
        myRefTextSize.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Long value = dataSnapshot.getValue(Long.class);
                // tvTest.setText(value);
                if (value!=null){
                    valueTextSize = value;} else {valueTextSize = 0L;}
                if(valueTextSize==2131231000){
                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    translatedText.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    fromLang.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    toLang.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnTranslate.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnChange.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnDelete.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvtranslate.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                }
                if(valueTextSize==2131231001){
                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    translatedText.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    fromLang.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    toLang.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnTranslate.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnChange.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnDelete.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvtranslate.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                }
                if(valueTextSize==2131231002){
                    text.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    translatedText.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    fromLang.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    toLang.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnTranslate.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnChange.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnDelete.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvtranslate.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });
    }
}