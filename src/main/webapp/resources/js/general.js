function removeAcentos(newStringComAcento) {
	var string = newStringComAcento;
	var mapaAcentosHex = {
		a : /[\xE0-\xE6]/g,
		A : /[\xC0-\xC6]/g,
		e : /[\xE8-\xEB]/g,
		E : /[\xC8-\xCB]/g,
		i : /[\xEC-\xEF]/g,
		I : /[\xCC-\xCF]/g,
		o : /[\xF2-\xF6]/g,
		O : /[\xD2-\xD6]/g,
		u : /[\xF9-\xFC]/g,
		U : /[\xD9-\xDC]/g,
	};

	for ( var letra in mapaAcentosHex) {
		var expressaoRegular = mapaAcentosHex[letra];
		string = string.replace(expressaoRegular, letra);
	}
	return upper(string);
}

function upper(str){
	return str.toUpperCase();
}


function validaCpf(cpf){
	strCPF = cpf.replace(/[^\d]+/g,'');
	var Soma;
    var Resto;
    Soma = 0;
    
    if (strCPF == "00000000000" || strCPF == "11111111111" ||
    	strCPF == "22222222222" || strCPF == "33333333333" ||
    	strCPF == "44444444444" || strCPF == "55555555555" ||
    	strCPF == "66666666666" || strCPF == "77777777777" ||
    	strCPF == "88888888888" || strCPF == "99999999999"){
    	alert('CPF inválido.')
    	cpf = '';
    	return cpf;
    }	
    
    for (i=1; i<=9; i++){
    	Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
    }
    Resto = (Soma * 10) % 11;
    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    
    if (Resto != parseInt(strCPF.substring(9, 10)) ){
    	alert('CPF inválido.');
    	cpf = '';
    	return cpf;    	
    } 
    
    Soma = 0;
    for (i = 1; i <= 10; i++){
    	Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
    } 
    
    Resto = (Soma * 10) % 11;
	
    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    
    if (Resto != parseInt(strCPF.substring(10, 11) ) ){
    	alert('CPF inválido.');
    	cpf = '';
    	return cpf;
    } 
    
    return cpf;
}



PrimeFaces.locales['pt_BR'] = {
        closeText: 'Fechar',
        prevText: 'Anterior',
        nextText: 'Próximo',
        currentText: 'Começo',
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],
        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],
        dayNamesMin: ['D','S','T','Q','Q','S','S'],
        weekHeader: 'Semana',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        timeOnlyTitle: 'Só Horas',
        timeText: 'Tempo',
        hourText: 'Hora',
        minuteText: 'Minuto',
        secondText: 'Segundo',
        currentText: 'Data Atual',
        ampm: false,
        month: 'Mês',
        week: 'Semana',
        day: 'Dia',
        allDayText : 'Todo Dia'
};

