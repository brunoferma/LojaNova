package Vendas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoa2 {
    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        Connection conexao = GeradorConexao.getConexao();
        String sql = "SELECT * FROM clientes WHERE nome like ?";

        System.out.println("Informe o valor da pesquisa: ");
        String valor = entrada.nextLine();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,"%" + valor + "%");
        ResultSet resultado = stmt.executeQuery();
        List<Pessoa> pessoas = new ArrayList<>();

        while(resultado.next()){
            int codigo = resultado.getInt("Codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo,nome));
        }

        for (Pessoa p: pessoas){
            System.out.println(p.getCodigo() + " ==> " + p.getNome());
        }

        stmt.close();
        entrada.close();
    }
}
