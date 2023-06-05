/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
/**
 *
 * @author Asus
 */
public class ReturnCar {

    /**
     * @return the total_bayar
     */
    public Integer getTotal_bayar() {
        return total_bayar;
    }

    /**
     * @param total_bayar the total_bayar to set
     */
    public void setTotal_bayar(Integer total_bayar) {
        this.total_bayar = total_bayar;
    }

    /**
     * @return the idPengembalian
     */
    public Integer getIdPengembalian() {
        return idPengembalian;
    }

    /**
     * @param idPengembalian the idPengembalian to set
     */
    public void setIdPengembalian(Integer idPengembalian) {
        this.idPengembalian = idPengembalian;
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
     * @return the delay
     */
    public Integer getDelay() {
        return delay;
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    /**
     * @return the denda
     */
    public Integer getDenda() {
        return denda;
    }

    /**
     * @param denda the denda to set
     */
    public void setDenda(Integer denda) {
        this.denda = denda;
    }
    private Integer idPengembalian;
    private String platNomor;
    private String namaCustomer;
    private Date tglPengembalian;
    private Integer delay;
    private Integer denda;
    private Integer total_bayar;
    
    
}
