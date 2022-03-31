package com.example.atividade_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class usoSqlite extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addButton;

    MyDatabaseHelper myDB;
    ArrayList<String>pessoaId, pessoaNome, pessoaCpf;
    CustomAdapter customAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uso_sqlite);

        recyclerView = findViewById(R.id.recyclerView);
        addButton = findViewById(R.id.bt_addPessoa);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(usoSqlite.this, addPessoa.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(usoSqlite.this);
        pessoaId = new ArrayList<>();
        pessoaNome = new ArrayList<>();
        pessoaCpf = new ArrayList<>();



        storeDataInArrays();


        customAdapter = new CustomAdapter(usoSqlite.this, pessoaId, pessoaNome, pessoaCpf);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(usoSqlite.this));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Nada a exibir", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                pessoaId.add(cursor.getString(0));
                pessoaNome.add(cursor.getString(1));
                pessoaCpf.add(cursor.getString(2));


            }
        }
    }
}