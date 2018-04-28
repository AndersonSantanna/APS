package Controller;

import Model.Pessoa;
import Model.Sexo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private PasswordField passawordCadastro;
    
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

    private String diretorio = "/view/Login.fxml", title = "Meio Ambiente em Jogo";
    
    //private FXMLDocumentController teste;

    @FXML
    void Cadastrar(ActionEvent event) {
        Sexo sexo = boxSexo.getSelectionModel().getSelectedItem();
        Pessoa pessoa = new Pessoa(textNome, textUsuario, textIdade, passawordCadastro, sexo, textNomeArvore);
        System.out.println(pessoa);
        ativadorDeButtom(buttonCadastrar);

    }

    @FXML
    void voltar(ActionEvent event) {
       System.out.println("Botao Voltar Clicado!");
        ativadorDeButtom(buttonVoltar);
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
    public void ativadorDeButtom(Button buttom){
        Stage stage = new Stage();  
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Meio Ambiente em Jogo");
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            stage = (Stage) buttom.getScene().getWindow();
            stage.close();
        }
    }
}
