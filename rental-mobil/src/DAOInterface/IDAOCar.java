/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Car;
import java.util.List;

/**
 *
 * @author user
 */
public interface IDAOCar {
    // Read Data
    public List<Car> getAllCar();
    
    // Insert Data
    public boolean insert(Car b);
    
    //Update Data
    public void update(Car b);
    
    //Delete Data
    public void delete(String platNomor);
}
