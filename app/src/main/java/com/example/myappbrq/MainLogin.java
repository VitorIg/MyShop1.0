package com.example.myappbrq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.RadioButton;

import com.example.myappbrq.BancoDeDados.BancoSQLite;
import com.example.myappbrq.Modelo.Cliente;
import com.example.myappbrq.Modelo.Vendedor;

public class MainLogin extends AppCompatActivity {


    Button CadastrarConta,BtnEntrarLogin;
    EditText EdtEmailLogin, EdtSenhaLogin;
    TextView TxtErroLogin;
    RadioButton RdoClienteLogin, RdoVendedorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BtnEntrarLogin = findViewById(R.id.BtnEntrarLogin);
        EdtEmailLogin = findViewById(R.id.EdtEmailLogin);
        EdtSenhaLogin = findViewById(R.id.EdtSenhaLogin);
        RdoClienteLogin = findViewById(R.id.RdoClienteLogin);
        RdoVendedorLogin = findViewById(R.id.RdoVendedorLogin);



        BtnEntrarLogin.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);
            if (RdoClienteLogin.isChecked()){
            try {
                Cliente cliente = db.selecionarUsuario(EdtEmailLogin.getText().toString());

                if(cliente.getSenha().equals(EdtSenhaLogin.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(), Main_perfil_usuario.class);
                    startActivity(intent);

                } else{
                    TxtErroLogin.setText("Email ou senha incorretos!");
                }
            }catch (Exception e){
                Toast.makeText(this, "Cliente não cadastrado", Toast.LENGTH_SHORT).show();
            }}


            if (RdoVendedorLogin.isChecked()){
                try {
                    Vendedor vendedor = db.selecionarVendedor(EdtEmailLogin.getText().toString());

                    if(vendedor.getSenha().equals(EdtSenhaLogin.getText().toString())){
                        Intent intent = new Intent(getApplicationContext(), Main_Perfil_Vendedor.class);
                        startActivity(intent);

                    } else{
                        TxtErroLogin.setText("Email ou senha incorretos!");
                    }
                }catch (Exception e){
                    Toast.makeText(this, "Cliente não cadastrado", Toast.LENGTH_SHORT).show();
                }}
        });



        CadastrarConta = findViewById(R.id.btnCadastrarContaUsuario);
        CadastrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastrar = new Intent(getApplicationContext(), MainCadastro.class);
                startActivity(cadastrar);
            }
        });
    }
}