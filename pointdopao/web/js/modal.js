$(document).ready(function() {
    $('#modalEditProduto').on('show.bs.modal', function (event) {
        var idProduto = $(event.relatedTarget).data('id');
        var nomeProduto = $(event.relatedTarget).data('nome');
        var qtdProduto = $(event.relatedTarget).data('qtd');
        var precoProduto = $(event.relatedTarget).data('preco');

        $(this).find("#md-idProduto").text(idProduto);
        $(this).find("#md-nome-produto").val(nomeProduto);
        $(this).find("#md-quantidade-produto").val(qtdProduto);
        $(this).find("#md-preco-produto").val(precoProduto);
    })
})