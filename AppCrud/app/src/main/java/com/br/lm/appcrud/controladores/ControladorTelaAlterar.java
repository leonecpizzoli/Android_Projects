package com.br.lm.appcrud.controladores;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.br.lm.appcrud.R;
import com.br.lm.appcrud.dominio.Cliente;
import com.br.lm.appcrud.utilitarios.Mensagem;


public class ControladorTelaAlterar extends ControladorTelaBase {
    private EditText edIdAlterar;
    private EditText edNomeAlterar;
    private EditText edCpfAlterar;
    private Button btnAlterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_alterar);
        inicializar();
        configurarBotao();
    }

    private void inicializar() {
        edIdAlterar = (EditText) findViewById(R.id.edIdAlterar);
        edNomeAlterar = (EditText) findViewById(R.id.edNomeAlterar);
        edCpfAlterar = (EditText) findViewById(R.id.edCpfAlterar);
        btnAlterar = (Button) findViewById(R.id.btnAlterar);
    }

    private void configurarBotao() {
        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validarObrigatoriedadeCampos()) {
                    String id = obterTexto(edIdAlterar);
                    String nome = obterTexto(edNomeAlterar);
                    String cpf = obterTexto(edCpfAlterar);

                    if (repositorioCliente.atualizarCliente(new Cliente(Long.parseLong(id), nome, cpf))) {
                        Mensagem.showMsg(getApplicationContext(), "Cliente " + id + "alterado com sucesso");
                    } else {
                        Mensagem.showMsg(getApplicationContext(), "Falha ao alterar cliente com ID " + id);

                    }
                }
            }
        });
    }
    private boolean validarObrigatoriedadeCampos() {
        boolean sucesso = false;

        if (obterTexto(edIdAlterar).isEmpty()) {
            Mensagem.showMsg(this, "Insira um Id válido");
            sucesso = false;
        } else if (obterTexto(edNomeAlterar).isEmpty()) {
            Mensagem.showMsg(this, "Insira um nome válido");
            sucesso = false;
        } else if (obterTexto(edCpfAlterar).isEmpty()) {
            Mensagem.showMsg(this, "Insira um cpf válido");
            sucesso = false;
        } else {
            sucesso = true;
        }
        return sucesso;
    }
}
