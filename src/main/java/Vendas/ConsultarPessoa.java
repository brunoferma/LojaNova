package Vendas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoa {
    public static void main(String[] args) throws SQLException {
        Connection conexao = GeradorConexao.getConexao();
        String sql = "SELECT * FROM clientes";

        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        List<Pessoa> pessoas = new ArrayList<>();

        while(resultado.next()){
            int codigo = resultado.getInt("Codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo,nome));
        }

        for (Pessoa p: pessoas){
            System.out.println(p.getCodigo() + "==>" + p.getNome());
        }


        stmt.close();
    }
}
