package com.br.lm.appbank.utilitarios;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by leone.pizzoli on 21/08/2017.
 */

public class Mensagem {

    public static void showMsg(Context tela, String msg){
        Toast.makeText(tela, msg, Toast.LENGTH_LONG).show();
    }
}
