package com.example.myappbrq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class termoPlanoPremium extends AppCompatActivity {

    ImageButton BotaoPefil;
    ImageButton BotaoLista;
    ImageButton BotaoHome;
    ImageButton BotaoCarrinho;
    ImageButton BotaoVendedor;
    Button BotaoPlanoPremium;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termo_plano_premium);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BotaoPefil = findViewById(R.id.botaoPefil);

        BotaoPefil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(it);
            }
        });

        BotaoLista = findViewById(R.id.botaoLista);

        BotaoLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lista = new Intent(getApplicationContext(), listaDeProdutos.class);
                startActivity(lista);
            }
        });



        BotaoCarrinho = findViewById(R.id.botaoCarrinho);

        BotaoCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Carrinho = new Intent(getApplicationContext(), MainCarrinho.class);
                startActivity(Carrinho);
            }
        });

        BotaoHome = findViewById(R.id.btnHome);

        BotaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Home);
            }
        });

        BotaoPlanoPremium = findViewById(R.id.btnContratarPlanoPremium);

        BotaoPlanoPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(getApplicationContext(), mensgamPagamentoPlano.class);
                startActivity(Home);
            }
        });




    }
}