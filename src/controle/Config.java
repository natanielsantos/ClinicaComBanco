/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import visao.cliente.TelaCliente;

/**
 *
 * @author nataniel
 */
public class Config {

    public Config() {
    }
    
    // Método para converter Date para String
    public Date formataData(String data) { 
		if (data == null || data.equals(""))
			return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date)formatter.parse(data);
        } catch (ParseException e) {            
            JOptionPane.showMessageDialog(null, "Erro ao converter a data");
        }
         return date;
    }
    
    public boolean atualiza(boolean b){
        boolean bb = false;
        
        if(b){
            bb = true;
        }
        
        return bb;
        
    }
    
}
