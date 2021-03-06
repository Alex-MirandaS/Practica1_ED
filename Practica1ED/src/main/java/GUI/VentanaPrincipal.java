/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Principal.Principal;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Principal principal;

    public VentanaPrincipal(Principal principal) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.principal = principal;
        verificarApuestas.setEnabled(false);
        ingresarResultados.setEnabled(false);
        entregaResultados.setEnabled(false);
    }

    public JTextArea getAreaTexto() {
        return areaTexto;
    }

    public void setAreaTexto(JTextArea areaTexto) {
        this.areaTexto = areaTexto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ingresarAupuestas = new javax.swing.JButton();
        verificarApuestas = new javax.swing.JButton();
        ingresarResultados = new javax.swing.JButton();
        entregaResultados = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        salir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(2, 4));

        ingresarAupuestas.setBackground(new java.awt.Color(0, 0, 0));
        ingresarAupuestas.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        ingresarAupuestas.setForeground(new java.awt.Color(255, 255, 255));
        ingresarAupuestas.setText("Ingresar Apuestas");
        ingresarAupuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarAupuestasActionPerformed(evt);
            }
        });
        jPanel2.add(ingresarAupuestas);

        verificarApuestas.setBackground(new java.awt.Color(0, 0, 0));
        verificarApuestas.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        verificarApuestas.setForeground(new java.awt.Color(255, 255, 255));
        verificarApuestas.setText("Verificar Apuestas");
        verificarApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarApuestasActionPerformed(evt);
            }
        });
        jPanel2.add(verificarApuestas);

        ingresarResultados.setBackground(new java.awt.Color(0, 0, 0));
        ingresarResultados.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        ingresarResultados.setForeground(new java.awt.Color(255, 255, 255));
        ingresarResultados.setText("Ingresar Resultados");
        ingresarResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarResultadosActionPerformed(evt);
            }
        });
        jPanel2.add(ingresarResultados);

        entregaResultados.setBackground(new java.awt.Color(0, 0, 0));
        entregaResultados.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        entregaResultados.setForeground(new java.awt.Color(255, 255, 255));
        entregaResultados.setText("Entrega de Resultados");
        entregaResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entregaResultadosActionPerformed(evt);
            }
        });
        jPanel2.add(entregaResultados);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jPanel5);

        salir.setBackground(new java.awt.Color(0, 0, 0));
        salir.setFont(new java.awt.Font("Noto Serif CJK KR", 2, 12)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel2.add(salir);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jPanel8, java.awt.BorderLayout.LINE_END);

        areaTexto.setBackground(new java.awt.Color(102, 102, 102));
        areaTexto.setColumns(20);
        areaTexto.setForeground(new java.awt.Color(0, 0, 0));
        areaTexto.setRows(5);
        jScrollPane2.setViewportView(areaTexto);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarAupuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarAupuestasActionPerformed
        principal.ingresarApuestas();
        verificarApuestas.setEnabled(true);
        ingresarResultados.setEnabled(true);
    }//GEN-LAST:event_ingresarAupuestasActionPerformed

    private void entregaResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entregaResultadosActionPerformed
        principal.ordenarResultados(true);
        principal.getTablaResultados().setVisible(true);
    }//GEN-LAST:event_entregaResultadosActionPerformed

    private void verificarApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarApuestasActionPerformed
        principal.verificarApuestas();

    }//GEN-LAST:event_verificarApuestasActionPerformed

    private void ingresarResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarResultadosActionPerformed
        principal.getEditorResultados().setVisible(true);
        entregaResultados.setEnabled(true);
    }//GEN-LAST:event_ingresarResultadosActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton entregaResultados;
    private javax.swing.JButton ingresarAupuestas;
    private javax.swing.JButton ingresarResultados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton salir;
    private javax.swing.JButton verificarApuestas;
    // End of variables declaration//GEN-END:variables
}
