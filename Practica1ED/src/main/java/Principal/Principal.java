/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Archivos.LectorArchivosEnTexto;
import GUI.VentajaPrincipal;
import Listas.Lista;
import Objetos.Ficha;

/**
 *
 * @author alex
 */
public class Principal {

    private VentajaPrincipal ventajaPrincipal = new VentajaPrincipal(this);

    private LectorArchivosEnTexto lector = new LectorArchivosEnTexto();
    private Controlador controlador = new Controlador(this);
    private Lista<Ficha> apuestas = new Lista<>();

    public void ingresarApuestas() {
        Lista<Ficha> apuestas = controlador.obtenerDatosTexto();
    }

    public void verificarApuestas() {

        for (int i = 0; i < apuestas.getSize(); i++) {
            String[] datos = apuestas.get(i).getDatos().split(",");

            if (datos.length != Constantes.CANTIDAD_DATOS) {
                try {
                    apuestas.get(i).setApostador(datos[0]);
                    apuestas.get(i).setMonto(Double.parseDouble(datos[1]));
                    int[] numeros = {Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]),
                        Integer.parseInt(datos[5]),
                        Integer.parseInt(datos[6]),
                        Integer.parseInt(datos[7]),
                        Integer.parseInt(datos[8]),
                        Integer.parseInt(datos[9]),
                        Integer.parseInt(datos[10]),
                        Integer.parseInt(datos[11])};
                    if (controlador.esRepetido(numeros)) {
                        apuestas.get(i).setOrdenCaballos(numeros);
                    } else {
                        //añadir a error
                    }

                    //VERIFICAR LO DE LOS NÚMEROS REPETIDOS
                } catch (NumberFormatException e) {
                    //METER A ERROR
                }
            } else {
                //METER LA APUESTA A UN ERROR
            }
        }
    }

    public VentajaPrincipal getVentajaPrincipal() {
        return ventajaPrincipal;
    }

    public void setVentajaPrincipal(VentajaPrincipal ventajaPrincipal) {
        this.ventajaPrincipal = ventajaPrincipal;
    }

    public LectorArchivosEnTexto getLector() {
        return lector;
    }

    public void setLector(LectorArchivosEnTexto lector) {
        this.lector = lector;
    }

}
