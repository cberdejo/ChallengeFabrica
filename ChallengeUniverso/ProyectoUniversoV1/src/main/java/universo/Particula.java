package universo;

public class Particula{
    private Punto posicion;
    private double masa;
    private double radio;
    private Vector velocidad;

    private static final double G = 6.67E-11;

    public Particula (Punto pos, Vector vel, double m, double r){
        posicion=pos;
        velocidad=vel;
        masa=m;
        radio=r;
    }

    public Punto posicion(){
        return posicion;
    }

    public double radio(){
        return radio;
    }

    public Vector fuerzaDesde(Particula p){

        Vector direccion = new Vector(this.posicion, p.posicion());

        // Cálculo de la distancia entre las posiciones
        double distancia = direccion.modulo(); // ||r2 - r1||

        // Cálculo del vector unitario
        Vector u12 = direccion.direccion();

        // Cálculo de la fuerza usando la fórmula
        double fuerza = (G * this.masa * p.masa) / Math.pow(distancia, 2);

        // Devolver la fuerza como un vector en la dirección de u12
        return u12.escalar(fuerza);
    }

    public void mueve(Vector vz, double dt) {

        Vector aceleracion = vz.escalar(1 / masa);


        this.velocidad = this.velocidad.sum(aceleracion.escalar(dt));


        this.posicion = this.posicion.sum(velocidad.escalar(dt));
    }


    @Override
    public String toString() {
        return "Particula{" +
                "posicion=" + posicion +
                ", velocidad=" + velocidad +
                ", masa=" + masa +
                ", radio=" + radio +
                '}';
    }

}



