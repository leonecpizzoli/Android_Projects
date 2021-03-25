package com.br.lm.appcrud.repositorios;

import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.br.lm.appcrud.dominio.Cliente;
import com.br.lm.appcrud.fabrica.FabricaCliente;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leone.pizzoli on 15/08/2017.
 */

public class RepositorioCliente extends RepositorioBase {
    private static final String TABELA_CLIENTE = "cliente";
    private static final String CHAVE_ID = "id";

    public RepositorioCliente(Context context) {
        super(context);
    }

    private void criarTabelaCliente(SQLiteDatabase db){
        String sql = "";
        sql += "CREATE TABLE cliente ( ";
        sql += "id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "nome TEXT, ";
        sql += "cpf TEXT";
        sql += ")";

        db.execSQL(sql);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        criarTabelaCliente(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cliente");
        this.onCreate(db);
    }

    public boolean salvarCliente(Cliente cliente){
        boolean salvo = salvar(TABELA_CLIENTE, FabricaCliente.criarClienteCv(cliente));
        Log.d("salvarCliente()", cliente.toString());

        return salvo;

    }

    public List<Cliente> obterTodos(){
        List<Cliente> clientes = new LinkedList<>();

        String sql = "SELECT * FROM " + TABELA_CLIENTE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
               clientes.add(FabricaCliente.criarCliente(cursor));
            }while(cursor.moveToNext());
        }
        Log.d("obterTodos()", clientes.toString());

        return clientes;
    }

    public boolean atualizarCliente(Cliente cliente){
        int retorno = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String condicionalWhere = CHAVE_ID + " = ?";
        String[] parametroId = new String[] { String.valueOf(cliente.getId())};
        ContentValues clienteCv = FabricaCliente.criarClienteCv(cliente);

        retorno = db.update(TABELA_CLIENTE, clienteCv, condicionalWhere, parametroId);

        db.close();

        return retorno != 0;
    }

    public boolean excluirCliente(Long id){
        int retorno = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        String idString = String.valueOf(id);
        String condicionalWhere = CHAVE_ID + " = ?";
        String[] parametroId = new String[] { idString };

        retorno = db.delete(TABELA_CLIENTE, condicionalWhere, parametroId);
        db.close();

        return retorno != 0;
    }
}
