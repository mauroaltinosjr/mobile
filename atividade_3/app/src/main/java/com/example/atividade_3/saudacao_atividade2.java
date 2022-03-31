package com.example.atividade_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class saudacao_atividade2 extends AppCompatActivity {
    private TextView tv;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saudacao_atividade2);

        tv = (TextView) findViewById(R.id.saudacao);

        if(savedInstanceState != null){
            nome = savedInstanceState.getString("nome");

        }else{
            nome = "saudacao";
        }

        Bundle args = getIntent().getExtras();
        nome = args.getString("keynome");

        tv.setText("Olá, "+ nome);

    }
    protected void onSaveInstanceState(Bundle dados){
        super.onSaveInstanceState(dados);
        dados.putString("nome", nome);
    }
}