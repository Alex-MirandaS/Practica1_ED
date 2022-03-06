/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Archivos.LectorArchivosEnTexto;
import Exportar.ExportarReporteCSV;
import GUI.EditorResultados;
import GUI.TablaResultados;
import GUI.VentanaPrincipal;
import Listas.Lista;
import Objetos.Ficha;
import Objetos.Resultado;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author alex
 */
public class Principal {

    private VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this);
    private EditorResultados editorResultados = new EditorResultados(this);
    private TablaResultados tablaResultados = new TablaResultados(this);

    private LectorArchivosEnTexto lector = new LectorArchivosEnTexto();
    private Controlador controlador = new Controlador(this);
    private ExportarReporteCSV exportarReporteCSV = new ExportarReporteCSV();
    private Lista<Ficha> apuestas = new Lista<>();
    private Lista<Ficha> errores = new Lista<>();
    private Lista<Resultado> resultados = new Lista<>();
    //Pasos
    private Lista<String> pasosIngresarApuesta = new Lista<>();
    private Lista<String> pasosVerificarApuestas = new Lista<>();
    private Lista<String> pasosCalculoResultados = new Lista<>();
    private Lista<String> pasosOrdenamientoResultados = new Lista<>();

    public void iniciar() {
        ventanaPrincipal.setVisible(true);
    }

    public void ingresarApuestas() {
        editorResultados = new EditorResultados(this);
        tablaResultados = new TablaResultados(this);
        long inicioTiempo = System.currentTimeMillis();
        apuestas = controlador.obtenerDatosTexto(pasosIngresarApuesta);
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText("Apuestas Cargadas Correctamente" + "\n");
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText() + "Tiempo de la Ejecución (en Segundos): " + ((finTiempo - inicioTiempo) / 1000));
        controlador.pasos(pasosIngresarApuesta);
    }

    public void verificarApuestas() {
        long inicioTiempo = System.currentTimeMillis();
        int pasos = 0;
        for (int i = 0; i < apuestas.getSize(); i++) {
            String[] datos = apuestas.get(i).getDatos().split(",");

            if (datos.length == Constantes.CANTIDAD_DATOS) {
                try {
                    apuestas.get(i).setApostador(datos[0]);
                    apuestas.get(i).setMonto(Double.parseDouble(datos[1]));
                    int[] numeros = controlador.obtenerNumeros(datos);

                    if (!controlador.esRepetido(numeros)) {
                        apuestas.get(i).setOrdenCaballos(numeros);
                    } else {
                        errores.add(apuestas.get(i));
                        apuestas.eliminar(i);
                        i--;
                    }

                } catch (NumberFormatException e) {
                    errores.add(apuestas.get(i));
                    apuestas.eliminar(i);
                    i--;
                }
            } else {
                errores.add(apuestas.get(i));
                apuestas.eliminar(i);
                i--;
            }
        }
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\n" + "Apuestas ingresadas Exitosamente"
                + "\nApuestas Validas: " + apuestas.getSize()
                + "\nApuestas Invalidas: " + errores.getSize()
                + "\nTiempo de la Ejecución (en Segundos): " + (finTiempo - inicioTiempo));
    }

    public void calcularResultados(Lista<String> resultadoCarrera) {
        long inicioTiempo = System.currentTimeMillis();
        for (int i = 0; i < apuestas.getSize(); i++) {
            resultados.add(controlador.verificarResultados(apuestas.get(i), resultadoCarrera, 0, 0));
        }
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\nResultados calculados exitosamente"
                + "\nTiempo de la Ejecución (en Segundos): " + (finTiempo - inicioTiempo));

    }

    public void exportarReportes(boolean esErrores) {
        if (esErrores) {
            exportarReporteCSV.generarReporte("Errores", (Lista<Object>) (Object) errores, esErrores);
        } else {
            exportarReporteCSV.generarReporte("Resultados de las Apuestas", (Lista<Object>) (Object) resultados, esErrores);
        }
    }

    public void ordenarResultados(boolean esPunteos) {
        long inicioTiempo = System.currentTimeMillis();
        if (esPunteos) {
            controlador.obtenerResultadosPorPuntaje(resultados);
            ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                    + "\nResultados ordenados por Puntaje");
        } else {
            controlador.obtenerResultadosPorNombres(resultados);
            ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                    + "\nResultados ordenados Alfabeticamente");
        }
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\nTiempo de la Ejecución (en Segundos): " + (finTiempo - inicioTiempo));
        controlador.llenarTabla((Lista<Object>) (Object) resultados, false);
    }

    public void mostrarErrores() {
        long inicioTiempo = System.currentTimeMillis();
        controlador.llenarTabla((Lista<Object>) (Object) errores, true);
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\nSe muestran las Apuestas Incorrectas"
                + "\nTiempo de la Ejecución (en Segundos): " + (finTiempo - inicioTiempo));
    }

    public void llenarCaballos(JComboBox<String> caballosDisponibles) {
        caballosDisponibles.removeAllItems();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (int i = 1; i <= Constantes.CANTIDAD_CABALLOS; i++) {
            modeloCombo.addElement(i);
        }
        caballosDisponibles.setModel(modeloCombo);

    }

    public void llenarDatos(JComboBox<String> caballosDisponibles) {
        caballosDisponibles.removeAllItems();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

        modeloCombo.addElement("Orden Alfabetico");
        modeloCombo.addElement("Orden por Puntaje");

        caballosDisponibles.setModel(modeloCombo);

    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventajaPrincipal) {
        this.ventanaPrincipal = ventajaPrincipal;
    }

    public LectorArchivosEnTexto getLector() {
        return lector;
    }

    public void setLector(LectorArchivosEnTexto lector) {
        this.lector = lector;
    }

    public TablaResultados getTablaResultados() {
        return tablaResultados;
    }

    public void setTablaResultados(TablaResultados tablaResultados) {
        this.tablaResultados = tablaResultados;
    }

    public EditorResultados getEditorResultados() {
        return editorResultados;
    }

    public void setEditorResultados(EditorResultados editorResultados) {
        this.editorResultados = editorResultados;
    }

}
