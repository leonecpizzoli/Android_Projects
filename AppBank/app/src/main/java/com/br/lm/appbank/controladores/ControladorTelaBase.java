package com.br.lm.appbank.controladores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.br.lm.appbank.repositorio.RepositorioCliente;

/**
 * Created by leone.pizzoli on 21/08/2017.
 */

public class ControladorTelaBase extends Activity {
  protected RepositorioCliente repositorioCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repositorioCliente = new RepositorioCliente(this);
    }
    protected void abrirTela(Context tela, Class<?> novaTela){
        Intent intent = new Intent(tela, novaTela);
        this.startActivity(intent);
    }
    public void finalizarAplicacao(){
        this.finish();
    }
    protected String obterTexto(EditText editText){
        String texto = editText.getText().toString();
        return texto != null &&!texto.isEmpty() ? texto : "";
    }
}
