/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Car;
import Model.RentCar;
import java.util.List;

/**
 *
 * @author user
 */
public interface IDAORentCar {
    //Read Car Data Only Available
    public List<Car> getAllCarAvailable();
    

    // Read Rent Car Data
    public List<RentCar> getAllRentCarData();
    
    //Insert Rent Car Data
    public boolean insertRentCar(RentCar b);
    
    //Update Car Status
    public void updateStatusMobilBooked(Car b);
    public void updateStatusMobilAvailable(Car b);
    
    //Update Rent Car Data
    public void updateRentCar(RentCar b);
    
    //Delete Rent Car Data
    public void deleteRentCar(Integer id_peminjaman);

}
