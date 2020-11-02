package Models;

public class Compra {
    private int id;
    private Usuario usuario;
    private Carrinho carrinho;
    private int metodoPagamento;
    private String estadoCompra;

    public Compra(Usuario usuario, Carrinho carrinho, int metodoPagamento, String estadoCompra) {
        this.usuario = usuario;
        this.carrinho = carrinho;
        this.metodoPagamento = metodoPagamento;
        this.estadoCompra = estadoCompra;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public int getMetodoPagamento() {
        return metodoPagamento;
    }

    public String getEstadoCompra() {
        return estadoCompra;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setMetodoPagamento(int metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void setEstadoCompra(String estadoCompra) {
        this.estadoCompra = estadoCompra;
    }
    
    
}
