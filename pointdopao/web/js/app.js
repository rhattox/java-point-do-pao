function navegarParaPagina(page, pr) {
    window.location = `${page}?pr=${pr}`;
}

function navegarParaHome() {
    window.location = "/entrar";
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
    if (variable===true) {
        alert('Usuário cadastrado com sucesso!');
    }
}