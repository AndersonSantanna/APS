/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Arvore;
import Model.Pessoa;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ander
 */
public class JogoController implements Initializable {

    @FXML
    private Label qtdRegar;

    @FXML
    private Label qtdPoldar;

    @FXML
    private Label qtdPragas;

    @FXML
    private Label qtdAdubar;
    static short aux;
    @FXML
    private ImageView arvore;
    private Arvore arv;
    
    @FXML
    private Text labelNivel;
    
    @FXML
    private ImageView imgAjuda;
    
    @FXML
    private ImageView nuvem;    
    
    @FXML
    private ProgressBar progresso;
    @FXML
    private ProgressIndicator pi;
    
    private Pessoa player;
    
    
    @FXML
    void aumentarTamanho(MouseEvent event) {
        arvore.setX(arvore.getX() - 3);
        arvore.setY(arvore.getY() - 5.89);
        arvore.setFitHeight(arvore.getFitHeight() + 10);
        arvore.setFitWidth(arvore.getFitWidth() + 5); 
    }

    @FXML
    void ajuda(MouseEvent event) throws InterruptedException {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Ajuda.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Ajuda");
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    void detetizar(MouseEvent event) {
        aux = Short.parseShort(qtdPragas.getText());
        if(aux > 0 ){
            arv.eliminarPragas();
            System.out.println("Detetizando");
            aux -= 1;
            qtdPragas.setText("" + aux);
            aumentarNivel();
            progresso.setProgress(arv.getXp());
            pi.setProgress(progresso.getProgress());
            verificador();
        }
    }

    @FXML
    void perguntas(MouseEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Quiz.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Quiz");
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void poldar(MouseEvent event) {
        aux = Short.parseShort(qtdPoldar.getText());
        if (aux > 0){
            arv.poldar();
            System.out.println("Poldando");
            aux -=1;
            qtdPoldar.setText("" + aux);
            aumentarNivel();
            progresso.setProgress(arv.getXp());
            pi.setProgress(progresso.getProgress());
            verificador();
        }
    }
      
    @FXML
    void adubar(MouseEvent event) {
        aux = Short.parseShort(qtdAdubar.getText());
        if( aux > 0){
            arv.adubar();
            System.out.println("Adubando");
            aux -= 1;
            qtdAdubar.setText("" + aux);
             aumentarNivel();
            progresso.setProgress(arv.getXp());
            pi.setProgress(progresso.getProgress());
            verificador();
           
        }
    }
    
    @FXML
    void regar(MouseEvent event) {
        aux = Short.parseShort(qtdRegar.getText());
        if( aux > 0){
            arv.regar();
            System.out.println("Regando");
            aux -= 1;
            qtdRegar.setText("" + aux);
            aumentarNivel();
            progresso.setProgress(arv.getXp());
            pi.setProgress(arv.getXp());
            verificador();
        }
    }
    
   public void verificador(){
       if (arv.getXp() == 1){
            progresso.setProgress(0);
            pi.setProgress(0);
        }
   }
    
    public void aumentarArvore(){
        if(arv.getNivel() < 41){
            arvore.setX(arvore.getX() - 3);
            arvore.setY(arvore.getY() - 5.89);
            arvore.setFitHeight(arvore.getFitHeight() + 10);
            arvore.setFitWidth(arvore.getFitWidth() + 5); 
        }
    }
    
    public void aumentarNivel(){
        if(arv.getXp() >= 1){
            arv.setNivel((short)(arv.getNivel() + 1));
            arv.setXp((float)(arv.getXp() - 1));
            aumentarArvore();
            labelNivel.setText(""+ arv.getNivel());
        }
    }
    
    public void setPlayer(Pessoa pessoa){
        this.player = new Pessoa(pessoa.getUsuario(),pessoa.getSenha());
    }
    
    public Pessoa getPlayer(){
        return this.player;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
