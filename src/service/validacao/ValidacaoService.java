package service.validacao;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.control.TextInputControl;
import service.validacao.strategy.DadosErroRecord;
import service.validacao.strategy.TamanhoMinimo;
import service.validacao.strategy.Validacao;
import service.validacao.strategy.ValorIgual;

/**
 * Classe responsavel por construir o hashMap das validacoes serao feitas 
 * e aplicar o strategy pattern para instanciar as classes de validacao corretas
 */
public class ValidacaoService {
	private ArrayList<DadosErroRecord> listaValidacoes;
	protected HashMap<String, Validacao> validacoesStrategy;
	
	public ValidacaoService() {
		this.listaValidacoes = new ArrayList<DadosErroRecord>();
		
		//TODO: PASSAR CLASSES POR REFERENCIA E INSTANCIAR AS CLASSES COM DADOS DO INPUT NO CONSTRUTOR
		this.validacoesStrategy = new HashMap<String, Validacao>();
		this.validacoesStrategy.put("igual", new ValorIgual());
		this.validacoesStrategy.put("tamanhoMinimo", new TamanhoMinimo());
	}
	
	//TODO: LANCAR EXCEPTION CASO A VALIDACAO NAO SEJA ENCONTRADA NO MAPA DE VALIDACOES	
	public void validarInput(TextInputControl input, String ...validacoes) {
		try {
			for (String validacao : validacoes) {
				Validacao validacaoInput = null;

				boolean validacaoContemParametros = validacao.contains(":");
				if (validacaoContemParametros) {
					//TODO: LANCAR EXCEPTION CASO NAO SEJA PASSADO NENHUM VALOR DE PARAMETRO
					Object nomeValidacao = validacao.split(":");
					String parametroValidacao = validacao.split(":")[1];
					
					validacaoInput = this.validacoesStrategy.get(nomeValidacao);
					validacaoInput.validar(input, parametroValidacao);
				} else {
					validacaoInput = this.validacoesStrategy.get(validacao);
					validacaoInput.validar(input);
				}
				
				this.listaValidacoes.add(validacaoInput.obterDadosErro());			}	
		} catch (Exception erroValidacao) {
			erroValidacao.printStackTrace();
		}
	}
	
	//TODO: CRIAR REPOSITORIO
	//https://stackoverflow.com/questions/16903046/find-todo-tags-in-eclipse
	//CRIAR UM OBJETO PARA ARMAZENAR ESSE MAP LER SOBRE RECORD https://www.youtube.com/watch?v=gJ9DYC-jswo

	
	public void imprimirErros() {
		for (DadosErroRecord erro : this.listaValidacoes) {
			if (erro.validacaoFalhou()) {
				System.out.println(erro.mensagemErro());
			}
		}
	}
}
