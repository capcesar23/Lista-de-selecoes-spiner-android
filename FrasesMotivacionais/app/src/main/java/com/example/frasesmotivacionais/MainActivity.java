package com.example.frasesmotivacionais;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mudarFrase(View view){
        TextView textFrases;

        textFrases = findViewById(R.id.textFrases);

        String[] frases = {
                "Sonhos são caminhos construídos pelo coração.",
                "Impossível é uma palavra que serve só de enfeite no dicionário.",
                "Você é beleza, luz e força.",
                "Dias nublados guardam o sol atrás deles.",
                "Um dia bonito começa com um barril de esperança e um café de otimismo.",
                "Permita que o seu corpo descanse.",
                "Por trás de um dia difícil, há uma versão forte de você que sempre seguiu em frente."
        };

        int n = new Random().nextInt(frases.length);//procurar no tamanho do indice

        textFrases.setText(frases[n]);//retorna o valor de n
    }
}