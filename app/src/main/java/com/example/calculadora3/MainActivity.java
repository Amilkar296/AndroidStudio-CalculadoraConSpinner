package com.example.calculadora3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.num1);
        et2 = (EditText) findViewById(R.id.num2);
        tv1 = (TextView) findViewById(R.id.respuesta);
        sp1 = (Spinner) findViewById(R.id.spi);

        String[] opciones = {"SUMAR", "RESTAR", "MULTIPLICAR", "dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item_personalizado, opciones);
        sp1.setAdapter(adapter);
    }

    public void calcular(View View) {
        String v1_s = et1.getText().toString();
        String v2_s = et2.getText().toString();
        int n1 = Integer.parseInt(v1_s);
        int n2 = Integer.parseInt(v2_s);
        String selec = sp1.getSelectedItem().toString();

        if (selec.equals("SUMAR")) {
            int sum = n1 + n2;
            String result = String.valueOf(sum);
            tv1.setText(result);
        }

        if (selec.equals("RESTAR")) {
            int res = n1 - n2;
            String result = String.valueOf(res);
            tv1.setText(result);
        }

        if (selec.equals("MULTIPLICAR")) {
            int mul = n1 * n2;
            String result = String.valueOf(mul);
            tv1.setText(result);
        }

        if (selec.equals("dividir")) {
            if (n2 != 0) {
                int div = n1 / n2;
                String result = String.valueOf(div);
                tv1.setText(result);
            } else {
                Toast.makeText(this, "Resultado Infinito", Toast.LENGTH_SHORT).show();
            }
        }
    }
}