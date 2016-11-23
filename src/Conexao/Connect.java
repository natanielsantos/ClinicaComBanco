package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import javax.swing.JOptionPane;

public class Connect {
	
    public static Connection getConexao() {

        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            Properties props = new Properties();
            props.put("user", "postgres");
            props.put("password", "postgres");
            props.put("charset", "UTF8");
            props.put("lc_ctype", "ISO8859_1");
//            System.err.println("Conectado com sucesso...");
//            return DriverManager.getConnection("jdbc:firebirdsql://192.168.4.103:3050/c:/acaosocial.fdb", props);
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica", props);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }
        return null;
    }


}
