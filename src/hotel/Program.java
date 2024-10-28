
package hotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import model.Passengers;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import model.Room;
import model.dao.mysql.PassengersDaoImpl;


public class Program {

  
    public static void main(String[] args) {
        Passengers p = new Passengers();
      
        Connection cn = null;
     
        // PreparedStatement pst = null;
       //  ResultSet rs = null;
     String url ="jdbc:mysql://localhost:3306/hotel"; //root:vanesa@
         String user = "root";
        String password = "vanesa";
    // String sqlInsert = "Insert into passengers(dni, fechaNacimiento,nombre, apellido, telefono,mail) VALUES(?,?,?,?,?,?);";
        
   try {
            cn = DriverManager.getConnection(url, user, password);
            
            System.out.println("Conectado");
            
           
            
                    
                
         /*System.out.println("Insertar pasajero");
          System.out.println(p);
            
            pst= cn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, p.getDni());
            LocalDate localDate = p.getFechaNacimiento();
            Date sqlDate = Date.valueOf(localDate);
            pst.setDate(2, sqlDate);
            //pst.setDate(2, p.getFechaNacimiento());
            pst.setString(3, p.getNombre());
            pst.setString(4, p.getApellido());
            pst.setString(5, p.getTelefono());
            pst.setString(6, p.getMail());
            pst.execute();
            
            if (rs.next()){
            
            }
             System.out.println("p");*/
             
        } catch (SQLException ex) {
     
            System.out.println("Bienvenido al Hotel Girls!");
       }finally{
            cn = null;
        
    } 
   
   view.ProgramaHotel hForm = new view.ProgramaHotel();
     hForm.setVisible(true); 
      
 
    }
     
}
