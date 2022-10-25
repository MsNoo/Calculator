package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView displayInSmallScr;
    Button root;
    Button plusMinus;
    String textForSmallScr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.calculatorScreen);
        displayInSmallScr = findViewById(R.id.calculatorScreenSmall);
        root = findViewById(R.id.root);
        plusMinus = findViewById(R.id.plus_minus);

        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(view -> {
            if(getString(R.string.display).equals(display.getText().toString())){
                display.setText("");
            }
        });

        root.setOnClickListener(view -> {
            try {
                String valStr = display.getText().toString();
                double result = Math.sqrt(Double.parseDouble(valStr));
                display.setText(String.valueOf(result));
                displayInSmallScr.setText("√(" + valStr + ")");
                textForSmallScr = String.valueOf(result);
            }
            catch (Exception e){
                Toast.makeText(this,"What was that?", Toast.LENGTH_SHORT).show();
            }
        });

        plusMinus.setOnClickListener(view -> {
            try {
                String valStr = display.getText().toString();
                double temp = Double.parseDouble(valStr);
                if(temp != 0) {
                    if (temp < 0) {
                        double result = Math.abs(Double.parseDouble(valStr));
                        textForSmallScr = String.valueOf(result);
                        display.setText(String.valueOf(result));
                        displayInSmallScr.setText(String.valueOf(result));
                    } else {
                        double result = -temp;
                        textForSmallScr = String.valueOf(result);
                        updateText(textForSmallScr);
                        display.setText(String.valueOf(result));
                        displayInSmallScr.setText(String.valueOf(result));
                    }
                }
            }
            catch (Exception e){
                Toast.makeText(this,"What was that?", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateText(String stringToAdd){
        display.setSelection(display.getText().length());
        try {
            String oldStr = display.getText().toString();
            int cursorPos = display.getSelectionStart();
            display.setSelection(display.getText().length());
            String leftStr = oldStr.substring(0, cursorPos);
            String rightStr = oldStr.substring(cursorPos);
            if(getString(R.string.display).equals(display.getText().toString())){
                display.setText(stringToAdd);
                display.setSelection(display.getText().length());
            }
            else{
                display.setText(String.format("%s%s%s", leftStr, stringToAdd, rightStr));
                display.setSelection(display.getText().length());
            }
        }
        catch (Exception e) {
            Toast.makeText(this,"What was that?", Toast.LENGTH_SHORT).show();
        }
    }

    private void setSmallScr(String valueBtn){
        textForSmallScr = textForSmallScr + valueBtn;
        displayInSmallScr.setText(textForSmallScr);
    }

    public void equalBTN(View view){
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double)engine.eval(textForSmallScr);
        } catch (ScriptException e) {
            Toast.makeText(this,"What was that?", Toast.LENGTH_SHORT).show();
        }
        if (result != null){
            display.setText(String.valueOf(result.doubleValue()));
        }
    }

    public void zeroBTN(View view){
        updateText("0");
        setSmallScr("0");
    }

    public void oneBTN(View view){
        updateText("1");
        setSmallScr("1");
    }

    public void twoBTN(View view){
        updateText("2");
        setSmallScr("2");
    }

    public void threeBTN(View view){
        updateText("3");
        setSmallScr("3");
    }

    public void fourBTN(View view){
        updateText("4");
        setSmallScr("4");
    }

    public void fiveBTN(View view){
        updateText("5");
        setSmallScr("5");
    }

    public void sixBTN(View view){
        updateText("6");
        setSmallScr("6");
    }

    public void sevenBTN(View view){
        updateText("7");
        setSmallScr("7");
    }

    public void eightBTN(View view){
        updateText("8");
        setSmallScr("8");
    }

    public void nineBTN(View view){
        updateText("9");
        setSmallScr("9");
    }

    public void minusBTN(View view){
        updateText("-");
        setSmallScr("-");
    }

    public void plusBTN(View view){
        updateText("+");
        setSmallScr("+");
    }

    public void multiplicationBTN(View view){
        updateText("*");
        setSmallScr("*");
    }

    public void divisionBTN(View view){
        updateText("/");
        setSmallScr("/");
    }

    public void rootBTN(View view){
        updateText("√");
        setSmallScr("√");
    }

    public void commaBTN(View view){
        updateText(".");
        setSmallScr(".");
    }

    public void ceBTN(View view){
        display.setText("");
        displayInSmallScr.setText("");
        textForSmallScr = "";
    }

    public void cBTN(View view){
        display.setText("");
        displayInSmallScr.setText("");
        textForSmallScr = "";
    }

    public void arrowBTN(View view){
        try {
            int cursorPos = display.getSelectionStart();
            int textLength = display.getText().length();
            if(cursorPos != 0 && textLength != 0){
                SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                selection.replace(cursorPos - 1, cursorPos, "");
                display.setText(selection);
                displayInSmallScr.setText(selection);
                textForSmallScr = String.valueOf(selection);
                display.setSelection(cursorPos - 1);
            }
        }
        catch (Exception e){
            Toast.makeText(this,"What was that?", Toast.LENGTH_SHORT).show();
        }
        display.setSelection(display.getText().length());
    }
}