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
    
//     public void wirterCsv(String csvFileName, Lista<Object> datos) 
//    throws FileNotFoundException, UnsupportedEncodingException {
//        File csvOutputFile = new File(csvFileName);
//        try (PrintWriter pw = new PrintWriter(csvOutputFile, "GBK")) {
//            data.stream()
//                .map(this::convertToCSV)
//                .forEach(pw::println);
//        }
//    }
//  
//    public String convertToCSV(String[] data) {
//        return Stream.of(data)
//            .map(this::escapeSpecialCharacters)
//            .collect(Collectors.joining(","));
//    }
// 
//    public String escapeSpecialCharacters(String data) {
//        String escapedData = data.replaceAll("\\R", " ");
//        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
//            data = data.replace("\"", "\"\"");
//            escapedData = "\"" + data + "\"";
//        }
//        return escapedData;
//    }
//
//    
//      public void generarReporte(HttpServletResponse response, String nombre, ArrayList<Venta>arrayList, ReportesEnum tipoReporte) {
//
//        String columnas = evaluarColumnas(tipoReporte);
//        String reporte = "";
//        reporte += columnas + "\n";
//        for (int i = 0; i < arrayList.size(); i++) {
//            Venta datosTemp = arrayList.get(i);
//            String fila = evaluarTipoReporte(datosTemp, tipoReporte);
//            reporte += fila;
//        }
//        exportar(response, reporte, nombre);
//    }
//
//    private void exportar(HttpServletResponse response, String reporte, String nombre) {
//        response.setContentType("text/csv;charset=UTF-8");
//        response.setHeader("Content-Disposition", "attatchment; filename=" + nombre + ".csv");
//        try (PrintWriter writer = response.getWriter();) {
//            writer.println(reporte);
//        } catch (IOException e) {
//        }
//    }
//
//    private String evaluarColumnas(ReportesEnum tipoReporte) {
//        switch (tipoReporte) {
//            case ReporteGanancias:
//                return "ID FACTURA;ID PRODUCTO;PRODUCTO;COSTO;PRECIO VENTA;GANANCIA;NIT CLIENTE;FECHA DE VENTA";
//            case ReporteMuebleMasVendido:
//                return "ID FACTURA;ID PRODUCTO;PRODUCTO;COSTO;PRECIO VENTA;GANANCIA;NIT CLIENTE;FECHA DE VENTA";
//            case ReporteMuebleMenosVendido:
//                return "ID FACTURA;ID PRODUCTO;PRODUCTO;COSTO;PRECIO VENTA;GANANCIA;NIT CLIENTE;FECHA DE VENTA";
//            case ReporteUsuarioVentas:
//                return "ID FACTURA;ID PRODUCTO;PRODUCTO;PRECIO VENTA;CLIENTE;FECHA DE VENTA";
//            case ReporteVentas:
//                return "ID FACTURA;ID PRODUCTO;PRODUCTO;PRECIO;CLIENTE;FECHA DE VENTA";
//            default:
//                return "";
//        }
//    }
//
//    private String evaluarTipoReporte(Venta datosTemp, ReportesEnum tipoReporte) {
//        switch (tipoReporte) {
//            case ReporteGanancias:
//                return datosTemp.getFactura().getIdFactura() + ";" + datosTemp.getMuebleEnsamblado().getIdEnsamblajeMueble() + ";" + datosTemp.getMuebleEnsamblado().getMueble().getNombreMueble() + ";"
//                        + datosTemp.getMuebleEnsamblado().getCostoEnsamblaje() + ";" + datosTemp.getPrecioMuebleVendido() + ";" + ((datosTemp.getPrecioMuebleVendido()) - (datosTemp.getMuebleEnsamblado().getCostoEnsamblaje())) + ";"
//                        + datosTemp.getCliente().getNIT() + ";" + datosTemp.getFechaVenta() + "\n";
//            case ReporteMuebleMasVendido:
//                return datosTemp.getFactura().getIdFactura() + ";" + datosTemp.getMuebleEnsamblado().getIdEnsamblajeMueble() + ";" + datosTemp.getMuebleEnsamblado().getMueble().getNombreMueble() + ";"
//                        + datosTemp.getMuebleEnsamblado().getCostoEnsamblaje() + ";" + datosTemp.getPrecioMuebleVendido() + ";" + ((datosTemp.getPrecioMuebleVendido()) - (datosTemp.getMuebleEnsamblado().getCostoEnsamblaje())) + ";"
//                        + datosTemp.getCliente().getNIT() + ";" + datosTemp.getFechaVenta() + "\n";
//            case ReporteMuebleMenosVendido:
//                return datosTemp.getFactura().getIdFactura() + ";" + datosTemp.getMuebleEnsamblado().getIdEnsamblajeMueble() + ";" + datosTemp.getMuebleEnsamblado().getMueble().getNombreMueble() + ";"
//                        + datosTemp.getMuebleEnsamblado().getCostoEnsamblaje() + ";" + datosTemp.getPrecioMuebleVendido() + ";" + ((datosTemp.getPrecioMuebleVendido()) - (datosTemp.getMuebleEnsamblado().getCostoEnsamblaje())) + ";"
//                        + datosTemp.getCliente().getNIT() + ";" + datosTemp.getFechaVenta() + "\n";
//            case ReporteUsuarioVentas:
//                return datosTemp.getFactura().getIdFactura() + ";" + datosTemp.getMuebleEnsamblado().getIdEnsamblajeMueble() + ";" + datosTemp.getMuebleEnsamblado().getMueble().getNombreMueble() + ";"
//                        +  datosTemp.getPrecioMuebleVendido() + ";" + datosTemp.getCliente().getNIT() + ";" + datosTemp.getFechaVenta() + "\n";
//            case ReporteVentas:
//                return datosTemp.getFactura().getIdFactura() + ";" + datosTemp.getMuebleEnsamblado().getIdEnsamblajeMueble() + ";" + datosTemp.getMuebleEnsamblado().getMueble().getNombreMueble() + ";"
//                        + datosTemp.getPrecioMuebleVendido() + ";" + datosTemp.getCliente().getNIT() + ";" + datosTemp.getFechaVenta() + "\n";
//            default:
//                return "";
//        }
//    }
}
