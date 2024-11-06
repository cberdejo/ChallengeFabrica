package fabrica;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Crear las máquinas de la cadena de producción
        Maquina fresadora1 = new Fresadora(Grosor.Medio, OrFresa.Vertical, Posicion.IzSu);
        Maquina fresadora2 = new Fresadora(Grosor.Medio, OrFresa.DiagonalDerecha, Posicion.IzCe);
        Maquina fresadora3 = new Fresadora(Grosor.Medio, OrFresa.Vertical, Posicion.IzIn);
        Maquina rotadora1 = new Rotadora(Sentido.Antihorario);
        //Maquina lijadora1 = new Lijadora(Posicion.CeSu, OrLija.Norte, Grosor.Fino);
        Maquina fresadora4 = new Fresadora(Grosor.Grueso, OrFresa.DiagonalDerecha, Posicion.CeSu);
        Maquina rotadora2 = new Rotadora(Sentido.Antihorario);
        Maquina fresadora5 = new Fresadora(Grosor.Medio, OrFresa.DiagonalDerecha, Posicion.CeCe);
        Maquina taladradora1 = new Taladradora(Posicion.IzCe, Grosor.Medio);
        Maquina rotadora3 = new Rotadora(Sentido.Antihorario);
        Maquina fresadora6 = new Fresadora(Grosor.Fino, OrFresa.Vertical, Posicion.CeSu);
        Maquina fresadora7 = new Fresadora(Grosor.Medio, OrFresa.Vertical, Posicion.IzIn);
        Maquina rotadora4 = new Rotadora(Sentido.Horario);
        //Maquina lijadora2 = new Lijadora(Posicion.IzCe, OrLija.Sur, Grosor.Grueso);
        Maquina fresadora8 = new Fresadora(Grosor.Fino, OrFresa.DiagonalDerecha, Posicion.CeCe);
        //Maquina lijadora3 = new Lijadora(Posicion.IzSu, OrLija.NorteSur, Grosor.Medio);
        Maquina fresadora9 = new Fresadora(Grosor.Medio, OrFresa.Vertical, Posicion.IzCe);
        Maquina fresadora10 = new Fresadora(Grosor.Grueso, OrFresa.DiagonalDerecha, Posicion.IzSu);

        // Crear la fábrica y añadir las máquinas
        Fabrica fabrica = new Fabrica();
        fabrica.addMaquina(fresadora1);
        fabrica.addMaquina(fresadora2);
        fabrica.addMaquina(fresadora3);
        fabrica.addMaquina(rotadora1);
        fabrica.addMaquina(lijadora1);
        fabrica.addMaquina(fresadora4);
        fabrica.addMaquina(rotadora2);
        fabrica.addMaquina(fresadora5);
        fabrica.addMaquina(taladradora1);
        fabrica.addMaquina(rotadora3);
        fabrica.addMaquina(fresadora6);
        fabrica.addMaquina(fresadora7);
        fabrica.addMaquina(rotadora4);
        fabrica.addMaquina(lijadora2);
        fabrica.addMaquina(fresadora8);
        fabrica.addMaquina(lijadora3);
        fabrica.addMaquina(fresadora9);
        fabrica.addMaquina(fresadora10);

        // Crear una pieza
        Pieza pieza = new Pieza();

        // Realizar el proceso de la fábrica sobre la pieza
        fabrica.marca(pieza);

        // Mostrar el resultado de la pieza después del proceso
        System.out.println(pieza);
    }
}