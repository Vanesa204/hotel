
package model.dao.mysql;

import java.util.List;
import model.Room;
import model.dao.RoomDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RoomDaoImpl implements RoomDao {

   public boolean existsByRoomNumber(int roomNumber) {
    Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/hotel";
    String user = "root";
    String password = "vanesa";
    String sqlCheck = "SELECT COUNT(*) FROM room WHERE nHabitacion = ?";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn = DriverManager.getConnection(url, user, password);
        pst = cn.prepareStatement(sqlCheck);
        pst.setInt(1, roomNumber);
        rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) > 0; // Si el recuento es mayor que 0, la habitación ya existe
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
} 
    @Override
    public void save(Room r) {
   
        Connection cn = null;
        PreparedStatement pst = null; // ayuda a proteger contra ataques de inyección SQL al utilizar parámetros que se establecen de forma separada de la consulta SQL
        ResultSet rs = null; //almacenar y manipular datos bd epresenta un conjunto de filas devueltas por la base de datos después de ejecutar una consulta SELECT.
        Statement stmt=null;
        String url = "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root";
        String password = "vanesa";
        String sqlInsert = "INSERT INTO room (nHabitacion, camaSimple, camaDoble, precio) VALUES(?,?,?,?);";
        String sqlSelect = "SELECT id, nHabitacion, camaSimple, camaDoble, precio FROM room;";
        

        try {
             // Registrar el driver JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");
              
            cn = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado y cargar");
                        
            pst = cn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            
            pst.setInt(1, r.getnHabitacion());
            pst.setInt(2, r.getSimple());
            pst.setInt(3, r.getDoble());
            pst.setDouble(4, r.getPrecio());
        
            
            pst.execute();
            rs=pst.getGeneratedKeys();
            
            if (rs.next()){
                r.setId(rs.getInt(1));
               
            }
            stmt = cn.createStatement();
            rs = stmt.executeQuery(sqlSelect);
           
            
            while(rs.next()){
               
                r = new Room();
                r.setnHabitacion(rs.getInt("nHabitacion"));
                r.setSimple(rs.getInt("camaSimple"));
                r.setDoble(rs.getInt("camaDoble"));
                r.setPrecio(rs.getDouble("precio"));
                                      
            }
            
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RoomDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (pst != null) pst.close();
            if (cn != null) cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }  
    

    @Override
    public Room getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Room> getAll() {
        Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<Room> room = new ArrayList<>();
    String url = "jdbc:mysql://localhost:3306/hotel";
    String user = "root";
    String password = "vanesa";
    String sqlSelect = "SELECT * FROM room";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn = DriverManager.getConnection(url, user, password);
        pst = cn.prepareStatement(sqlSelect);
        rs = pst.executeQuery();

        while (rs.next()) {
            Room r = new Room();
            r.setId(rs.getInt("id"));
            r.setnHabitacion(rs.getInt("nHabitacion"));
            r.setSimple(rs.getInt("camaSimple"));
            r.setDoble(rs.getInt("camaDoble"));
            r.setPrecio(rs.getDouble("precio"));
            room.add(r);
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return room;
}
    

    @Override
    public void update(Room r) {
        Connection cn = null;
        PreparedStatement pst = null; // ayuda a proteger contra ataques de inyección SQL al utilizar parámetros que se establecen de forma separada de la consulta SQL
        //ResultSet rs = null; //almacenar y manipular datos bd epresenta un conjunto de filas devueltas por la base de datos después de ejecutar una consulta SELECT.
        //Statement stmt=null;
        String url = "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root";
        String password = "vanesa";
        String sqlUpdate = "UPDATE room SET nHabitacion = ?, camaSimple = ?, camaDoble = ?, precio = ? WHERE id = ?";
      try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
            
           pst = cn.prepareStatement(sqlUpdate);//, Statement.RETURN_GENERATED_KEYS
            pst.setInt(1, r.getnHabitacion());
            pst.setInt(2, r.getSimple());
            pst.setInt(3, r.getDoble());
            pst.setDouble(4,r.getPrecio());
            pst.setInt(5, r.getId());
             // rs = pst.getGeneratedKeys();
            //if(rs.next()){
            //    r.setId(rs.getInt(1));
                
                
            
            //pst = (PreparedStatement) cn.createStatement();
            pst.executeUpdate();
            
            
            } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
   
    
}
    @Override
    public void delete(Room t) {
        Connection cn = null;
        PreparedStatement pst = null; // ayuda a proteger contra ataques de inyección SQL al utilizar parámetros que se establecen de forma separada de la consulta SQL
        String url = "jdbc:mysql://localhost:3306/hotel"; 
        String user = "root";
        String password = "vanesa";
        String sqlDelete = "DELETE FROM room WHERE id = ?";
        
        try {
            
         Class.forName("com.mysql.cj.jdbc.Driver");
         cn = DriverManager.getConnection(url, user, password);
         System.out.println("Conexión exitosa");
         
            pst = cn.prepareStatement(sqlDelete);
            pst.setInt(1, t.getId()); //agregue 
              
         int rowsAffected = pst.executeUpdate(); 
         
         if (rowsAffected > 0) {
            System.out.println("Habitación eliminada exitosamente.");
        } else {
            System.out.println("No se encontró ninguna habitación con el ID proporcionado.");
        }      
          
        
        
        }  catch (ClassNotFoundException ex) { 
            Logger.getLogger(RoomDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        
         
        
        } catch (SQLException ex) {
            Logger.getLogger(RoomDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
