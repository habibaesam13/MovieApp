package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity{
    EditText te1,te2;
    TextView t;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        t=findViewById(R.id.sign);
        b=findViewById(R.id.login);
        te1=findViewById(R.id.loginmail);
        te2=findViewById(R.id.loginpass);



         b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check(te1)==false||check(te2)==false){
                    Toast.makeText(LoginPage.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (te1.getText().toString()==getIntent().getStringExtra("username")||te1.getText().toString()==getIntent().getStringExtra("email"))
                    {
                        if(te2.getText().toString()==getIntent().getStringExtra("password"));
                        openActivity2();
                    }
                    Toast.makeText(LoginPage.this, "INVALID EMAIL OR PASSWORD", Toast.LENGTH_SHORT).show();
               }
            }
        });


        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtoSign();
            }
        });
    }
    public void backtoSign(){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);

    }
public void openActivity2(){
    Intent i=new Intent(getApplicationContext(), HomePage.class);
    startActivity(i);
}
public Boolean check(EditText t){
if(t.length()>0)
    return true;
else
    return false;
}
}