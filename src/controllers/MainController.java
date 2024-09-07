package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController implements Initializable{
    @FXML
    private Label rodape;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int anoAtual = Year.now().getValue();
		String mensagemRodape = String.format("© %s Lixosoft Corporation", anoAtual);
		
		this.rodape.setText(mensagemRodape);		
	}
	

	@FXML
	public void renderizarViewCriarNovaSenha(ActionEvent eventoClique) throws IOException {
		// TODO CRIAR METODO ESTATICO PARA RENDERIZAR FXML
		URL arquivoJanelaCriarSenha = this.getClass().getResource("/resources/views/criarSenha.fxml");
		
		Parent fxmlJanela = FXMLLoader.load(arquivoJanelaCriarSenha);
		Scene conteudoJanela = new Scene(fxmlJanela);
	
		Stage janela = new Stage();
		janela.setScene(conteudoJanela);
		janela.setMinWidth(600);
		janela.setMinHeight(400);
		janela.setResizable(false);
		janela.show();
	}
}
