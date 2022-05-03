package Vendas;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GeradorConexao {
    public static Connection getConexao() {

        try {
            Properties prop = getProperties();
              final String url = prop.getProperty("banco.url");
              final String user = prop.getProperty("banco.usuario");
              final String senha = prop.getProperty("banco.senha");

            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/conexao.properties");
        prop.load(fis);
        return prop;
    }
}
