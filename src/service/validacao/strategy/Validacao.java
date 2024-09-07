package service.validacao.strategy;

import javafx.scene.control.TextInputControl;

public abstract class Validacao{
	//TODO: CRIAR EXCEPTIONS PARA: MAL USO DA SERVICE DE VALIDACAO (NAO ENVIAR PARAMETROS DE VALIDACAO) E ERRO DE VALIDACAO
	public abstract ResultadoValidacaoRecord validar(TextInputControl inputJanela) throws Exception;
	public abstract ResultadoValidacaoRecord validar(TextInputControl inputJanela, String parametroValidacao) throws Exception;
	public abstract boolean validacaoFalhou();
		
	
}
