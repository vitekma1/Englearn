package com.englearn;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.util.List;

import static java.lang.Integer.parseInt;

public class GrammarActivity extends AppCompatActivity {

    Button btnA1,btnA2,btnA3,btnA4;
    int steps = 1;
    FirebaseAuth mFirebaseAuth;
    private String uid, valueScore;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private boolean complete = false;
    TextView tvTask,tvSentence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        mFirebaseAuth = FirebaseAuth.getInstance();
        tvTask = findViewById(R.id.tvTask);
        tvSentence = findViewById(R.id.tvSentence);
        btnA1 = findViewById(R.id.btnA1);
        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);
        btnA4 = findViewById(R.id.btnA4);

        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(steps) {
                    case 1:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("zmenaM");
                        tvSentence.setText("zmena");
                        steps++;
                        break;
                    case 3:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        tvSentence.setText("");
                        steps++;
                        break;
                    case 7:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(GrammarActivity.this, "Dokončeno", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        complete = true;
                        steps++;
                        break;
                }


            }
        });

        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(steps) {
                    case 1:

                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        tvSentence.setText("");
                        steps++;

                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        tvSentence.setText("");
                        steps++;
                        break;
                    case 5:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });

        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(steps) {
                    case 1:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        tvSentence.setText("");
                        steps++;
                        break;
                    case 4:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        tvSentence.setText("");
                        steps++;
                        break;
                    case 10:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });

        btnA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(steps) {
                    case 1:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        tvSentence.setText("");
                        steps++;
                        break;
                    case 6:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        tvSentence.setText("");
                        steps++;
                        break;
                    case 8:
                        Toast.makeText(GrammarActivity.this, "Spravne", Toast.LENGTH_SHORT).show();
                        btnA1.setText("");
                        btnA2.setText("");
                        btnA3.setText("");
                        btnA4.setText("");
                        tvSentence.setText("");
                        steps++;
                        break;
                    case 9:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(GrammarActivity.this, "Spatne", Toast.LENGTH_SHORT).show();
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
        Button btnMenu = (Button)findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (complete){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(uid+"grammar1");
                    myRef.setValue("done");
                    DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
                    int score = parseInt(valueScore)+10;
                    myRefScore.setValue(String.valueOf(score));

                }
                startActivity(new Intent(GrammarActivity.this, HomeActivity.class));
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
                    valueScore = value;}
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });
    }
}
