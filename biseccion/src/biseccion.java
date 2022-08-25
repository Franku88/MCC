import java.util.Scanner;

public class biseccion {
    
    public static void main(String[] args) {
        //Algoritmo que busca raices aproximadas utilizando el metodo de biseccion
        Scanner sc = new Scanner(System.in);
        int i = 0;
        double a, b, E, r;
        
        System.out.print("Ingrese el valor de a: ");
        a = sc.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        b = sc.nextDouble();

        if (f(a)*f(b) < 0) {
            System.out.print("Ingrese el valor de E: ");
            E = sc.nextDouble();
            do {
                r = (a+b)/2;
                i++;
                System.out.println(i+"° iteracion: "+r);
                if (f(a)*f(r) < 0) {
                    b = r;
                } else {
                    a = r;
                }
            } while(Math.abs(f(r))>E);

            System.out.println("La raiz aproximada entre el intervalo ingresado es: "+r);
        } else {
            System.out.println("No se cumple la condicion f(a)*f(b)<0 con los valores ingresados.");
        }
    }

    public static double f(double x) {
        //retorna el calculo de una funcion con algun x ingresado por parametro
        double res;
        res = 2*Math.sin(x+1); //Ingresar funcion a evaluar en esta linea
        return res;
    }
}
