package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Integer.parseInt;

public class ReadingActivity extends AppCompatActivity {

    private Button btnMenu,btnPopUp,btnA1,btnA2,btnA3,btnA4;
    int steps = 1;
    FirebaseAuth mFirebaseAuth;
    private Long valueTextSize;
    private String uid;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private boolean complete = false;
    private int localScore = 20;
    private String valueScore = "0";
    private String valueScoreG = "0";
    TextView tvTask,tvSentence, tvTask2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        btnMenu = (Button)findViewById(R.id.btnMenu);
        btnPopUp = findViewById(R.id.btnPopUp);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReadingActivity.this, HomeActivity.class));
                finish();
            }
        });
        mFirebaseAuth = FirebaseAuth.getInstance();
        tvTask = findViewById(R.id.tvTask);
        tvSentence = findViewById(R.id.tvSentence);
        tvTask2 = findViewById(R.id.tvTask2);
        btnA1 = findViewById(R.id.btnA1);
        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);
        btnA4 = findViewById(R.id.btnA4);

        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(steps) {
                    case 1:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 2:
                        Toast.makeText(ReadingActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("Mark Baker");
                        btnA2.setText("Steve Roach");
                        btnA3.setText("Carl Jung");
                        btnA4.setText("None of the people in the text");
                        tvTask2.setText("Věta - People have always collected because we need to stay alive.");
                        steps++;
                        break;
                    case 3:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 4:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 5:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 6:
                        Toast.makeText(ReadingActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("Mark Baker");
                        btnA2.setText("Carl Jung");
                        btnA3.setText("Werner Muensterberger");
                        btnA4.setText("None of the people in the text");
                        tvTask2.setText("Věta - Collecting links ordinary people to the lives of well-known people.");
                        steps++;
                        break;
                    case 7:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 8:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                }


            }
        });

        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(steps) {
                    case 1:

                        Toast.makeText(ReadingActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("Mark Baker");
                        btnA2.setText("Carl Jung");
                        btnA3.setText("Philipp Bloom");
                        btnA4.setText("None of the people in the text");
                        tvTask2.setText("Věta - I collect because I enjoy trying to achieve something.");
                        steps++;

                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 3:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 4:
                        Toast.makeText(ReadingActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("Carl Jung");
                        btnA2.setText("Mark Baker");
                        btnA3.setText("Werner Muensterberger");
                        btnA4.setText("Philipp Bloom");
                        tvTask2.setText("Věta - People start collecting again when they can afford to buy special things.");
                        steps++;
                        break;
                    case 5:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 6:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 7:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 8:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                }


            }
        });

        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(steps) {
                    case 1:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 2:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 3:
                        Toast.makeText(ReadingActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("Werner Muensterberger");
                        btnA2.setText("Steve Roach");
                        btnA3.setText("Philipp Bloom");
                        btnA4.setText("None of the people in the text");
                        tvTask2.setText("Věta - People collect because they want to be famous for something important.");
                        steps++;
                        break;
                    case 4:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 5:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 6:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 7:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 8:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                }


            }
        });

        btnA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(steps) {
                    case 1:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 2:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 3:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 4:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 5:
                        Toast.makeText(ReadingActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("Steve Roach");
                        btnA2.setText("Werner Muensterberger");
                        btnA3.setText("Philipp Bloom");
                        btnA4.setText("None of the people in the text");
                        tvTask2.setText("Věta - Collecting gives people something to do during bad weather and cold or wet seasons.");
                        steps++;
                        break;
                    case 6:
                        Toast.makeText(ReadingActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        if(localScore>0){localScore--;}
                        break;
                    case 7:
                        Toast.makeText(ReadingActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("Carl Jung");
                        btnA2.setText("Werner Muensterberger");
                        btnA3.setText("Philipp Bloom");
                        btnA4.setText("Mark Baker");
                        steps++;
                        break;
                    case 8:
                        Toast.makeText(ReadingActivity.this, "Dokončeno", Toast.LENGTH_SHORT).show();
                        complete = true;
                        steps++;
                        break;
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
        btnMenu = (Button)findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (complete){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(uid+"reading1");
                    myRef.setValue("done");
                    DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
                    int score = parseInt(valueScore)+localScore;
                    myRefScore.setValue(String.valueOf(score));
                    DatabaseReference myRefScoreG = database.getReference(uid+"scoreReading");
                    int scoreG = parseInt(valueScoreG)+localScore;
                    myRefScoreG.setValue(String.valueOf(scoreG));

                }
                startActivity(new Intent(ReadingActivity.this, HomeActivity.class));
                finish();
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
        myRefScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value!=null){
                    valueScore = value;}else{
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
                    myRefScore.setValue("0");}
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });
        DatabaseReference myRefScoreR = database.getReference(uid+"scoreReading");
        myRefScoreR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value!=null){
                    valueScoreG = value;}else{
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid+"scoreReading");
                    myRefScore.setValue("0");}
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
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
                    tvTask2.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnA1.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnA2.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnA3.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnA4.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    tvSentence.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                }
                if(valueTextSize==2131231001){
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvTask2.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnA1.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnA2.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnA3.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnA4.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    tvSentence.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                }
                if(valueTextSize==2131231002){
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvTask2.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnA1.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnA2.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnA3.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnA4.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    tvSentence.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
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
