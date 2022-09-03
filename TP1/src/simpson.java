import java.util.Scanner;

public class simpson {

    public static void main(String[] args) {
        //Calcula integral definida en base el metodo de Simpson 1/3
        Scanner sc = new Scanner(System.in);
        double a, b, n, h, area;

        System.out.print("Ingrese el valor de a: ");
        a = sc.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        b = sc.nextDouble();
        System.out.print("Ingrese el valor de n: ");
        n = sc.nextDouble();
        h = (b - a) / n;
        System.out.println("h = " + h);
        area = formSimp(a, b, h, n);
        System.out.println("Area aproximada: " + area);
    }

    public static double formSimp(double a, double b, double h, double n) {
        //Formula de Simpson 1/3
        double x0, sumImpar = 0, sumPar = 0, xn;
        //Almaceno f(a) y f(b)
        x0 = f(a);
        xn = f(b);
        
        for (int i = 1; i < n; i++) { //Iterar de x1 a xn
            //Aumento a
            a = a + h;
            //Verifica si i es par
            if ((i % 2) == 0) {
                sumPar = sumPar + f(a);
            } else {
                sumImpar = sumImpar + f(a);
            }
        }

        return ((h/3) * (x0 + xn + (4 * sumImpar) + (2 * sumPar)));
    }

    public static double f(double x) {
        //Modulo que almacena la funcion y calcula segun un x ingresado
        double result;
        result = Math.tan(x); 
        return result;
    }
}