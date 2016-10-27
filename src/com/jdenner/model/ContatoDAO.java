package com.jdenner.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Juliano
 */
public class ContatoDAO {

    public static void inserir(Contato contato) throws ClassNotFoundException, SQLException {
        String sql = "insert into tb_contato (nome, telefone) values (?,?)";
        Conexao con = new Conexao();
        PreparedStatement ps = con.getConexao().prepareStatement(sql);
        ps.setString(1, contato.getNome());
        ps.setString(2, contato.getTelefone());
        ps.execute();
        con.confirmar();
    }

    public static ObservableList<Contato> listar() throws ClassNotFoundException, SQLException {
        String sql = "select * from tb_contato order by nome asc";
        Conexao con = new Conexao();
        PreparedStatement ps = con.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ObservableList<Contato> lista = FXCollections.observableArrayList();
        while (rs.next()) {
            Contato contato = new Contato();
            contato.setCodigo(rs.getInt("codigo"));
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            lista.add(contato);
        }
        return lista;
    }
}
