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

public class HomeActivity extends AppCompatActivity {
    private Long valueTextSize;
    Button btnLogout;
    TextView tvTest, textView2, textView3, textView4, textView5;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String email, uid;
    Button btnImages, btnGrammar1, btnScore, btnListening, btnRecognition, btnSettings, btnProfile, btnTranslator, btnLearning, btnReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvTest = findViewById(R.id.textView2);
        btnImages = findViewById(R.id.btnImages);
        btnScore = findViewById(R.id.btnScore);
        btnGrammar1 = findViewById(R.id.btnGrammar1);
        btnListening = findViewById(R.id.btnListening);
        btnRecognition = findViewById(R.id.btnRecognition);
        btnSettings = findViewById(R.id.btnSettings);
        btnProfile = findViewById(R.id.btnProfile);
        btnTranslator = findViewById(R.id.btnTranslator);
        btnReading = findViewById(R.id.btnReading);
        btnLearning = findViewById(R.id.btnLearning);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        btnLogout = findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });

        //ziskani emailu a id prihlaseneho uzivatele
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            email = user.getEmail();
            uid = user.getUid();
        } else {
            email = "error";
            uid = "error";
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRefNick = database.getReference(uid + "nickname");

        // Read from the database
        myRefNick.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    tvTest.setText("Přihlášený uživatel: " + value);
                } else {
                    tvTest.setText("Přihlášený uživatel: " + email);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });


        // Write a message to the database
        DatabaseReference myRef = database.getReference(uid + "animals1");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    if (value.equals("done")) {
                        btnImages.setText("Slovní zásoba - hotovo");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Write a message to the database
        DatabaseReference myRefW = database.getReference(uid + "writing");

        // Read from the database
        myRefW.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    if (value.equals("done")) {
                        btnImages.setText("Psaní - hotovo");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Write a message to the database
        DatabaseReference myRefG = database.getReference(uid + "grammar1");

        // Read from the database
        myRefG.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    if (value.equals("done")) {
                        btnGrammar1.setText("Gramatika - hotovo");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Write a message to the database
        DatabaseReference myRefR = database.getReference(uid + "reading1");

        // Read from the database
        myRefR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    if (value.equals("done")) {
                        btnReading.setText("Čtení - hotovo");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Write a message to the database
        DatabaseReference myRefL = database.getReference(uid + "listening1");

        // Read from the database
        myRefL.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value != null) {
                    if (value.equals("done")) {
                        btnListening.setText("Poslech - hotovo");
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        btnImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnImages.getText().equals("Slovní zásoba - hotovo")) {
                } else {
                    startActivity(new Intent(HomeActivity.this, ImageRecognition.class));
                    finish();
                }
            }
        });

        btnGrammar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnGrammar1.getText().equals("Gramatika - hotovo")) {
                } else {
                    startActivity(new Intent(HomeActivity.this, GrammarActivity.class));
                    finish();
                }
            }
        });
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ScoreActivity.class));
                finish();
            }
        });
        btnListening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnListening.getText().equals("Poslech - hotovo")) {
                } else {
                    startActivity(new Intent(HomeActivity.this, ListeningActivity.class));
                    finish();
                }
            }
        });
        btnRecognition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RecognizeActivity.class));
                finish();
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                finish();
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                finish();
            }
        });
        btnLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LearningActivity.class));
                finish();
            }
        });
        btnReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnReading.getText().equals("Čtení - hotovo")) {
                } else {
                    startActivity(new Intent(HomeActivity.this, ReadingActivity.class));
                    finish();
                }
            }
        });

        btnTranslator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TranslatorActivity.class));
                finish();
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
                    btnImages.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnGrammar1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnScore.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnListening.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnRecognition.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnSettings.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnProfile.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnTranslator.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnLearning.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnReading.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    tvTest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnLogout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    tvTest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                }
                if (valueTextSize == 2131231005) {
                    btnImages.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnGrammar1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnScore.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnListening.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnRecognition.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnSettings.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnProfile.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnTranslator.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnLearning.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnReading.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    tvTest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnLogout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    tvTest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                }
                if (valueTextSize == 2131231006) {
                    btnImages.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnImages.setPadding(12, 17, 12, 20);
                    btnGrammar1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnGrammar1.setPadding(12, 17, 12, 20);
                    btnScore.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnScore.setPadding(12, 17, 12, 20);
                    btnListening.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnListening.setPadding(12, 17, 12, 20);
                    btnRecognition.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnRecognition.setPadding(12, 17, 12, 20);
                    btnSettings.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnSettings.setPadding(12, 17, 12, 20);
                    btnProfile.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnProfile.setPadding(12, 17, 12, 20);
                    btnTranslator.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnTranslator.setPadding(12, 17, 12, 20);
                    btnLearning.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnLearning.setPadding(12, 17, 12, 20);
                    btnReading.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnReading.setPadding(12, 17, 12, 20);
                    tvTest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnLogout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnLogout.setPadding(12, 17, 12, 20);
                    tvTest.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    textView5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
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
