/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public abstract class Produk {
    protected String noProduk;
    protected String namaProduk;
    protected int hargaSatuan;
    protected int jumlahProduk;
    
    public Produk (String noProduk, String namaProduk, int hargaSatuan, int jumlahProduk){
        this.noProduk = noProduk;
        this.namaProduk = namaProduk;
        this.hargaSatuan = hargaSatuan;
        this.jumlahProduk = jumlahProduk;
    }
    
    public String getnoProduk(){
        return noProduk;
    }
    
    public String getnamaProduk(){
        return namaProduk;
    }
    
    public int gethargaSatuan(){
        return hargaSatuan;
    }
    
    public int getjumlahProduk(){
        return jumlahProduk;
    }
    
    public void setnoProduk(String noProduk){
        this.noProduk = noProduk;
    }
    
    public void setnamaProduk(String namaProduk){
        this.namaProduk = namaProduk;
    }
    
    public void sethargaSatuan(int hargaSatuan){
        this.hargaSatuan = hargaSatuan;
    }
    
    public void setjumlahProduk(int jumlahProduk){
        this.jumlahProduk = jumlahProduk;
    }
    
    public abstract String viewdata();
    public abstract int hitungTotal();
    
}
