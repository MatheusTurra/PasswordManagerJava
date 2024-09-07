package service.validacao.strategy;

public record DadosErroRecord(
		String nomeInput, 
		String valorInput, 
		Boolean validacaoFalhou, 
		String tipoValidacao, 
		String mensagemErro
) {}
