package com.br.lm.appcrud.controladores;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.br.lm.appcrud.R;
import com.br.lm.appcrud.dominio.Cliente;

public class ControladorTelaConsulta extends ControladorTelaBase {
    private Button btnConsultar;
    private ListView lvClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_consulta);
        inicializar();
        configurarBotao();
    }

    private void inicializar(){
        lvClientes = (ListView) findViewById(R.id.lvClientes);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
    }
    private void configurarBotao(){
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarClientes();
            }
        });
    }
    private void carregarClientes(){
        lvClientes.setAdapter(new ArrayAdapter<Cliente>(ControladorTelaConsulta.this,
                android.R.layout.simple_list_item_1, repositorioCliente.obterTodos()));
    }
}
