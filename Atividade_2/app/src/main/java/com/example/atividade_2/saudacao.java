package com.example.atividade_2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class saudacao extends AppCompatActivity {

    private TextView tv;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saudacao);

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
