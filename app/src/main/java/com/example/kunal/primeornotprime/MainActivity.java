package com.example.kunal.primeornotprime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static int number;
    public static int cheat_attempt=0,hint_attempt=0;
    public static EditText hint_text;
    public static EditText cheat_text;
    public static EditText hint_counter,cheat_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hint_text=(EditText)findViewById(R.id.Hint_text);
        hint_text.setFocusable(false);
        hint_text.setText("False");
        cheat_text=(EditText)findViewById(R.id.Cheat_text);
        cheat_text.setFocusable(false);
        cheat_text.setText("False");
        hint_counter=(EditText)findViewById(R.id.hint_counter);
        hint_counter.setFocusable(false);
        hint_counter.setText("0");
        cheat_counter=(EditText)findViewById(R.id.cheat_counter);
        cheat_counter.setFocusable(false);
        cheat_counter.setText("0");
    }

    public  int  isPrime() {
        EditText edited = (EditText) findViewById(R.id.editText);
        number = Integer.parseInt(edited.getText().toString());
        int sqrt= (int)Math.sqrt(number)+1;
        if(number== 1 ){
            return 0;
        }
        if(number ==2 || number ==3){
            return 1;
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
        if(returnedValue==0) {
            Toast.makeText(this, "Sorry wrong answer", Toast.LENGTH_SHORT).show();

        }
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

    public void onButtonClick(View view) {
        Random random = new Random();
        int number = random.nextInt(1000) + 1;
        EditText myText = (EditText) findViewById(R.id.editText);
        String myString = String.valueOf(number);
        myText.setText(myString);
    }

    public void OnHinClick(View view){
        EditText edited = (EditText) findViewById(R.id.editText);
        Intent intent = new Intent(this,Hint_Activity.class);
        intent.putExtra("data",edited.getText().toString());
        startActivity(intent);
        hint_text=(EditText)findViewById(R.id.Hint_text);
        hint_text.setText("True");
        hint_text.setFocusable(false);
        hint_counter=(EditText)findViewById(R.id.hint_counter);
        hint_attempt++;
        hint_counter.setText(Integer.toString(hint_attempt));
        hint_counter.setFocusable(false);

    }

    public void onCheatClick(View view){
        EditText edited=(EditText)findViewById(R.id.editText);
        Intent intent = new Intent(this,Cheat_Activity.class);
        intent.putExtra("data",edited.getText().toString());
        startActivity(intent);
        cheat_text=(EditText)findViewById(R.id.Cheat_text);
        cheat_text.setText("True");
        cheat_text.setFocusable(false);
        cheat_counter=(EditText)findViewById(R.id.cheat_counter);
        cheat_attempt++;
        cheat_counter.setText(Integer.toString(cheat_attempt));
        cheat_counter.setFocusable(false);

    }
}



