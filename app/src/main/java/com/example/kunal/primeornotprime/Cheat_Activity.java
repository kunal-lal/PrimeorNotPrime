package com.example.kunal.primeornotprime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Cheat_Activity extends AppCompatActivity {
    public static TextView edit,addedtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheat_layout);
        cheat();
    }

    public void cheat(){
        edit=(TextView)findViewById(R.id.editText3);

        addedtext=(TextView)findViewById(R.id.editText4);
        addedtext.setFocusable(false);
        edit.setText(getIntent().getExtras().getString("data"));
        edit.setFocusable(false);
        String a=getIntent().getExtras().getString("data");
        int foo=Integer.parseInt(a);
        int sqrt= (int)Math.sqrt(foo)+1;
        if(foo== 1 ){
            addedtext.setText("Is not a prime number");
        }
        if(foo==2 ||foo==3){
            addedtext.setText("It is a prime number");
        }
        for (int i = 2; i < sqrt; i++) {
            if (foo % i == 0) {
                addedtext.setText("Is not a prime number");
                break;
            }
                addedtext.setText("Is a prime number");
            }
        }

    }

