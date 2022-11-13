/**
 * 
 * @author Franco Benitez
 */


public class EulerModificado {
    /**
     * Algoritmo principal del metodo
     * Realiza una tabla de resultados aproximados de y mediante el metodo de Euler modificado
     * Reemplazar la funcion D(x,y) y valores de x0, xn, y0, h para cada caso de aproximacion
     * @param args 
     */
    public static void main(String[] args) {
        double x0 = 0, xn = 1, y0 = -3, h = 0.2; //Reemplazar segun se necesite (Tambien en la funcion D(x,y))
        System.out.println("---------------------------- Método de Euler Modificado ----------------------------");
        System.out.println("----------------------- xe["+x0+","+xn+"], y("+x0+") = "+y0+", h = "+h+" -----------------------");
        System.out.println();
        CalcularEulerModif(x0, xn, y0, h);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");

    }
    /**
     * Genera tabla con valores aproximados de y por el método de euler modificado
     * con xe[xi,xn], valor inicial y(xi) = yi, y valor de h (separacion entre xi)
     * Se debe reemplazar y' en la funcion D(x,y)
     * @param xi
     * @param xn
     * @param yi
     * @param h
     */
    public static void CalcularEulerModif(double xi, double xn, double yi, double h) {
        double yp, dydx; //Resultados de Predictora (y*i+1) y de dydx (derivada de y en (xi,yi))
        System.out.println("x  |  y");
        System.out.println("--------");
        System.out.println(xi+" | "+yi);
        while (xi < xn) {
            dydx = D(xi,yi); //Almaceno calculo de D(x,y) a utilizar dos veces
            yp = yi + h*(dydx); //Predictora
            xi = xi + h; //Aumento xi para calcular correctora y proxima iteracion del while
            yi = yi + (h/2)*(dydx + D(xi,yp)); //Correctora
            System.out.println(xi+" | "+yi);
        }
        
    }

    /**
     * Almacena y calcula y'== dy/dx == D(x,y)
     * @param x
     * @param y
     * @return
     */
    public static double D(double x, double y) {
        double resultado;
        resultado = x+(1/(5*y)); //Reemplazar en esta linea con dy/dx
        return resultado;
    }
}