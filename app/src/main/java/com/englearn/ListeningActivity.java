package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Integer.parseInt;

public class ListeningActivity extends AppCompatActivity {
    Button btnMenu, btnPopUp, btnCheck;
    MediaPlayer mp;
    EditText soundId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        soundId = findViewById(R.id.soundId);
        btnPopUp = findViewById(R.id.btnPopUp);
        btnMenu = (Button)findViewById(R.id.btnMenu);
        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = soundId.getText().toString();
                if(name.isEmpty()){
                    soundId.setError("Zadejte slovo");
                    soundId.requestFocus();
                }else {
                            if(name.equals("welcome")){
                                Toast.makeText(ListeningActivity.this, "Spravne", Toast.LENGTH_SHORT).show();

                            }else {
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
