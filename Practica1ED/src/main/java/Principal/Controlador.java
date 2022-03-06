/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Archivos.LectorArchivosEnTexto;
import Listas.Lista;
import Objetos.Ficha;
import Objetos.Resultado;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
 */
public class Controlador {

    private Principal principal;

    public Controlador(Principal principal) {
        this.principal = principal;
    }

    public Lista<Ficha> obtenerDatosTexto() {
        Lista<Ficha> filasArchivo = new Lista<>();
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(principal.getVentanaPrincipal());

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
        int[] orden = new int[valores.length - 2];
        for (int i = 2; i < valores.length; i++) {
            orden[i - 2] = Integer.parseInt(valores[i]);
        }
        return orden;
    }

    public boolean esRepetido(int[] numeros) {
        Lista<String> caballos = new Lista<>();
        caballos.add("" + 1);
        caballos.add("" + 2);
        caballos.add("" + 3);
        caballos.add("" + 4);
        caballos.add("" + 5);
        caballos.add("" + 6);
        caballos.add("" + 7);
        caballos.add("" + 8);
        caballos.add("" + 9);
        caballos.add("" + 10);

        return verificarRepetido(numeros, caballos, 0, 0);
    }

    private boolean verificarRepetido(int[] numeros, Lista<String> caballos, int indiceLista, int indiceArray) {

        if (caballos.getSize() == indiceLista) {
            return true;
        } else if (numeros[indiceArray] == Integer.parseInt(caballos.get(indiceLista))) {
            caballos.eliminar(indiceLista);

            if (caballos.esVacia()) {
                return false;
            } else {
                return verificarRepetido(numeros, caballos, 0, indiceArray + 1);
            }
        } else {
            if (caballos.getSize() == (indiceLista - 1)) {
                return true;
            }
            return verificarRepetido(numeros, caballos, indiceLista + 1, indiceArray);
        }
    }

    public int[] obtenerNumeros(String[] datos) {
        int[] array = {Integer.parseInt(datos[2]),
            Integer.parseInt(datos[3]),
            Integer.parseInt(datos[4]),
            Integer.parseInt(datos[5]),
            Integer.parseInt(datos[6]),
            Integer.parseInt(datos[7]),
            Integer.parseInt(datos[8]),
            Integer.parseInt(datos[9]),
            Integer.parseInt(datos[10]),
            Integer.parseInt(datos[11])};
        return array;
    }

    public Resultado verificarResultados(Ficha get, Lista<String> resultadoCarrera, int indice, int puntos) {

        if ((resultadoCarrera.getSize() - 1) == indice) {
            return new Resultado(puntos, get);
        } else if (get.getOrdenCaballos()[indice] == Integer.parseInt(resultadoCarrera.get(indice))) {
            puntos = puntos + (Constantes.CANTIDAD_PUNTOS_MAXIMA - indice);
        }
        return verificarResultados(get, resultadoCarrera, indice + 1, puntos);

    }

    public void obtenerResultadosPorNombres(Lista<Resultado> listado) {
        Resultado temp;
        for (int i = 0; i < listado.getSize(); i++) {
            for (int j = i + 1; j < listado.getSize(); j++) {

                // to compare one string with other strings
                if (listado.get(i).getFicha().getApostador().compareTo(listado.get(j).getFicha().getApostador()) > 0) {
                    // swapping
                    temp = listado.get(i);
                    listado.modifica(listado.get(j), i);
                    listado.modifica(temp, j);

                }
            }
        }

    }

    public void obtenerResultadosPorPuntaje(Lista<Resultado> listado) {
        int i, j;
        Resultado aux;
        for (i = 0; i < listado.getSize() - 1; i++) {
            for (j = 0; j < listado.getSize() - i - 1; j++) {
                if (listado.get(j + 1).getPuntajeTotal() > listado.get(j).getPuntajeTotal()) {
                    aux = listado.get(j + 1);
                    listado.modifica(listado.get(j), j + 1);
                    listado.modifica(aux, j);
                }
            }
        }
    }

    public void llenarTabla(Lista<Resultado> lista) {

        DefaultTableModel modelo = new DefaultTableModel();

        principal.getTablaResultados().getTabla().setModel(modelo);

        modelo.addColumn("Nombre del Apostador");
        modelo.addColumn("Puntos");

        for (int i = 0; i < lista.getSize(); i++) {
            modelo.addRow(new Object[]{lista.get(i).getFicha().getApostador(), lista.get(i).getPuntajeTotal()});
        }

        principal.getTablaResultados().setVisible(true);
    }

}
