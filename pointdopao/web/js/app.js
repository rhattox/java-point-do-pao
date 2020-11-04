function navegarParaPagina(page) {
    window.location = page;
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
function validaForm(urlDestino) {
    if (document.getElementById('nomeHelp').style.display === "none" &&
        document.getElementById('sobrenomeHelp').style.display === "none" &&
        document.getElementById('emailHelp').style.display === "none" &&
        document.getElementById('senhaHelp').style.display === "none" &&
        document.getElementById('senhaHelp').style.display === "none") {
        navegarParaPagina(urlDestino);
    } else {
        validaCampoTexto('nomeForm', 'nomeHelp', 'nome');
        validaCampoTexto('sobrenomeForm', 'sobrenomeHelp', 'sobrenome');
        validaCampoTexto('emailForm', 'emailHelp', 'email');
        validaSenhas();
        window.alert("O formulário contém campos inválidos!");
    }
}
/*------------------------------*/