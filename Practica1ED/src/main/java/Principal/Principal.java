/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Archivos.LectorArchivosEnTexto;
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
    private TablaResultados tablaResultados = new TablaResultados();

    private LectorArchivosEnTexto lector = new LectorArchivosEnTexto();
    private Controlador controlador = new Controlador(this);
    private Lista<Ficha> apuestas = new Lista<>();
    private Lista<Ficha> errores = new Lista<>();
    private Lista<Resultado> resultados = new Lista<>();

    public void iniciar() {
        ventanaPrincipal.setVisible(true);
    }

    public void ingresarApuestas() {
        editorResultados = new EditorResultados(this);
        apuestas = controlador.obtenerDatosTexto();
        ventanaPrincipal.getAreaTexto().setText("Apuestas Cargadas Correctamente");
    }

    public void verificarApuestas() {

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
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\n" + "Apuestas ingresadas Exitosamente"
                + "\nApuestas Validas: " + apuestas.getSize()
                + "\nApuestas Invalidas: " + errores.getSize());
    }

    public void calcularResultados(Lista<String> resultadoCarrera) {
        for (int i = 0; i < apuestas.getSize(); i++) {
            resultados.add(controlador.verificarResultados(apuestas.get(i), resultadoCarrera, 0, 0));
        }
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\nResultados calculados exitosamente");
    }

    public void ordenarResultados(boolean esPunteos) {
        if (esPunteos) {
            controlador.obtenerResultadosPorPuntaje(resultados);
        } else {
            controlador.obtenerResultadosPorNombres(resultados);
        }
        controlador.llenarTabla(resultados);
    }

    public void llenarCaballos(JComboBox<String> caballosDisponibles) {
        caballosDisponibles.removeAllItems();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (int i = 1; i <= Constantes.CANTIDAD_CABALLOS; i++) {
            modeloCombo.addElement(i);
        }
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
