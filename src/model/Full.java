/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Full extends Produk{
    private int totalHarga;
    
    public Full (String noProduk, String namaProduk, int hargaSatuan, int jumlahProduk, int totalHarga){
        super(noProduk, namaProduk, hargaSatuan, jumlahProduk);
        this.totalHarga = totalHarga;
    }
    
    public int gettotal(){
        return totalHarga;
    }
    
    public void settotal(int totalHarga){
        this.totalHarga = totalHarga;
    }
    
    @Override
    public int hitungTotal(){
        totalHarga = jumlahProduk*hargaSatuan;
        return totalHarga;
    }
    
    @Override
    public String viewdata(){
        return "Nomor Produk : " + noProduk
                +", Nama Produk : " + namaProduk
                +", Harga Satuan : Rp. " + hargaSatuan
                +", Jumlah Produk : " + jumlahProduk
                +", Total : Rp. " + totalHarga;
    }
    
}
