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

    public Lista<Ficha> obtenerDatosTexto(Lista<String> pasosIngresoApuestas) {
        Lista<Ficha> filasArchivo = new Lista<>();
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(principal.getVentanaPrincipal());

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //aqui selecciono y guardo el FILE que va a utilizar el FileReader
            File fichero = fileChosser.getSelectedFile();
            try {
                //Se le asigna el valor obtenido del texto, para manipular las apuestas
                filasArchivo = principal.getLector().leerFichero(fichero, pasosIngresoApuestas);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            }
        }

        return filasArchivo;
    }

    //Se encarga de separar una cadena a un array
    public String[] separarCampos(String linea) {
        String[] campos = linea.split(",");
        return campos;
    }
//Se encarga de evaluar si se encuentra un caballo repetido en el arreglo

    public boolean esRepetido(int[] numeros, int pasos) {
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
//Realiza 10 asignaciones
        pasos += 10;
        return verificarRepetido(numeros, caballos, 0, 0, pasos);
    }
//Es un método recursivo encargado de eliminar un elemento de una lista de 10 caballos, al encontrar un caballo, lo elimina de la lista

    private boolean verificarRepetido(int[] numeros, Lista<String> caballos, int indiceLista, int indiceArray, int pasos) {

        if (caballos.getSize() == indiceLista) {
            //acaba la recursividad, hallando un error
            pasos++;
            return true;
        } else if (numeros[indiceArray] == Integer.parseInt(caballos.get(indiceLista))) {
            caballos.eliminar(indiceLista);
            //elimina un valor
            pasos++;
            if (caballos.esVacia()) {
                //acaba la recursividad, de forma correcta
                pasos++;
                return false;
            } else {
                //realiza recursividad
                pasos++;
                return verificarRepetido(numeros, caballos, 0, indiceArray + 1, pasos);
            }
        } else {
            //realiza recursividad
            pasos++;
            return verificarRepetido(numeros, caballos, indiceLista + 1, indiceArray, pasos);
        }
    }
//Se encarga de transformar un valor de String a Int ya que equivale al número de caballos

    public int[] obtenerNumeros(String[] datos, int pasos) {
        //asigna 10 valores
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
        pasos += 10;
        return array;
    }
//Es un metodo recursivo que se encarga de verificar y asignar el punteo requerido a cada participante que ha ingresado una apuesta valida

    public Resultado verificarResultados(Ficha get, Lista<String> resultadoCarrera, int indice, int puntos, int pasos) {

        if ((resultadoCarrera.getSize() - 1) == indice) {
            pasos++;
            return new Resultado(puntos, get);//Finaliza la recursividad, cuando ya ha asignado todos los valores
        } else if (get.getOrdenCaballos()[indice] == Integer.parseInt(resultadoCarrera.get(indice))) {
            puntos = puntos + (Constantes.CANTIDAD_PUNTOS_MAXIMA - indice);//Si encuentra una similitud en cuanto al orden ingresado y al de la carrera, asigna una puntuación
            pasos++;
        }
        pasos++;
        return verificarResultados(get, resultadoCarrera, indice + 1, puntos, pasos);//realiza la recursividad

    }
//Se encarga de ordenar los resultados por nombres 

    public void obtenerResultadosPorNombres(Lista<Resultado> listado, int pasos) {
        Resultado temp;
        for (int i = 0; i < listado.getSize(); i++) {//Entra a un ciclo y asignación
            pasos++;
            for (int j = i + 1; j < listado.getSize(); j++) {//Entra a un ciclo y asignación
                pasos++;
                if (listado.get(i).getFicha().getApostador().compareTo(listado.get(j).getFicha().getApostador()) > 0) {//Realiza una comparación y asignaciones
                    temp = listado.get(i);
                    listado.modifica(listado.get(j), i);
                    listado.modifica(temp, j);
                    pasos+=3;

                }
            }
        }

    }
//Se encarga de ordenar los resultados por puntaje 

    public void obtenerResultadosPorPuntaje(Lista<Resultado> listado, int pasos) {
        int i, j;
        Resultado aux;
        for (i = 0; i < listado.getSize() - 1; i++) {//Entra a un ciclo y asignación
            pasos++;
            for (j = 0; j < listado.getSize() - i - 1; j++) {//Entra a un ciclo y asignación
                pasos++;
                if (listado.get(j + 1).getPuntajeTotal() > listado.get(j).getPuntajeTotal()) {//Realiza una comparación y asignaciones
                    aux = listado.get(j + 1);
                    listado.modifica(listado.get(j), j + 1);
                    listado.modifica(aux, j);
                    pasos+=3;
                }
            }
        }
    }
//Se encarga de llenar una tabla de resultados o de errores segun sea el caso

    public void llenarTabla(Lista<Object> lista, boolean esErrores) {

        DefaultTableModel modelo = new DefaultTableModel();
        principal.getTablaResultados().getTabla().setModel(modelo);

        if (esErrores) {

            modelo.addColumn("Error");
            Ficha temp;
            for (int i = 0; i < lista.getSize(); i++) {
                temp = (Ficha) lista.get(i);
                modelo.addRow(new Object[]{temp.getDatos()});
            }
        } else {
            modelo.addColumn("Nombre del Apostador");
            modelo.addColumn("Puntos");
            Resultado temp;
            for (int i = 0; i < lista.getSize(); i++) {
                temp = (Resultado) lista.get(i);
                modelo.addRow(new Object[]{temp.getFicha().getApostador(), temp.getPuntajeTotal()});
            }
        }

    }
//Obtiene el número mayor de una lista

    private int obtenerNumeroMayor(Lista<String> lista) {

        int mayor = Integer.parseInt(lista.get(0));
        for (int x = 1; x < lista.getSize(); x++) {
            if (Integer.parseInt(lista.get(x)) > mayor) {
                mayor = Integer.parseInt(lista.get(x));
            }
        }
        return mayor;
    }
//Obtiene el número Menor de una lista

    private int obtenerNumeroMenor(Lista<String> lista) {

        int menor = Integer.parseInt(lista.get(0));
        for (int x = 1; x < lista.getSize(); x++) {
            if (Integer.parseInt(lista.get(x)) < menor) {
                menor = Integer.parseInt(lista.get(x));
            }
        }
        return menor;
    }
//Obtiene el promedio de los pasos de una lista

    private int obtenerPromedio(Lista<String> lista) {

        int promedio = 0;
        for (int x = 0; x < lista.getSize(); x++) {
            promedio += Integer.parseInt(lista.get(x));
        }
        return (promedio / lista.getSize());
    }
//Obtiene los datos correspndientes a los pasos

    public void imprimirPasos(Lista<String> pasos) {
        principal.getVentanaPrincipal().getAreaTexto().setText(principal.getVentanaPrincipal().getAreaTexto().getText() + "\nMayor cantidad de Pasos: " + obtenerNumeroMayor(pasos));
        principal.getVentanaPrincipal().getAreaTexto().setText(principal.getVentanaPrincipal().getAreaTexto().getText() + "\nMenor cantidad de Pasos: " + obtenerNumeroMenor(pasos));
        principal.getVentanaPrincipal().getAreaTexto().setText(principal.getVentanaPrincipal().getAreaTexto().getText() + "\nPasos Promedio: " + obtenerPromedio(pasos));
    }

}
