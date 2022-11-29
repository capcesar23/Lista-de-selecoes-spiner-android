package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycleview.adapter.JogoAdapter;
import com.example.recycleview.model.Jogo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycler = findViewById(R.id.recyclerView);
        ArrayList<Jogo> itens = new ArrayList<>();
        itens.add(new Jogo("Halo", "Xbox"));
        itens.add(new Jogo("God of War", "Playstation"));
        JogoAdapter adapter = new JogoAdapter(getApplicationContext(), itens);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

    }
}