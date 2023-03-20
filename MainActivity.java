package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText number1EditText;
    private EditText number2EditText;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1);
        number2EditText = findViewById(R.id.number2);
        addButton = findViewById(R.id.buttonPlus);
        subtractButton = findViewById(R.id.buttonMinus);
        multiplyButton = findViewById(R.id.buttonMultiply);
        divideButton = findViewById(R.id.buttonDivide);
        resultTextView = findViewById(R.id.result);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('/');
            }
        });
    }

    private void calculateResult(char operator) {
        double result = 0;
        double number1 = Double.parseDouble(number1EditText.getText().toString());
        double number2 = Double.parseDouble(number2EditText.getText().toString());

        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                }
                else {
                    resultTextView.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        resultTextView.setText(String.valueOf(result));
    }
}
