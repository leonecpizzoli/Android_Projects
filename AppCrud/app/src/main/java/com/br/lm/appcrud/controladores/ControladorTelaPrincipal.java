package com.br.lm.appcrud.controladores;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.br.lm.appcrud.R;
import com.br.lm.appcrud.utilitarios.Mensagem;


public class ControladorTelaPrincipal extends ControladorTelaBase implements View.OnClickListener{
    private Button btnTelaCadastrar;
    private Button btnTelaAlterar;
    private Button btnTelaExcluir;
    private Button btnTelaConsultar;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
        inicializar();
    }

    private void inicializar(){
        btnTelaCadastrar = (Button) findViewById(R.id.btnTelaCadastrar);
        btnTelaConsultar = (Button) findViewById(R.id.btnTelaConsultar);
        btnTelaAlterar = (Button) findViewById(R.id.btnTelaAlterar);
        btnTelaExcluir = (Button) findViewById(R.id.btnTelaExcluir);
        btnSair = (Button) findViewById(R.id.btnSair);

        btnTelaCadastrar.setOnClickListener(this);
        btnTelaConsultar.setOnClickListener(this);
        btnTelaAlterar.setOnClickListener(this);
        btnTelaExcluir.setOnClickListener(this);
        btnSair.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        int opcao = v.getId();
        if(opcao == R.id.btnTelaCadastrar){
            abrirTela(this.getApplicationContext(),ControladorTelaCadastro.class);
        }else if ( opcao == R.id.btnTelaConsultar) {
            abrirTela(this.getApplicationContext(),ControladorTelaConsulta.class);
        } else if ( opcao == R.id.btnTelaAlterar) {
            abrirTela(this.getApplicationContext(),ControladorTelaAlterar.class);
        }else if(opcao == R.id.btnTelaExcluir){
            abrirTela(this.getApplicationContext(), ControladorTelaExclusao.class);
        }else if (opcao == R.id.btnSair){
            finalizarAplicacao();
        }

    }
}
