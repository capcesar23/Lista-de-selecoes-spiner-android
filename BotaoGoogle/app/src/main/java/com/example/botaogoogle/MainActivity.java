package com.example.botaogoogle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.botaogoogle.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    // objeto para receber a vinculação do binding
    ActivityMainBinding binding;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //arquivo de vienculação com nome da classe de layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //criação de variavél de vinculação
        View view = binding.getRoot();
        setContentView(view);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!= null){
            irParaSegundaAtivity();
        }


        binding.botaoGoogle.setOnClickListener(v -> {
            signIn();
        });
    }

    private void signIn() {
        Intent SignInIntent = gsc.getSignInIntent();
        startActivityForResult(SignInIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1000){
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            task.getResult(ApiException.class);
            irParaSegundaAtivity();
        }catch (ApiException e){
            Toast.makeText(getApplicationContext(), "Erro ao realizar Login!", Toast.LENGTH_SHORT).show();
        }
        }
    }

    private void irParaSegundaAtivity() {
        finish();
        Intent intent = new Intent(MainActivity.this,SegundaActivity.class);
        startActivity(intent);
    }
}