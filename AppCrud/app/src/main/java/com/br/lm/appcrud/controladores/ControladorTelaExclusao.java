package com.br.lm.appcrud.controladores;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.br.lm.appcrud.R;
import com.br.lm.appcrud.utilitarios.Mensagem;


public class ControladorTelaExclusao extends ControladorTelaBase{
    private EditText edId;
    private Button btnExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exclusao);
        inicializar();
        configurarBotao();
    }

    private void configurarBotao(){
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validarObrigatoriedadeCampos()){
                    if(repositorioCliente.excluirCliente(Long.parseLong(obterTexto(edId)))){
                        Mensagem.showMsg(getApplicationContext(), "Cliente excluído com sucesso");
                    }else {
                        Mensagem.showMsg(getApplicationContext(), "Falha ao excluir cliente");
                    }
                }
            }
        });
    }
    private boolean validarObrigatoriedadeCampos(){
        boolean sucesso = false;

        if(obterTexto(edId).isEmpty()){
            Mensagem.showMsg(this, "Insira um ID valido");
            sucesso = false;
        } else {
            sucesso = true;
        }
        return sucesso;
    }
    private void inicializar(){
        btnExcluir = (Button) findViewById(R.id.btnExcluir);
        edId = (EditText) findViewById(R.id.edId);
    }
}
