package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.validacao.ValidacaoService;

public class CriarSenhaController {
	@FXML
	private TextField nome;
	@FXML
	private TextField senha;
	@FXML
	private TextField repetirSenha;
	@FXML
	private TextField url;
	@FXML
	private TextArea detalhes;
	
	public void criarSenha() {
		ValidacaoService validacao= this.obterValidationService();
		validacao.validarInput(this.nome, "tamanhoMinimo:6", "tamanhoMinimo:10");
		validacao.validarInput(this.senha, "tamanhoMinimo:11");
		validacao.validarInput(this.senha, "tamanhoMinimo:12");
		validacao.validarInput(this.repetirSenha, String.format("igual:%s", this.senha.getText()), "tamanhoMinimo:13");
		
		// TODO: CRIAR UMA CLASSE FINAL CHAMADA ERRO VALIDACAO QUE VAI SALVAR O INPUT QUE FALHOU, MENSAGEM E MOTIVO QUE FALHOU E INSERIR ELE NA LISTA DE ERROS
		validacao.imprimirErros();
	}
	
	protected ValidacaoService obterValidationService() {
		return new ValidacaoService();
	}
}
