package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Integer.parseInt;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioTextSize;
    private RadioButton radioButton;
    private Button btnSettings, btnNickname;
    private String uid;
    private EditText nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        addListenerOnButton();
        addListenerOnButtonNickname();

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
                DatabaseReference myRef = database.getReference(uid+"textSize");
                myRef.setValue(radioButton.getId());
                DatabaseReference myRef2 = database.getReference(uid+"settings");
                myRef2.setValue("done");

                Toast.makeText(SettingsActivity.this, "Velikost písma nastavena", Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void addListenerOnButtonNickname() {

        btnNickname = (Button) findViewById(R.id.btnNickname);
        nickname = findViewById(R.id.nickname);
        btnNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(uid+"nickname");
                myRef.setValue(nickname.getText().toString());
                Toast.makeText(SettingsActivity.this, "Přezdívka nastavena", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
