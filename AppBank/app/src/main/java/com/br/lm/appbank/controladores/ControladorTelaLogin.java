package com.br.lm.appbank.controladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.br.lm.appbank.R;

public class ControladorTelaLogin extends ControladorTelaBase {
    private Button btnEntrar;
    private EditText edLogin;
    private EditText edSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlador_tela_conta);
        inicializar();
    }
    public void inicializar(){
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        edLogin = (EditText) findViewById(R.id.edLogin);
        edSenha = (EditText) findViewById(R.id.edSenha);
    }
    public boolean validarCamposObrigatorios(){
        boolean sucesso = false;

        if(obterTexto(edLogin).isEmpty()){
        }
    return sucesso;
    }
}
