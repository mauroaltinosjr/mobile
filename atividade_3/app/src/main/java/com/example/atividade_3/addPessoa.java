package com.example.atividade_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addPessoa extends AppCompatActivity {

    EditText et_pessoaNome, et_pessoaCpf;
    Button bt_cadastra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pessoa);

        et_pessoaNome = findViewById(R.id.et_Nome);
        et_pessoaCpf = findViewById(R.id.et_Cpf);
        bt_cadastra = findViewById(R.id.bt_cadastra);

        bt_cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(addPessoa.this);
                myDB.addPessoa(et_pessoaNome.getText().toString().trim(),
                        et_pessoaCpf.getText().toString().trim());
            }
        });
    }
}