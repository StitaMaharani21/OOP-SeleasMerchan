/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import dao.FullDAO;
import javax.swing.table.TableModel;
import model.Full;
import model.TabelFull;

/**
 *
 * @author HP
 */
public class FullControl {
    private FullDAO fDAO = new FullDAO();
    
    public void insertDataFull(Full f) {
        fDAO.makeConnection();
        fDAO.insert(f);
        fDAO.closeConnection();
    }
    
    public TableModel displayFull(){

       fDAO.makeConnection();
       TableModel tabelf = new TabelFull(fDAO.showFull());
       fDAO.closeConnection();
       return tabelf;
    }
    
    public String showDataFull() {
        fDAO.makeConnection();
        List<Full> FullData = fDAO.showFull();
        fDAO.closeConnection();
        
        String FullString="";
        for(int i=0 ; i<FullData.size() ; i++) {
            FullString = FullString + FullData.get(i).viewdata() + " \n ";
        }
        
        return FullString;
    }
    
    public Full searchFull(String noProduk) {
        Full f = null;
        fDAO.makeConnection();
        f = fDAO.searchFull(noProduk);
        fDAO.closeConnection();
        
        return f;
    }
    
    
    public void deleteDataFull(String noProduk) {
        fDAO.makeConnection();
        fDAO.deleteFull(noProduk);
        fDAO.closeConnection();
    }
}
