package service.validacao.strategy;

import javafx.scene.control.TextInputControl;

public class TamanhoMinimo extends Validacao {
	private boolean validacaoFalhou;
	private String mensagemErro;
	private DadosErroRecord dadosErro;
	
	public TamanhoMinimo() {
		this.mensagemErro = null;
		 this.validacaoFalhou = false;
	}
	
	@Override
	public void validar(TextInputControl inputJanela) throws Exception {
		throw new Exception("Deve ser passado um um valor minimo para a validacao TamanhoMinimo.");
	}
	
	@Override
	public void validar(TextInputControl input, String parametroValidacao) {
		if (input.getText().length() < Integer.valueOf(parametroValidacao)) {
			this.validacaoFalhou = true;
			this.mensagemErro = String.format("O campo %s não pode conter menos que %s caracteres", input.getId(), parametroValidacao);
		}
		
		this.dadosErro = new DadosErroRecord(input.getId(), input.getText(), this.validacaoFalhou, this.getClass().getName(), this.mensagemErro);
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
