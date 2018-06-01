/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import Model.*;
import static DAO.ArvoreDao.cadastraArvore;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
/**
 *
 * @author gustavo
 */
public class PlayerDao {
    
    static PreparedStatement pst;
    static ResultSet rs;
    
    public static boolean cadastraPlayer(Pessoa pessoa,Arvore arvore){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Connection conexao = ConnectionModule.conexao();
            String sql = "SELECT * FROM Players WHERE Usuario = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1,pessoa.getUsuario());
            rs = pst.executeQuery();
            if(!rs.next()){
                sql = "INSERT INTO Players(NomeJogador,Usuario,Senha,Idade,Sexo) VALUES (?,?,?,?,?)";
                pst = conexao.prepareStatement(sql);
                pst.setString(1,pessoa.getNome());
                pst.setString(2,pessoa.getUsuario());
                pst.setString(3,pessoa.getSenha());
                pst.setString(4,String.valueOf(pessoa.getIdade()));
                pst.setString(5,pessoa.getSexo());
                int result = pst.executeUpdate();
                if(result > 0){
                    sql = "SELECT MAX(IdJogador) FROM Players";
                    pst= conexao.prepareStatement(sql);
                    rs = pst.executeQuery(sql);
                    if(rs != null){
                        rs.first();
                        boolean isArvoreCadastrada = cadastraArvore(rs.getInt("max(IdJogador)"),arvore);
                        if(isArvoreCadastrada){
                            alert.setHeaderText("Informação");
                            alert.setContentText("Usuário cadastrado com sucesso! Clique em OK para ser redirecionado para a área de login.");
                            alert.showAndWait();
                            conexao.close();
                            return true;
                        }else{ 
                            System.out.println("Erro na Query \"SELECT MAX \"");
                            conexao.close();
                            return false;
                        }
                    }
                }
            }else{
                alert.setHeaderText("Informação");
                alert.setContentText("Nome de usuário já cadastrado no banco de dados. Por favor, tente novamente com outro nome.");
                alert.showAndWait();
                conexao.close();
                return false;
            }
            //return rs;
        }catch(SQLException e){
            e.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Erro no banco de dados. Por favor, tente novamente mais tarde.");
            alert.showAndWait();
            return false;
        }
        return false;
    } 
    
    public static boolean loginPlayer(Pessoa pessoa){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try{
            Connection conexao = ConnectionModule.conexao();
            String sql = "SELECT * from Players WHERE Usuario = ? AND Senha = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1,pessoa.getUsuario());
            pst.setString(2, pessoa.getSenha());
            rs = pst.executeQuery();
            if(rs.next()){
                conexao.close();
                return true;
            }else{
                alert.setHeaderText("Informação");
                alert.setContentText("Nome de usuário ou senha incorretos. Por favor, tente novamente.");
                alert.showAndWait();
                conexao.close();
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            alert.setHeaderText("Informação");
            alert.setContentText("Erro no banco de dados. Por favor, tente novamente mais tarde.");
            alert.showAndWait();
            return false;
        }
    }
    
}
