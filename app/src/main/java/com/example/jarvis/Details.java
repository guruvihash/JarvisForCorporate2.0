package com.example.jarvis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {
    Database myDb;
    EditText name,mail,pass,phoneno;
    Button but2,but3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        but2 = findViewById(R.id.b2);
        but3 = findViewById(R.id.b3);
        myDb = new Database(this);

        name=(EditText) findViewById(R.id.et1);
        mail=(EditText)findViewById(R.id.et2);
        pass=(EditText)findViewById(R.id.et4);
        phoneno=(EditText)findViewById(R.id.et3);
        but2=(Button)findViewById(R.id.b2);
        but3=(Button)findViewById(R.id.b3);

            but2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean ifinserted=myDb.insertdata(name.getText().toString(),mail.getText().toString(),phoneno.getText().toString(),pass.getText().toString());
                    if(ifinserted==true) {
                        Toast.makeText(Details.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Details.this, Welcome.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Details.this, "Registration Failed", Toast.LENGTH_LONG).show();
                    }
                }
            });


        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
