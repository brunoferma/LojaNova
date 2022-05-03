package Vendas;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {

    private Connection conexao;

    private Connection getConexao(){
        try {
            if(conexao !=null && !conexao.isClosed()){
                return conexao;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexao = GeradorConexao.getConexao();
        return conexao;
    }
}
