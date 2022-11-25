package com.example.listviewlista;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listviewlista.adapter.JogaAdapter;
import com.example.listviewlista.databinding.ActivityMainBinding;
import com.example.listviewlista.model.Jogo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Jogo> itens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        itens.add(new Jogo("halo", "Xbox"));
        itens.add(new Jogo("God of War", "playstation"));
        JogaAdapter adapter = new JogaAdapter(getApplicationContext(), itens);
        binding.lista.setAdapter(adapter);

        binding.lista.setOnItemClickListener((parent, view1, position, id) ->
                Toast.makeText(MainActivity.this,
                        itens.get(position).getNome(),
                        Toast.LENGTH_SHORT).show());
    }
}