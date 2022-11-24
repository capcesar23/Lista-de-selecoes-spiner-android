package com.example.botaogoogle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.botaogoogle.databinding.ActivityMainBinding;
import com.example.botaogoogle.databinding.ActivitySegundaBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SegundaActivity extends AppCompatActivity {

    ActivitySegundaBinding binding;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //arquivo de vienculação com nome da classe de layout
        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        //criação de variavél de vinculação
        View view = binding.getRoot();
        setContentView(view);



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!= null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            binding.name.setText(personName);
            binding.email.setText(personEmail);
        }
        binding.signInOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    private void signOut() {
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(SegundaActivity.this,MainActivity.class));
            }
        });
    }
}