package com.example.recycleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.model.Jogo;
import com.example.recycleview.recycleView.JogoViewHolder;

import java.util.ArrayList;

public class JogoAdapter extends RecyclerView.Adapter<JogoViewHolder> {

    private final Context context;
    private final ArrayList<Jogo> itens;

    public JogoAdapter(Context context, ArrayList<Jogo> itens) {
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public JogoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jogo_linha, parent, false);
        return new JogoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JogoViewHolder jogoViewHolder, int position) {
        Jogo jogo = itens.get(position);
        jogoViewHolder.nome.setText(jogo.getNome());
        jogoViewHolder.plataforma.setText(jogo.getPlataforma());

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
