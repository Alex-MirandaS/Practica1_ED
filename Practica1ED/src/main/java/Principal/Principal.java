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
//Se encarga de ingresar las apuestas

    public void ingresarApuestas() {
        reinicio();
        long inicioTiempo = System.currentTimeMillis();
        apuestas = controlador.obtenerDatosTexto(pasosIngresarApuesta);
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText("Apuestas Cargadas Correctamente" + "\n");
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText() + "Tiempo de la Ejecución (en Segundos): " + ((finTiempo - inicioTiempo) / 1000));
        controlador.imprimirPasos(pasosIngresarApuesta);
    }
//Se encarga de verificar las apuestas

    public void verificarApuestas() {
        long inicioTiempo = System.currentTimeMillis();
        
        for (int i = 0; i < apuestas.getSize(); i++) {
            int pasos = 1;//selecciona una apuesta
            String[] datos = apuestas.get(i).getDatos().split(",");            //asigna un valor
            pasos++;
            if (datos.length == Constantes.CANTIDAD_DATOS) {//realiza una verificación
                pasos++;
                try {
                    apuestas.get(i).setApostador(datos[0]);
                    apuestas.get(i).setMonto(Double.parseDouble(datos[1]));//asigna dos valores
                    pasos += 2;
                    int[] numeros = controlador.obtenerNumeros(datos, pasos);
                    
                    if (!controlador.esRepetido(numeros, pasos)) {
                        apuestas.get(i).setOrdenCaballos(numeros);//asigna el valor obtenido de los caballos
                    } else {
                        errores.add(apuestas.get(i));//asigna el valor como un error
                        apuestas.eliminar(i);//elimina el valor de la lista de apuestas
                        i--;//regresa un paso
                        pasos += 3;
                    }
                    
                } catch (NumberFormatException e) {
                    errores.add(apuestas.get(i));//asigna el valor como un error
                    apuestas.eliminar(i);//elimina el valor de la lista de apuestas
                    i--;//regresa un paso
                    pasos += 3;
                }
            } else {
                errores.add(apuestas.get(i));//asigna el valor como un error
                apuestas.eliminar(i);//elimina el valor de la lista de apuestas
                i--;//regresa un paso
                pasos += 3;
            }
            pasosVerificarApuestas.add("" + pasos);
        }
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\n" + "Apuestas ingresadas Exitosamente"
                + "\nApuestas Validas: " + apuestas.getSize()
                + "\nApuestas Invalidas: " + errores.getSize());
        controlador.imprimirPasos(pasosVerificarApuestas);
    }
//Se encarga de calcular y asignar los resultados

    public void calcularResultados(Lista<String> resultadoCarrera) {
        long inicioTiempo = System.currentTimeMillis();
        for (int i = 0; i < apuestas.getSize(); i++) {
            int pasos = 1;//selecciona una apuesta y verifica su resultado
            resultados.add(controlador.verificarResultados(apuestas.get(i), resultadoCarrera, 0, 0, pasos));
            pasosCalculoResultados.add("" + pasos);
        }
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\nResultados calculados exitosamente"
                + "\nTiempo de la Ejecución (en Segundos): " + (finTiempo - inicioTiempo));
        controlador.imprimirPasos(pasosCalculoResultados);
        
    }
//Se encarga de exportar la información

    public void exportarReportes(boolean esErrores) {
        if (esErrores) {
            exportarReporteCSV.generarReporte("Errores", (Lista<Object>) (Object) errores, esErrores);
        } else {
            exportarReporteCSV.generarReporte("Resultados de las Apuestas", (Lista<Object>) (Object) resultados, esErrores);
        }
    }
//Se encarga del ordenamiento de resultados

    public void ordenarResultados(boolean esPunteos) {
        long inicioTiempo = System.currentTimeMillis();
        int pasos = 1;
        if (esPunteos) {//Realiza una verificación
            controlador.obtenerResultadosPorPuntaje(resultados, pasos);
            ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                    + "\nResultados ordenados por Puntaje");
        } else {
            controlador.obtenerResultadosPorNombres(resultados, pasos);
            ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                    + "\nResultados ordenados Alfabeticamente");
        }
        long finTiempo = System.currentTimeMillis();
        pasosOrdenamientoResultados.add("" + pasos);
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\nTiempo de la Ejecución (en Segundos): " + (finTiempo - inicioTiempo));
        controlador.imprimirPasos(pasosOrdenamientoResultados);
        controlador.llenarTabla((Lista<Object>) (Object) resultados, false);
    }
//Se encarga de mostrar los errores

    public void mostrarErrores() {
        long inicioTiempo = System.currentTimeMillis();
        controlador.llenarTabla((Lista<Object>) (Object) errores, true);
        long finTiempo = System.currentTimeMillis();
        ventanaPrincipal.getAreaTexto().setText(ventanaPrincipal.getAreaTexto().getText()
                + "\nSe muestran las Apuestas Incorrectas"
                + "\nTiempo de la Ejecución (en Segundos): " + (finTiempo - inicioTiempo));
    }
//Se encarga de llenar la lista de caballos que correran en la carrera

    public void llenarCaballos(JComboBox<String> caballosDisponibles) {
        caballosDisponibles.removeAllItems();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for (int i = 1; i <= Constantes.CANTIDAD_CABALLOS; i++) {
            modeloCombo.addElement(i);
        }
        caballosDisponibles.setModel(modeloCombo);
        
    }
//Se encarga de llenar la lista de opciones de ordenamiento

    public void llenarDatos(JComboBox<String> caballosDisponibles) {
        caballosDisponibles.removeAllItems();
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        
        modeloCombo.addElement("Orden Alfabetico");
        modeloCombo.addElement("Orden por Puntaje");
        
        caballosDisponibles.setModel(modeloCombo);
        
    }
//Se encarga de reiniciar valores cuando ingresan nuevas apuestas de una carrera

    public void reinicio() {
        editorResultados = new EditorResultados(this);
        tablaResultados = new TablaResultados(this);
        pasosCalculoResultados = new Lista<>();
        pasosIngresarApuesta = new Lista<>();
        pasosOrdenamientoResultados = new Lista<>();
        pasosVerificarApuestas = new Lista<>();
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
