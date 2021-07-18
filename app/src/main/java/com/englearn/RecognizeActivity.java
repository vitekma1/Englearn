package com.englearn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class RecognizeActivity extends AppCompatActivity {
    TextView tvResult,tvTask,tvHeadline;
    Button btnMenu,btnPopUp, buttonzm;
    private Long valueTextSize;
    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognize);
        tvResult = findViewById(R.id.tvResult);
        tvTask = findViewById(R.id.tvTask);
        btnMenu = (Button)findViewById(R.id.btnMenu);
        btnPopUp = (Button)findViewById(R.id.btnPopUp);
        tvHeadline = findViewById(R.id.tvHeadline);
        buttonzm = (Button)findViewById(R.id.buttonzm);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (complete){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(uid+"animals1");
                    myRef.setValue("done");
                    DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
                    int score = parseInt(valueScore)+100;
                    myRefScore.setValue(String.valueOf(score));

                }*/
                startActivity(new Intent(RecognizeActivity.this, HomeActivity.class));
                finish();
            }
        });

        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_window, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });}

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
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvHeadline.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    buttonzm.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                }
                if(valueTextSize==2131231001){
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvHeadline.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    buttonzm.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                }
                if(valueTextSize==2131231002){
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvHeadline.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    buttonzm.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });
    }

    public void getSpeechInput (View v){
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if(i.resolveActivity(getPackageManager()) != null){
            startActivityForResult(i, 10);
        } else{
            Toast.makeText(this,"Vaše zařízení nepodporuje zvukový vstup", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data!=null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tvResult.setText(result.get(result.size()-1));
                    if(tvResult.getText().toString().equals(tvTask.getText().toString()) ){
                        Toast.makeText(this,"Správně, pokračujte dalším slovem", Toast.LENGTH_SHORT).show();
                        tvResult.setTextColor(Color.rgb(0,200,0));
                        Random generate = new Random();
                        String[] words = {"Welcome", "Car", "Window", "Tiger", "Pen", "Computer","Mobile","Hello","Goodbye","Queen","King","Room","Morning","Why","Which","Who", "Can","Clean","Long","Short"};
                        tvTask.setText(words[generate.nextInt(20)]);
                    } else{
                        Toast.makeText(this,"Špatně", Toast.LENGTH_SHORT).show();
                        tvResult.setTextColor(Color.rgb(200,0,0));
                    }
                }
                break;
        }
    }
}
