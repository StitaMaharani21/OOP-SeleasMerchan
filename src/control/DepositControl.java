/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import dao.DepositDAO;
import javax.swing.table.TableModel;
import model.Deposit;
import model.TabelDeposit;

/**
 *
 * @author HP
 */
public class DepositControl {
    private DepositDAO dDAO = new DepositDAO();
    
    public void insertDataDeposit(Deposit d) {
        dDAO.makeConnection();
        dDAO.insert(d);
        dDAO.closeConnection();
    }
    
    public TableModel displayDeposit()
    {

       dDAO.makeConnection();
       TableModel tabeld = new TabelDeposit(dDAO.showDeposit());
       dDAO.closeConnection();
       return tabeld;
    }
    
    public String showDataDeposit() {
        dDAO.makeConnection();
        List<Deposit> DepositData = dDAO.showDeposit();
        dDAO.closeConnection();
        
        String DepositString="";
        for(int i=0 ; i<DepositData.size() ; i++) {
            DepositString = DepositString + DepositData.get(i).viewdata() + " \n ";
        }
        
        return DepositString;
    }
    
    public Deposit searchDeposit(String noProduk) {
        Deposit d = null;
        dDAO.makeConnection();
        d = dDAO.searchDeposit(noProduk);
        dDAO.closeConnection();
        
        return d;
    }
    
   
    
    public void deleteDataDeposit(String noProduk) {
        dDAO.makeConnection();
        dDAO.deleteDeposit(noProduk);
        dDAO.closeConnection();
    }
}
