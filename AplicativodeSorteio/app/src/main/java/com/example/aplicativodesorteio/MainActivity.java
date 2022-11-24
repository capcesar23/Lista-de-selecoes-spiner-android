package com.example.aplicativodesorteio;

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
    //método responsavel para dispara o aplicativo
    public void jogar(View view){
        TextView textResultado;

        textResultado = findViewById(R.id.textResultado);//procure por uma view pelo id

        int numero = new Random().nextInt(11);//número raleatório, de 0 à 10

        textResultado.setText("Número sorteado: " + numero);
    }
}