package dao;

import factory.ConnectionFactory;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Cliente cliente){
        String sql = "INSERT INTO cliente(cli_nome) VALUES(?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            // String id_aux = Integer.toString(cliente.getId());
            stmt.setString(1, cliente.getNome());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
}
