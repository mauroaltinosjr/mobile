package com.example.atividade_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculaIMC extends AppCompatActivity {
    EditText editTextAltura;
    EditText editTextPeso;
    Button btnClickHere;
    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_imc);

        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);
        btnClickHere = findViewById(R.id.btnClickHere);
        textViewResultado = findViewById(R.id.textViewResultado);

        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int altura = Integer.parseInt(editTextAltura.getText().toString());
                int peso = Integer.parseInt(editTextPeso.getText().toString());

                double alturaCm = altura / 100;

                double resultado = peso / (alturaCm * alturaCm);

                if(resultado < 18.5){
                    textViewResultado.setText(String.valueOf("Abaixo do peso"));
                }else if(resultado >= 18.5 && resultado <= 24.9){
                    textViewResultado.setText(String.valueOf("Peso normal"));
                }else if(resultado >= 25 && resultado <= 29.9){
                    textViewResultado.setText(String.valueOf("Sobrepeso"));
                }else if(resultado >= 30 && resultado <= 34.9){
                    textViewResultado.setText(String.valueOf("Obesidade grau I"));
                }else if(resultado >= 35 && resultado <= 39.9){
                    textViewResultado.setText(String.valueOf("Obesidade grau II"));
                }else if(resultado >= 40){
                    textViewResultado.setText(String.valueOf("Obesidade grau III ou mórbida"));
                }

            }
        });


    }

}
