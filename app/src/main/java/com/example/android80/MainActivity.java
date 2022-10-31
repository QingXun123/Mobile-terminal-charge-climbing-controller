package com.example.android80;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginBtn;
    private Button masterBtn;
    private EditText editTextNumber;
    private EditText editTextTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        masterBtn = findViewById(R.id.masterBtn);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

        loginBtn.setOnClickListener(this);
        masterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.loginBtn:
                intent.setClass(MainActivity.this, Chaoxing.class);
                startActivity(intent);
                break;
            case R.id.masterBtn:
                intent.setClass(MainActivity.this, Master.class);
                startActivity(intent);
                break;
        }
    }
}