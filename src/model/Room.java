
package model;


public class Room {

    private int id;
    private int nHabitacion;
    private int simple;
    private int doble;
    private double precio;

    public Room() {
    }
    
     public Room(int id, int nHabitacion, int simple, int doble, double precio) {
         this.id = id;
        this.nHabitacion = nHabitacion;
        this.simple = simple;
        this.doble = doble;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getnHabitacion() {
        return nHabitacion;
    }

    public void setnHabitacion(int nHabitacion) {
        this.nHabitacion = nHabitacion;
    }

    public int getSimple() {
        return simple;
    }

    public void setSimple(int simple) {
        this.simple = simple;
    }

    public int getDoble() {
        return doble;
    }

    public void setDoble(int doble) {
        this.doble = doble;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + "nHabitacion=" + nHabitacion + ", simple=" + simple + ", doble=" + doble + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.nHabitacion;
        hash = 71 * hash + this.simple;
        hash = 71 * hash + this.doble;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
         if (this.id != other.id) {
            return false;
        }
        if (this.nHabitacion != other.nHabitacion) {
            return false;
        }
        if (this.simple != other.simple) {
            return false;
        }
        if (this.doble != other.doble) {
            return false;
        }
        return Double.doubleToLongBits(this.precio) == Double.doubleToLongBits(other.precio);
    }
     
}
