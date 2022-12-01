package com.example.agendaandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agendaandroid.databinding.ActivityTelaConsultaBinding;

public class TelaConsulta extends AppCompatActivity {

    ActivityTelaConsultaBinding binding;

    SQLiteDatabase db = null;//chamando banco de dados
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaConsultaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        buscarDados();
        binding.btnVoltarConsulta.setOnClickListener(v -> voltarTelaMain());
      /*  binding.btnAnteriorConsulta.setOnClickListener(v -> registroAnterior());
        binding.btnProximoConsulta.setOnClickListener(v -> proximoRegistro());
*/
    }
    /*
     * inicio da configuração do banco de dados
     * */

    //método abrir  o banco de dados
    public void abrirDB() {
        try {
            db = openOrCreateDatabase("bancoAgenda", MODE_PRIVATE, null);
        } catch (Exception e) {
            msg("Erro ao abrir ou criar o banco de dados!");
        }/* finally {
            msg("Banco de dados aberto");
        }*/

    }

    //método para buscar registro
    public void buscarDados() {
        abrirDB();
        cursor = db.query("contatos",
                new String[]{"nome", "fone"},
                null,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            mostraDados();
        } else {
            msg("Nenhum dados encontrado!");
        }
    }
    // método mostrar dados na tela

    public void mostraDados() {
       // binding.etNomeConsulta.setText(cursor.getString(cursor.getColumnIndex("nome")));
        //binding.etTelefoneConsulta.setText(cursor.getString(cursor.getColumnIndex("fone")));
    }

    /*
    //Buscra proximo registro
    public void proximoRegistro() {
        cursor.moveToNext();
    }

    //buscar registro anterior
    public void registroAnterior() {
        cursor.moveToPrevious();
    }
    */



    /*
     * Fim da configuração do banco de dados
     * */

    // configurando mensagens de alerta para melhor identificar
    public void msg(String txt) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setMessage(txt);
        adb.setNeutralButton("OK", null);
        adb.show();
    }


    public void voltarTelaMain() {
        Intent it_tela_main = new Intent(this, MainActivity.class);
        startActivity(it_tela_main);
        finish();
    }
}