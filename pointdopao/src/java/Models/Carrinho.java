package Models;

import java.util.ArrayList;

public class Carrinho {
    private int id;
    private ArrayList<Produto> listaProduto;

    public Carrinho(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(ArrayList<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
}
