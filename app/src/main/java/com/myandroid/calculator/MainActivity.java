package com.myandroid.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtExpression, txtAnswer;
    private ImageButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9, btnPoint,
                        btnClear, btnChangeSign, btnPercentage, btnDivision, btnMultiplication,
                        btnSubtraction, btnAddition, btnEquals;

    private String expression = "";
    private char lastCharacter;
    private boolean isPointUsed = false;

    //ExpressionState
    // 1 mean enter number sate
    // 2 mean last enter char is symbol
    private int expressionState = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtExpression = findViewById(R.id.txtExpression);
        txtAnswer = findViewById(R.id.txtAnswer);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPoint = findViewById(R.id.btnPoint);
        btnClear = findViewById(R.id.btnClear);
        btnChangeSign = findViewById(R.id.btnChangeSign);
        btnPercentage = findViewById(R.id.btnPercentage);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnAddition = findViewById(R.id.btnAddition);
        btnEquals = findViewById(R.id.btnEquals);

        txtExpression.setText("");
        txtAnswer.setText("0");

        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btnPoint.setOnClickListener(listener);
        btnClear.setOnClickListener(listener);
        btnChangeSign.setOnClickListener(listener);
        btnPercentage.setOnClickListener(listener);
        btnDivision.setOnClickListener(listener);
        btnMultiplication.setOnClickListener(listener);
        btnSubtraction.setOnClickListener(listener);
        btnAddition.setOnClickListener(listener);
        btnEquals.setOnClickListener(listener);



    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn0:
                    enterNumber('0');
                    break;
                case R.id.btn1:
                    enterNumber('1');
                    break;
                case R.id.btn2:
                    enterNumber('2');
                    break;
                case R.id.btn3:
                    enterNumber('3');
                    break;
                case R.id.btn4:
                    enterNumber('4');
                    break;
                case R.id.btn5:
                    enterNumber('5');
                    break;
                case R.id.btn6:
                    enterNumber('6');
                    break;
                case R.id.btn7:
                    enterNumber('7');
                    break;
                case R.id.btn8:
                    enterNumber('8');
                    break;
                case R.id.btn9:
                    enterNumber('9');
                    break;
                case R.id.btnPoint:
                    if (!isPointUsed){
                        expression = expression + ".";
                        isPointUsed = true;
                        txtExpression.setText(expression);
                    }
                    break;
                case R.id.btnClear:
                    expression = "";
                    lastCharacter = '0';
                    txtExpression.setText(expression);
                    txtAnswer.setText("0");
                    break;
                case R.id.btnChangeSign:
                    ChangeSign();
                    break;
                case R.id.btnPercentage:
                    Percentage();
                    break;
                case R.id.btnDivision:
                    enterSymbol('÷');
                    break;
                case R.id.btnMultiplication:
                    enterSymbol('×');
                    break;
                case R.id.btnSubtraction:
                    enterSymbol('-');
                    break;
                case R.id.btnAddition:
                    enterSymbol('+');
                    break;
                case R.id.btnEquals:
                    printAnswer();
            }
        }

    };

    private void enterNumber(char number) {
        expression = expression + number;
        lastCharacter = number;
        expressionState = 1;
        txtExpression.setText(expression);
    }

    private void enterSymbol(char symbol) {
        if(symbol != '-') {
            if (expression.equals("")) {}
            else if (expressionState == 1) {
                enterNumber(symbol);
                expressionState = 2;
                isPointUsed = false;
            }
            else if (expressionState == 2 && lastCharacter != symbol) {
                replaceLastChar(symbol);
            } else if (expressionState == 3) {
                replaceLastTwoChar(symbol);
                expressionState = 2;
            }
        }
        // symbol = '-'
        else {
            if (expressionState == 1) {
                enterNumber('-');
                expressionState = 2;
                isPointUsed = false;
            }
            else if (expressionState == 2 && lastCharacter == '+') {
                replaceLastChar(symbol);
            }
            else if (expressionState == 2 && lastCharacter != '-') {
                enterNumber(symbol);
                expressionState = 3;
            }
        }
    }

    private void ChangeSign() {
        String temp = "";
        boolean isChange = false;
        for (int i = expression.length()-1; i > -1; i--) {
            if (expression.charAt(i) == '×' || expression.charAt(i) == '÷') {
                if (lastCharacter == '×' || lastCharacter == '÷') {
                    lastCharacter = '-';
                    expressionState = 3;
                }
                temp = '-' + temp;
                expression = expression.substring(0, i+1) + temp;
                txtExpression.setText(expression);
                isChange = true;
                break;
            }
            else if (expression.charAt(i) == '+') {
                if (lastCharacter == '+') {
                    lastCharacter = '-';
                    expressionState = 3;
                }
                temp = '-' + temp;
                expression = expression.substring(0, i) + temp;
                txtExpression.setText(expression);
                isChange = true;
                break;
            }
            else if (expression.charAt(i) == '-') {
                if (i == 0) {
                    if (lastCharacter == '-') {
                        lastCharacter = '0';
                        expressionState = 1;
                    }
                    expression = temp;
                }
                else if (expression.charAt(i-1) == '×'){
                    if (lastCharacter == '-') {
                        lastCharacter = '×';
                        expressionState = 2;
                    }
                    expression = expression.substring(0, i) + temp;
                }
                else if (expression.charAt(i-1) == '÷') {
                    if (lastCharacter == '-') {
                        lastCharacter = '÷';
                        expressionState = 2;
                    }
                    expression = expression.substring(0, i) + temp;
                }
                else {
                    if (lastCharacter == '-') {
                        lastCharacter = '+';
                    }
                    temp = '+' +temp;
                    expression = expression.substring(0, i) + temp;
                }

                txtExpression.setText(expression);
                isChange = true;
                break;
            }
            else {
                temp = expression.charAt(i) + temp;
            }
        }

        if (!isChange){
            expression = '-' + expression;
            txtExpression.setText(expression);
        }
    }

    private void Percentage() {
        if (lastCharacter >= '0' && lastCharacter <= '9' || lastCharacter == '%') {
            expression = expression + '%';
            lastCharacter = '%';
            txtExpression.setText(expression);
        }
    }


    private void replaceLastChar(char symbol) {
        char[] temp = expression.toCharArray();
        temp[temp.length-1] = symbol;
        expression = new String(temp);
        lastCharacter = symbol;
        txtExpression.setText(expression);
    }

    private void replaceLastTwoChar(char symbol) {
        char[] temp = expression.toCharArray();
        char[] result = new char[temp.length-1];
        for (int i = 0; i < result.length-1; i++) {
            result[i] = temp[i];
        }
        result[result.length-1] = symbol;
        expression = new String(result);
        lastCharacter = symbol;
        txtExpression.setText(expression);
    }

    private void printAnswer() {

        for (int i = 0; i < expression.length(); i++) {
            ArrayList<Double> numbers = new ArrayList<>();
            ArrayList<Character> symbols = new ArrayList<>();
            String temp = "";

            if (expression.charAt(i) == '-') {
                if (i == 0 || expression.charAt(i-1) == '×'
                        || expression.charAt(i-1) == '÷' || expression.charAt(i-1) == '+') {
                    temp = temp + "-";
                }
            }
            else if (expression.charAt(i) == '×' || expression.charAt(i) == '÷' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {

            }
        }


    }
}
