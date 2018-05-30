/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import Model.Arvore;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

/**
 *
 * @author Gustavo.Alves
 */
public class ArvoreDao {
    
    static PreparedStatement pst;
    static ResultSet rs;
    
    public static boolean cadastraArvore(int id,Arvore arvore){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Connection conexao = ConnectionModule.conexao();
            String sql = "SELECT * FROM Arvores WHERE NomeArvore = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1,arvore.getNome());
            rs = pst.executeQuery();
            if(!rs.next()){
                sql = "INSERT INTO Arvores(expArvore,nivelArvore,IdJogador,NomeArvore,QtdAdubar,QtdRegar,QtdDedetizar,QtdPodar) VALUES (?,?,?,?,10,10,10,10)";
                pst = conexao.prepareStatement(sql);
                pst.setInt(1,0);
                pst.setInt(2,1);
                pst.setInt(3,id);
                pst.setString(4,arvore.getNome());
                int result = pst.executeUpdate();
                if(result > 0){
                    return true;
                }
            }else{
                alert.setHeaderText("Informação");
                alert.setContentText("Nome da árvore já existe no banco de dados. Por favor, tente novamente com outro nome.");
                alert.showAndWait();
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            
        }
        return false;
    }
}
