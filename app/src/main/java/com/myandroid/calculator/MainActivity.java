package com.myandroid.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtExpression, txtAnswer;
    private ImageButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9, btnPoint,
                        btnClear, btnChangeSign, btnPercentage, btnDivision, btnMultiplication,
                        btnSubtraction, btnAddition, btnEquals;

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

        }

    };
}
