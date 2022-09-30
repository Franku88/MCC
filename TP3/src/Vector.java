public class Vector {
    
    private String nombre;
    private double a;
    private double b;

    //Constructor
    public Vector(double a, double b) {
        this.nombre = "";
        this.a = a;
        this.b = b;
    }

    public Vector(double a, double b, String nombre) {
        this.nombre = nombre;
        this.a = a;
        this.b = b;
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String toString() {
        return nombre+"("+a+","+b+")";
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    //Del tipo
    /**
     * Modulo que calcula la norma del vector v=(a,b)
     * @return norma
     */
    public double norma() {
        double norma;
        norma = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        return norma;
    }
    
    /**
     * Modulo que retorna verdadero si la norma de un vector v=(a,b) es igual a 1
     * @return
     */
    public boolean verifica_unitario() {
        boolean es_unitario;
        double norma;

        //Calculo de norma
        norma = norma();
        //Verifica que sea igual a 1
        es_unitario = norma == 1;
        return es_unitario;
    }

    /**
     * Modulo que retorna un vector unitario con la direccion del objeto
     * @return unitario
     */
    public Vector generar_unitario() {
        Vector unitario;
        double norma = norma();

        unitario = new Vector(a/norma,b/norma,nombre+"'");
        return unitario;
    }

    /**
     * Modulo que crea un vector director en base al vector con origen p1 y extremo p2
     * @param p1
     * @param p2
     * @return
     */
    public static Vector generar_director(Punto p1, Punto p2) {
        Vector director;
        double a, b;
        a = p2.getX() - p1.getX();
        b = p2.getY() - p1.getY();
        director = new Vector(a,b,"d");
        return director;
    }
}
