/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alex
 */


public class EscritorArchivosTexto {

    //donde se guardan los archivos
    private String ubicación = "archivos/Archivo Guardado.txt";
//Se encarga de guardar un texto en un archivo .txt
    public void guardarArchivoTexto(String texto) throws IOException, FileNotFoundException {
        File archivo = new File(ubicación);
        File temp = new File(archivo.getParentFile().getAbsolutePath());
        if (!temp.exists()) {
            temp.mkdirs();
        }
        FileWriter fichero = new FileWriter(archivo);
        fichero.write(texto);
        fichero.close();
    }

}