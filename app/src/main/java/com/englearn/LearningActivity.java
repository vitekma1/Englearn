package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LearningActivity extends AppCompatActivity {
    private Long valueTextSize;
    private Button btnMenu,btnPopUp;
    private TextView tvTask, tvSentence,tvSentence2,tvSentence3,tvSentence4,tvSentence5,tvSentence6,tvSentence7,tvSentence8,tvSentence9,
            tvSentence10,tvSentence11,tvSentence12,tvSentence13,tvSentence14,tvSentence15,tvTimes, tvListening, tvListening1, tvListening2, tvListening3,
    tvListening4, tvListening5, tvSpeaking, tvSpeaking2, tvSpeaking3;
    private String uid;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        btnMenu = (Button)findViewById(R.id.btnMenu);
        tvTask = findViewById(R.id.tvTask);
        tvSentence = findViewById(R.id.tvSentence);
        tvSentence2 = findViewById(R.id.tvSentence2);
        tvSentence3 = findViewById(R.id.tvSentence3);
        tvSentence4 = findViewById(R.id.tvSentence4);
        tvSentence5 = findViewById(R.id.tvSentence5);
        tvSentence6 = findViewById(R.id.tvSentence6);
        tvSentence7 = findViewById(R.id.tvSentence7);
        tvSentence8 = findViewById(R.id.tvSentence8);
        tvSentence9 = findViewById(R.id.tvSentence9);
        tvSentence10 = findViewById(R.id.tvSentence10);
        tvSentence11 = findViewById(R.id.tvSentence11);
        tvSentence12 = findViewById(R.id.tvSentence12);
        tvSentence13 = findViewById(R.id.tvSentence13);
        tvSentence14 = findViewById(R.id.tvSentence14);
        tvSentence15 = findViewById(R.id.tvSentence15);
        tvTimes = findViewById(R.id.tvTimes);
        tvListening = findViewById(R.id.tvListening);
        btnPopUp = findViewById(R.id.btnPopUp);
        tvListening1 = findViewById(R.id.tvListening1);
        tvListening2 = findViewById(R.id.tvListening2);
        tvListening3 = findViewById(R.id.tvListening3);
        tvListening4 = findViewById(R.id.tvListening4);
        tvListening5 = findViewById(R.id.tvListening5);
        tvSpeaking = findViewById(R.id.tvSpeaking);
        tvSpeaking2 = findViewById(R.id.tvSpeaking2);
        tvSpeaking3 = findViewById(R.id.tvSpeaking3);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearningActivity.this, HomeActivity.class));
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
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence2.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence3.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence4.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence5.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence6.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence7.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence8.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence9.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence10.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence11.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence12.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence13.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence14.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence15.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvTimes.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvListening.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvListening1.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvListening2.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvListening3.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvListening4.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvListening5.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSpeaking.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSpeaking2.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSpeaking3.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);

                }
                if(valueTextSize==2131231001){
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence2.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence3.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence4.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence5.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence6.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence7.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence8.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence9.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence10.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence11.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence12.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence13.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence14.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence15.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvTimes.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvListening.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvListening1.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvListening2.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvListening3.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvListening4.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvListening5.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSpeaking.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSpeaking2.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSpeaking3.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                }
                if(valueTextSize==2131231002){
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence2.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence3.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence4.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence5.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence6.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence7.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence8.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence9.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence10.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence11.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence12.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence13.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence14.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence15.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvTimes.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvListening.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvListening1.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvListening2.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvListening3.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvListening4.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvListening5.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSpeaking.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSpeaking2.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSpeaking3.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });
    }

    public void startSound1(View v) {
        mp = MediaPlayer.create(v.getContext(), R.raw.audio_1);
        mp.start();

        }
    public void startSound2(View v) {
        mp = MediaPlayer.create(v.getContext(), R.raw.audio_2);
        mp.start();
    }
    public void startSound3(View v) {
        mp = MediaPlayer.create(v.getContext(), R.raw.audio_3);
        mp.start();
    }
    public void startSound4(View v) {
        mp = MediaPlayer.create(v.getContext(), R.raw.audio_4);
        mp.start();
    }
    public void startSound5(View v) {
        mp = MediaPlayer.create(v.getContext(), R.raw.audio_5);
        mp.start();

    }

    }


