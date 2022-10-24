package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.calculatorScreen);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(view -> {
            if(getString(R.string.display).equals(display.getText().toString())){
                display.setText("");
            }
        });
    }

    private void updateText(String stringToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(stringToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, stringToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }


    }

    public void zeroBTN(View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");

    }

    public void twoBTN(View view){
        updateText("2");

    }

    public void threeBTN(View view){
        updateText("3");

    }

    public void fourBTN(View view){
        updateText("4");

    }

    public void fiveBTN(View view){
        updateText("5");

    }

    public void sixBTN(View view){
        updateText("6");

    }

    public void sevenBTN(View view){
        updateText("7");

    }

    public void eightBTN(View view){
        updateText("8");

    }

    public void nineBTN(View view){
        updateText("9");

    }

    public void minusBTN(View view){
        updateText("-");

    }

    public void plusBTN(View view){
        updateText("+");

    }

    public void multiplicationBTN(View view){
        updateText("*");

    }

    public void divisionBTN(View view){
        updateText("/");

    }

    public void ceBTN(View view){
        display.setText("");
    }

    public void cBTN(View view){
        display.setText("");
    }

    public void arrowBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        if(cursorPos != 0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void comaBTN(View view){
        updateText(".");
    }

    public void equalBTN(View view){

    }


}