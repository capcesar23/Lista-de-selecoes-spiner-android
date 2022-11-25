package com.example.calendario;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calendario.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.submitButton.setOnClickListener(v -> {
            String dia = "Dia = " + binding.date.getDayOfMonth();
            String mes = "Mês = " + binding.date.getMonth();
            String ano = "Ano = " + binding.date.getYear();

            Toast.makeText(getApplicationContext(), dia + "/" + mes + "/" + ano , Toast.LENGTH_SHORT).show();
        });

    }
}