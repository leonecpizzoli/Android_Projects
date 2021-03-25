package com.br.lm.appcrud.repositorios;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by leone.pizzoli on 15/08/2017.
 */

public abstract class RepositorioBase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "AppCrudDB";

    public RepositorioBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    protected boolean salvar(String nomeTabela, ContentValues objeto){
        boolean sucesso = false;
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.insert(nomeTabela, null, objeto);
            sucesso = true;
        }catch(Exception e){
            sucesso = false;
            Log.e("Erro ao salvar " + objeto, e.toString());
        }
        db.close();

        return sucesso;
    }
}
