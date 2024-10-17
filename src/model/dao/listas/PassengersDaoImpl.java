
package model.dao.listas;

import model.dao.PassengerDao;
import java.util.ArrayList;
import java.util.List;
import model.Passengers;

 public class PassengersDaoImpl implements PassengerDao {
    private static PassengersDaoImpl instance;
    private static long nextId;
    private List<Passengers> data;
   
    private PassengersDaoImpl() {
        this.data = new ArrayList();
        nextId = 1;
    }

    @Override
    public void save(Passengers t) {
        data.add(t);
    }

    @Override
    public Passengers getById(long id) {
          for (Passengers passenger : data) {
            if (passenger.getNPasajero()== id) {
                return passenger;
            }
        }
        return null;

    }

    @Override
    public List<Passengers> getAll() {
          return data;
}
    

    @Override
    public void update(Passengers t) {
         for (int i = 0; i <data.size(); i++) {
        if (data.get(i).getNPasajero()== t.getNPasajero()) {// Actualizar los datos del pasajero en la posición encontrada
            data.get(i).setNombre(t.getNombre());
            data.get(i).setApellido(t.getApellido());
            data.get(i).setTelefono(t.getTelefono());
            data.get(i).setFechaNacimiento(t.getFechaNacimiento());
            data.get(i).setDni(t.getDni());
           data.get(i).setMail(t.getMail());
            break;
        }
         }
    }
    

    @Override
    public void delete(Passengers t) {
        for (int i = 0; i < data.size(); i++) {
        if (data.get(i).getNPasajero()== t.getNPasajero()) {
            data.remove(i);
            break; 
        }
        }
    }
    
 public static PassengerDao getInstance() {
        if (PassengersDaoImpl.instance == null) {
            PassengersDaoImpl.instance = new PassengersDaoImpl();
        }
        
        return PassengersDaoImpl.instance;
    }
}
