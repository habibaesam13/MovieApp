package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView e;
    EditText e11, e12, e13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.signup);
        e = findViewById(R.id.log);
        e11 = findViewById(R.id.username);
        e12 = findViewById(R.id.email);
        e13 = findViewById(R.id.password);


        User.setData(e11.getText().toString(), e12.getText().toString(), e13.getText().toString());
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     if (!check2(e11) || !check2(e12) || !check2(e13)) {
                                         Toast.makeText(MainActivity.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                                     } else {
                                         openActivity2();
                                         Toast.makeText(MainActivity.this, User.getInstance().toString(), Toast.LENGTH_SHORT).show();
                                     }
                                 }
                             }
        );
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });


    }

    public void openActivity2() {
        Intent i = new Intent(getApplicationContext(), HomePage.class);
        i.putExtra("username", e11.getText().toString());
        i.putExtra("email", e12.getText().toString());
        i.putExtra("password", e13.getText().toString());
        startActivity(i);
    }

    public void Login() {
        Intent i = new Intent(this, LoginPage.class);
        startActivity(i);
    }

    public boolean check2(EditText e) {
        if (e.length() <= 0)
            return false;
        else
            return true;
    }
}