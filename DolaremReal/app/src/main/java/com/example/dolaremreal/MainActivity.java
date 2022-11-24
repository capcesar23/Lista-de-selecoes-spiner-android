package com.example.dolaremreal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void converter(View view){

        EditText editDolar;
        TextView textResultado;

        editDolar = findViewById(R.id.editDolar);
        textResultado = findViewById(R.id.textResultado);

        //converter texto em número
        Double valorDolar = Double.parseDouble(editDolar.getText().toString());

        Double valorConvertido = valorDolar * 5.38;

        textResultado.setText("Valor em R$: " + valorConvertido);

    }
}