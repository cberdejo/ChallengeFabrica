package universo;

import java.util.ArrayList;
import java.util.List;

public class Particulas{
    private Punto posicion;
    private double masa;
    private double radio;
    private Vector velocidad;

    private static final double G = 6.67E-11;

    public Partculas (Punto pos, Vector vel, double m, double r){
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

    }



}