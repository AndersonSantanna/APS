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
    void enviar(ActionEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
