
package servicios;

import model.dao.PassengerDao;
import java.util.List;
import model.Passengers;


public class PassengersService {
     private static PassengersService instance = null;
    private PassengerDao dao;

public static PassengersService getInstance() {
        if ( PassengersService.instance == null ) {
            PassengersService.instance = new PassengersService();
        }
        
        return PassengersService.instance;
    }

public void createPassengers(Passengers p) {
        this.dao.save(p);

}

public List<Passengers> listPassengers() {
        return this.dao.getAll();
    }
    
}
