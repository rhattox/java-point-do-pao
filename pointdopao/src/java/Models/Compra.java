package Models;

import java.util.ArrayList;

public class Compra {

    private int id;
    private Usuario usuario;
    private ArrayList<Produto> listaProdutos;
    private double valorTotal;

    public Compra(int id, Usuario usuario, ArrayList<Produto> listaProdutos, double valorTotal) {
        this.id = id;
        this.usuario = usuario;
        this.listaProdutos = listaProdutos;
        this.valorTotal = valorTotal;
    }

    public Compra() {
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
