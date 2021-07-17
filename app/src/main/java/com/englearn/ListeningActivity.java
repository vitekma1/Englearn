package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import static java.lang.Integer.parseInt;

public class ListeningActivity extends AppCompatActivity {
    Button btnMenu, btnPopUp, btnCheck, start, stop;
    MediaPlayer mp;
    EditText soundId;
    TextView textView2,tvTask;
    private Long valueTextSize;
    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        soundId = findViewById(R.id.soundId);
        btnPopUp = findViewById(R.id.btnPopUp);
        btnMenu = (Button)findViewById(R.id.btnMenu);
        btnCheck = findViewById(R.id.btnCheck);
        tvTask = findViewById(R.id.tvTask);
        textView2 = findViewById(R.id.textView2);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = soundId.getText().toString();
                if(name.isEmpty()){
                    soundId.setError("Zadejte slovo");
                    soundId.requestFocus();
                }else {
                            if(name.equals("welcome")){
                                soundId.setTextColor(Color.rgb(0,200,0));
                                Toast.makeText(ListeningActivity.this, "Spravne", Toast.LENGTH_SHORT).show();

                            }else {
                                soundId.setTextColor(Color.rgb(200,0,0));
                                Toast.makeText(ListeningActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
            }
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (complete){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(uid+"listening1");
                    myRef.setValue("done");
                    DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
                    int score = parseInt(valueScore)+100;
                    myRefScore.setValue(String.valueOf(score));

                }*/
                startActivity(new Intent(ListeningActivity.this, HomeActivity.class));
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
                    soundId.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnCheck.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    start.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    stop.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);

                }
                if(valueTextSize==2131231001){
                    soundId.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnCheck.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    start.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    stop.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);


                }
                if(valueTextSize==2131231002){
                    soundId.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnCheck.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    start.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    stop.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });
    }

    public void startSound(View v) {
        mp = MediaPlayer.create(v.getContext(), R.raw.welcome);
        mp.start();
    }
    public void stopSound(View v) {
        mp = MediaPlayer.create(v.getContext(), R.raw.welcome);
        mp.stop();
    }


}
