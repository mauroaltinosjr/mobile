package com.example.atividade_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Atividade2 extends DebugActivity implements View.OnClickListener {

    private TextView textViewSaudacao;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button btnEnviar;
    private String nome;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade2);

        textViewSaudacao = (TextView) findViewById(R.id.textViewSaudacao);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);


        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnEnviar){
            nome = editTextEmail.getText().toString();
            senha = editTextSenha.getText().toString();
            String name = "Admin";
            String password = "admin";

            if(nome.equals(name) && senha.equals(password)){

                Toast.makeText(getApplicationContext(),"Sucesso", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(this, saudacao_atividade2.class);
                Bundle params = new Bundle();
                params.putString("keynome", nome);
                intent.putExtras(params);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Email ou senha incorretos",Toast.LENGTH_LONG).show();
            }
        }

    }
}