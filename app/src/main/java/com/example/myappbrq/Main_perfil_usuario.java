package com.example.myappbrq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;

import com.example.myappbrq.BancoDeDados.BancoSQLite;
import com.example.myappbrq.Modelo.Cliente;
import com.example.myappbrq.Modelo.Vendedor;

public class Main_perfil_usuario extends AppCompatActivity {

    TextView TxtNomePerfil, TxtEmailPerfil, TxtCpfPerfil, TxtTelefonePerfil;
    EditText EdtAtualizaEmailPerfil, EdtAtualizaTelefonePerfil, EdtAtualizaCepPerfil, EdtAtualizaEnderecoPerfil,
            EdtAtualizaBairroPerfil, EdtAtualizaCidadePerfil, EdtAtualizaEstadoPerfil;
    ImageButton BtnLogoffHome, imgPerfilHome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perfil_usuario);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TxtNomePerfil = findViewById(R.id.TxtNomePerfil);
        TxtEmailPerfil = findViewById(R.id.TxtEmailPerfil);
        TxtCpfPerfil = findViewById(R.id.TxtCpfPerfil);
        TxtTelefonePerfil = findViewById(R.id.TxtTelefonePerfil);
        BtnLogoffHome = findViewById(R.id.BtnPefilUsuarioLogoff);

        BancoSQLite db = new BancoSQLite(this);
        Cliente cliente = db.selecionarInformacoesCliente("1");

        TxtNomePerfil.setText(cliente.getNome());
        TxtEmailPerfil.setText(cliente.getEmail());
        TxtTelefonePerfil.setText(cliente.getTelefone());
        TxtCpfPerfil.setText(cliente.getDocumento());


        Vendedor vendedor = db.selecionarInformacoesVendedor("1");

        TxtNomePerfil.setText(vendedor.getNome());
        TxtEmailPerfil.setText(vendedor.getEmail());
        TxtTelefonePerfil.setText(vendedor.getTelefone());
        TxtCpfPerfil.setText(vendedor.getTelefone());



        BtnLogoffHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent it = new Intent(getApplicationContext(), MainLogin.class);
               startActivity(it);
            }
        });






    }
}