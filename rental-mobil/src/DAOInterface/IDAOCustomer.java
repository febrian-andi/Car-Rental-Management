/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Customer;
import Model.RentCar;
import java.util.List;

/**
 *
 * @author kumil
 */
public interface IDAOCustomer {
    public List<Customer> getAllCustomer();
            
    public boolean insert(Customer customer);  
    
    public void update(Customer customer);
    
    public void delete(int id);
    
    public void updateNamaCustomerRentCar(Customer customer, String namaCustomer);
    
    public void updateNamaCustomerReturnCar(Customer customer, String namaCustomer);
}
