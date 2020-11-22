package Models;

import java.util.ArrayList;

public class Compra {
    private int id;
    private Usuario usuario;
    private ArrayList<Produto> listaProdutos;

    public Compra(int id, Usuario usuario, ArrayList <Produto> listaProdutos) {
        this.id = id;
        this.usuario = usuario;
        this.listaProdutos = listaProdutos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

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