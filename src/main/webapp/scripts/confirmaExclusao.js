function confirmar(codigo){
	let resposta = confirm("Confirme a exclusão do contato")
	
	if (resposta === true){
		window.location.href="delete?codigo=" + codigo;
	}
}