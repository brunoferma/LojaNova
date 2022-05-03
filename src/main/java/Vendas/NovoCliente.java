package Vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovoCliente {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        Connection conexao = GeradorConexao.getConexao();
        String sql = "INSERT INTO clientes (nome) VALUES (?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,nome);
        stmt.execute();
        System.out.println("Pessoa inclusa com sucesso");
        entrada.close();
    }
}
