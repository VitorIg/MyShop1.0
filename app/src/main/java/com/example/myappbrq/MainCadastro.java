package com.example.myappbrq;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myappbrq.BancoDeDados.BancoSQLite;
import com.example.myappbrq.Modelo.Cliente;
import com.example.myappbrq.Modelo.Vendedor;

public class MainCadastro extends AppCompatActivity {

    Button  BtnContinuarCadastroUsuario;
    EditText EdtNomeCadastroUsuario;
    EditText EdtEmailCadastroUsuario;
    EditText EdtDocumentoCadastroUsuario;
    EditText EdtTelefoneCadastroUsuario;
    EditText EdtSenhaCadastroUsuario;
    EditText EdtCepCadastroUsuario;
    EditText EdtEnderecoCadastroUsuario;
    EditText EdtBairroCadastroUsuario;
    EditText EdtCidadeCadastroUsuario;
    EditText EdtEstadoCadastroUsuario;
    RadioButton RdoRegistraClienteCadastroUsuario, RdoRegistraVendedorCadastroUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cadastro);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        BtnContinuarCadastroUsuario = findViewById(R.id.BtnContinuarCadastroUsuario);
        EdtNomeCadastroUsuario = findViewById(R.id.EdtNomeCadastroUsuario);
        EdtEmailCadastroUsuario = findViewById(R.id.EdtEmailCadastroUsuario);
        EdtDocumentoCadastroUsuario = findViewById(R.id.EdtDocumentoCadastroUsuario);
        EdtTelefoneCadastroUsuario = findViewById(R.id.EdtTelefoneCadastroUsuario);
        EdtSenhaCadastroUsuario = findViewById(R.id.EdtSenhaCadastroUsuario);
        EdtCepCadastroUsuario = findViewById(R.id.EdtCepCadastroUsuario);
        EdtEnderecoCadastroUsuario = findViewById(R.id.EdtEnderecoCadastroUsuario);
        EdtBairroCadastroUsuario = findViewById(R.id.EdtBairroCadastroUsuario);
        EdtCidadeCadastroUsuario = findViewById(R.id.EdtCidadeCadastroUsuario);
        EdtEstadoCadastroUsuario = findViewById(R.id.EdtEstadoCadastroUsuario);
        RdoRegistraVendedorCadastroUsuario = findViewById(R.id.RdoRegistraVendedorCadastroUsuario);
        RdoRegistraClienteCadastroUsuario = findViewById(R.id.RdoRegistraClienteCadastroUsuario);

        BtnContinuarCadastroUsuario.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);

            if (RdoRegistraClienteCadastroUsuario.isChecked()) {

            if(db.inserirCliente(new Cliente(
                    EdtNomeCadastroUsuario.getText().toString(),
                    EdtEmailCadastroUsuario.getText().toString(),
                    EdtDocumentoCadastroUsuario.getText().toString(),
                    EdtTelefoneCadastroUsuario.getText().toString(),
                    EdtSenhaCadastroUsuario.getText().toString(),
                    EdtCepCadastroUsuario.getText().toString(),
                    EdtEnderecoCadastroUsuario.getText().toString(),
                    EdtBairroCadastroUsuario.getText().toString(),
                    EdtCidadeCadastroUsuario.getText().toString(),
                    EdtEstadoCadastroUsuario.getText().toString()

            ))) {
                Toast.makeText(this, "Cliente Cadastrado com sucessso!", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(this, "Não foi possível realizar o cadastro!", Toast.LENGTH_SHORT).show();
            }
            }

            if (RdoRegistraVendedorCadastroUsuario.isChecked()) {

                if(db.inserirVendedor(new Vendedor(
                        EdtNomeCadastroUsuario.getText().toString(),
                        EdtEmailCadastroUsuario.getText().toString(),
                        EdtDocumentoCadastroUsuario.getText().toString(),
                        EdtTelefoneCadastroUsuario.getText().toString(),
                        EdtSenhaCadastroUsuario.getText().toString(),
                        EdtCepCadastroUsuario.getText().toString(),
                        EdtEnderecoCadastroUsuario.getText().toString(),
                        EdtBairroCadastroUsuario.getText().toString(),
                        EdtCidadeCadastroUsuario.getText().toString(),
                        EdtEstadoCadastroUsuario.getText().toString()

                ))) {
                    Toast.makeText(this, "Cliente Cadastrado com sucessso!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(this, "Não foi possível realizar o cadastro!", Toast.LENGTH_SHORT).show();
                }
            }


        });



    }
}