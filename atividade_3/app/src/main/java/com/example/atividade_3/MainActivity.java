package com.example.atividade_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button atividade1, atividade1_2, atividade2, atividade3, conversor, imc, WS, bt_sqlite;
    private ShareActionProvider shareAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        atividade1 = findViewById(R.id.bt_atividade1);
        atividade1_2 = findViewById(R.id.bt_atividade1_2);
        atividade2 = findViewById(R.id.bt_atividade2);
        atividade3 = findViewById(R.id.bt_atividade3);
        conversor = findViewById(R.id.bt_conversor);
        imc = findViewById(R.id.bt_imc);
        WS = findViewById(R.id.bt_webService);
        bt_sqlite = findViewById(R.id.bt_sqlite);

        atividade1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), atividade1.class);
                startActivity(intent);
            }
        });

        atividade1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Atividade1_tarefa2.class);
                startActivity(intent);
            }
        });

        atividade2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Atividade2.class);
                startActivity(intent);
            }
        });

        conversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_convert.class);
                startActivity(intent);
            }
        });
        imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), calculaIMC.class);
                startActivity(intent);
            }
        });
        bt_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), usoSqlite.class);
                startActivity(intent);
            }
        });

        WS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), webService.class);
                startActivity(intent);
            }
        });

    }

    //SearchView
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);

        //Search
        MenuItem searchItem = menu.findItem(R.id.busca);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(onSearch());


        return true;
    }



    private SearchView.OnQueryTextListener onSearch(){
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                return false;
            }
        };
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.atividade1:
                Intent intent = new Intent(MainActivity.this, atividade1.class);
                startActivity(intent);
                break;
            case R.id.activity_convert:
                Intent intent1 = new Intent(MainActivity.this, activity_convert.class);
                startActivity(intent1);
                break;
            case R.id.calculaIMC:
                Intent intent2 = new Intent(MainActivity.this, calculaIMC.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}