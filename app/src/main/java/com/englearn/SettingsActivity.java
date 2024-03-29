package com.englearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioTextSize;
    private RadioButton radioButton;
    private Button btnSettings, btnMenu;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        addListenerOnButton();

        //ziskani emailu a id prihlaseneho uzivatele
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
        } else {
            uid = "error";
        }
        btnMenu = (Button) findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, HomeActivity.class));
                finish();
            }
        });
    }

    public void addListenerOnButton() {

        radioTextSize = (RadioGroup) findViewById(R.id.size);
        btnSettings = (Button) findViewById(R.id.btnSettings);

        btnSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioTextSize.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(uid + "textSize");
                myRef.setValue(radioButton.getId());
                DatabaseReference myRef2 = database.getReference(uid + "settings");
                myRef2.setValue("done");

                Toast.makeText(SettingsActivity.this, "Velikost písma nastavena", Toast.LENGTH_SHORT).show();
            }

        });

    }

}
