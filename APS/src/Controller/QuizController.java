/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ander
 */
public class QuizController implements Initializable {

    @FXML
    private RadioButton alternativaA;

    @FXML
    private RadioButton alternativaB;

    @FXML
    private RadioButton alternativaC;

    @FXML
    private RadioButton alternativaD;
    
    @FXML
    private Text pergunta;

    @FXML
    private Button buttonEnviar;
    
    @FXML
    private Label situacao;
    
    String perguntas[] = new String[15];
    char resposta [] = new char[1];
    String agua[] = new String[25];
    
    @FXML
    void enviar(ActionEvent event) {
        if(true){
            situacao.setText("Acertou, ganhou 1 regador");
            JogoController.aux++;
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        agua[0] = "O que é agua";
        perguntas[0] = agua[0];
        pergunta.setText(perguntas[0]);
        resposta[0] = 'a';
        alternativaA.setText("h20");
        alternativaB.setText("h02");
        alternativaC.setText("2h0");
        alternativaD.setText("0h2");
        
    }    
    
}
