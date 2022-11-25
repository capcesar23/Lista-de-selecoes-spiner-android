package com.example.listviewlista.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listviewlista.R;
import com.example.listviewlista.model.Jogo;

import java.util.ArrayList;

public class JogaAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Jogo> itens;

    public JogaAdapter(Context context, ArrayList<Jogo> itens) {
        this.context = context;
        this.itens = itens;
    }

    //quantidade de itens na sua listagem
    @Override
    public int getCount() {
        return itens.size();
    }
    //pega a posição do item
    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }
    //posição do objeto
    @Override
    public long getItemId(int position) {
        return position;
    }
    //
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View inflater = LayoutInflater.from(context).inflate(R.layout.jogo_linha,parent,false);
        TextView txtNome = inflater.findViewById(R.id.nome);
        TextView txtPlataforma = inflater.findViewById(R.id.plataforma);
        txtNome.setText(itens.get(position).getNome());
        txtPlataforma.setText(itens.get(position).getPlataforma());

        return inflater;
    }
}
