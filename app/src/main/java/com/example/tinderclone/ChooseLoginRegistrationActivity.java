package com.example.tinderclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChooseLoginRegistrationActivity extends AppCompatActivity {

    private Button mLogin;
    private TextView mRegister;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login_registration);

        mLogin = (Button) findViewById(R.id.login);
        mRegister = (TextView) findViewById(R.id.register);
        mRegister.setPaintFlags(mRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseLoginRegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseLoginRegistrationActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mUser != null){
            Intent intent = new Intent(ChooseLoginRegistrationActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}