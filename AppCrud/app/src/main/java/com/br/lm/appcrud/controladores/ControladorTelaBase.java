package com.br.lm.appcrud.controladores;

import com.br.lm.appcrud.repositorios.RepositorioCliente;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;


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
        return texto != null && !texto.isEmpty() ? texto : "";
    }
}
