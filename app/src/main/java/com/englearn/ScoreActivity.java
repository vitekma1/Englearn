package com.englearn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ScoreActivity extends AppCompatActivity {

    TextView tvScore, tvScore2, tvScore3, tvScore4, tvScore5, textView4, textView5, textView6, textView7, textView8;
    private String email, uid;
    private Long valueTextSize;
    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tvScore = findViewById(R.id.tvScore);
        tvScore2 = findViewById(R.id.tvScore2);
        tvScore3 = findViewById(R.id.tvScore3);
        tvScore4 = findViewById(R.id.tvScore4);
        tvScore5 = findViewById(R.id.tvScore5);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        //ziskani emailu a id prihlaseneho uzivatele
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            email = user.getEmail();
            uid = user.getUid();
        } else {
            email = "error";
            uid = "error";
        }

        btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScoreActivity.this, HomeActivity.class));
                finish();
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Write a message to the database
        DatabaseReference myRefScore = database.getReference(uid + "scoreTotal");
        DatabaseReference myRefScoreG = database.getReference(uid + "scoreGrammar");
        DatabaseReference myRefScoreI = database.getReference(uid + "scoreImages");
        DatabaseReference myRefScoreR = database.getReference(uid + "scoreReading");
        DatabaseReference myRefScoreL = database.getReference(uid + "scoreListening");

        // Read from the database
        myRefScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    tvScore.setText(value);
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid + "scoreTotal");
                    myRefScore.setValue("0");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        myRefScoreG.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    tvScore2.setText(value);
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid + "scoreGrammar");
                    myRefScore.setValue("0");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        myRefScoreI.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    tvScore3.setText(value);
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid + "scoreImages");
                    myRefScore.setValue("0");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        myRefScoreR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    tvScore4.setText(value);
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid + "scoreReading");
                    myRefScore.setValue("0");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        myRefScoreL.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    tvScore5.setText(value);
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid + "scoreListening");
                    myRefScore.setValue("0");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        DatabaseReference myRefTextSize = database.getReference(uid + "textSize");
        myRefTextSize.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Long value = dataSnapshot.getValue(Long.class);
                // tvTest.setText(value);
                if (value != null) {
                    valueTextSize = value;
                } else {
                    valueTextSize = 0L;
                }
                if (valueTextSize == 2131231004) {
                    tvScore.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    tvScore2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    tvScore3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    tvScore4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    tvScore5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                }
                if (valueTextSize == 2131231005) {
                    tvScore.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    tvScore2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    tvScore3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    tvScore4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    tvScore5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                }
                if (valueTextSize == 2131231006) {
                    tvScore.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    tvScore2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    tvScore3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    tvScore4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    tvScore5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
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
