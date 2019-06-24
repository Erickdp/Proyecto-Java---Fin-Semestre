/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.vista;

import com.zoolomania.funcional.control.GuiaTrs;
import com.zoolomania.funcional.control.ItinerarioTrs;
import com.zoolomania.funcional.control.MyExcepcion;
import com.zoolomania.funcional.control.UtilGestion;
import com.zoolomania.funcional.modelo.Guia;
import com.zoolomania.funcional.modelo.Itinerario;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick Díaz
 */
public class frmGuia extends javax.swing.JFrame {

    GuiaTrs gtrs = new GuiaTrs();
    ItinerarioTrs itrs = new ItinerarioTrs();
    List<Guia> guias = gtrs.listar();
    List<Itinerario> itinerarios = itrs.listar();
    boolean bandera = false;

    private void cargarTablaI() {
        Object[] columna = {"ID", "Codigo", "N° Especies visitadas", "Duración (HH/mm)", "N° Max. Personas", "Longitud (Km)"};
        DefaultTableModel modeloI = new DefaultTableModel(columna, 0);
        for (Itinerario i : itinerarios) {
            short id = i.getId();
            String codigo = i.getCodigo();
            int especies = i.especiesVisitadas(i.getZonas());
            LocalTime duracion = i.getDuracionRecorrido();
            byte personas = i.getNumMaxVisitantes();
            float longitud = i.getLongitud();
            Object[] fila = {id, codigo, especies, duracion, personas, longitud};
            modeloI.addRow(fila);
        }
        this.tablaI.setModel(modeloI);
    }

    private void cargarTablaG() {
        Object[] columna = {"ID", "Nombre", "Dirección", "Teléfono", "Fecha Inicio Trabajo"};
        DefaultTableModel modeloG = new DefaultTableModel(columna, 0);
        for (Guia g : guias) {
            short id = g.getId();
            String nombre = g.getNombre();
            String direccion = g.getDireccion();
            String telefono = g.getTelefono();
            LocalDateTime fecha = g.getFechInicioTrabajar();
            Object[] fila = {id, nombre, direccion, telefono, fecha};
            modeloG.addRow(fila);
        }
        this.tablaG.setModel(modeloG);
    }

    /**
     * Creates new form frmGuia
     */
    public frmGuia() {
        initComponents();
        cargarTablaI();
        cargarTablaG();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jNada = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDireccion = new javax.swing.JTextField();
        bEliminar = new javax.swing.JButton();
        bAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bRegresar = new javax.swing.JButton();
        bRelacion = new javax.swing.JButton();
        bOrdenar = new javax.swing.JButton();
        cBox = new javax.swing.JComboBox<>();
        rAscendente = new javax.swing.JRadioButton();
        rDescendente = new javax.swing.JRadioButton();
        bAgregar1 = new javax.swing.JButton();
        bEliminar1 = new javax.swing.JButton();
        bOrdenar1 = new javax.swing.JButton();
        rAscendente1 = new javax.swing.JRadioButton();
        rDescendente1 = new javax.swing.JRadioButton();
        cBoxO = new javax.swing.JComboBox<>();
        bRelacion1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaI = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaG = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jNada.setText("ID");

        jLabel2.setText("Nombre");

        jLabel4.setText("Telefono");

        jLabel5.setText("Direcicion");

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bRegresar.setText("Regresar");
        bRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegresarActionPerformed(evt);
            }
        });

        bRelacion.setText("ver Relacion");
        bRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRelacionActionPerformed(evt);
            }
        });

        bOrdenar.setText("Ordenar");
        bOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdenarActionPerformed(evt);
            }
        });

        cBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Id" }));
        cBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxActionPerformed(evt);
            }
        });

        buttonGroup1.add(rAscendente);
        rAscendente.setSelected(true);
        rAscendente.setText("Ascendente");

        buttonGroup1.add(rDescendente);
        rDescendente.setText("Descendente");

        bAgregar1.setText("Agregar");
        bAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregar1ActionPerformed(evt);
            }
        });

        bEliminar1.setText("Eliminar");
        bEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminar1ActionPerformed(evt);
            }
        });

        bOrdenar1.setText("Ordenar");
        bOrdenar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdenar1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rAscendente1);
        rAscendente1.setSelected(true);
        rAscendente1.setText("Ascendente");

        buttonGroup2.add(rDescendente1);
        rDescendente1.setText("Descendente");

        cBoxO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Id" }));
        cBoxO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxOActionPerformed(evt);
            }
        });

        bRelacion1.setText("Ver Todo");
        bRelacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRelacion1ActionPerformed(evt);
            }
        });

        tablaI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaI);

        tablaG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaG);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jNada, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(bRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bAgregar)
                            .addComponent(bOrdenar))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rAscendente)
                                .addGap(30, 30, 30)
                                .addComponent(rDescendente)
                                .addGap(52, 52, 52)
                                .addComponent(cBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(63, 63, 63)
                                .addComponent(bRelacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bAgregar1)
                                            .addComponent(bOrdenar1))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(bEliminar1)
                                                .addGap(169, 169, 169)
                                                .addComponent(bRelacion1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rAscendente1)
                                                .addGap(30, 30, 30)
                                                .addComponent(rDescendente1)
                                                .addGap(52, 52, 52)
                                                .addComponent(cBoxO, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(648, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNada, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(bRegresar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bEliminar)
                            .addComponent(bAgregar)
                            .addComponent(jButton1)
                            .addComponent(bRelacion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bEliminar1)
                            .addComponent(bAgregar1)
                            .addComponent(bRelacion1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bOrdenar1)
                            .addComponent(cBoxO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rAscendente1)
                            .addComponent(rDescendente1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOrdenar)
                    .addComponent(cBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rAscendente)
                    .addComponent(rDescendente))
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(303, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxActionPerformed

    private void cBoxOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxOActionPerformed

    private void bRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegresarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new frmMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_bRegresarActionPerformed

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        // TODO add your handling code here:
        if (!validarCampos()) {
            try {
                gtrs.guardar(new Guia(jNombre.getText(), jDireccion.getText(), jTelefono.getText(),
                        Short.parseShort(jid.getText())));
                jNombre.setText("");
                jTelefono.setText("");
                jDireccion.setText("");
            } catch (MyExcepcion ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
            } finally {
                jid.setText("");
                cargarTablaG();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bAgregarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        if (tablaG.getSelectedRow() > -1) {
            try {
                UtilGestion.eliminacionCompleta(guias.get(tablaG.getSelectedRow()));
                gtrs.eliminar(guias.get(tablaG.getSelectedRow()));
            } catch (MyExcepcion ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Error al Eliminar", JOptionPane.ERROR_MESSAGE);
            } finally {
                cargarTablaG();
                itinerarios = itrs.listar();
                cargarTablaI();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor elija la fila a eliminar",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (tablaG.getSelectedRow() > -1 & !validarCampos()) {
            JOptionPane.showMessageDialog(null, "Solo el ID no puede ser actualizado",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            try {
                gtrs.actulizar(new Guia(jNombre.getText(),
                        jDireccion.getText(), jTelefono.getText(), guias.get(tablaG.getSelectedRow()).getId()));
                jNombre.setText("");
                jTelefono.setText("");
                jDireccion.setText("");
                jid.setText("");
            } catch (MyExcepcion ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al Actualizar", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRelacionActionPerformed
        // TODO add your handling code here:
        if (tablaG.getSelectedRow() > -1) {
            itinerarios = guias.get(tablaG.getSelectedRow()).getItinerarios();
            cargarTablaI();
            bandera = true;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione la fila al cuál desea acceder a los itinerarios",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bRelacionActionPerformed

    private void bAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregar1ActionPerformed
        // TODO add your handling code here:
        if (tablaG.getSelectedRow() > -1 & tablaI.getSelectedRow() > -1 & !bandera) {
            Guia guia = guias.get(tablaG.getSelectedRow());
            Itinerario itinerario = itinerarios.get(tablaI.getSelectedRow());
            if (!guia.getItinerarios().contains(itinerario)) {
                guia.agregarItinerario(itinerario);
                itinerario.agregarGuia(guia);
                try {
                    gtrs.actulizar(guia);
                    itrs.actulizar(itinerario);
                    JOptionPane.showMessageDialog(null, "Itinerario agregado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (MyExcepcion ex) {
                    Logger.getLogger(frmGuia.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    cargarTablaI();
                }
            } else {
                JOptionPane.showMessageDialog(null, "El itinerario ya está en la lista de " + guia.getNombre(),
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Si desea agregar un itinerario agregelos desde la lista completa",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bAgregar1ActionPerformed

    private void bEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminar1ActionPerformed
        // TODO add your handling code here:
        if (tablaG.getSelectedRow() > -1 & tablaI.getSelectedRow() > -1 & bandera) {
            Guia guia = guias.get(tablaG.getSelectedRow());
            Itinerario itinerario = itinerarios.get(tablaI.getSelectedRow());
            if (guia.getItinerarios().contains(itinerario)) {
                guia.eliminarItinerario(itinerario);
                itinerario.eliminarGuia(guia);
                try {
                    gtrs.actulizar(guia);
                    itrs.actulizar(itinerario);
                } catch (MyExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
                } finally {
                    cargarTablaI();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el itinerario pues no está en la lista del guia.",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Si desea eliminar un itinerario eliminelo desde la lista del Guia",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bEliminar1ActionPerformed

    private void bOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdenarActionPerformed
        // TODO add your handling code here:
        if (cBox.getSelectedIndex() == 0) {
            Guia.bandera = false;
            if (rAscendente.isSelected()) {
                Collections.sort(guias, Collections.reverseOrder());
            } else if (rDescendente.isSelected()) {
                Collections.sort(guias);
            }
        } else if (cBox.getSelectedIndex() == 1) {
            Guia.bandera = true;
            if (rAscendente.isSelected()) {
                Collections.sort(guias);
            } else if (rDescendente.isEnabled()) {
                Collections.sort(guias, Collections.reverseOrder());
            }
            cargarTablaG();
        }
    }//GEN-LAST:event_bOrdenarActionPerformed

    private void bOrdenar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdenar1ActionPerformed
        // TODO add your handling code here:
        if (cBoxO.getSelectedIndex() == 0) {
            Itinerario.bandera = false;
            if (rAscendente1.isSelected()) {
                Collections.sort(itinerarios, Collections.reverseOrder());
            } else if (rDescendente1.isSelected()) {
                Collections.sort(itinerarios);
            }
        } else if (cBoxO.getSelectedIndex() == 1) {
            Itinerario.bandera = true;
            if (rAscendente.isSelected()) {
                Collections.sort(itinerarios);
            } else if (rDescendente.isEnabled()) {
                Collections.sort(itinerarios, Collections.reverseOrder());
            }
            cargarTablaI();
        }
    }//GEN-LAST:event_bOrdenar1ActionPerformed

    private void bRelacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRelacion1ActionPerformed
        // TODO add your handling code here:
        itinerarios = itrs.listar();
        cargarTablaI();
        bandera = false;
    }//GEN-LAST:event_bRelacion1ActionPerformed

    public boolean validarCampos() {
        if (jNombre.getText().isEmpty() | jTelefono.getText().isEmpty()
                | jDireccion.getText().isEmpty() | jid.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmGuia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGuia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGuia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGuia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGuia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bAgregar1;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bEliminar1;
    private javax.swing.JButton bOrdenar;
    private javax.swing.JButton bOrdenar1;
    private javax.swing.JButton bRegresar;
    private javax.swing.JButton bRelacion;
    private javax.swing.JButton bRelacion1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cBox;
    private javax.swing.JComboBox<String> cBoxO;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jDireccion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jNada;
    private javax.swing.JTextField jNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTelefono;
    private javax.swing.JTextField jid;
    private javax.swing.JRadioButton rAscendente;
    private javax.swing.JRadioButton rAscendente1;
    private javax.swing.JRadioButton rDescendente;
    private javax.swing.JRadioButton rDescendente1;
    private javax.swing.JTable tablaG;
    private javax.swing.JTable tablaI;
    // End of variables declaration//GEN-END:variables
}
