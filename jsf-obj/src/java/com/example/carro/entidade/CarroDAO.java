/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carro.entidade;

import com.example.carro.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bielm
 */
public class CarroDAO {
    public void salvar(Carro carro){
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareCall("INSERT INTO `system-car`.`carro`(`modelo`,`fabricante`,`cor`,`ano`)VALUES(?,?,?,?);");
            ps.setString(1,carro.getModelo());
            ps.setString(2,carro.getFabricante());
            ps.setString(3,carro.getCor());
            ps.setDate(4, new Date(carro.getAno().getTime()));
            ps.executeQuery();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
