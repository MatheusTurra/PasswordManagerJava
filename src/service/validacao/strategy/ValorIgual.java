package service.validacao.strategy;

import javafx.scene.control.TextInputControl;

public class ValorIgual extends Validacao {
	private String mensagemErro;
	private boolean validacaoFalhou = false;
	
	@Override
	public ResultadoValidacaoRecord validar(TextInputControl inputJanela) throws Exception {
		return new ResultadoValidacaoRecord(false, "Deve ser passado um um valor minimo para a validacao ValorIgual.");
	}

	@Override
	public ResultadoValidacaoRecord validar(TextInputControl inputJanela, String parametroValidacao) throws Exception {
		if (!inputJanela.getText().equals(parametroValidacao)) {
			this.validacaoFalhou = true;
			this.mensagemErro = "Os valores nao podem ser diferentes!";
		}
		
		return new ResultadoValidacaoRecord(this.validacaoFalhou, this.mensagemErro);
	}

	@Override
	public boolean validacaoFalhou() {
		return this.validacaoFalhou;
	}
}
