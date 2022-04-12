package com.example.myappbrq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {

        ImageButton Btn_Figura_A, Btn_Figura_B;
        ImageView Imgv_foto;
        TextView Txv_rotulos;

        ImageButton BotaoPefil;
        ImageButton BotaoLista;
        ImageButton BotaoHome;
        ImageButton BotaoCarrinho;
        ImageButton BotaoVenda;
        ImageButton BotaoContato;
        ImageButton BotaoCaloi1;
        ImageButton BotaoGalaxy1;
        ImageButton BotaoCamisa1;
        ImageButton BotaoMotorola1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        Btn_Figura_A = findViewById(R.id.btn_Figura_A);
        Btn_Figura_B = findViewById(R.id.btn_Figura_B);

        Txv_rotulos = findViewById(R.id.txv_rotulos);
        Imgv_foto = findViewById(R.id.imgv_foto);

        Btn_Figura_A.setOnClickListener(view -> {
            Txv_rotulos.setText("Figura A");
            Imgv_foto.setImageResource(R.drawable.images__4_);
        });


        Btn_Figura_B.setOnClickListener(view -> {
            Txv_rotulos.setText("Figura B");
            Imgv_foto.setImageResource(R.drawable.download);
        });




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

        BotaoContato = findViewById(R.id.botaoSuporte);

        BotaoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Contato = new Intent(getApplicationContext(), MainContato.class);
                startActivity(Contato);
            }
        });



        BotaoCaloi1 = findViewById(R.id.IbtnHomeProduto3);

        BotaoCaloi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Caloi = new Intent(getApplicationContext(), bicicletaCaloi.class);
                startActivity(Caloi);
            }
        });

        BotaoVenda = findViewById(R.id.botaoVendedor);

        BotaoVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent venda = new Intent(getApplicationContext(), cadastrarProduto.class);
                startActivity(venda);
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

        BotaoCamisa1 = findViewById(R.id.IbtnHomeProduto2);

        BotaoCamisa1.setOnClickListener(view -> {
            Intent Camisa = new Intent(getApplicationContext(), camisaPazEAmor.class);
            startActivity(Camisa);
        });

        BotaoGalaxy1 = findViewById(R.id.IbtnHomeProduto1);

        BotaoGalaxy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galaxy1 = new Intent(getApplicationContext(), CelularGalaxyA32.class);
                startActivity(galaxy1);
            }
        });

        BotaoMotorola1 = findViewById(R.id.IbtnHomeProduto4);

        BotaoMotorola1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moto = new Intent(getApplicationContext(), celularMotoF40.class);
                startActivity(moto);
            }
        });












    }
}