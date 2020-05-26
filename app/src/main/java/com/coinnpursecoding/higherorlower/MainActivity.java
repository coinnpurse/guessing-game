package com.coinnpursecoding.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void generateRandomNumber(){ //create a function to avoid repeated code
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }
    
    public void clickFunction(View view){

        Log.i("Info", "Button pressed!");

        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);

        int userGuess = Integer.parseInt(guessEditText.getText().toString());

            if (userGuess == randomNumber) {
                Toast.makeText(this, "Correct! The number was " + randomNumber + ". Try another?", Toast.LENGTH_SHORT).show();
                generateRandomNumber();
                Log.i("Info", "THE NEW NUMBER IS " + randomNumber);
            } else if (userGuess > randomNumber ) {
                Toast.makeText(this, "Lower!", Toast.LENGTH_SHORT).show();
            } else if (userGuess < randomNumber) {
                Toast.makeText(this, "Higher!", Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
        Log.i("Info", "THE GENERATOR PRODUCED " + randomNumber);
    }
}
