package com.example.recycleview.recycleView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;

public class JogoViewHolder extends RecyclerView.ViewHolder {

    public TextView nome, plataforma;

    public JogoViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.nome);
        plataforma = itemView.findViewById(R.id.plataforma);
    }
}
