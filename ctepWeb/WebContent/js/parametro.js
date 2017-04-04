function removerValor(idParametro, idParametroValor) {
	if (confirm(msgConfirmRemove)) {
		var parametro = idParametro;
		var parametroValor = idParametroValor;
		jQuery.post("parametro.do?removerParametroValor", // URL para a ActionBean
				{
					'method' :'removerParametroValor', // nome do metodo no Bean
					'parametro.idParametro' :parametro,
					'parametroValor.idParametroValor' :parametroValor
				}, function(response) { // response gerada após processamento do JSP pelo container
					// format and output result
				jQuery("#crudParametroValor").html(response); // Coloca a response no conteúdo do elemento HTML cujo id é defaultOrgId.
			}, 'html');
	}
}
function xxsalvarParametroValor() {
	var parametro = document.getElementById('idParametro').value;
	var descricao = document.getElementById('descricao').value;
	var percentual = document.getElementById('percentual').value;
	var acrescimo = document.getElementById('acrescimo').value;
	jQuery.post("parametro.do?salvarParametroValor", // URL para a ActionBean
			{
				'method' :'salvarParametroValor', // nome do metodo no Bean
				'parametro.idParametro' :parametro,
				'parametroValor.descricao' :descricao,
				'parametroValor.acrescimo' :acrescimo,
				'parametroValor.eAcrescimoPercentual' :percentual
			}, function(response) { // response gerada após processamento do JSP pelo container
				// format and output result
			jQuery("#crudParametroValor").html(response); // Coloca a response no conteúdo do elemento HTML cujo id é defaultOrgId.
		}, 'html');
	limparCamposParametroValor();
}

function limparCamposParametroValor() {
	document.getElementById('acrescimo').value = '';
	document.getElementById('descricao').value = '';
	
}

function alterarParametroValor(idParametroValor, opcao, difValor) {
	var parametro = document.getElementById('idParametro').value;
	jQuery.post("parametro.do?salvarParametroValor", // URL para a ActionBean
			{
				'method' :'salvarParametroValor', // nome do metodo no Bean
				'parametro.idParametro' :parametro,
				'parametroValor.idParametroValor' :idParametroValor,
				'parametroValor.descricao' :opcao,
				'parametroValor.acrescimo' :difValor,
				'editando':true
			}, function(response) { // response gerada após processamento do JSP pelo container
				// format and output result
			tb_remove();	
			jQuery("#crudParametroValor").html(response); // Coloca a response no conteúdo do elemento HTML cujo id é defaultOrgId.
		}, 'html');
}