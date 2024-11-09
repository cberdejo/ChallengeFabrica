import rectas.Implicita;
import rectas.Punto;
import rectas.Recta;
import rectas.Vector;

import java.util.Optional;

public class Main2 {
    public static void main(String[] args) {
        // Crear algunos puntos
        Punto p1 = new Punto(0, 0);     // Origen
        Punto p2 = new Punto(3, 4);     // Punto en (3, 4)
        Punto p3 = new Punto(6, 8);     // Punto en (6, 8), paralelo a p1 -> p2

        // Probar el método distancia en Punto
        System.out.println("Distancia entre p1 y p2: " + p1.distancia(p2)); // Esperado: 5.0 (3-4-5 triangle)

        // Crear algunos vectores
        Vector v1 = new Vector(p2);     // Vector con extremo en (3, 4)
        Vector v2 = new Vector(3, 4);   // Vector (3, 4) explícito
        Vector v3 = new Vector(p1, p3); // Vector (6, 8) usando dos puntos

        // Probar métodos de Vector
        System.out.println("Módulo de v1: " + v1.modulo()); // Esperado: 5.0
        System.out.println("¿v1 es paralelo a v3?: " + v1.esParaleloA(v3)); // Esperado: true

        // Crear algunas rectas
        Recta r1 = new Recta(v1,p1); // Recta con vector dirección v1 y pasa por p1
        Recta r2 = new Recta(p1, p3); // Recta que pasa por puntos p1 y p3 (paralela a r1)
        Recta r3 = new Recta(new Vector(-4, 3), p2); // Recta con vector (-4, 3) y que pasa por p2

        // Probar si las rectas son paralelas
        System.out.println("¿r1 es paralela a r2?: " + r1.esParalelaA(r2)); // Esperado: true
        System.out.println("¿r1 es paralela a r3?: " + r1.esParalelaA(r3)); // Esperado: false

        // Probar la ecuación implícita de r1
        Implicita implicitaR1 = r1.implicita();
        System.out.println("Ecuación implícita de r1: " + implicitaR1.a() + "x + "
                + implicitaR1.b() + "y + " + implicitaR1.c() + " = 0");

        // Probar el método contieneA
        System.out.println("¿r1 contiene a p2?: " + r1.contieneA(p2)); // Esperado: true
        System.out.println("¿r1 contiene a (5, 5)?: " + r1.contieneA(new Punto(5, 5))); // Esperado: false

        // Probar el método interseccionCon
        Optional<Punto> interseccion = r1.interseccionCon(r3);
        if (interseccion.isPresent()) {
            Punto pInterseccion = interseccion.get();
            System.out.println("Intersección entre r1 y r3: (" + pInterseccion.x() + ", " + pInterseccion.y() + ")");
        } else {
            System.out.println("r1 y r3 no tienen intersección.");
        }

        // Probar rectas paralelaPor y perpendicularPor
        Recta r4 = r1.paralelaPor(new Punto(1, 1)); // Recta paralela a r1 pasando por (1, 1)
        Recta r5 = r1.perpendicularPor(new Punto(1, 1)); // Recta perpendicular a r1 pasando por (1, 1)
        System.out.println("Recta r4 (paralela a r1) pasando por (1,1): " + r4);
        System.out.println("Recta r5 (perpendicular a r1) pasando por (1,1): " + r5);

        // Probar la distancia desde un punto a la recta
        double distanciaPuntoAR1 = r1.distanciaDesde(new Punto(3, 3));
        System.out.println("Distancia desde (3,3) a r1: " + distanciaPuntoAR1); // Esperado: valor positivo

        // Fin de las pruebas
    }
}
