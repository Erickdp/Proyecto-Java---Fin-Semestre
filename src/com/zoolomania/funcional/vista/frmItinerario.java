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
import com.zoolomania.funcional.control.ZonaTrs;
import com.zoolomania.funcional.modelo.Guia;
import com.zoolomania.funcional.modelo.Itinerario;
import com.zoolomania.funcional.modelo.Zona;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick Díaz
 */
public class frmItinerario extends javax.swing.JFrame {

    GuiaTrs gtrs = new GuiaTrs();
    ZonaTrs ztrs = new ZonaTrs();
    ItinerarioTrs itrs = new ItinerarioTrs();
    List<Guia> guias = gtrs.listar();
    List<Zona> zonas = ztrs.listar();
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

    private void cargarTablaZ() {
        Object[] columna = {"ID", "Nombre", "Extensión (Km)"};
        DefaultTableModel modeloZ = new DefaultTableModel(columna, 0);
        for (Zona z : zonas) {
            short id = z.getId();
            String nombre = z.getNombreZona();
            Float extension = z.getExtension();
            Object[] fila = {id, nombre, extension};
            modeloZ.addRow(fila);
        }
        this.tablaZ.setModel(modeloZ);
    }

    private void cargarTablaG() {
        Object[] columna = {"ID", "Nombre", "Dirección", "Teléfono", "Fecha Inicio Trabajo"};
        DefaultTableModel modeloG = new DefaultTableModel(columna, 0);
        for (Guia g : guias) {
            short id = g.getId();
            String nombre = g.getNombre();
            String telefono = g.getTelefono();
            LocalDateTime fecha = g.getFechInicioTrabajar();
            Object[] fila = {id, nombre, telefono, fecha};
            modeloG.addRow(fila);
        }
        this.tablaG.setModel(modeloG);
    }

    /**
     * Creates new form Itinerario
     */
    public frmItinerario() {
        initComponents();
        setLocationRelativeTo(null);
        cargarTablaI();
        cargarTablaG();;
        cargarTablaZ();
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jiD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCodigo = new javax.swing.JTextField();
        jLongitud = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jNumPersonas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaI = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        rAscendente = new javax.swing.JRadioButton();
        rDescendente = new javax.swing.JRadioButton();
        cBox = new javax.swing.JComboBox<>();
        bEliminarO = new javax.swing.JButton();
        bAgregarO = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        bOrdenarO = new javax.swing.JButton();
        rAscendenteO = new javax.swing.JRadioButton();
        rDescendenteO = new javax.swing.JRadioButton();
        cBoxO = new javax.swing.JComboBox<>();
        bVerTodo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaZ = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaG = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo");

        jLabel4.setText("Longitud");

        jLabel5.setText("Numero Max De personas");

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

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Ver relacion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Ordenar");

        buttonGroup1.add(rAscendente);
        rAscendente.setText("Ascendente");

        buttonGroup1.add(rDescendente);
        rDescendente.setText("Descendente");

        cBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "ID" }));

        bEliminarO.setText("Eliminar");
        bEliminarO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarOActionPerformed(evt);
            }
        });

        bAgregarO.setText("Agregar");
        bAgregarO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarOActionPerformed(evt);
            }
        });

        jButton8.setText("Volver al Menú");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        bOrdenarO.setText("Ordenar");

        buttonGroup2.add(rAscendenteO);
        rAscendenteO.setText("Ascendente");

        buttonGroup2.add(rDescendenteO);
        rDescendenteO.setText("Descendente");

        cBoxO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "ID" }));

        bVerTodo.setText("Ver Todo");
        bVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerTodoActionPerformed(evt);
            }
        });

        tablaZ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaZ);

        jTabbedPane1.addTab("Zonas", jScrollPane2);

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
        jScrollPane3.setViewportView(tablaG);

        jTabbedPane1.addTab("Guias", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jiD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(29, 29, 29)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNumPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(185, 185, 185)
                .addComponent(jButton8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(bOrdenarO)
                        .addGap(18, 18, 18)
                        .addComponent(rAscendenteO))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(bVerTodo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bEliminarO)
                        .addGap(37, 37, 37)
                        .addComponent(bAgregarO, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rDescendenteO)
                        .addGap(37, 37, 37)
                        .addComponent(cBoxO, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(rAscendente)
                        .addGap(18, 18, 18)
                        .addComponent(rDescendente)
                        .addGap(37, 37, 37)
                        .addComponent(cBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bEliminarO)
                                    .addComponent(bAgregarO)
                                    .addComponent(bVerTodo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bOrdenarO)
                                    .addComponent(rAscendenteO)
                                    .addComponent(rDescendenteO)
                                    .addComponent(cBoxO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jiD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jNumPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(rAscendente)
                            .addComponent(rDescendente)
                            .addComponent(cBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new frmMenuPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!(jiD.getText().isEmpty() | jCodigo.getText().isEmpty()
                | jLongitud.getText().isEmpty() | jNumPersonas.getText().isEmpty())) {
            try {
                itrs.guardar(new Itinerario(jCodigo.getText(), Byte.parseByte(jNumPersonas.getText()),
                        Short.parseShort(jiD.getText()), Short.parseShort(jLongitud.getText())));
                jNumPersonas.setText("");
                jLongitud.setText("");
            } catch (MyExcepcion ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
            } finally {
                jCodigo.setText("");
                jiD.setText("");
                cargarTablaI();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (!(jiD.getText().isEmpty() | jCodigo.getText().isEmpty()
                | jLongitud.getText().isEmpty() | jNumPersonas.getText().isEmpty()) & tablaI.getSelectedRow() > -1) {
            JOptionPane.showMessageDialog(null, "Solo el Id no se puede actualizar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            try {
                itrs.actulizar(new Itinerario(jCodigo.getText(), Byte.parseByte(jNumPersonas.getText()),
                        itinerarios.get(tablaI.getSelectedRow()).getId(), Short.parseShort(jLongitud.getText())));
                jNumPersonas.setText("");
                jLongitud.setText("");
            } catch (MyExcepcion ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al Actualizar", JOptionPane.ERROR_MESSAGE);
            } finally {
                jCodigo.setText("");
                jiD.setText("");
                cargarTablaI();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos"
                    + "/Seleccione la fila a actualizar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (tablaI.getSelectedRow() > -1) {
            try {
                UtilGestion.eliminacionCompleta(itinerarios.get(tablaI.getSelectedRow()));
                itrs.eliminar(itinerarios.get(tablaI.getSelectedRow()));
            } catch (MyExcepcion ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al Eliminar", JOptionPane.ERROR_MESSAGE);
            } finally {
                guias = gtrs.listar();
                zonas = ztrs.listar();
                cargarTablaG();
                cargarTablaI();
                cargarTablaZ();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione la fila a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (tablaI.getSelectedRow() > -1) {
            zonas = itinerarios.get(tablaI.getSelectedRow()).getZonas();
            guias = itinerarios.get(tablaI.getSelectedRow()).getGuias();
            cargarTablaG();
            cargarTablaZ();
            bandera = true;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void bVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerTodoActionPerformed
        // TODO add your handling code here:
        zonas = ztrs.listar();
        guias = gtrs.listar();
        itinerarios = (List<Itinerario>) itrs.listar();
        cargarTablaG();
        cargarTablaI();
        cargarTablaZ();
        bandera = false;
    }//GEN-LAST:event_bVerTodoActionPerformed

    private void bAgregarOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarOActionPerformed
        // TODO add your handling code here:
        if (tablaI.getSelectedRow() > -1 & tablaG.getSelectedRow() > -1 & !bandera) {
            Itinerario itinerario = itinerarios.get(tablaI.getSelectedRow());
            Guia guia = guias.get(tablaG.getSelectedRow());
            if (!itinerario.getGuias().contains(guia)) {
                itinerario.agregarGuia(guia);
                guia.agregarItinerario(itinerario);
                try {
                    itrs.actulizar(itinerario);
                    gtrs.actulizar(guia);
                    JOptionPane.showMessageDialog(null, "Se agregó al Guia " + guia.getNombre() + ", al itinerario",
                            "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (MyExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Guia " + guia.getNombre() + ", ya se encuentra en el itinerario.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (tablaI.getSelectedRow() > -1 & tablaZ.getSelectedRow() > -1 & !bandera) {
            Itinerario itinerario = itinerarios.get(tablaI.getSelectedRow());
            Zona zona = zonas.get(tablaZ.getSelectedRow());
            if (!itinerario.getZonas().contains(zona)) {
                itinerario.agregarZona(zona);
                zona.agregarItinerario(itinerario);
                itinerario.especiesVisitadas(itinerario.getZonas());
                try {
                    itrs.actulizar(itinerario);
                    ztrs.actulizar(zona);
                    JOptionPane.showMessageDialog(null, "Se agregó la Zona " + zona.getNombreZona() + ", al itinerario",
                            "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (MyExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    cargarTablaZ();
                }
            } else {
                JOptionPane.showMessageDialog(null, "La zona " + zona.getNombreZona() + ", ya se encuentra en el itinerario.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se pueden agregar relaciones desde la tabla general", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bAgregarOActionPerformed

    private void bEliminarOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarOActionPerformed
        // TODO add your handling code here:
        if (tablaI.getSelectedRow() > -1 & tablaG.getSelectedRow() > -1 & bandera) {
            Itinerario itinerario = itinerarios.get(tablaI.getSelectedRow());
            Guia guia = guias.get(tablaG.getSelectedRow());
            if (itinerario.getGuias().contains(guia)) {
                itinerario.eliminarGuia(guia);
                guia.eliminarItinerario(itinerario);
                try {
                    itrs.actulizar(itinerario);
                    gtrs.actulizar(guia);
                } catch (MyExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    guias = itinerario.getGuias();
                    cargarTablaG();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar al Guia pues no se encuentra en el itinerario",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (tablaI.getSelectedRow() > -1 & tablaZ.getSelectedRow() > -1 & bandera) {
            Itinerario itinerario = itinerarios.get(tablaI.getSelectedRow());
            Zona zona = zonas.get(tablaZ.getSelectedRow());
            if (itinerario.getZonas().contains(zona)) {
                itinerario.eliminarZona(zona);
                zona.eliminarItinerario(itinerario);
                itinerario.especiesVisitadas(itinerario.getZonas());
                try {
                    itrs.actulizar(itinerario);
                    ztrs.actulizar(zona);
                } catch (MyExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    zonas = itinerario.getZonas();
                    cargarTablaZ();
                    cargarTablaI();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar a la Zona pues no se encuentra en el itinerario",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bEliminarOActionPerformed

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
            java.util.logging.Logger.getLogger(frmItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmItinerario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregarO;
    private javax.swing.JButton bEliminarO;
    private javax.swing.JButton bOrdenarO;
    private javax.swing.JButton bVerTodo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cBox;
    private javax.swing.JComboBox<String> cBoxO;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jLongitud;
    private javax.swing.JTextField jNumPersonas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jiD;
    private javax.swing.JRadioButton rAscendente;
    private javax.swing.JRadioButton rAscendenteO;
    private javax.swing.JRadioButton rDescendente;
    private javax.swing.JRadioButton rDescendenteO;
    private javax.swing.JTable tablaG;
    private javax.swing.JTable tablaI;
    private javax.swing.JTable tablaZ;
    // End of variables declaration//GEN-END:variables
}