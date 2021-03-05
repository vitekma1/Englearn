package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ImageRecognition extends AppCompatActivity {
    EditText animalId;
    Button btnCheck;
    TextView tvTask;
    ImageView imageView;

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_recognition);

        mFirebaseAuth = FirebaseAuth.getInstance();
        animalId = findViewById(R.id.animalId);
        tvTask = findViewById(R.id.tvTask);
        imageView = findViewById(R.id.imageView);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = animalId.getText().toString();
                if(name.isEmpty()){
                    animalId.setError("Zadejte název");
                    animalId.requestFocus();
                }else {
                    if (name.equals("lion")) {
                        Toast.makeText(ImageRecognition.this, "Spravne", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ImageRecognition.this, "Spatne", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button btnMenu = (Button)findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImageRecognition.this, HomeActivity.class));
                finish();
            }
        });
    }
}
