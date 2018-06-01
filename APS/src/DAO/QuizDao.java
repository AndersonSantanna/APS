/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

/**
 *
 * @author gustavo
 */
public class QuizDao {
    
    static ResultSet rs;
    static PreparedStatement pst;
    
    public static Questao fetchPergunta(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Connection conexao = ConnectionModule.conexao();
            Questao questao = new Questao();
            String sql = "SELECT * FROM Questoes WHERE IdQuestao = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, ThreadLocalRandom.current().nextInt(1,4));
            rs = pst.executeQuery();
            if(rs.next()){
                questao.setQuestao(rs.getString("questao"));
                questao.setId(rs.getInt("IdQuestao"));
                questao.setRespCerta(rs.getInt("IdRespostaCorreta"));
                sql = "SELECT * FROM Respostas WHERE IdQuestao = ? ORDER BY rand()";
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, questao.getId());
                rs = pst.executeQuery();
                
                ArrayList<Resposta> aux = new ArrayList<>();
                while(rs.next()){
                    aux.add(new Resposta(rs.getInt("IdResposta"),rs.getString("resposta")));
                }
                questao.setRespostas(aux);
                conexao.close();
                return questao;
            }
        }catch(SQLException e){
            e.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Nome de usuário ou senha incorretos. Por favor, tente novamente.");
            alert.showAndWait();
            return null;
        }
        return null;
    }
}
