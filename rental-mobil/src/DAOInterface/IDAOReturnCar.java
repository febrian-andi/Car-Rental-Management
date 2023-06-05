/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;

import Model.Car;
import Model.Customer;
import Model.ReturnCar;
import Model.RentCar;
import java.util.List;

/**
 *
 * @author user
 */
public interface IDAOReturnCar {

    //Read Return Car Data
    public List<ReturnCar> getAll();
    
    
    //Insert Return Car Data
    public boolean insertReturnCar(ReturnCar b);

    


}
