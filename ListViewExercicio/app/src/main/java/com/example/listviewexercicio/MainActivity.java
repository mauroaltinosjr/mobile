package com.example.listviewexercicio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ArrayList<String> lista = new ArrayList<String>();
    EditText et_nomeBebida,et_marcaBebida, et_precoBebida, et_id;
    Button bt_cadastrar, bt_deletar, bt_limpar, bt_atualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_cadastrar = findViewById(R.id.bt_cadastrar);
        bt_deletar = findViewById(R.id.bt_deletar);
        bt_atualizar = findViewById(R.id.bt_alterar);
        bt_cadastrar.setEnabled(true);
        bt_atualizar.setEnabled(false);
        bt_deletar.setEnabled(false);

        SQLiteDatabase db = openOrCreateDatabase("lvbanco", Context.MODE_PRIVATE, null);
        String sql = "CREATE TABLE IF NOT EXISTS bebida(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nomeBebida TEXT, marcaBebida TEXT, precoBebida TEXT);";
        db.execSQL(sql);

        ListView lv = findViewById(R.id.lv_bebidas);
            try {
                Cursor c = db.query("bebida", null, null, null, null, null, null, null);

                c.moveToFirst();

                lista.clear();
                do {
                    lista.add(c.getString(0).toString()+"\n"+
                            c.getString(1).toString()+"\n"+
                            c.getString(2).toString()+"\n"+
                            c.getString(3).toString());
                } while (c.moveToNext());
            } catch (Exception e) {
                e.toString();
            }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        lv.setAdapter(adaptador);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView av, View view, int i, long l) {
                String itemSelecionado = (String) av.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), itemSelecionado, Toast.LENGTH_SHORT).show();
                String[] texto = itemSelecionado.split("\n");

                et_id = findViewById(R.id.et_id);
                et_nomeBebida = findViewById(R.id.et_bebida);
                et_marcaBebida = findViewById(R.id.et_marca);
                et_precoBebida = findViewById(R.id.et_valor);

                et_id.setText(texto[0].trim());
                et_nomeBebida.setText(texto[1].trim());
                et_marcaBebida.setText(texto[2].trim());
                et_precoBebida.setText(texto[3].trim());

                bt_cadastrar.setEnabled(false);
                bt_atualizar.setEnabled(true);
                bt_deletar.setEnabled(true);


            }
        });

        et_nomeBebida = findViewById(R.id.et_bebida);
        et_marcaBebida = findViewById(R.id.et_marca);
        et_precoBebida = findViewById(R.id.et_valor);
        et_id = findViewById(R.id.et_id);


        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("nomeBebida", et_nomeBebida.getText().toString());
                cv.put("marcaBebida", et_marcaBebida.getText().toString());
                cv.put("precoBebida", et_precoBebida.getText().toString());

                db.insert("bebida", null, cv);
            }
        });

        bt_deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.delete("bebida", "id = ?", new String[]{et_id.getText().toString()});

            }
        });

        bt_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("nomeBebida", et_nomeBebida.getText().toString());
                cv.put("marcaBebida", et_marcaBebida.getText().toString());
                cv.put("precoBebida", et_precoBebida.getText().toString());

                db.update("bebida", cv, "id = ?", new String[]{et_id.getText().toString()});
            }
        });

    }
}