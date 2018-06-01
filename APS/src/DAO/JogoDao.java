/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.*;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author gustavo
 */
public class JogoDao {
    
    static ResultSet rs;
    static PreparedStatement pst;
    static String[] tipoRecurso = {"QtdAdubar","QtdRegar","QtdDedetizar","QtdPodar"};
    
    public static PessoaArvore fetchPlayer(Pessoa pessoa){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Connection conexao = ConnectionModule.conexao();
            String sql = "select * from Players  where Players.Usuario = ? and Players.Senha = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1,pessoa.getUsuario());
            pst.setString(2,pessoa.getSenha());
            rs = pst.executeQuery();
            if(rs.next()){
                sql = "select * from Players inner join Arvores on Players.IdJogador=Arvores.IdJogador where Players.IdJogador = ?";
                pst = conexao.prepareStatement(sql);
                pst.setInt(1,rs.getInt("IdJogador"));
                rs = pst.executeQuery();
                if(rs.next()){
                    PessoaArvore player = new PessoaArvore(new Pessoa(rs.getString("NomeJogador"),rs.getString("Usuario"),rs.getInt("IdJogador")),new Arvore(rs.getString("NomeArvore"),rs.getShort("nivelArvore"),rs.getDouble("expArvore"),rs.getInt("IdArvore"),rs.getInt("QtdAdubar"),rs.getInt("QtdRegar"),rs.getInt("QtdDedetizar"),rs.getInt("QtdPodar")));
                    conexao.close();
                    return player;
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Erro no banco de dados. Por favor, tente novamente mais tarde.");
            alert.showAndWait();
        }
        return null;
    }
    
    public static void updateXp(int id,double xp){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Connection conexao = ConnectionModule.conexao();
            String sql = "UPDATE Arvores SET ExpArvore = ? WHERE IdArvore = ?";
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, xp);
            pst.setInt(2, id);
            int r = pst.executeUpdate();
            conexao.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Erro no banco de dados. Por favor, tente novamente mais tarde.");
            alert.showAndWait();
        }
    }
    
    public static void updateNivel(int id,short nivel){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Connection conexao = ConnectionModule.conexao();
            String sql = "UPDATE Arvores SET NivelArvore= ?, ExpArvore = 0 WHERE IdArvore=?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, nivel);
            pst.setInt(2, id);
            pst.executeUpdate();
            addRecursos(nivel,id, (short)ThreadLocalRandom.current().nextInt(0,4));
            conexao.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Erro no banco de dados. Por favor, tente novamente mais tarde.");
            alert.showAndWait();
        }
    }
    
    public static void addRecursos(short nivel,int id, short tipoRec){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Connection conexao = ConnectionModule.conexao();
            String sql = "UPDATE Arvores SET "+ tipoRecurso[tipoRec]+ " = " + tipoRecurso[tipoRec] + " + ? WHERE IdArvore = ?";
            pst= conexao.prepareStatement(sql);
            pst.setInt(1, nivel * 4);
            pst.setInt(2, id);
            pst.executeUpdate();
            conexao.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Erro no banco de dados. Por favor, tente novamente mais tarde.");
            alert.showAndWait();
        }
    }
    
    public static Arvore atualizaFrontEnd(int id){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Arvore arv;
            try (Connection conexao = ConnectionModule.conexao()) {
                String sql = "SELECT * FROM Arvores WHERE IdArvore = ?";
                pst= conexao.prepareStatement(sql);
                pst.setInt(1,id);
                rs = pst.executeQuery();
                rs.next();
                arv = new Arvore(rs.getString("NomeArvore"),rs.getShort("NivelArvore"),rs.getDouble("ExpArvore"),rs.getInt("IdArvore"),rs.getInt("QtdAdubar"),rs.getInt("QtdRegar"),rs.getInt("QtdDedetizar"),rs.getInt("QtdPodar"));
                conexao.close();
            }
            return arv;
        }catch(SQLException ex){
            ex.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Erro no banco de dados. Por favor, tente novamente mais tarde.");
            alert.showAndWait();
            return null;
        }
    }
    
    public static void updateRecursos(String tipoRec,int id){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        String rec = null;
        try{
            Connection conexao = ConnectionModule.conexao();
            switch(tipoRec){
                case "adubar":
                    rec = tipoRecurso[0];
                    break;
                case "regar":
                    rec = tipoRecurso[1];
                    break;
                case "dedetizar":
                    rec = tipoRecurso[2];
                    break;
                case "podar":
                    rec = tipoRecurso[3];
                    break;
                default:
                    System.out.println("algo errado nas strings!");
            }
            String sql = "UPDATE Arvores SET " + rec + " = " +rec+ " - 1 WHERE IdArvore = ?";
            pst= conexao.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
            conexao.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Erro no banco de dados. Por favor, tente novamente mais tarde.");
            alert.showAndWait();
        }
    }
    
}
