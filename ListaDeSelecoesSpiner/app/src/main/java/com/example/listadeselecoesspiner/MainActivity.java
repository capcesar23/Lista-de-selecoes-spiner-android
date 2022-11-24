package com.example.listadeselecoesspiner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadeselecoesspiner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //criando o spinner e buscando dados do array na string.xml debtro da pasta values
        // Crie um ArrayAdapter usando a matriz de string e um layout giratório padrão
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this,
                //chama o array de nome opcoes no string.xml, tem a opcao de chamar no banco de dados
                R.array.opcoes, android.R.layout.simple_spinner_item);
        // Especifique o layout a ser usado quando a lista de opções aparecer
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplique o adaptador no spinner
        binding.lista.setAdapter(adapter);


        //pegando a seleção no dropdown/spinner com o botão e enviando para textView
        binding.botao.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this,
                    "Você escolheu " + binding.lista.getSelectedItem() + "!",
                    Toast.LENGTH_SHORT).show();
            binding.textView.setText((CharSequence) binding.lista.getSelectedItem());
        });
    }
}