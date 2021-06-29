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
import android.widget.EditText;
import android.widget.ImageView;
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
import java.util.List;

import static java.lang.Integer.parseInt;

public class ImageRecognition extends AppCompatActivity {
    EditText animalId;
    Button btnCheck, btnPopUp;
    TextView tvTask, tvPop;
    ImageView imageView;
    int steps = 1;
    FirebaseAuth mFirebaseAuth;
    private String uid, valueScore,valueScoreI;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private boolean complete = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_recognition);

        mFirebaseAuth = FirebaseAuth.getInstance();
        animalId = findViewById(R.id.animalId);
        tvTask = findViewById(R.id.tvTask);
        imageView = findViewById(R.id.imageView);
        btnCheck = findViewById(R.id.btnCheck);
        btnPopUp = findViewById(R.id.btnPopUp);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = animalId.getText().toString();
                if(name.isEmpty()){
                    animalId.setError("Zadejte název");
                    animalId.requestFocus();
                }else {
                    switch(steps) {
                        case 1:
                            if(name.equals("lion")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.cow);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 2:
                            if(name.equals("cow")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.dog);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 3:
                            if(name.equals("dog")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.cat);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 4:
                            if(name.equals("cat")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.camel);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 5:
                            if(name.equals("camel")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.parrot);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 6:
                            if(name.equals("parrot")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.elephant);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 7:
                            if(name.equals("elephant")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.tiger);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 8:
                            if(name.equals("tiger")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.owl);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 9:
                            if(name.equals("owl")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.chicken);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 10:
                            if(name.equals("chicken")){
                                Toast.makeText(ImageRecognition.this, "Dokončeno", Toast.LENGTH_SHORT).show();
                                complete = true;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }

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
                    DatabaseReference myRef = database.getReference(uid+"animals1");
                    myRef.setValue("done");
                    DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
                    int score = parseInt(valueScore)+10;
                    myRefScore.setValue(String.valueOf(score));
                    DatabaseReference myRefScoreI = database.getReference(uid+"scoreImages");
                    int scoreI = parseInt(valueScoreI)+10;
                    myRefScoreI.setValue(String.valueOf(scoreI));

                }
                startActivity(new Intent(ImageRecognition.this, HomeActivity.class));
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

        DatabaseReference myRefScoreI = database.getReference(uid+"scoreImages");
        myRefScoreI.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // tvTest.setText(value);
                if (value!=null){
                    valueScoreI = value;}else{
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRefScore = database.getReference(uid+"scoreImages");
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
    }
}
