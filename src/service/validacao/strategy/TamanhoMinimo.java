package service.validacao.strategy;

import javafx.scene.control.TextInputControl;

public class TamanhoMinimo extends Validacao {
	private boolean validacaoFalhou;
	private String mensagemErro;
	
	public TamanhoMinimo() {
		this.mensagemErro = null;
		 this.validacaoFalhou = false;
	}
	
	@Override
	public ResultadoValidacaoRecord validar(TextInputControl inputJanela) throws Exception {
		return new ResultadoValidacaoRecord(false, "Deve ser passado um um valor minimo para a validacao TamanhoMinimo.");
	}
	
	@Override
	public ResultadoValidacaoRecord validar(TextInputControl input, String parametroValidacao) {
		if (input.getText().length() < Integer.valueOf(parametroValidacao)) {
			this.validacaoFalhou = true;
			this.mensagemErro = String.format("O campo %s não pode conter menos que %s caracteres", input.getId(), parametroValidacao);
		}
		
		return new ResultadoValidacaoRecord(this.validacaoFalhou, this.mensagemErro);
	}
	
	@Override
	public boolean validacaoFalhou() {
		return this.validacaoFalhou;
	}
}
