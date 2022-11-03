/**
 * 
 * @author Franco Benitez
 */

public class MetodoSimpson {
    public static void main(String args[]) {
        /*Algoritmo principal, aproxima volumen de f(x,y) por metodo de Simpson 1/3, invoca al metodo 
        con una region R=[a,b]X[c,d] y divisiones de la misma (m y n)*/
        double a = 0, b = 1, c = 0, d = 1;  //Reemplazar region, m y n segun se necesite aproximar
        int m = 3, n = 3;
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
        double x, y, h, k, I, suma = 0;
        //Rectangulo dividido en rectangulos de h*k
        h = (b-a)/m;
        k = (d-c)/n;
        //Inicializo x e y
        x = a;
        y = c;

        for (int j = 0; j <= n; j++) { //Aumenta y n+1 veces
            I = 0;
            for (int i = 0; i <= m; i++) { //Aumenta x m+1 veces
                if (i == 0 || i == m) {
                    I = f(x,y)+I;
                } else {
                    if (i%2 == 1) {
                        I = (4*f(x,y))+I;
                    } else {
                        I = (2*f(x,y))+I;
                    }
                }
                //Aumento x en h
                x = x+h;
            }
            if (j != 0 && j != n) {
                if (j%2 == 1) {
                    I = I*4;
                } else {
                    I = I*2;
                }
            }
            suma = ((h/3)*I)+suma;
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