public class Punto {
    
    private String nombre;
    private double x;
    private double y;

    //Constructor
    public Punto(double x, double y) {
        this.nombre = "";
        this.x = x;
        this.y = y;
    }

    public Punto(double x, double y, String nombre) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }
    
    //Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre+"("+x+","+y+")";
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
