package com.br.lm.appcrud.controladores;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.br.lm.appcrud.R;
import com.br.lm.appcrud.dominio.Cliente;
import com.br.lm.appcrud.repositorios.RepositorioCliente;
import com.br.lm.appcrud.utilitarios.Mensagem;


public class ControladorTelaCadastro extends ControladorTelaBase{
    private Button btnCadastrar;
    private EditText edNome;
    private EditText edCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
        inicializar();
        configurarBotao();
    }
    private void inicializar(){
        btnCadastrar = (Button) findViewById(R.id.btnTelaCadastrar);
        edNome = (EditText) findViewById(R.id.edNome);
        edCpf = (EditText) findViewById(R.id.edCpf);
    }

    private void configurarBotao(){
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarObrigatoriedadeCampos() == true) {
                    String nome = obterTexto(edNome);
                    String cpf = obterTexto(edCpf);
                    repositorioCliente.salvarCliente(new Cliente(nome, cpf));
                    Mensagem.showMsg(getApplicationContext(), "Cliente cadastrado com sucesso");
                    }else {
                        Mensagem.showMsg(getApplicationContext(), "Falha ao cadastrar cliente");
                    }
                }
        });
    }
    private boolean validarObrigatoriedadeCampos(){
        boolean sucesso = false;

        if(obterTexto(edNome).isEmpty() == true){
            Mensagem.showMsg(this, "Insira um nome válido");
            sucesso = false;
        }else if (obterTexto(edCpf).isEmpty() == true){
            Mensagem.showMsg(this, "Insira um cpf válido");
            sucesso = false;
        }else {
            sucesso = true;
        }
        return sucesso;
    }
}
