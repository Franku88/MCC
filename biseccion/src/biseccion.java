import java.util.Scanner;

public class biseccion {
    
    public static void main(String[] args) throws Exception {
        //Invoca módulos para realizar biseccion
        Scanner sc = new Scanner(System.in);
        double a, b, E, r = 0;
        
        System.out.print("Ingrese el valor de a: ");
        a = sc.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        b = sc.nextDouble();
        System.out.print("Ingrese el valor de E: ");
        E = sc.nextDouble();

        if (f(a)*f(b) < 0) {
            do {
                r = (a+b)/2;
                System.out.println(r);
                if (f(a)*f(r) < 0) {
                    b = r;
                } else {
                    a = r;
                }
            } while(Math.abs(f(r))>E);
        } else {
            System.out.println("");
        }
        
        System.out.println("La raiz aproximada es: "+r);
    }

    public static double f(double x) {
        //retorna el calculo con algun x ingresado
        double result;
        result = (Math.pow(x,3))-(2*x)- 1; //2*Math.sin(x+1)Ingresar funcion a evaluar en esta linea
        return result;
    }

    

}
