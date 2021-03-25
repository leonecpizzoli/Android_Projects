package com.br.lm.appbank.controladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.br.lm.appbank.R;

public class ControladorTelaPrincipal extends ControladorTelaBase implements View.OnClickListener{
    private Button btnTelaCadastrar;
    private Button btnTelaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
        inicializar();
    }
    private void inicializar(){
        btnTelaCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnTelaLogin = (Button) findViewById(R.id.btnEntrar);

        btnTelaCadastrar.setOnClickListener(this);
        btnTelaLogin.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        int opcao = v.getId();
        if(opcao == R.id.btnCadastrar){
            abrirTela(getApplicationContext(), ControladorTelaCadastrar.class);
        } else if(opcao == R.id.btnEntrar){
            abrirTela(getApplicationContext(), ControladorTelaLogin.class);
        }
    }
}
