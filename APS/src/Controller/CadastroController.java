package Controller;

import Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static DAO.PlayerDao.cadastraPlayer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author anderson
 */
public class CadastroController implements Initializable {

      
    @FXML
    private TextField textNome;

    @FXML
    private TextField textUsuario;

    @FXML
    private PasswordField senhaCadastro;
    
    @FXML
    private TextField textIdade;

    @FXML
    private ComboBox<Sexo> boxSexo;
    private List<Sexo> list = new ArrayList<>();
    private ObservableList<Sexo> observableList;
    @FXML
    private TextField textNomeArvore;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonVoltar;
    
    @FXML
    private Label aviso;

    
    //private FXMLDocumentController teste;

    @FXML
    void Cadastrar(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Sexo sexo = boxSexo.getSelectionModel().getSelectedItem();
            boolean isCadastrado = cadastraPlayer(new Pessoa(textNome, textUsuario, textIdade, senhaCadastro, sexo.getSexo()),new Arvore(textNomeArvore));
            if(isCadastrado){
                ativadorDeButton(buttonCadastrar,true);
            }else{
                ativadorDeButton(buttonCadastrar,false);
            }
        }
        catch(NumberFormatException | NullPointerException ex){
            alert.setHeaderText("Informação");
            alert.setContentText("Por favor,preencha todos os campos e selecione o sexo antes de continuar.");
            alert.showAndWait();
            ativadorDeButton(buttonCadastrar,false);
        }  
    }

    @FXML
    void voltar(ActionEvent event) {
        System.out.println("Botao Voltar Clicado!");
        ativadorDeButton(buttonVoltar,true);
    }
    
    private void carregarSexo(){
        Sexo feminino = new Sexo(0,"Feminino");
        Sexo masculino = new Sexo(1,"Masculino");
        list.add(masculino);
        list.add(feminino);
        observableList = FXCollections.observableArrayList(list);
        boxSexo.setItems(observableList);
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarSexo();
        
    }    
    public void ativadorDeButton(Button button, boolean isCadastrado){
        Stage stage = new Stage();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            if(!isCadastrado){
                root = FXMLLoader.load(getClass().getResource("/View/Cadastro.fxml"));
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Meio Ambiente em Jogo");
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            stage = (Stage) button.getScene().getWindow();
            stage.close();
        }
    }
}
