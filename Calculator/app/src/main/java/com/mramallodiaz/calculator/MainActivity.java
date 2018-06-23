package com.mramallodiaz.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView tv_result, tv_history;
    public String display = "";
    public String displayTotal = "";
    public String currentOperator = "";
    private String result = "";

    public Button btn_dividir, btn_multiplicar, btn_borrarUno, btn_borrarTodo, btn_sumar, btn_restar, btn_igual, btn_borrarUnoHistorial;
    public Button btn_1, btn_2, btn_3,  btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_coma;



    //TODO HACERLO COMO LA CALCULADORA DE WINDOWS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = findViewById(R.id.tv_result);
        tv_history = findViewById(R.id.tv_history);
        tv_result.setText(display);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dividir = findViewById(R.id.btn_dividir);
        btn_multiplicar = findViewById(R.id.btn_multiplicar);
        btn_sumar = findViewById(R.id.btn_sumar);
        btn_restar = findViewById(R.id.btn_restar);
        btn_igual = findViewById(R.id.btn_igual);
        btn_borrarUno = findViewById(R.id.btn_borrarUno);
        btn_borrarTodo = findViewById(R.id.btn_borrarTodo);
        btn_coma = findViewById(R.id.btn_coma);
        btn_borrarUnoHistorial = findViewById(R.id.btn_borrarUnoHistorial);


        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_sumar.setOnClickListener(this);
        btn_restar.setOnClickListener(this);
        btn_multiplicar.setOnClickListener(this);
        btn_dividir.setOnClickListener(this);
        btn_igual.setOnClickListener(this);
        btn_borrarUno.setOnClickListener(this);
        btn_borrarTodo.setOnClickListener(this);
        btn_coma.setOnClickListener(this);
        btn_borrarUnoHistorial.setOnClickListener(this);


    }


    public void updateScreen(){
        tv_result.setText(display);
        tv_history.setText(displayTotal);
    }

    public void onClickNumber(View v){
        if(result != "") {
            clear();
            updateScreen();
        }
        Button b = (Button) v;
        display += b.getText();
        displayTotal += b.getText();
        updateScreen();
    }


    public boolean isOperator(char op){
        switch (op){
            case '+':
            case '-':
            case '*':
            case '/': return true;
            default: return false;
        }
    }


    public void onClickOperator(View v){

        if(display == "") return;

        Button b = (Button) v;

        if(result != ""){
            String _display  = result;
            clear();
            display = _display;
        }

        if(currentOperator != ""){
            Log.e("calc", "" + display.charAt(display.length() - 1 ));

            if(isOperator(display.charAt(display.length() - 1 ))){
               display = display.replace(display.charAt(display.length() - 1) , b.getText().charAt(0));
               displayTotal = display.replace(display.charAt(display.length() - 1) , b.getText().charAt(0));
               updateScreen();
               return;
            } else {
                getResult();
                display = result;
                result = "";
            }
            currentOperator = b.getText().toString();
        }

        display += b.getText();
        displayTotal += b.getText();
        currentOperator = b.getText().toString();
        updateScreen();
    }

    public void clear(){
        display = "";
        currentOperator = "";
        result = "";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }


    public double operate (String a, String b, String op){
        switch (op){
            case "+":
                return  Double.valueOf(a) + Double.valueOf(b);
            case "-":
                return Double.valueOf(a) - Double.valueOf(b);
            case "*":
                return  Double.valueOf(a) * Double.valueOf(b);
            case "/":
                try{
                    return Double.valueOf(a) / Double.valueOf(b);
                } catch (Exception e){
                    Log.e("Calc", e.getMessage());
                }

            default: return -1;
        }
    }


    public boolean getResult(){
        if(currentOperator == "") return  false;
        String[] operation = display.split(Pattern.quote(currentOperator));
        if(operation.length < 2) return false;
        result = String.valueOf(operate(operation[0], operation[1], currentOperator));
        return true;
    }

    public void onClickEqual(View v){
        if(display == "") return;
        if(!getResult()) return;
        tv_result.setText(String.valueOf(result));
    }


    public void borrarUno(){
        if(!tv_result.getText().toString().equals("")){
            tv_result.setText(tv_result.getText().subSequence(0, tv_result.getText().length() - 1) + "");
        }
    }

    public void borrarUnoHistorial(){
        if(!tv_history.getText().toString().equals("")){
            tv_history.setText(tv_history.getText().subSequence(0, tv_history.getText().length() -1) + "");
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                onClickNumber(v);
                break;

            case R.id.btn_1:
                onClickNumber(v);
                break;

            case R.id.btn_2:
                onClickNumber(v);
                break;

            case R.id.btn_3:
                onClickNumber(v);
                break;

            case R.id.btn_4:
                onClickNumber(v);
                break;

            case R.id.btn_5:
                onClickNumber(v);
                break;

            case R.id.btn_6:
                onClickNumber(v);
                break;

            case R.id.btn_7:
                onClickNumber(v);
                break;

            case R.id.btn_8:
                onClickNumber(v);
                break;

            case R.id.btn_9:
                onClickNumber(v);
                break;

            case R.id.btn_sumar:
                onClickOperator(v);
                break;

            case R.id.btn_restar:
                onClickOperator(v);
                break;

            case R.id.btn_multiplicar:
                onClickOperator(v);
                break;

            case R.id.btn_dividir:
                onClickOperator(v);
                break;

            case R.id.btn_igual:
                onClickEqual(v);
                break;

            case R.id.btn_borrarTodo:
                onClickClear(v);
                break;

            case R.id.btn_borrarUno:
                borrarUno();
                break;

            case R.id.btn_coma:
                onClickNumber(v);
                break;

            case R.id.btn_borrarUnoHistorial:
                borrarUnoHistorial();
                break;

                default:
                    break;
        }

    }
}
