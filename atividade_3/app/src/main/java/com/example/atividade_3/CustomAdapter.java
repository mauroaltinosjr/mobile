package com.example.atividade_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private Context context;
    private ArrayList pessoaId, pessoaNome, pessoaCpf;

    CustomAdapter(Context context,
                  ArrayList pessoaId,
                  ArrayList pessoaNome,
                  ArrayList pessoaCpf){
        this.context = context;
        this.pessoaId = pessoaId;
        this.pessoaNome = pessoaNome;
        this.pessoaCpf = pessoaCpf;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_pessoaId.setText(String.valueOf(pessoaId.get(position)));
        holder.tv_pessoaNome.setText(String.valueOf(pessoaNome.get(position)));
        holder.tv_pessoaCpf.setText(String.valueOf(pessoaCpf.get(position)));

    }

    @Override
    public int getItemCount() {
        return pessoaId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_pessoaId, tv_pessoaNome, tv_pessoaCpf;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_pessoaId = itemView.findViewById(R.id.tv_pessoaId);
            tv_pessoaNome = itemView.findViewById(R.id.tv_pessoaNome);
            tv_pessoaCpf = itemView.findViewById(R.id.tv_pessoaCpf);

        }
    }
}
