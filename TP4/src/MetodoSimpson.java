/**
 * 
 * @author Franco Benitez
 */

public class MetodoSimpson {
    public static void main(String args[]) {
        /*Algoritmo principal, aproxima volumen de f(x,y) por metodo de Simpson 1/3, invoca al metodo 
        con una region R=[a,b]X[c,d] y divisiones de la misma (m y n)*/
        double a = 0, b = 2, c = 0, d = 2;  //Reemplazar region, m y n segun se necesite aproximar
        int m = 2, n = 2;
        double volumenAprox;
        
        volumenAprox = Simpson(a, b, c, d, m, n);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.print("Volumen aproximado por Simpson 1/3 (R=["+a+","+b+"]x["+c+","+d+"], m="+m+", n="+n+"): ");
        System.out.println(volumenAprox+" u^3");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
        

    }
    /**
     * Aproxima integral de f en la region R=[a,b]x[c,d] mediante metodo de Simpson, 
     * subdividiendo R en m y n (base y altura respectivamente)
     * @param a
     * @param b
     * @param c
     * @param d
     * @param m
     * @param n
     * @return
     */
    public static double Simpson(double a, double b, double c, double d, double m, double n) {
        double x, y, h, k, suma = 0;
        //Rectangulo dividido en rectangulos de h*k
        h = (b-a)/m;
        k = (d-c)/n;
        //Inicializo x e y
        x = a;
        y = c;

        for (int j = 0; j <= n; j++) { //Aumenta y n+1 veces
            for (int i = 0; i <= m; i++) { //Aumenta x m+1 veces
                if (j%2 == 1) { //Si j es impar, multiplica por 4
                    if (i%2 == 1) { //Si i es impar, multiplica por 4
                        suma = (16*(h/3)*f(x,y))+suma;
                    } else { //Si i es par, no multiplica
                        suma = (4*(h/3)*f(x,y))+suma;
                    }
                } else { //Si j es par, no multiplica
                    if (i%2 == 1) { //Si i es impar, multiplica por 4
                        suma = (4*(h/3)*f(x,y))+suma;
                    } else { //Si i es par, no multiplica
                        suma = ((h/3)*f(x,y))+suma;
                    }
                }
                //Aumento x en h
                x = x+h;
            }
            //Reinicio x, aumento y en k
            x = a;
            y = y+k;
        }
        //Multiplico suma total por k/3
        suma = (k/3)*suma;
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