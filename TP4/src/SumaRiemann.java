/**
 * 
 * @author Franco Benitez
 */

public class SumaRiemann {
    public static void main(String[] args) throws Exception {
        /*Algoritmo principal, aproxima volumen de f(x,y) con sumatoria de Riemannm, invoca la sumatoria 
        con una region S=[x0,x1]X[y0,y1] y un limite de sumatoria m=n por parametro*/
        double volumenAprox;
        double x0 = 0, x1 = 2, y0 = 0, y1 = 2, m = 16; //Reemplazar region y m segun se necesite aproximar
        volumenAprox = Riemann(x0,x1,y0,y1,m); 
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.print("Volumen aproximado por Sumatoria de Riemann (S=["+x0+","+x1+"]x["+y0+","+y1+"] y m=n="+m+"): ");
        System.out.println(volumenAprox+" u^3");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    /**
     * Aproxima el volumen de f(x,y) mediante Sumatoria de Rieman en una region  S=[x0,x1]X[y0,y1]
     * @param x0 //Extremo de integración
     * @param x1 //Extremo de integración 
     * @param y0 //Extremo de integración 
     * @param y1 //Extremo de integración 
     * @param m //Limite de las sumatorias (m=n)
     * @return
     */
    public static double Riemann(double x0, double x1, double y0, double y1, double m) {
        double ladoX = x1-x0; //Medida del lado X
        double ladoY = y1-y0; //Medida del lado Y
        double x, y; //Valores donde se evaluará la funcion
        double dx, dy; //Valor de aumento en cada coordenada (lados de los cuadrados)
        double dA; //Area de los cuadrados
        double suma = 0;
        
        dx = ladoX/m; //Divide el lado en m porciones
        dy = ladoY/m; //Divide el lado en m porciones
        dA = dx*dy; //Area de los cuadrados
        x = x0+dx; //Calcula desde x0+dx
        y = y0+dy; //Calcula desde y0+dy
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                //Calcula y suma f(x,y), luego aumenta y en dy
                suma = (f(x,y)*dA)+suma;
                y = y+dy;
            }
            //Aumenta x en dx y reinicia valor de y
            x = x+dx;
            y = y0+dy;
        }
        return suma;
    }

    /**
     * Contiene la funcion y retorna el resultado del calculo en (x,y)
     * @param x
     * @param y
     * @return
     */
    public static double f(double x, double y) {
        double resultado = 16-(Math.pow(x,2))-(2*Math.pow(y,2)); //Reemplazar dependiendo el caso
        return resultado;
    }
    
}
