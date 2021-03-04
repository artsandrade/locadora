/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author arthu
 */
public class Conexao implements Serializable{
    private static Conexao conexao = null;
    private static Connection connection;
    private String usuario;
    private String senha;
    private String url;
    
    private Conexao(){
        usuario = "root";
        senha = "";
        url="jdbc:mysql://localhost:3306/locadora";
        
        try{
           Class.forName("com.mysql.jdbc.Driver"); 
            connection = (Connection) DriverManager.getConnection(url, usuario, senha);
        } catch(ClassNotFoundException e){
        } catch(SQLException e){
        }
    }
    
    public static Connection getinstance(){
        if(conexao==null){
            synchronized(Conexao.class){
                conexao = new Conexao();
            }
        }
        return connection;
    }
    
    public static void closeInstance() throws SQLException{
        if(conexao!=null){
            connection.close();
        }
    }
    
    public static void setAutoCommit(boolean vlr) throws SQLException{
        connection.setAutoCommit(vlr);
    }
    
    public static void commit() throws SQLException{
        connection.commit();
    }
    
    public static void rollback() throws SQLException{
        connection.rollback();
    }
}
