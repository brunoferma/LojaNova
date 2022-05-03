package Vendas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
    public static void main(String[] args) throws SQLException {
        Connection conexao = GeradorConexao.getConexao();
        String sql = "CREATE TABLE clientes ("
                +"codigo INT AUTO_INCREMENT PRIMARY KEY,"
                +"nome VARCHAR(80) NOT NULL"
                +")";
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        System.out.println("Tabela criada com sucesso");
        conexao.close();
    }
}
