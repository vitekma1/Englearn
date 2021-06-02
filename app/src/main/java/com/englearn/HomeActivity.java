package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.google.firebase.auth.FirebaseUser.*;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout;
    TextView tvTest, tvScore;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String email,uid;
    Button btnImages, btnGrammar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvTest = findViewById(R.id.textView2);
        tvScore = findViewById(R.id.tvScore);
        btnImages = findViewById(R.id.btnImages);
        btnGrammar1 = findViewById(R.id.btnGrammar1);

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
        }
        else{
            email = "error";
            uid = "error";
        }

        tvTest.setText("Přihlášený uživatel: "+email);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(uid+"animals1");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
               // tvTest.setText(value);
                if (value!=null){
                if( value.equals("done")){
                btnImages.setText("Zvířata - hotovo");}}
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Write a message to the database
        DatabaseReference myRefG = database.getReference(uid+"grammar1");

        // Read from the database
        myRefG.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value!=null){
                    if( value.equals("done")){
                        btnGrammar1.setText("Gramatika - hotovo");}}
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("test", "Failed to read value.", error.toException());
            }
        });

        // Write a message to the database
        DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");

        // Read from the database
        myRefScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value!=null){
                        tvScore.setText(value);}else{
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
                    myRefScore.setValue("0");
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
                if (btnImages.getText().equals("Zvířata - hotovo")){
                }else{
                startActivity(new Intent(HomeActivity.this, ImageRecognition.class));
                finish();}
            }
        });

        btnGrammar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnGrammar1.getText().equals("Gramatika - hotovo")){
                }else{
                    startActivity(new Intent(HomeActivity.this, GrammarActivity.class));
                    finish();}
            }
        });


    }
}
