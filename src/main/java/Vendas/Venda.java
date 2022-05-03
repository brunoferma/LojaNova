package Vendas;

import java.sql.Connection;
import java.sql.SQLException;

public class Venda {
    public static void main(String[] args) throws SQLException {

        Connection conexao = GeradorConexao.getConexao();

        System.out.println("conexao efetuada com sucesso");

        conexao.close();
    }
}
