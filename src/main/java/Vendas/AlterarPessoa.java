package Vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o codigo da pessoa: ");
        int codigo =  entrada.nextInt();

        String selectSql = "SELECT codigo, nome FROM clientes WHERE codigo = ? ";
        String updateSql = "UPDATE clientes SET nome = ? WHERE codigo = ?";

        Connection conexao = GeradorConexao.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(selectSql);
        stmt.setInt(1,codigo);
        ResultSet r = stmt.executeQuery();

        if(r.next()){
            Pessoa p = new Pessoa(r.getInt(1),r.getString(2));
            System.out.println("O nome atual é " + p.getNome());
            entrada.nextLine();

            System.out.println("Informe um novo nome: ");
            String novoNome = entrada.nextLine();

            stmt.close();
            stmt = conexao.prepareStatement(updateSql);
            stmt.setString(1,novoNome);
            stmt.setInt(2,codigo);
            stmt.execute();

            System.out.println(" Pessoa alterada com sucesso ");
        } else {
            System.out.println(" Pessoa nao encontrada no banco de dados ");

        }

        conexao.close();
        entrada.close();
    }
}
