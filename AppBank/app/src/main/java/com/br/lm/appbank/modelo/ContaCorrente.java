package com.br.lm.appbank.modelo;

/**
 * Created by leone.pizzoli on 18/08/2017.
 */

public class ContaCorrente {
    private Long nroContaCorrente;
    private Cliente cliente;
    private long saldo;

    public ContaCorrente() {
    }

    public ContaCorrente(Long nroContaCorrente, Cliente cliente, long saldo) {
        this.nroContaCorrente = nroContaCorrente;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Long getNroContaCorrente() {
        return nroContaCorrente;
    }

    public void setNroContaCorrente(Long nroContaCorrente) {
        this.nroContaCorrente = nroContaCorrente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "nroContaCorrente=" + nroContaCorrente +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }

}
