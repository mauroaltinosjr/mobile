package com.example.atividade_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class atividade1 extends AppCompatActivity {
    EditText editTextName;
    Button btnClickHere;
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade1);
        editTextName = (EditText) findViewById(R.id.editTextName);
        btnClickHere = (Button)findViewById(R.id.btnClickHere);
        textName = (TextView) findViewById(R.id.textName);

        btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                textName.setText(name);
            }
        });


    }
    public void displayToast(View v){
        Context context = getApplicationContext();
        CharSequence text = "Enviado";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);

        toast.show();
    }
}