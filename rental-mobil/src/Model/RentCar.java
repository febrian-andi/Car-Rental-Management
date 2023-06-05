/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author user
 */
public class RentCar {

    /**
     * @return the namaCustomer
     */
    public String getNamaCustomer() {
        return namaCustomer;
    }

    /**
     * @param namaCustomer the namaCustomer to set
     */
    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    /**
     * @return the idPeminjaman
     */
    public Integer getIdPeminjaman() {
        return idPeminjaman;
    }

    /**
     * @param idPeminjaman the idPeminjaman to set
     */
    public void setIdPeminjaman(Integer idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    /**
     * @return the platNomor
     */
    public String getPlatNomor() {
        return platNomor;
    }

    /**
     * @param platNomor the platNomor to set
     */
    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    /**
     * @return the tglPeminjaman
     */
    public Date getTglPeminjaman() {
        return tglPeminjaman;
    }

    /**
     * @param tglPeminjaman the tglPeminjaman to set
     */
    public void setTglPeminjaman(Date tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }

    /**
     * @return the tglPengembalian
     */
    public Date getTglPengembalian() {
        return tglPengembalian;
    }

    /**
     * @param tglPengembalian the tglPengembalian to set
     */
    public void setTglPengembalian(Date tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }

    /**
     * @return the totalHarga
     */
    public Integer getTotalHarga() {
        return totalHarga;
    }

    /**
     * @param totalHarga the totalHarga to set
     */
    public void setTotalHarga(Integer totalHarga) {
        this.totalHarga = totalHarga;
    }
    private Integer idPeminjaman;
    private String platNomor;
    private String namaCustomer;
    private Date tglPeminjaman;
    private Date tglPengembalian;
    private Integer totalHarga;
}
