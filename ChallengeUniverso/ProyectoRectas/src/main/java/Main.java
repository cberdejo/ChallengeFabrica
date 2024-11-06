import rectas.Recta;


public class Main {

    public static double calcularAreaTriangulo(Punto a, Punto b, Punto c) {
        return Math.abs((a.x() * (b.y() - c.y()) + b.x() * (c.y() - a.y()) + c.x() * (a.y() - b.y())) / 2.0);
    }

    public static void main(String[] args) {
        Punto p1 = new Punto(2, 3);
        Punto p2 = new Punto(5, 7);
        Punto p3 = new Punto(6, 2);

        double area = calcularAreaTriangulo(p1, p2, p3);
        System.out.println("Área del triángulo: " + area);

        Recta recta1 = new Recta(new Punto(1, 2), new Punto(5, 4));
        Recta recta2 = new Recta(new Punto(2, 6), new Punto(4, 8));


        System.out.println("Paralelas: " + recta1.esParalela(recta2));


        Implicita implicita1 = recta1.implicita();
        System.out.println("Ecuación implícita de la Recta 1: a: " + implicita1.a() + ", b: " + implicita1.b() + ", c: " + implicita1.c());


        double distancia = recta1.distanciaDesde(p2);
        System.out.println("Distancia desde el punto " + p2 + " a la Recta 1: " + distancia);

        var interseccion = recta1.interseccionCon(recta2);
        interseccion.ifPresent(punto -> System.out.println("Las rectas se intersectan en: " + punto));
    }

}