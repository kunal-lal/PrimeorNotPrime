package com.example.kunal.primeornotprime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Hint_Activity extends AppCompatActivity {
 public static TextView edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint_layout);
        hint();

    }
 public void hint(){
     edit=(TextView)findViewById(R.id.editText2);
     edit.setText(getIntent().getExtras().getString("data"));
 }

}
