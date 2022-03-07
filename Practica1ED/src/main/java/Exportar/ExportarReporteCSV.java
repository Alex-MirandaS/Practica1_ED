/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exportar;

import Listas.Lista;
import Objetos.Ficha;
import Objetos.Resultado;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class ExportarReporteCSV {

    public void generarReporte(String nombre, Lista<Object> lista, boolean esErrores) {

        FileWriter csvWriter;
        try {
            csvWriter = new FileWriter(nombre + ".csv");
            llenarColumnas(csvWriter, esErrores);
            for (int i = 0; i < lista.getSize(); i++) {
                llenarFilas(csvWriter, lista.get(i), esErrores);
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

        } catch (IOException ex) {
            System.out.println("Error");
        }
        JOptionPane.showMessageDialog(null, "SE GUARDO EL ARCHIVO CORRECTAMENTE");
    }

    private void llenarFilas(FileWriter csvWriter, Object get, boolean esErrores) {
        try {
            if (esErrores) {
                Ficha error = (Ficha) get;
                csvWriter.append(String.join(",", error.getDatos()));
                csvWriter.append("\n");
            } else {
                Resultado resultado = (Resultado) get;
                csvWriter.append(String.join(",", resultado.getFicha().getApostador()));
                csvWriter.append(",");
                csvWriter.append(String.join(",", "" + resultado.getFicha().getMonto()));
                csvWriter.append(",");
                csvWriter.append(String.join(",", "" + resultado.getPuntajeTotal()));
                csvWriter.append(",");
                csvWriter.append("\n");
            }
        } catch (IOException ex) {
            System.out.println("error");
        }
    }

    private void llenarColumnas(FileWriter csvWriter, boolean esErrores) {
        try {
            if (esErrores) {

                csvWriter.append("Cadena de Error");
                csvWriter.append("\n");
            } else {

                csvWriter.append("Nombre del Apostador");
                csvWriter.append(",");
                csvWriter.append("Monto");
                csvWriter.append(",");
                csvWriter.append("Puntaje");
                csvWriter.append(",");
                csvWriter.append("\n");
            }

        } catch (IOException ex) {
            System.out.println("ERROR AL INGRESAR NOMBRES");
        }

    }
}
