/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class TabelDeposit extends AbstractTableModel {
    private List<Deposit> list;
    
    public TabelDeposit(List<Deposit> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 5;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex) {
            case 0 : list.get(rowIndex).getnoProduk();
            case 1 : list.get(rowIndex).getnamaProduk();
            case 2 : list.get(rowIndex).gethargaSatuan();
            case 3 : list.get(rowIndex).getjumlahProduk();
            case 4 : list.get(rowIndex).gettotal();
            default : return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 : return "Nomor Produk";
            case 1 : return "Nama Produk";
            case 2 : return "Harga Satuan";
            case 3 : return "Jumlah Produk";
            case 4 : return "Total Harga";
            default : return null;
        }
    }

   

}
