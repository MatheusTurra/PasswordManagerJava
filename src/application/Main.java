package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {	
	@Override
	public void start(Stage janelaPrincipal) {
		try {
			URL pathArquivoFxml = this.getClass().getResource("/resources/views/main.fxml");
			Parent conteudoJanela = FXMLLoader.load(pathArquivoFxml);
			Scene conteudo = new Scene(conteudoJanela);
			
			janelaPrincipal.setMinWidth(1000);
			janelaPrincipal.setMinHeight(700);
			janelaPrincipal.setScene(conteudo);
			janelaPrincipal.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
