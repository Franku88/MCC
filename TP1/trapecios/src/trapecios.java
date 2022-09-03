import java.util.Scanner;

public class trapecios {

    public static void main(String[] args) {
        //Calcula integral definida en base el metodo de los trapecios
        Scanner sc = new Scanner(System.in);
        double a, b, n, h;

        System.out.print("Ingrese el valor de a: ");
        a = sc.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        b = sc.nextDouble();
        System.out.print("Ingrese el valor de n: ");
        n = sc.nextDouble();
        h = (b - a) / n;
        System.out.println("h = " + h);

        System.out.println("Area aproximada: " + formTrape(a, b, h, n));
    }

    public static double formTrape(double a, double b, double h, double n) {
        //Formula de trapecios
        double sumat = 0, x0;
        //Almaceno valor de f(a)
        x0 = f(a);
        //Aumento a
        a = a + h;

        for (int i = 1; i < n; i++) { //Salta en cada x del intervalo
            sumat = f(a) + sumat;
            a = a + h;
        }
        return ((h/2)*(x0 + f(b) + (2 * sumat)));
    }

    public static double f(double x) {
        //Modulo que almacena la funcion y calcula segun un x ingresado
        double result = Math.tan(x);
        return result;
    }

}