/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.JogoDao;
import static DAO.JogoDao.atualizaFrontEnd;
import Model.Arvore;
import Model.Pessoa;
import Model.PessoaArvore;
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
import static DAO.JogoDao.fetchPlayer;
import static DAO.JogoDao.updateNivel;
import static DAO.JogoDao.updateXp;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author ander
 */
public class JogoController implements Initializable {

    @FXML
    private Label qtdRegar;

    @FXML
    private Label qtdPodar;

    @FXML
    private Label qtdDedetizar;

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
    private Label nomeArvoreLabel;
    
    @FXML
    private ProgressBar progresso;
    @FXML
    private ProgressIndicator pi;
    
    private PessoaArvore player;
    
    
    
    
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
    void sair(MouseEvent event) throws InterruptedException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmar saída");
        alert.setHeaderText("Confirmação de saída do jogo");
        alert.setContentText("Deseja realmente sair do jogo?");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
        } else {
            //Nada, retornar ao fluxo normal do jogo.
        }
        
    }
    
    @FXML
    void dedetizar(MouseEvent event) {
        aux = Short.parseShort(qtdDedetizar.getText());
        if(aux > 0 ){
            arv.eliminarPragas();
            System.out.println(arv.getIdArvore());
            System.out.println("XP atual:" + arv.getXp());
            aux -= 1;
            qtdDedetizar.setText("" + aux);
            verificaNivel();
            progresso.setProgress(getProgresso());
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
    void podar(MouseEvent event) {
        aux = Short.parseShort(qtdPodar.getText());
        if (aux > 0){
            arv.podar();
            updateXp(arv.getIdArvore(),arv.getXp());
            System.out.println("XP atual:" + arv.getXp());
            aux -=1;
            qtdPodar.setText("" + aux);
            verificaNivel();
            progresso.setProgress(getProgresso());
            pi.setProgress(progresso.getProgress());
            verificador();
        }
    }
      
    @FXML
    void adubar(MouseEvent event) {
        aux = Short.parseShort(qtdAdubar.getText());
        if( aux > 0){
            arv.adubar();
            updateXp(arv.getIdArvore(),arv.getXp());
            System.out.println("XP atual:" + arv.getXp());
            aux -= 1;
            qtdAdubar.setText("" + aux);
             verificaNivel();
            progresso.setProgress(getProgresso());
            pi.setProgress(progresso.getProgress());
            verificador();
           
        }
    }
    
    @FXML
    void regar(MouseEvent event) {
        aux = Short.parseShort(qtdRegar.getText());
        if( aux > 0){
            arv.regar();
            updateXp(arv.getIdArvore(),arv.getXp());
            System.out.println("XP atual:" + arv.getXp());
            aux -= 1;
            qtdRegar.setText("" + aux);
            verificaNivel();
            progresso.setProgress(getProgresso());
            pi.setProgress(progresso.getProgress());
            verificador();
        }
    }
    
   public void verificador(){
       if (arv.getXp() == getXpProxNivel()){
            progresso.setProgress(getProgresso());
            pi.setProgress(progresso.getProgress());
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
    
    public void verificaNivel(){
        if(arv.getXp() >= getXpProxNivel()){
            arv.setXp(arv.getXp()-getXpProxNivel());
            arv.setNivel((short)(arv.getNivel() + 1));
            aumentarArvore();
            updateNivel(arv.getIdArvore(),arv.getNivel());
            arv = atualizaFrontEnd(arv.getIdArvore());
            qtdAdubar.setText(String.valueOf(arv.getQtdAdubar()));
            qtdRegar.setText(String.valueOf(arv.getQtdRegar()));
            qtdDedetizar.setText(String.valueOf(arv.getQtdDedetizar()));
            qtdPodar.setText(String.valueOf(arv.getQtdPodar()));
            progresso.setProgress(getProgresso());
            labelNivel.setText(""+ arv.getNivel());
        }
    }
    
    public void setPlayer(Pessoa pessoa){
        this.player = fetchPlayer(pessoa);
        labelNivel.setText(Short.toString(player.getArvore().getNivel()));
        arv = new Arvore(player.getArvore().getNome(),player.getArvore().getNivel(),player.getArvore().getXp(),player.getArvore().getIdArvore(),player.getArvore().getQtdAdubar(),player.getArvore().getQtdRegar(),player.getArvore().getQtdDedetizar(),player.getArvore().getQtdPodar());
        nomeArvoreLabel.setText(arv.getNome());
        qtdAdubar.setText(String.valueOf(arv.getQtdAdubar()));
        qtdRegar.setText(String.valueOf(arv.getQtdRegar()));
        qtdDedetizar.setText(String.valueOf(arv.getQtdDedetizar()));
        qtdPodar.setText(String.valueOf(arv.getQtdPodar()));
        progresso.setProgress(getProgresso());
        pi.setProgress(progresso.getProgress());
    }
    
    public double getXpProxNivel(){
        return arv.getNivel()* 0.75;
    }
    
    public double getProgresso(){
        double x = (arv.getXp()*100) / getXpProxNivel();
        return x/100;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
