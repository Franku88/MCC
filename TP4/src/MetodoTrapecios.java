/**
 * 
 * @author Franco Benitez
 */


 public class MetodoTrapecios {
    public static void main(String args[]) {
        /*Algoritmo principal, aproxima volumen de f(x,y) por metodo de trapecios, invoca al metodo 
        con una region R=[a,b]X[c,d] y divisiones de la misma (m y n)*/
        double a = 0, b = 2, c = 0, d = 2;  //Reemplazar region, m y n segun se necesite aproximar
        int m = 2, n = 2;
        double volumenAprox;
        
        volumenAprox = Trapecios(a, b, c, d, m, n);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.print("Volumen aproximado por Trapecios (R=["+a+","+b+"]x["+c+","+d+"], m="+m+", n="+n+"): ");
        System.out.println(volumenAprox+" u^3");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
        

    }
    /**
     * Aproxima integral de f en la region R=[a,b]x[c,d] mediante metodo de trapecios, 
     * subdividiendo R en m y n (base y altura respectivamente)
     * @param a
     * @param b
     * @param c
     * @param d
     * @param m
     * @param n
     * @return
     */
    public static double Trapecios(double a, double b, double c, double d, int m, int n) {
        double x, y, h, k, suma = 0;
        //Rectangulo dividido en rectangulos de h*k
        h = (b-a)/m; //Divido base de rectangulo en m partes
        k = (d-c)/n; //Divido altura de rectangulo en n partes
        //Inicializo x e y
        x = a;
        y = c;

        for (int j = 0; j <= n; j++) { //Aumenta y n+1 veces
            for (int i = 0; i <= m; i++) { //Aumenta x m+1 veces
                if (j%2 == 1) { //Si j es impar, multiplica el resultado de la suma por h
                    if (i%2 == 1) { //Si i es impar, duplica f(x,y)
                        suma = (2*h*f(x,y))+suma;
                    } else { //Si i es par, no duplica f(x,y)
                        suma = (h*f(x,y))+suma;
                    }
                } else { //Si j es par, multiplica el resultado de la suma por h/2 
                    if (i%2 == 1) { //Si i es impar, duplica f(x,y)
                        suma = (h*f(x,y))+suma;
                    } else { //Si i es par, no duplica f(x,y)
                        suma = ((h/2)*f(x,y))+suma;
                    }
                }
                //Aumento x en h
                x = x+h;
            }
            //Reinicio x, aumento y en k
            x = a;
            y = y+k;
        }
        //Multiplico suma total por k/2
        suma = (k/2)*suma;
        return suma;
    }

    /**
     * Contiene funcion a evaluar, retorna resultado de la funcion en un (x,y) dado
     * @param x
     * @param y
     * @return
     */
    public static double f(double x, double y) {
        double resultado = Math.pow(x,2)+Math.pow(y,2); //Reemplazar funcion aca
        return resultado;
    }
 }