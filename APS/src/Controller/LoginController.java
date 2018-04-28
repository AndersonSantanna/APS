package Controller;

import java.io.IOException;
import java.net.URL;
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

    @FXML
    private void entrarButtonAction(ActionEvent event) {
        //String string = passaword.getText().toString();
        System.out.println("Botão clicado" );
        System.out.println("Usuuario: " + usuario.getText());
        System.out.println("senha: " + senha.getText());
        Stage stage = new Stage();
       // if(usuario.getText().equals("adm") && senha.getText().equals("123")){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/View/Jogo.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Jogo em ação");
                stage.show();
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                stage = (Stage) buttonCadastrar.getScene().getWindow();
                stage.close();
            }
        /*}else{
            aviso.visibleProperty().setValue(Boolean.TRUE);
        }*/
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
