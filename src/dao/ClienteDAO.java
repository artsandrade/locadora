/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;

/**
 *
 * @author arthu
 */
public class ClienteDAO {
    PreparedStatement pst;
    String sql;
    
    public void salvar(Cliente cliente) throws SQLException{
        
        sql = "insert into cliente values (?, ?, ?, ?)";
        pst = Conexao.getinstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, cliente.getNomeCliente());
        pst.setString(3, cliente.getEnderecoCliente());
        pst.setString(4, cliente.getBairroCliente());
        pst.execute();
        pst.close();
    }
    
    public Cliente buscaClienteCodigo(String codigo) throws SQLException{
        sql = "select * from cliente where codigo = " + codigo;
        pst = Conexao.getinstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Cliente cli = null;
        while(rs.next()){
             cli = new Cliente(rs.getInt("codigo"), rs.getString("nome"), rs.getString("endereco"), rs.getString("bairro"));
        }
        pst.close();
        return cli;
    }
    
    public void excluir (Cliente cliente) throws SQLException{
        sql = "delete from cliente where codigo=?";
        pst = Conexao.getinstance().prepareStatement(sql);
        pst.setInt(1, cliente.getCodigoCliente());
        pst.execute();
        pst.close();
    }
    
    public void alterar (Cliente cliente) throws SQLException{
        sql = "update cliente set nome=?, endereco=?, bairro=? where codigo=?";
        pst = Conexao.getinstance().prepareStatement(sql);
        pst.setString(1, cliente.getNomeCliente());
        pst.setString(2, cliente.getEnderecoCliente());
        pst.setString(3, cliente.getBairroCliente());
        pst.setInt(4, cliente.getCodigoCliente());
        pst.execute();
        pst.close();
    }
}
