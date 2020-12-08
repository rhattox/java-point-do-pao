function navegarParaPagina(page, pr) {
    window.location = `${page}?pr=${pr}`;
}

function navegarParaHome() {
    window.location = "/pointdopao";
}

function voltar() {
    window.history.back();
}

/*Validações na tela de cadastro*/
function validaCampoTexto(inputId, mensagemId, nomeCampo) {
    var campo = document.getElementById(inputId).value;
    if (campo.length > 0) {
        document.getElementById(mensagemId).style.display = "none";
    } else {
        document.getElementById(mensagemId).style.display = "block";
        document.getElementById(mensagemId).innerHTML = `O ${nomeCampo} é obrigatório.`;
    }
}
function validaSenhas() {
    var senha = document.getElementById('senhaForm').value;
    var confirmacaoSenha = document.getElementById('confirmacaoSenhaForm').value;
    if (senha.length >= 6 && senha.length <= 10) {
        document.getElementById('senhaHelp').style.display = "none";
    } else {
        document.getElementById('senhaHelp').style.display = "block";
        document.getElementById('senhaHelp').innerHTML = "A senha deve conter de 6-10 dígitos.";
    }
    if (confirmacaoSenha === senha) {
        document.getElementById('confirmacaoSenhaHelp').style.display = "none";
    } else {
        document.getElementById('confirmacaoSenhaHelp').style.display = "block";
        document.getElementById('confirmacaoSenhaHelp').innerHTML = "As senhas não são iguais.";
    }
}

function validaSenhasRedefinicao() {
    var senha = document.getElementById('novaSenhaResetForm').value;
    var confirmacaoSenha = document.getElementById('confirmacaoNovaSenhaResetForm').value;
    if (senha.length >= 6 && senha.length <= 10) {
        document.getElementById('novaSenhaHelpReset').style.display = "none";
    } else {
        document.getElementById('novaSenhaHelpReset').style.display = "block";
        document.getElementById('novaSenhaHelpReset').innerHTML = "A senha deve conter de 6-10 dígitos.";
    }
    if (confirmacaoSenha === senha) {
        document.getElementById('confirmacaoNovaSenhaHelpReset').style.display = "none";
    } else {
        document.getElementById('confirmacaoNovaSenhaHelpReset').style.display = "block";
        document.getElementById('confirmacaoNovaSenhaHelpReset').innerHTML = "As senhas não são iguais.";
    }
}

function validaFormCadastro() {
    if (document.getElementById('nomeHelp').style.display === "none" &&
            document.getElementById('sobrenomeHelp').style.display === "none" &&
            document.getElementById('emailHelp').style.display === "none" &&
            document.getElementById('senhaHelp').style.display === "none" &&
            document.getElementById('senhaHelp').style.display === "none") {
        return true;
    } else {
        validaCampoTexto('nomeForm', 'nomeHelp', 'nome');
        validaCampoTexto('sobrenomeForm', 'sobrenomeHelp', 'sobrenome');
        validaCampoTexto('emailForm', 'emailHelp', 'email');
        validaSenhas();
        window.alert("O formulário contém campos inválidos!");
        return false;
    }
}
/*------------------------------*/

/*Validação na tela de login*/
function validarLogin() {
    var email = document.getElementById('emailLoginForm').value;
    var senha = document.getElementById('senhaLoginForm').value;

    if (email.length > 0 &&
            (senha.length >= 6 && senha.length <= 10)) {
        return true;
    } else {
        window.alert("O email e/ou senha inválido(s).");
        return false;
    }
}
/*-----------------------------*/
function alertLoginSuccess(variable) {
    if (variable === true) {
        alert('Usuário cadastrado com sucesso!');
    }
}

/*------------------------------*/
/*Funcionais para controlar quantidade dos itens*/
function quantidadeItemControl(index, acao) {
    const item = `${index}-${acao}`;
    console.log(item);
    let valor = parseInt(document.getElementById(`${index}-label`).innerText);
    console.log("valor: " + valor);
    if (acao === 'diminuir' && valor > 0) {
        valor--;
    } else if (acao === 'aumentar') {
        valor++;
    } else {
        return;
    }
    document.getElementById(`${index}-label`).innerHTML = `${valor}`;

    let btnComprar = document.getElementById(`${index}-comprar`)
    btnComprar.disabled = valor <= 0;
}

function fecharPedido(index, autenticado) {
    console.log(autenticado);
    if (autenticado == null || autenticado === false) {
        navegarParaPagina('acesso', 'entrar');
    } else {
        let qtdItem = parseInt(document.getElementById(`${index}-label`).innerText);
        window.location = `acesso?pr=carrinho&produto=${index + 1}&qtd=${qtdItem}`;
    }
}


function podeComprar(index) {
    let qtdItem = parseInt(document.getElementById(`${index}-label`).innerText);
    return qtdItem > 0;
}

function removerProdutoListaCompra(index) {
    window.location = `carrinho?remover=${index}`;
}

function removerProdutoLista(id) {
    const msg = confirm("Você realmente deseja remover esse produto?\nATENÇÃO: Esta ação não poderá ser revertida!");
    if (msg === true) {
        window.location = `produto?remover=${id}`;
    }
}

/*----------------------------------------*/
function validaFormCarrinho() {
    updateValueAndValidityCarrinhoForm();
    if (document.getElementById('enderecoCheckoutHelp').style.display === "none" &&
        document.getElementById('numeroCheckoutHelp').style.display === "none" &&
        document.getElementById('bairroCheckoutHelp').style.display === "none" &&
        document.getElementById('estadoCheckoutHelp').style.display === "none" &&
        document.getElementById('cepCheckoutHelp').style.display === "none") {
        window.alert("Compra realizada com sucesso! \nEm breve estará na sua casa =D");
        return true;
    } else {
        updateValueAndValidityCarrinhoForm();
        window.alert("O formulário contém campos inválidos!");
        return false;
    }
}

function formatPrecoProduto() {
    let valor = document.getElementById('precoProdutoForm').value.replace(',', '.');
    document.getElementById('precoProdutoForm').value = new Intl.NumberFormat('pt').format(valor);
}

function atualizarProduto() {
    let idProduto = document.getElementById('md-idProduto').innerText;
    let nomeProduto = document.getElementById('md-nome-produto').value;
    let qtdProduto = document.getElementById('md-quantidade-produto').value;
    let preco = document.getElementById('md-preco-produto').value;

    if (isNotNullOrEmpty(nomeProduto) &&
        isNotNullOrEmpty(qtdProduto) &&
        isNotNullOrEmpty(preco)
    ) {
        window.location = `produto?up=${idProduto}&nm=${nomeProduto}&qt=${qtdProduto}&pc=${preco}`;
        window.alert("Seu produto foi atualizado com sucesso!");
    } else {
        window.alert("Os dados sobre o produto precisam ser informados!");
    }
}

function isNotNullOrEmpty(valor) {
    return valor != null && valor !== "";
}

function updateValueAndValidityCarrinhoForm() {
    validaCampoTexto('enderecoCheckoutForm', 'enderecoCheckoutHelp', 'endereço');
    validaCampoTexto('numeroCheckoutForm', 'numeroCheckoutHelp', 'número');
    validaCampoTexto('bairroCheckoutForm', 'bairroCheckoutHelp', 'bairro');
    validaCampoTexto('estadoCheckoutForm', 'estadoCheckoutHelp', 'estado');
    validaCampoTexto('cepCheckoutForm', 'cepCheckoutHelp', 'CEP');
}

function isLoginFailed(valor) {
    if (valor) window.alert("Verifique novamente seus dados!");
}