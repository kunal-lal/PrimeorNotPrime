package com.example.kunal.primeornotprime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int  isPrime() {
        EditText edit = (EditText) findViewById(R.id.editText);
        number = Integer.parseInt(edit.getText().toString());
        int sqrt= (int)Math.sqrt(number)+1;
        if(number== 1){
            return 0;
        }
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return 0;
            }

        }
        return 1;
    }

    public void onCorrectClick(View view) {
        int returnedValue= isPrime();
        if(returnedValue==0)
            Toast.makeText(this, "Sorry wrong answer", Toast.LENGTH_SHORT).show();
        else if(returnedValue==1){
            Toast.makeText(this, "Correct, "+number+" is a prime number", Toast.LENGTH_SHORT).show();
        }

    }

    public void onIncorrectClick(View view){
        int returnedValue=isPrime();
        if(returnedValue==0){
            Toast.makeText(this, "Correct, " +number+" is not a prime number", Toast.LENGTH_SHORT).show();
        }
        else if(returnedValue==1){
            Toast.makeText(this, "Sorry wrong answer", Toast.LENGTH_SHORT).show();
        }
    }

    public void onButtonClick(View v) {
        Random random = new Random();
        int number = random.nextInt(1000) + 1;
        EditText myText = (EditText) findViewById(R.id.editText);
        String myString = String.valueOf(number);
        myText.setText(myString);
    }

}



