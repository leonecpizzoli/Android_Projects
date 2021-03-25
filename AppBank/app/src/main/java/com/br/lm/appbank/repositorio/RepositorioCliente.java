package com.br.lm.appbank.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.br.lm.appbank.fabrica.FabricaCliente;
import com.br.lm.appbank.modelo.Cliente;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leone.pizzoli on 18/08/2017.
 */

public class RepositorioCliente extends RepositorioBase {
    private static final String TABELA_CLIENTEBANCO = "clientes";
    private static final String CHAVE_ID = "id";

    public RepositorioCliente(Context context) {
        super(context);
    }

    private void criarTabelaCliente(SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE clientebanco ( ";
        sql += "id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "nome TEXT, ";
        sql += "cpf TEXT, ";
        sql += "login TEXT, ";
        sql += "senha TEXT, ";
        sql += "conta TEXT";
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
        boolean salvo = salvar(TABELA_CLIENTEBANCO, FabricaCliente.criarClienteCv(cliente));
        Log.e("salvarCliente() ", cliente.toString());

        return salvo;
    }

    public List<Cliente> obterTodos(){
        List<Cliente> clientes = new LinkedList<>();

        String sql = "SELECT * FROM " + TABELA_CLIENTEBANCO;

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
        String condicionalWhere = CHAVE_ID +" = ?";
        String[] parametroId = new String[]{
                String.valueOf(cliente.getId())};
        ContentValues clienteCv = FabricaCliente.criarClienteCv(cliente);

        retorno = db.update(TABELA_CLIENTEBANCO, clienteCv,condicionalWhere,parametroId);

        db.close();

        return retorno != 0;
        }

        public boolean excluirCliente(Long id){
            int retorno = 0;

            SQLiteDatabase db = this.getWritableDatabase();
            String idString = String.valueOf(id);
            String condicionalWhere = CHAVE_ID + " = ?";
            String[] parametroId = new String[] { idString };

            retorno = db.delete(TABELA_CLIENTEBANCO, condicionalWhere, parametroId);
            db.close();

            return retorno != 0;
    }



}
