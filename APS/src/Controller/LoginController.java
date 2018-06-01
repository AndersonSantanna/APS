package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static DAO.PlayerDao.loginPlayer;
import Model.Pessoa;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

/**
 *
 * @author anderson
 */

public class LoginController implements Initializable {
    
    @FXML
    private Button buttonEntrar;

    @FXML
    public Button buttonCadastrar ;

    @FXML
    private PasswordField senha;

    @FXML
    private ImageView imagemArvore;
    
    @FXML
    private Label label;
    
    @FXML
    public TextField usuario;
     
    @FXML
    private Label aviso;
    
    //SQL
    PreparedStatement pst;
    ResultSet rs = null;
    

    @FXML
    private void entrarButtonAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Pessoa pessoa = new Pessoa(usuario,senha);
            boolean isLoginSucessful = loginPlayer(pessoa);
            if(isLoginSucessful){
                verificaLogin(true,pessoa);
            }else{
                verificaLogin(false,null);
            }
        }catch(NumberFormatException| NullPointerException e){
            e.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Por favor,preencha todos os campos corretamente antes de continuar");
            alert.showAndWait();
            verificaLogin(false,null);
        }
    }
    
    @FXML
    private void cadastrarButtonAction(ActionEvent event) {
        System.out.println("Botao Cadastrar clicado!");
        
        Stage stage = new Stage();  
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/View/Cadastro.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Cadastro");
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            stage = (Stage) buttonCadastrar.getScene().getWindow();
            stage.close();
        }
    }
    
    public void verificaLogin( boolean loginSucess,Pessoa pessoa){
        Stage stage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
            Parent root = (Parent)loader.load();
            if(loginSucess == true){
                loader = new FXMLLoader(getClass().getResource("/View/Jogo.fxml"));
                root = (Parent)loader.load();
                JogoController jogoCtrlr = loader.getController();
                jogoCtrlr.setPlayer(pessoa);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Meio Ambiente em Jogo");
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            stage = (Stage) buttonCadastrar.getScene().getWindow();
            stage.close();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
