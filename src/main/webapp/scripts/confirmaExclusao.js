function confirmar(codigo){
	let resposta = confirm("Confirme a exclusão do contato")
	
	if (respoata === true){
		window.location.href="delete?codigo=" + codigo;
	}
}