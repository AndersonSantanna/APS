/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static DAO.QuizDao.fetchPergunta;
import Model.Questao;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import static DAO.JogoDao.addRecursos;
import javafx.scene.Node;

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
    ToggleGroup grupoAlternativas = new ToggleGroup();

    
    @FXML
    private Text pergunta;

    @FXML
    private Button buttonEnviar;
    
    static int idRespostaCerta;
    private int id;
    private short nivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }
    
    @FXML
    void enviar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            if(Integer.parseInt(grupoAlternativas.getSelectedToggle().getUserData().toString()) == idRespostaCerta){
                alert.setHeaderText("Informação");
                alert.setContentText("Resposta correta ! você acaba de ganhar mais recursos para utilizar na sua árvore!");
                alert.showAndWait();
                addRecursos(nivel,id, (short)ThreadLocalRandom.current().nextInt(0,4));
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }else{
                alert.setHeaderText("Informação");
                alert.setContentText("Resposta errada :( tente novamente !");
                alert.showAndWait();
            }
        }catch(NullPointerException e){
            alert.setHeaderText("Informação");
            alert.setContentText("Selecione pelo menos uma das alternativas!");
            alert.showAndWait();
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alternativaA.setToggleGroup(grupoAlternativas);
        alternativaB.setToggleGroup(grupoAlternativas);
        alternativaC.setToggleGroup(grupoAlternativas);
        alternativaD.setToggleGroup(grupoAlternativas);
        Questao questao = fetchPergunta();
        pergunta.setText(questao.getQuestao());
        idRespostaCerta = questao.getRespCerta();

        alternativaA.setText(questao.getRespostas().get(0).getResposta());
        alternativaA.setUserData(questao.getRespostas().get(0).getId());
        
        alternativaB.setText(questao.getRespostas().get(1).getResposta());
        alternativaB.setUserData(questao.getRespostas().get(1).getId());
        
        alternativaC.setText(questao.getRespostas().get(2).getResposta());
        alternativaC.setUserData(questao.getRespostas().get(2).getId());
        
        alternativaD.setText(questao.getRespostas().get(3).getResposta());
        alternativaD.setUserData(questao.getRespostas().get(3).getId());
        
    }    
    
}
