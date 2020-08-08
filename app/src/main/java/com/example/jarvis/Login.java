package com.example.jarvis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {
    Database myDb;
    EditText uname,pass;
    Button but3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        but3 = findViewById(R.id.b3);
        myDb = new Database(this);

        uname=(EditText) findViewById(R.id.e1);
        pass=(EditText)findViewById(R.id.e2);

        but3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            boolean ifexisted=myDb.checkuser(uname.getText().toString(),pass.getText().toString());
            if(ifexisted==true) {
                Toast.makeText(Login.this, "Log In Successful", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Login.this,Speech.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(Login.this, "INVALID USER!!", Toast.LENGTH_LONG).show();
            }
        }}
        );
    }
}
