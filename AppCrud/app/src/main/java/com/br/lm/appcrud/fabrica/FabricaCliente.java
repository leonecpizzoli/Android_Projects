package com.br.lm.appcrud.fabrica;

import android.content.ContentValues;
import android.database.Cursor;

import com.br.lm.appcrud.dominio.Cliente;

/**
 * Created by leone.pizzoli on 15/08/2017.
 */

public class FabricaCliente {

        public static Cliente criarCliente(Cursor cursor){
            Cliente cliente = new Cliente();

            cliente.setId(Long.parseLong(cursor.getString(0)));
            cliente.setNome(cursor.getString(1));
            cliente.setCpf(cursor.getString(2));

            return cliente;
        }

        public static ContentValues criarClienteCv(Cliente cliente){
            ContentValues clienteCv = new ContentValues();

            clienteCv.put("nome", cliente.getNome());
            clienteCv.put("cpf", cliente.getCpf());

            return clienteCv;
        }
}

