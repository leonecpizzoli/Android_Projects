package com.br.lm.appbank.controladores;

import com.br.lm.appbank.modelo.Cliente;
import com.br.lm.appbank.utilitarios.Mensagem;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.br.lm.appbank.R;
import com.br.lm.appbank.utilitarios.Mensagem;

public class ControladorTelaCadastrar extends ControladorTelaBase {
    private Button btnCadastrar;
    private EditText edLogin;
    private EditText edSenha;
    private EditText edCpf;
    private EditText edNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrar);
        inicializar();
        configurarBotao();
    }
    private void inicializar() {
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        edNome = (EditText) findViewById(R.id.edNome);
        edCpf = (EditText) findViewById(R.id.edCpf);
        edLogin = (EditText) findViewById(R.id.edLogin);
        edSenha = (EditText) findViewById(R.id.edSenha);
    }
        private void configurarBotao(){

            btnCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            if(validarObrigatoriedadeCampos() == true){
                String nome = obterTexto(edNome);
                String cpf = obterTexto(edCpf);
                String login = obterTexto(edLogin);
                String senha = obterTexto(edSenha);

                repositorioCliente.salvarCliente(new Cliente(nome, cpf, login, senha));
                Mensagem.showMsg(getApplicationContext(), "Cliente cadastrado com sucesso");
            } else{
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
        }else if (obterTexto(edCpf).isEmpty() == true) {
            Mensagem.showMsg(this, "Insira um cpf válido");
            sucesso = false;
        }else if (obterTexto(edLogin).isEmpty() == true){
                Mensagem.showMsg(this, "Insira um Login válido");
                sucesso = false;
        }else if (obterTexto(edSenha).isEmpty() == true){
            Mensagem.showMsg(this, "Insira uma Senha válido");
            sucesso = false;
        }else {
            sucesso = true;
        }
        return sucesso;
    }
}
