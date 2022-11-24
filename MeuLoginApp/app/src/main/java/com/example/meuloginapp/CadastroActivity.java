package com.example.meuloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.meuloginapp.databinding.ActivityCadastroBinding;
import com.example.meuloginapp.databinding.ActivityMainBinding;

public class CadastroActivity extends AppCompatActivity {

    // objeto para receber a vinculação do binding
    ActivityCadastroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //arquivo de vienculação com nome da classe de layout
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        //criação de variavél de vinculação
        View view = binding.getRoot();
        setContentView(view);

        /*
         * configurando o login de usuario
         * usuario admin senha  admin
         * ao apertar o botão login
         * se estiver correto o textView username e textView password
         * lance a mensagem "Login successfull"
         * se estiver errado
         * lance a mensagem "Login failed"
         * */
        //
        binding.cadastrarbtn.setOnClickListener(v -> {
           // binding.username.getText().toString();
            Toast.makeText(CadastroActivity.this,
                    "Seu nome é " + binding.username.getText().toString() + "! " , Toast.LENGTH_SHORT)
                    .show();

           /*
           if (binding.username.getText().toString().equals("admin")
                    && binding.password.getText().toString().equals("admin")){
                //correto
                Toast.makeText(CadastroActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
            }else {
                //incorreto
                Toast.makeText(CadastroActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }*/
        });
    }
}