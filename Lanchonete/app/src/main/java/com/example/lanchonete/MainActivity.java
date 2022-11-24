package com.example.lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Integer quantity = 0;

    TextView totalMessage;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incrementQuantity();
        decrementQuantity();

        totalMessage = findViewById(R.id.totalMessage);
        totalMessage.setVisibility(View.GONE);

    }

    //incrementa quantidade
    private void incrementQuantity(){

        Button incrementButton = findViewById(R.id.increment);// botão de soma
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificando e não deixando ser maior que 10
                if (quantity <10){
                    quantity ++;
                }

                TextView quantityText = findViewById(R.id.quantity);
                quantityText.setText(String.valueOf(quantity));
                orderButton();
            }
        });
    }

    private void decrementQuantity(){

        Button decrementButton = findViewById(R.id.decrement);
        decrementButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificando e não deixando ser menor que 1
                if (quantity > 0){
                    quantity --;
                }

                TextView quantityText = findViewById(R.id.quantity);
                quantityText.setText(String.valueOf(quantity));
            }
        }));
    }

    private void orderButton(){
        Button order = findViewById(R.id.order);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                totalMessage = findViewById(R.id.totalMessage);

                EditText etName = findViewById(R.id.name);

                totalMessage.setText("Your total is $ " + String.valueOf(quantity * 15) + " ! " + "\n" +
                        "Thanks for buying with us! " + etName.getText().toString());

                totalMessage.setVisibility(View.VISIBLE);
            }
        });
    }
}