/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import model.Deposit;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class DepositDAO {
    public static Connection CON;
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "C:\\Users\\HP\\Documents\\NetBeansProjects\\TubesOOP\\DatabaseBarang - Copy.mdb";
    
    public void makeConnection(){
        System.out.println("Opening database ... ");
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            CON = DriverManager.getConnection(url+path);
            System.out.println("Success");
        }catch(Exception e){
            System.out.println("Error opening database");
            System.out.println(e);
        }
    }
    
    public void closeConnection(){
        System.out.println("Closing database ... ");
        try{
            CON.close();
            System.out.println("Success");
        }catch(Exception e){
            System.out.println("Error opening database");
            System.out.println(e);
        }
    }
    
    public void insert(Deposit d) {
        String sql = "insert into Deposit(noProduk, namaProduk, hargaSatuan, jumlahProduk, totalHarga) values ('"
                +d.getnoProduk()+"','"
                +d.getnamaProduk()+"','"
                +d.gethargaSatuan()+"','"
                +d.getjumlahProduk()+"','"
                +d.gettotal()+"')";
        
        System.out.println("Adding Data...");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added" +result +"Deposit Payment \n");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding deposit payment...");
            System.out.println(e);
        }
    }
    
    public List<Deposit> showDeposit() {
        String sql = "select * from Deposit";
        System.out.println("Mengambil data...");
        
        List<Deposit> list = new ArrayList<>();
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null) {
                while(rs.next()) {
                    Deposit d = new Deposit(rs.getString("noProduk")
                            ,rs.getString("namaProduk")
                            ,Integer.parseInt(rs.getString("hargaSatuan"))
                            ,Integer.parseInt(rs.getString("jumlahProduk"))
                            ,Integer.parseInt(rs.getString("totalHarga")));
                    list.add(d);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        return list;
    }
    
    public Deposit searchDeposit(String noProduk) {
        String sql = "select * from Deposit where noProduk = '" +noProduk +"'";
        System.out.println("Searching data...");
        
        Deposit d = null;
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null) {
                while(rs.next()) {
                    d = new Deposit(rs.getString("noProduk")
                            ,rs.getString("namaProduk")
                            ,Integer.parseInt(rs.getString("hargaSatuan"))
                            ,Integer.parseInt(rs.getString("jumlahProduk"))
                            ,Integer.parseInt(rs.getString("totalHarga")));
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        
        return d;
    }
    
     
    
    public void deleteDeposit(String noProduk) {
        String sql = "delete from Deposit where noProduk = '" +noProduk +"'";
        System.out.println("Deleting data...");
        
        try{
            Statement s = CON.createStatement();
            int result = s.executeUpdate(sql);
            System.out.println("Delete" +result +"Data \n");
            s.close();
        } catch(Exception e) {
            System.out.println("Error deleting data...");
            System.out.println(e);
        }
    }
    
}
