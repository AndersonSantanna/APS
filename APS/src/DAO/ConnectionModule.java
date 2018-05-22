/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author gustavo
 */
public class ConnectionModule {
        public static Connection conexao(){
        Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/Game";
        String user = "root";
        String password = "root";

        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
