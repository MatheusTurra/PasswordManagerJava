package service.validacao.strategy;

public record ResultadoValidacaoRecord(
		Boolean validacaoFalhou, 
		String mensagemErro
) {}
