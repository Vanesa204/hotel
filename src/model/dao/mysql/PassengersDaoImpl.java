package model.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;


import java.util.List;
import model.Passengers;
import model.dao.PassengerDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PassengersDaoImpl implements PassengerDao {

    @Override
    public void save(Passengers p) {

        Connection cn = null;
        PreparedStatement pst = null; // ayuda a proteger contra ataques de inyección SQL al utilizar parámetros que se establecen de forma separada de la consulta SQL
        ResultSet rs = null; //almacenar y manipular datos bd epresenta un conjunto de filas devueltas por la base de datos después de ejecutar una consulta SELECT.
        Statement stmt=null;
        String url = "jdbc:mysql://localhost:3306/hotel"; //root:vanesa@
        String user = "root";
        String password = "vanesa";
        String sqlInsert = "INSERT INTO passenger(dni, FechaNacimiento, nombre, apellido, telefono, email) VALUES(?,?,?,?,?,?);";
        String sqlSelect = "SELECT id, dni, FechaNacimiento,nombre, apellido, telefono,email FROM passenger;";
        try {
             // Registrar el driver JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");
              
            cn = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado y cargar");
            
            LocalDate localDate = p.getFechaNacimiento();
            if (localDate == null) {
            throw new IllegalArgumentException("Fecha de nacimiento no puede ser null");
        }
            Date sqlDate = Date.valueOf(localDate);
            
            pst = cn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, p.getDni());
            pst.setDate(2, sqlDate);
            pst.setString(3, p.getNombre());
            pst.setString(4, p.getApellido());
            pst.setString(5, p.getTelefono());
            pst.setString(6, p.getMail());
            
            pst.execute();
            rs=pst.getGeneratedKeys();
            
            if (rs.next()){
                p.setNPasajero(rs.getInt(1));
                //NPasajero.setText(String.valueOf(p.getNPasajero()));
            }
            stmt = cn.createStatement();
            rs = stmt.executeQuery(sqlSelect);
           
            
            while(rs.next()){
               
                p = new Passengers();
                p.setNPasajero(rs.getInt("id"));
                p.setDni(rs.getString("dni"));
                 p.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTelefono(rs.getString("telefono"));
                p.setMail(rs.getString("email"));
                                      
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PassengersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public Passengers getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Passengers> getAll() {
        
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Passengers> passengers = new ArrayList<>();
       // Statement stmt=null;
        String url = "jdbc:mysql://localhost:3306/hotel"; //root:vanesa@
        String user = "root";
        String password = "vanesa";
         String sqlSelect = "SELECT * FROM passenger";
       
     
        try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              cn = DriverManager.getConnection(url, user, password);
              System.out.println(" Lista Actualizada");
             pst = cn.prepareStatement(sqlSelect);//("SELECT * FROM passenger");
             rs = pst.executeQuery();
            while (rs.next()) {
                Passengers p = new Passengers();
                p.setNPasajero(rs.getInt("id"));
                p.setDni(rs.getString("dni"));
                p.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTelefono(rs.getString("telefono"));
                p.setMail(rs.getString("email"));
               // p.setHabitacion(rs.getString("habitacion"));
                passengers.add(p);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return passengers;
    }  
    

    @Override
    public void update(Passengers p) {
       Connection cn = null;
        PreparedStatement pst = null;
         
        String url = "jdbc:mysql://localhost:3306/hotel"; //root:vanesa@
        String user = "root";
        String password = "vanesa";
         String  sqlUpdate  = "UPDATE passenger SET dni = ?, FechaNacimiento = ?, nombre = ?, apellido = ?, telefono = ?, email = ? WHERE id = ?";
//hay que cargar habitacion en la linea de arriba       
    
        try {
          
              Class.forName("com.mysql.cj.jdbc.Driver");
              cn = DriverManager.getConnection(url, user, password);
              System.out.println(" modificar pasajeros");
              LocalDate localDate = p.getFechaNacimiento();
             Date sqlDate = Date.valueOf(localDate);
             pst = cn.prepareStatement(sqlUpdate);
         // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //String formattedDate = p.getFechaNacimiento().format(formatter);     
        pst.setString(1, p.getDni());
        pst.setDate(2, sqlDate);
        pst.setString(3, p.getNombre());
        pst.setString(4, p.getApellido());
        pst.setString(5, p.getTelefono());
        pst.setString(6, p.getMail());
        //pst.setString(7, p.getHabitacion());
        pst.setInt(7, p.getNPasajero());
        pst.executeUpdate();
              
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
       
      }


    @Override
    public void delete(Passengers p) {
        Connection cn = null;
        PreparedStatement pst = null;
         
        String url = "jdbc:mysql://localhost:3306/hotel"; //root:vanesa@
        String user = "root";
        String password = "vanesa";
        String sqlDelete = "DELETE FROM passenger WHERE id = ?";
        
    try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         cn = DriverManager.getConnection(url, user, password);
         System.out.println("Conexión exitosa");
         
          pst = cn.prepareStatement(sqlDelete);
          
          
           pst.setInt(1,p.getNPasajero());
        int rowsAffected = pst.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Pasajero eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún pasajero con el ID proporcionado.");
        }
          
          
          
          
        
    }   catch (ClassNotFoundException ex) { 
            Logger.getLogger(PassengersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PassengersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
