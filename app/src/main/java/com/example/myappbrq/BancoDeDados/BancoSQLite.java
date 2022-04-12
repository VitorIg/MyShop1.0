package com.example.myappbrq.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.myappbrq.Modelo.Cliente;
import com.example.myappbrq.Modelo.Produto;
import com.example.myappbrq.Modelo.Vendedor;


public class BancoSQLite extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "Dados_MyShop.db";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String EMAIL = "email";
    private static final String DOCUMENTO = "documento";
    private static final String TELEFONE = "telefone";
    private static final String SENHA = "senha";
    private static final String CEP = "cep";
    private static final String ENDERECO = "endereco";
    private static final String BAIRRO = "bairro";
    private static final String CIDADE = "cidade";
    private static final String ESTADO = "estado";


    private static final String CATEGORIA = "categoria";
    private static final String NOMEPRODUTO = "nomeproduto";
    private static final String CODIGO = "codigo";
    private static final String QUANTIDADE = "quantidade";
    private static final String DESCRICAO = "descricao";
    private static final String MARCA = "marca";
    private static final String CUSTO = "custo";
    private static final String VENDA= "venda";



    private static final String TABELA_CLIENTE = "cliente";
    private static final String TABELA_VENDEDOR = "vendedor";
    private static final String TABELA_PRODUTO = "produto";
    private static final int VERSAO = 1;

    public BancoSQLite(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //TABELA CLIENTE
        String CREATE_CLIENTE_TABLE = "CREATE TABLE " + TABELA_CLIENTE + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT, " +
                EMAIL + " TEXT, " +
                DOCUMENTO + " TEXT, " +
                TELEFONE + " TEXT, " +
                SENHA + " TEXT, " +
                CEP + " TEXT, " +
                ENDERECO + " TEXT, " +
                BAIRRO + " TEXT, " +
                CIDADE + " TEXT, " +
                ESTADO + " TEXT )";

        //TABELA VENDEDOR
        String CREATE_VENDEDOR_TABLE = "CREATE TABLE " + TABELA_VENDEDOR + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT, " +
                EMAIL + " TEXT UNIQUE, " +
                DOCUMENTO + " TEXT UNIQUE, " +
                TELEFONE + " TEXT, " +
                SENHA + " TEXT, " +
                CEP + " TEXT, " +
                ENDERECO + " TEXT, " +
                BAIRRO + " TEXT, " +
                CIDADE + " TEXT, " +
                ESTADO + " TEXT )";

        //TABELA PRODUTO
        String CREATE_PRODUTO_TABLE = "CREATE TABLE " + TABELA_PRODUTO + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CATEGORIA + " TEXT, " +
                NOMEPRODUTO + " TEXT UNIQUE, " +
                CODIGO + " TEXT UNIQUE, " +
                QUANTIDADE + " TEXT, " +
                DESCRICAO + " TEXT, " +
                MARCA + " TEXT, " +
                CUSTO + " TEXT, " +
                VENDA + " TEXT)";

        db.execSQL(CREATE_CLIENTE_TABLE);
        db.execSQL(CREATE_VENDEDOR_TABLE);
        db.execSQL(CREATE_PRODUTO_TABLE);

}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_VENDEDOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PRODUTO);

        onCreate(db);
    }

    public boolean inserirCliente(Cliente c) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, c.getNome());
        values.put(EMAIL, c.getEmail());
        values.put(DOCUMENTO, c.getDocumento());
        values.put(TELEFONE, c.getTelefone());
        values.put(SENHA, c.getSenha());
        values.put(CEP, c.getCep());
        values.put(ENDERECO, c.getEndereco());
        values.put(BAIRRO, c.getBairro());
        values.put(CIDADE, c.getCidade());
        values.put(ESTADO, c.getEstado());
        result = db.insert(TABELA_CLIENTE, null, values);
        db.close();

        if (result == -1) return false;
        else return true;
    }

    public Cliente selecionarUsuario(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_CLIENTE,
                new String[]{ID, EMAIL, SENHA},
                EMAIL + " = ?",
                new String[]{String.valueOf(email)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();

            Cliente cli = new Cliente(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2));

            return (Cliente) cli.clone();

        } else return null;
    }

    public Cliente selecionarInformacoesCliente(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_CLIENTE,
                new String[]{ID, NOME, EMAIL, DOCUMENTO, TELEFONE, CEP, ENDERECO, BAIRRO, CIDADE, ESTADO},
                ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();

            Cliente cli = new Cliente(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9));

            return (Cliente) cli.clone();
        } else return null;
    }


    public boolean inserirVendedor(Vendedor v) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, v.getNome());
        values.put(EMAIL, v.getEmail());
        values.put(DOCUMENTO, v.getDocumento());
        values.put(TELEFONE, v.getTelefone());
        values.put(SENHA, v.getSenha());
        values.put(CEP, v.getCep());
        values.put(ENDERECO, v.getEndereco());
        values.put(BAIRRO, v.getBairro());
        values.put(CIDADE, v.getCidade());
        values.put(ESTADO, v.getEstado());
        result = db.insert(TABELA_VENDEDOR, null, values);
        db.close();

        if (result == -1) return false;
        else return true;
    }

    public Vendedor selecionarVendedor(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_VENDEDOR,
                new String[]{ID, EMAIL, SENHA},
                EMAIL + " = ?",
                new String[]{String.valueOf(email)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();

            Vendedor vend = new Vendedor(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2));

            return (Vendedor) vend.clone();

        } else return null;
    }



    public Vendedor selecionarInformacoesVendedor(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_VENDEDOR,
                new String[]{ID, NOME, EMAIL, DOCUMENTO, TELEFONE, CEP, ENDERECO, BAIRRO, CIDADE, ESTADO},
                ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();

            Vendedor ven = new Vendedor(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9));

            return (Vendedor) ven.clone();
        } else return null;
    }

    ////////////////

    public boolean inserirProduto(Produto p) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CATEGORIA, p.getCategoria());
        values.put(NOME, p.getNome());
        values.put(CODIGO, p.getCodigo());
        values.put(QUANTIDADE, p.getQuantidade());
        values.put(DESCRICAO, p.getDescricao());
        values.put(MARCA, p.getMarca());
        values.put(CUSTO, p.getCusto());
        values.put(VENDA, p.getVenda());

        result = db.insert(TABELA_PRODUTO, null, values);
        db.close();



        if (result == -1) return false;
        else return true;
    }


    public Produto selecionarProduto(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_PRODUTO,
                new String[]{ID, CATEGORIA, NOME, CODIGO, QUANTIDADE, DESCRICAO, MARCA, CUSTO, VENDA},
                ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();

            Produto ven = new Produto(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8));

            return (Produto) ven.clone();
        } else return null;
    }


}
