/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kumil
 */
public class Customer {

    /**
     * @return the id_customer
     */
    public Integer getId_customer() {
        return id_customer;
    }

    /**
     * @param id_customer the id_customer to set
     */
    public void setId_customer(Integer id_customer) {
        this.id_customer = id_customer;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the no_telpon
     */
    public String getNo_telpon() {
        return no_telpon;
    }

    /**
     * @param no_telpon the no_telpon to set
     */
    public void setNo_telpon(String no_telpon) {
        this.no_telpon = no_telpon;
    }
    private Integer id_customer;
    private String nama;
    private String alamat;
    private String no_telpon;
}
