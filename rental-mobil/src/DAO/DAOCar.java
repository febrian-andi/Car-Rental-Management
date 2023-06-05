/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.KoneksiDatabase;
import Model.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DAOInterface.IDAOCar;

public class DAOCar implements IDAOCar {
    public DAOCar(){
        con = KoneksiDatabase.getConnection();
    }
    
    Connection con;
    //SQL Query
    String strRead = "SELECT * FROM tbl_mobil;";        
    String strInsert = "INSERT INTO tbl_mobil (plat_nomor,merek,status,harga) VALUES (?,?,?,?);";
    String strUpdate = "UPDATE tbl_mobil SET merek=?, status=?, harga=? WHERE plat_nomor=?";
    String strDelete = "DELETE FROM tbl_mobil WHERE plat_nomor=?;";
    
    @Override
    public List<Car> getAllCar() {
        List<Car> listCar = null;
        try
        {
            listCar = new ArrayList<Car>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            
            while(rs.next()){
                Car car = new Car();
                car.setPlatNomor(rs.getString("plat_nomor"));
                car.setMerek(rs.getString("merek"));
                car.setStatus(rs.getString("status"));
                car.setHarga(rs.getInt("harga"));
                listCar.add(car);
            }
        }
        catch(SQLException e){
            System.out.println("error " + e);
        }
        return listCar;
    }    

    @Override
    public boolean insert(Car b) {
        boolean result = true;
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strInsert);
            statement.setString(1, b.getPlatNomor());
            statement.setString(2, b.getMerek());
            statement.setString(3, b.getStatus());
            statement.setInt(4, b.getHarga());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println(e);      
            result = false;
        }
        finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                System.out.println(e);
                result = false;
            }
        }
        return result;        
    }

    @Override
    public void update(Car b) {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, b.getMerek());
            statement.setString(2, b.getStatus());
            statement.setInt(3, b.getHarga());
            statement.setString(4, b.getPlatNomor());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println(e);        
        }
        finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }        
    }

    @Override
    public void delete(String platNomor) {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strDelete);
            statement.setString(1, platNomor);
            statement.execute();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }
    }
}
