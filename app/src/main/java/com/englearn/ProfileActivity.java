package com.englearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private Button btnNickname, btnMenu;
    private String uid;
    private EditText nickname;
    private Long valueTextSize;
    private TextView textView7, textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        addListenerOnButtonNickname();
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
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
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                finish();
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
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
                    btnNickname.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    nickname.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    textView8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                }
                if (valueTextSize == 2131231005) {
                    btnNickname.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    nickname.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                }
                if (valueTextSize == 2131231006) {
                    btnNickname.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    nickname.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    btnMenu.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
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

    public void addListenerOnButtonNickname() {

        btnNickname = (Button) findViewById(R.id.btnNickname);
        nickname = findViewById(R.id.nickname);
        btnNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(uid + "nickname");
                myRef.setValue(nickname.getText().toString());
                Toast.makeText(ProfileActivity.this, "Přezdívka nastavena", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
