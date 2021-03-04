/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
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
}
