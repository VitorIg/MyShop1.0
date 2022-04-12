package com.example.myappbrq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myappbrq.BancoDeDados.BancoSQLite;
import com.example.myappbrq.Modelo.Cliente;
import com.example.myappbrq.Modelo.Vendedor;

public class Main_Perfil_Vendedor extends AppCompatActivity {

    ImageButton TelaPlanoPremium, BtnPefilVendedorLogoff;
    TextView TxtNomePerfilVendedor, TxtEmailPerfilVendedor, TxtCpfPerfilVendedor, TxtTelefonePerfilVendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perfil_vendedor);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TxtNomePerfilVendedor = findViewById(R.id.TxtNomePerfilVendedor);
        TxtEmailPerfilVendedor = findViewById(R.id.TxtEmailPerfilVendedor);
        TxtCpfPerfilVendedor = findViewById(R.id.TxtCpfPerfilVendedor);
        TxtTelefonePerfilVendedor = findViewById(R.id.TxtTelefonePerfilVendedor);
        BtnPefilVendedorLogoff = findViewById(R.id.BtnPefilVendedorLogoff);

        BancoSQLite db = new BancoSQLite(this);
        Vendedor vendedor = db.selecionarInformacoesVendedor("1");

        TxtNomePerfilVendedor.setText(vendedor.getNome());
        TxtEmailPerfilVendedor.setText(vendedor.getEmail());
        TxtTelefonePerfilVendedor.setText(vendedor.getTelefone());
        TxtCpfPerfilVendedor.setText(vendedor.getDocumento());



        TelaPlanoPremium = findViewById(R.id.ibtnTelaPlanoPremium);
        TelaPlanoPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastrar = new Intent(getApplicationContext(),termoPlanoPremium.class);
                startActivity(cadastrar);
            }
        });

        BtnPefilVendedorLogoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(it);
            }
        });
    }
}


