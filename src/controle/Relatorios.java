package controle;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import visao.Principal;

public class Relatorios {

	private static InputStream path;

	public static void callRelatorio(String nameRel, String title, HashMap<String, Object> filtro) {

		try {
		
      
			Connection cn = Conexao.Connect.getConexao();
			path = Principal.class.getClassLoader().getResourceAsStream("visao/relatorio/" + nameRel + ".jasper");
			JasperPrint print = JasperFillManager.fillReport(path, filtro, cn);
                        
			JasperViewer viewr = new JasperViewer(print, false);
			viewr.setVisible(true);
			// viewr.setExtendedState(Frame.MAXIMIZED_BOTH);
			viewr.setTitle(title);

			try {
				cn.close();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex.getCause());
			}

		} catch (JRException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
