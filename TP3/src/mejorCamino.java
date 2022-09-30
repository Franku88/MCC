
/**
 * @author fabian.benitez, guillermo.diaz, sebastian.iovaldi
 * 
 */
public class mejorCamino {
    public static void main(String[] args) throws Exception {
        //Puntos
        Punto A,B,C,D,E,F,G,H,I,J;
        A = new Punto(-1.08,1.56, "A");
        C = new Punto(-1.57,1.34, "C");
        D = new Punto(-1.22,-0.41, "D");
        B = new Punto(-1.91,1.5, "B");
        E = new Punto(-1.76,-0.43, "E");
        F = new Punto(-2.13,1.59, "F");
        G = new Punto(-2,0.07, "G");
        H = new Punto(-2.22,0.58, "H");
        I = new Punto(-2.28,-1.17, "I");
        J = new Punto(-2.36,-0.26, "J");
        
        //Puntos segun su curva de nivel
        Punto[][] puntos = {{A},{C,D},{B,E},{F,G},{H,I},{J}};
        double[] curvas = {9.23, 8, 6, 4, 2, 0};
        String camino = "A";

        Punto inicio = A, llegada;
        double pendiente1;
        double pendiente2;

        for (int i=1; i < puntos.length; i++) {
            System.out.println("----- De "+curvas[i-1]*100+"mts a "+curvas[i]*100+"mts -----");
            pendiente1 = calcular_derivada_direccional(inicio,puntos[i][0]);
            llegada = puntos[i][0];

            for (int j=1; j< puntos[i].length; j++) {

                pendiente2 = calcular_derivada_direccional(inicio,puntos[i][j]);

                if (Math.abs(pendiente1) > Math.abs(pendiente2)) {
                    llegada = puntos[i][j];
                    pendiente1 = pendiente2;
                }
            }
            System.out.println("-- Hacia el punto "+llegada.toString()+" tiene menor tasa de variacion. --");
            camino = camino+"-"+llegada.getNombre();
            inicio = llegada;
            System.out.println("");
        }

        System.out.println("--- Camino con menor tasa de variacion: "+camino+" ---");
    }

    /**
     * Modulo que calcula la derivada direccional desde p1 a p2, Imprime y retorna el resultado
     * @param p1
     * @param p2
     * @return resultado
     */
    public static double calcular_derivada_direccional(Punto p1, Punto p2) {
        Vector d;
        boolean es_unitario;
        double resultado;

        d = Vector.generar_director(p1,p2); 

        es_unitario = d.verifica_unitario();
        if (!es_unitario) {
            d = d.generar_unitario();
        }
        resultado = Duf(p1,d);
        System.out.println("La pendiente desde "+p1.toString()+" a "+p2.toString()+" con direccion del "+
        "vector "+d.toString()+" es: "+resultado);
        return resultado;
    }

    /**
     * Modulo que retorna el calculo de la derivada direccional en el
     * punto P(x,y) con direccion del vector u=(a,b), u debe ser unitario
     * @param Punto p
     * @param Vector u
     * @return resultado
     */
    public static double Duf(Punto p, Vector u) {
        double resultado;
        double x, y;
        x = p.getX();
        y = p.getY();

        //Invoca y calcula ambas derivadas parciales
        resultado = fx(x,y)*u.getA() + fy(x,y)*u.getB();
        return resultado;
    }   

    /**
     * Modulo que retorna el calculo de fx(x,y), (derivada parcial respecto a x)
     * @param double x
     * @param double y
     * @return resultado
     */
    public static double fx(double x, double y) {
        double resultado;
        resultado = (-3+3*(Math.pow(x,2))); //Reemplazar con fx dependiendo el caso
        return resultado;
    }

    /**
     * Modulo que retorna el calculo de fy(x,y), (derivada parcial respecto a y)
     * @param double x
     * @param double y
     * @return resultado
     */
    public static double fy(double x, double y) {
        double resultado;
        resultado = ((2*y)-(0.8*Math.pow(y,3))); //Reemplazar con fy dependiendo el caso
        return resultado;
    } 
}
