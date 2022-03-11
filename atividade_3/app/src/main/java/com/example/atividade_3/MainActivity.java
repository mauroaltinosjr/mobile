package com.example.atividade_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return true;
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