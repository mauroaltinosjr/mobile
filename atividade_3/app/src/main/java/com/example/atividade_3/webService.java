package com.example.atividade_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class webService extends AppCompatActivity {

    EditText et_buscaWS;
    TextView tv_mostraWS;
    Button bt_chamaWS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        et_buscaWS = findViewById(R.id.et_buscaWS);
        tv_mostraWS = findViewById(R.id.tv_mostraWS);
        bt_chamaWS = findViewById(R.id.bt_chamaWS);

        bt_chamaWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_buscaWS.getText().toString().length() > 0 && !et_buscaWS.getText().toString().equals("") && et_buscaWS.getText().toString().length() == 8) {
                    HTTPService service = new HTTPService(et_buscaWS.getText().toString());
                    try {
                        CEP retorno = service.execute().get();
                        tv_mostraWS.setText(retorno.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}