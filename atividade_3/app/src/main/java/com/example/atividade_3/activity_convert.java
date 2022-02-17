package com.example.atividade_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_convert extends AppCompatActivity {
    EditText editTextValor;
    Button btnClickHere;
    TextView textViewDolar;
    TextView textViewPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        editTextValor = findViewById(R.id.editTextValor);
        btnClickHere = findViewById(R.id.btnClickHere);
        textViewDolar = findViewById(R.id.textViewDolar);
        textViewPeso = findViewById(R.id.textViewPeso);

        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorReal = Double.parseDouble(editTextValor.getText().toString());

                double valorDolar = valorReal * 5.17;
                double valorPeso = valorReal / 0.12;

                textViewDolar.setText(String.valueOf(valorDolar));
                textViewPeso.setText(String.valueOf(valorPeso));
            }
        });
    }
}