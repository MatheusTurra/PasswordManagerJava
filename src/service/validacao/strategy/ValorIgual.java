package service.validacao.strategy;

import javafx.scene.control.TextInputControl;

public class ValorIgual extends Validacao {
	private String mensagemErro;
	private boolean validacaoFalhou = false;
	private DadosErroRecord dadosErro;
	
	@Override
	public void validar(TextInputControl inputJanela) throws Exception {
		throw new Exception("Nenhum valor passado para comparacao");
	}

	@Override
	public void validar(TextInputControl inputJanela, String parametroValidacao) throws Exception {
		if (!inputJanela.getText().equals(parametroValidacao)) {
			this.validacaoFalhou = true;
			this.mensagemErro = "Os valores nao podem ser diferentes!";
		}
		
		this.dadosErro = new DadosErroRecord(inputJanela.getId(), inputJanela.getText(), this.validacaoFalhou, this.getClass().getName(), this.mensagemErro);
	}

	@Override
	public DadosErroRecord obterDadosErro() {
		return this.dadosErro;
	}

	@Override
	public boolean validacaoFalhou() {
		return this.validacaoFalhou;
	}
}
