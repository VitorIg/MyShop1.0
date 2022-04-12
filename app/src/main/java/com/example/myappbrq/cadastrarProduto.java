package com.example.myappbrq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myappbrq.BancoDeDados.BancoSQLite;

import com.example.myappbrq.Modelo.Produto;


public class cadastrarProduto extends AppCompatActivity {

    ImageButton BotaoPefil;
    ImageButton BotaoLista;
    ImageButton BotaoHome;
    ImageButton BotaoCarrinho;
    ImageButton BotaoVendedor;

    Button CadastrarNovoProduto;
    EditText EdtCodigoBarra;
    Spinner EdtCategoriaDoProduto;
    EditText EdtNomeDoProduto;
    EditText EdtQuantidadeNoEstoque;
    EditText EdtDescricaoDoProduto;
    EditText EdtMarcaDoProduto;
    EditText EdtPrecoCusto;
    EditText EdtPrecoVenda;
    private BancoSQLite db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Spinner spinner = (Spinner) findViewById(R.id.EdtCategoriaDoProduto);
        Button Botao_Comando = findViewById(R.id.btnCadastrarNovoProduto);
        TextView Txt_display = findViewById(R.id.txt_Display);


        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                R.array.categoria_array, R.layout.spinner_estilo);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        Botao_Comando.setOnClickListener(View ->{
            String texto = spinner.getSelectedItem().toString();
            //Txt_display.setText(texto);
        });

        //EdtCategoriaDoProduto = findViewById(R.id.EdtCategoriaDoProduto);
        EdtNomeDoProduto = findViewById(R.id.EdtNomeDoProduto);
        EdtCodigoBarra = findViewById(R.id.EdtCodigoBarra);
        EdtQuantidadeNoEstoque = findViewById(R.id.EdtQuantidadeNoEstoque);
        EdtDescricaoDoProduto = findViewById(R.id.EdtDescricaoDoProduto);
        EdtMarcaDoProduto = findViewById(R.id.EdtMarcaDoProduto);
        EdtPrecoCusto = findViewById(R.id.EdtPrecoCusto);
        EdtPrecoVenda = findViewById(R.id.EdtPrecoVenda);





            if (CadastrarNovoProduto.onCheckIsTextEditor()) {

                if(db.inserirProduto(new Produto(
                        EdtCategoriaDoProduto.getSelectedItem().toString(),
                        EdtNomeDoProduto.getText().toString(),
                        EdtCodigoBarra.getText().toString(),
                        EdtQuantidadeNoEstoque.getText().toString(),
                        EdtDescricaoDoProduto.getText().toString(),
                        EdtMarcaDoProduto.getText().toString(),
                        EdtPrecoCusto.getText().toString(),
                        EdtPrecoVenda.getText().toString()
                ))) {
                    Toast.makeText(this, "Produto Cadastrado com sucessso!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(this, "Não foi possível realizar o cadastro!", Toast.LENGTH_SHORT).show();
                }
            }


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

        CadastrarNovoProduto = findViewById(R.id.btnCadastrarNovoProduto);

        CadastrarNovoProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastrar = new Intent(getApplicationContext(), cadastrarProduto.class);
                startActivity(cadastrar);
            }
        });

    }
}