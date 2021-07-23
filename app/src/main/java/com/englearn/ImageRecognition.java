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
    Button btnCheck, btnPopUp, btnMenu;
    TextView tvTask, tvPop;
    ImageView imageView;
    int steps = 1;
    private Long valueTextSize;
    FirebaseAuth mFirebaseAuth;
    private String uid;
    private String valueScoreI = "0";
    private String valueScore = "0";
    private int localScore = 20;
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
                            if(name.equals("bus")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.book);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
                            }
                            break;
                        case 2:
                            if(name.equals("book")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.dog);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
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
                                if(localScore>0){localScore--;}
                            }
                            break;
                        case 4:
                            if(name.equals("cat")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.chair);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
                            }
                            break;
                        case 5:
                            if(name.equals("chair")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.meat);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
                            }
                            break;
                        case 6:
                            if(name.equals("meat")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.tree);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
                            }
                            break;
                        case 7:
                            if(name.equals("tree")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.window);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
                            }
                            break;
                        case 8:
                            if(name.equals("window")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.table);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
                            }
                            break;
                        case 9:
                            if(name.equals("table")){
                                Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                                imageView.setImageResource(R.drawable.pen);
                                animalId.setText(null);
                                steps++;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
                            }
                            break;
                        case 10:
                            if(name.equals("pen")){
                                Toast.makeText(ImageRecognition.this, "Dokončeno", Toast.LENGTH_SHORT).show();
                                complete = true;
                            }else {
                                Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                                if(localScore>0){localScore--;}
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
        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (complete){
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(uid+"animals1");
                    myRef.setValue("done");
                    DatabaseReference myRefScore = database.getReference(uid+"scoreTotal");
                    int score = parseInt(valueScore)+localScore;
                    myRefScore.setValue(String.valueOf(score));
                    DatabaseReference myRefScoreI = database.getReference(uid+"scoreImages");
                    int scoreI = parseInt(valueScoreI)+localScore;
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
                if(valueTextSize==2131231004){
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    animalId.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    btnCheck.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);

                }
                if(valueTextSize==2131231005){
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    animalId.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                    btnCheck.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);

                }
                if(valueTextSize==2131231006){
                    tvTask.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnPopUp.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    animalId.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                    btnCheck.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);

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
