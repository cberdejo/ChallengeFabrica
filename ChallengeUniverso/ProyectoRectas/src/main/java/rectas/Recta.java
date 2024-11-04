package rectas;

import java.util.Optional;

public record Recta(Punto punto, Vector vectorDirector) {

    private static final double EPSILON = 0.000001;

    /// Constructor con el punto y vector de la recta
    public Recta(Punto punto, Vector vectorDirector) {
        this.vectorDirector = vectorDirector;
        this.punto = punto;
    }
    /// Constructor de recta a partir de dos puntos
    public Recta(Punto p1, Punto p2) {
        this(p1, new Vector(p1, p2));
    }

    /// Recta paralela a otra recta
    public boolean esParalela (Recta r){
        return this.vectorDirector.esParalelo(r.vectorDirector);
    }

    /// Calcula la ecuacion implicita de la recta
    public Implicita implicita() {
        double a = vectorDirector.y();
        double b = -vectorDirector.x();
        double c = - (a * punto.x() + b * punto.y());
        return new Implicita(a, b, c);
    }

    /// Calcula el determinante
    private double determinante(double a11, double a12, double a21, double a22) {
        return a11 * a22 - a12 * a21;
    }

    ///Calcula la interseccion con otra recta (si la hay)
    public Optional<Punto> interseccionCon(Recta r) {

        double a1 = vectorDirector.y();
        double b1 = -vectorDirector.x();
        double c1 = -(a1 * punto.x() + b1 * punto.y());

        double a2 = r.vectorDirector.y();
        double b2 = -r.vectorDirector.x();
        double c2 = -(a2 * r.punto.x() + b2 * r.punto.y());


        double determinante = a1 * b2 - a2 * b1;
        if (Math.abs(determinante) < EPSILON) {
            return Optional.empty();
        }

        double x = (b1 * c2 - b2 * c1) / determinante;
        double y = (a2 * c1 - a1 * c2) / determinante;

        return Optional.of(new Punto(x, y));
    }

    /// Nueva recta paralela a la original que pasa por un punto p
    public Recta paralelaPor(Punto p){
        return new Recta (p, vectorDirector);
    }

    /// Nueva recta perpendicular a la actual que pasa por un punto p
    public Recta perpendicularPor(Punto p){
        Vector vectorPerpendicular = new Vector(-vectorDirector.y(), vectorDirector.x());
        return new Recta(p, vectorPerpendicular);
    }

    ///Distacnia desde un punto a la recta
    public double distanciaDesde (Punto p){
        Recta perpendicular = perpendicularPor(p);

        Optional<Punto> interseccion = this.interseccionCon(perpendicular);

        if (interseccion.isPresent()) {
            Punto puntoInterseccion = interseccion.get();
            return p.distancia(puntoInterseccion);
        }
        return -1;
    }


    public Punto punto() {
        return this.punto;
    }

    ///Comprueba si un punto esta en la recta
    public boolean contieneA(Punto p) {
        Implicita impl = this.implicita();
        return Math.abs(impl.a() * p.x() + impl.b() * p.y() + impl.c()) < EPSILON;
    }
}
