
package model.dao.listas;

import java.util.ArrayList;
import java.util.List;
import model.Room;
import model.dao.RoomDao;

public class RoomDaoImpl implements RoomDao {
    private static RoomDaoImpl instance;
    private static long nextId;
    private List<Room> data;
    
      
    private RoomDaoImpl() {
        this.data = new ArrayList();
        nextId = 1;
    } 
    @Override
    public void save(Room t) {
           data.add(t);
    }

    @Override
    public Room getById(long id) {
         for (Room r : data) {
            if (r.getId()== id) {
                return r;
            }
        }
        return null;

    }

    @Override
    public List<Room> getAll() {
        return data;
    }

    @Override
    public void update(Room t) {
       for (int i = 0; i <data.size(); i++) {
        if (data.get(i).getId()== t.getId()) {
            // Actualizar los datos de la habitacion en la posición encontrada
            data.get(i).setnHabitacion(t.getnHabitacion());
            data.get(i).setSimple(t.getSimple());
             data.get(i).setDoble(t.getDoble());
            data.get(i).setPrecio(t.getPrecio());
             break;
            
    }
           }  
    }

    @Override
    public void delete(Room t) {
          for (int i = 0; i < data.size(); i++) {
        if (data.get(i).getId()== t.getId()) {
            data.remove(i);
            break; 
        }
    }
    
}
     public static RoomDaoImpl getInstance() {
        if (RoomDaoImpl.instance == null) {
            RoomDaoImpl.instance = new RoomDaoImpl();
        }
        
        return RoomDaoImpl.instance;
    }
}
