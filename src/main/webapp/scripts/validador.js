function validar(){
	let nome = formContato.nome.value
	let fone = formContato.telefone.value
	let email = formContato.email.value
	
	if(nome === ""){
		alert('O campo Nome é obrigatório')
		formContato.nome.focus()
		return false
	}else	
	if(fone === ""){
		alert('O campo Telefone é obrigatório')
		formContato.telefone.focus()
		return false
	}else	
	if(email === ""){
		alert('O campo Email é obrigatório')
		formContato.email.focus()
		return false
	}else{
		document.forms["formContato"].submit()
	}
}