package com.example.jarvis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    Button but4;
    CheckBox check1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        addListenerOnButtonClick();

    }
    public void addListenerOnButtonClick(){
        check1=findViewById(R.id.ch1);
        but4=findViewById(R.id.b4);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    Intent intent=new Intent(Welcome.this,Login.class);
                    startActivity(intent);
                }
            }
        });

    }
}
