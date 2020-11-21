package Models;

import java.util.ArrayList;

public class Carrinho {

    private int id;
    private ArrayList<Produto> listaProduto;

    public Carrinho(int id, ArrayList<Produto> listaProduto) {
        this.id = id;
        this.listaProduto = listaProduto;
    }

    public Carrinho() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

}
