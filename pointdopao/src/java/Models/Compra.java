package Models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Compra {

    private int id;
    private Usuario usuario;
    private ArrayList<Produto> listaProdutos;
    private double valorTotal;
    private Timestamp data;

    public Compra(int id, Usuario usuario, ArrayList<Produto> listaProdutos, double valorTotal, Timestamp data) {
        this.id = id;
        this.usuario = usuario;
        this.listaProdutos = listaProdutos;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
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
