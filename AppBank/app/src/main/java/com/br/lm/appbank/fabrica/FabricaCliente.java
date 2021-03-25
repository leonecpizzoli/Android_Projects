package com.br.lm.appbank.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import com.br.lm.appbank.modelo.Cliente;
import com.br.lm.appbank.modelo.ContaCorrente;

/**
 * Created by leone.pizzoli on 18/08/2017.
 */

public class FabricaCliente {

    public static Cliente criarCliente(Cursor cursor){
        Cliente cliente = new Cliente();

        cliente.setId(Integer.parseInt(cursor.getString(0)));
        cliente.setNome(cursor.getString(1));
        cliente.setCpf(cursor.getString(2));
        cliente.setLogin(cursor.getString(3));
        cliente.setSenha(cursor.getString(4));

        return cliente;
    }

    public static ContentValues criarClienteCv(Cliente cliente){
        ContentValues clienteCv = new ContentValues();
        ContaCorrente conta = new ContaCorrente();

        clienteCv.put("nome", cliente.getNome());
        clienteCv.put("cpf", cliente.getCpf());
        clienteCv.put("login", cliente.getLogin());
        clienteCv.put("senha", cliente.getSenha());

        return clienteCv;
    }
}
