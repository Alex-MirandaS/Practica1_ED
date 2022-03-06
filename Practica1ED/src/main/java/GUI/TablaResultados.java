/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Principal.Principal;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Alex
 */
public class TablaResultados extends javax.swing.JFrame {
    
    Principal principal;
    
    public TablaResultados(Principal principal) {
        initComponents();
        this.principal = principal;
        principal.llenarDatos(tiposOrdenamiento);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        exportarErrores.setEnabled(false);
    }
    
    public JTable getTabla() {
        return tabla;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        mostrarResultadoApuestas = new javax.swing.JButton();
        mostrarErrores = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tiposOrdenamiento = new javax.swing.JComboBox<>();
        exportarApuestas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        exportarErrores = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        salir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RESULTADOS");

        tabla.setBackground(new java.awt.Color(0, 0, 0));
        tabla.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2));

        mostrarResultadoApuestas.setBackground(new java.awt.Color(0, 0, 0));
        mostrarResultadoApuestas.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        mostrarResultadoApuestas.setForeground(new java.awt.Color(255, 255, 255));
        mostrarResultadoApuestas.setText("Resultado de Apuestas");
        mostrarResultadoApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarResultadoApuestasActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarResultadoApuestas);

        mostrarErrores.setBackground(new java.awt.Color(0, 0, 0));
        mostrarErrores.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        mostrarErrores.setForeground(new java.awt.Color(255, 255, 255));
        mostrarErrores.setText("Apuestas Invalidas");
        mostrarErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarErroresActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarErrores);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        tiposOrdenamiento.setBackground(new java.awt.Color(0, 0, 0));
        tiposOrdenamiento.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        tiposOrdenamiento.setForeground(new java.awt.Color(255, 255, 255));
        tiposOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(tiposOrdenamiento);

        exportarApuestas.setBackground(new java.awt.Color(0, 0, 0));
        exportarApuestas.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        exportarApuestas.setForeground(new java.awt.Color(255, 255, 255));
        exportarApuestas.setText("Exportar");
        exportarApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarApuestasActionPerformed(evt);
            }
        });
        jPanel3.add(exportarApuestas);

        jPanel1.add(jPanel3);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jPanel5);

        exportarErrores.setBackground(new java.awt.Color(0, 0, 0));
        exportarErrores.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        exportarErrores.setForeground(new java.awt.Color(255, 255, 255));
        exportarErrores.setText("Exportar");
        exportarErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarErroresActionPerformed(evt);
            }
        });
        jPanel2.add(exportarErrores);

        jPanel1.add(jPanel2);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jPanel4);

        salir.setBackground(new java.awt.Color(0, 0, 0));
        salir.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel8, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarResultadoApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarResultadoApuestasActionPerformed
        tiposOrdenamiento.setEnabled(true);
        exportarApuestas.setEnabled(true);
        exportarErrores.setEnabled(false);
        boolean esPunteo = false;
        if (tiposOrdenamiento.getSelectedIndex() != 0) {
            esPunteo = true;
        }
        principal.ordenarResultados(esPunteo);
    }//GEN-LAST:event_mostrarResultadoApuestasActionPerformed

    private void mostrarErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarErroresActionPerformed
        tiposOrdenamiento.setEnabled(false);
        exportarApuestas.setEnabled(false);
        exportarErrores.setEnabled(true);
        principal.mostrarErrores();
    }//GEN-LAST:event_mostrarErroresActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_salirActionPerformed

    private void exportarApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarApuestasActionPerformed
        principal.exportarReportes(false);
    }//GEN-LAST:event_exportarApuestasActionPerformed

    private void exportarErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarErroresActionPerformed
        principal.exportarReportes(true);
    }//GEN-LAST:event_exportarErroresActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportarApuestas;
    private javax.swing.JButton exportarErrores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mostrarErrores;
    private javax.swing.JButton mostrarResultadoApuestas;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox<String> tiposOrdenamiento;
    // End of variables declaration//GEN-END:variables
}
