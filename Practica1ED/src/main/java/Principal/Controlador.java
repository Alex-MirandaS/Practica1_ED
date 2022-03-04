/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Archivos.LectorArchivosEnTexto;
import Listas.Lista;
import Objetos.Ficha;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class Controlador {
    
    
   private Principal principal;

    public Controlador(Principal principal) {
        this.principal = principal;
    }
    
    public Lista<Ficha> obtenerDatosTexto(){
        Lista<Ficha> filasArchivo = new Lista<>();
       JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(principal.getVentajaPrincipal());

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //aqui selecciono y guardo el FILE que va a utilizar el FileReader
            File fichero = fileChosser.getSelectedFile();
            try {
                filasArchivo = principal.getLector().leerFichero(fichero);
                //principal.getPrincipalGUI().getAreaTexto().setText("");
                //mostrarTextArea(principal.getPrincipalGUI().getAreaTexto());
                //pathDocumentoActual = fichero.getAbsolutePath();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            }
        }

        return filasArchivo;
    }
    
     public String[] separarCampos(String linea) {
        String[] campos = linea.split(",");
        return campos;
    }

    public int[] obtenerOrdenCaballos(String[] valores) {
       int [] orden = new int[valores.length-2];
        for (int i = 2; i < valores.length; i++) {
            orden[i-2] = Integer.parseInt(valores[i]);
        }
        return orden;
    }
    
//    public boolean datosCorrectos (String [] datos){
//        if (datos[0] instanceof String) {
//            if (datos[1] instan ) {
//                
//            }
//        }
//    }
//    

    boolean esRepetido(int[] numeros) {
       boolean repetido;
       int temp;
        for (int i = 0; i < numeros.length; i++) {
            temp = numeros
        }
        
        
        
    }
    
}
