/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Listas.Lista;
import Principal.Principal;

/**
 *
 * @author alex
 */
public class EditorResultados extends javax.swing.JFrame {

    private Principal principal;
    private int orden = 1;
    private Lista<String> ordenCaballos = new Lista<>();

    public EditorResultados(Principal principal) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.principal = principal;
        numeroCaballo.setText("" + orden);
        cambios.setText("Posiciones de los Caballos");
        principal.llenarCaballos(caballosDispuestos);
        aceptar.setEnabled(false);
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
        jPanel10 = new javax.swing.JPanel();
        salir = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cambios = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        numeroCaballo = new javax.swing.JLabel();
        caballosDispuestos = new javax.swing.JComboBox<>();
        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        agregarCaballo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10);

        salir.setBackground(new java.awt.Color(0, 0, 0));
        salir.setFont(new java.awt.Font("Noto Sans CJK KR", 2, 12)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir);

        aceptar.setBackground(new java.awt.Color(0, 0, 0));
        aceptar.setFont(new java.awt.Font("Noto Sans CJK KR", 2, 12)); // NOI18N
        aceptar.setForeground(new java.awt.Color(255, 255, 255));
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(aceptar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jPanel8, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        cambios.setBackground(new java.awt.Color(102, 102, 102));
        cambios.setColumns(20);
        cambios.setFont(new java.awt.Font("Noto Sans CJK KR", 2, 12)); // NOI18N
        cambios.setForeground(new java.awt.Color(0, 0, 0));
        cambios.setRows(5);
        jScrollPane1.setViewportView(cambios);

        jPanel2.add(jScrollPane1);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel22.setLayout(new java.awt.GridLayout(4, 2));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Noto Sans CJK KR", 2, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Posici??n del Caballo:");
        jPanel22.add(jLabel13);

        numeroCaballo.setBackground(new java.awt.Color(0, 0, 0));
        numeroCaballo.setFont(new java.awt.Font("Noto Sans CJK KR", 2, 12)); // NOI18N
        numeroCaballo.setForeground(new java.awt.Color(0, 0, 0));
        numeroCaballo.setText("NUMERO XD");
        jPanel22.add(numeroCaballo);

        caballosDispuestos.setBackground(new java.awt.Color(0, 0, 0));
        caballosDispuestos.setFont(new java.awt.Font("Noto Sans CJK KR", 2, 12)); // NOI18N
        caballosDispuestos.setForeground(new java.awt.Color(255, 255, 255));
        caballosDispuestos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel22.add(caballosDispuestos);

        jPanel21.setLayout(new java.awt.GridLayout(1, 2));

        jPanel20.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        jPanel21.add(jPanel20);

        agregarCaballo.setBackground(new java.awt.Color(0, 0, 0));
        agregarCaballo.setFont(new java.awt.Font("Noto Sans CJK KR", 2, 12)); // NOI18N
        agregarCaballo.setForeground(new java.awt.Color(255, 255, 255));
        agregarCaballo.setText("OK");
        agregarCaballo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCaballoActionPerformed(evt);
            }
        });
        jPanel21.add(agregarCaballo);

        jPanel22.add(jPanel21);

        jPanel3.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        principal.calcularResultados(ordenCaballos);
        this.setVisible(false);
    }//GEN-LAST:event_aceptarActionPerformed

    private void agregarCaballoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCaballoActionPerformed
        ordenCaballos.add(caballosDispuestos.getSelectedItem().toString());
        cambios.setText(cambios.getText() + "\nCaballo en la posici??n " + orden + ":\n" + caballosDispuestos.getSelectedItem().toString());
        orden++;
        numeroCaballo.setText("" + orden);
        caballosDispuestos.removeItemAt(caballosDispuestos.getSelectedIndex());
        if (caballosDispuestos.getItemCount() == 0) {
            caballosDispuestos.setEnabled(false);
            numeroCaballo.setText("Ya se agregaron todos los caballos");
            agregarCaballo.setEnabled(false);
            aceptar.setEnabled(true);
        }
    }//GEN-LAST:event_agregarCaballoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_salirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton agregarCaballo;
    private javax.swing.JComboBox<String> caballosDispuestos;
    private javax.swing.JTextArea cambios;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numeroCaballo;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
