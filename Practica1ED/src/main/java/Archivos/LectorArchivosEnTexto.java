/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import Listas.Lista;
import Objetos.Ficha;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class LectorArchivosEnTexto {

    //File=archivo
    //FileReader necesita a un archivo para poder leerlo
    //BufferedReader lee el texto del archivo
    public Lista<Ficha> leerFichero(File archivo) throws FileNotFoundException, IOException {
        Lista<Ficha> textos = new Lista<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        //int fila = 1;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
           textos.add(new Ficha(linea));
        }
        fr.close();
        return textos;
    }
}