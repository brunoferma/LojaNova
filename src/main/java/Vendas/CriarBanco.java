package Vendas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {

        Connection conexao = GeradorConexao.getConexao();
        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS vendas");
        System.out.println("banco criado com sucesso");
        conexao.close();
    }
}
