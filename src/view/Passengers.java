/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.PassengerDao;
import model.dao.mysql.PassengersDaoImpl; 
//import model.dao.listas.PassengersDaoImpl;


/**
 *
 * @author Usuario
 */
public class Passengers extends javax.swing.JFrame {

    /**
     * Creates new form Passengers
     */
    public Passengers() {
        dao = new PassengersDaoImpl();
      
        initComponents();

        this.setExtendedState(this.MAXIMIZED_BOTH);
          model = (DefaultTableModel) tablePassenger.getModel();
        loadPassengerData(); //para cargar los datos al iniciar
          addTableSelectionListener(); //agregar el listener despues de cargar
    }
    public void loadPassengerData() {
        List<model.Passengers> passengers = dao.getAll();
        DefaultTableModel model = (DefaultTableModel)tablePassenger.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los nuevos datos
        for (model.Passengers p : passengers) {
            model.addRow(new Object[]{p.getNPasajero(), p.getDni(), p.getFechaNacimiento(), p.getNombre(), p.getApellido(), p.getTelefono(), p.getMail() });// agregar p.getHabitacion() cuando cree la clase
        }
    }
    private void addTableSelectionListener() {
        tablePassenger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tablePassenger.getSelectedRow();
                if (row != -1) {
                    nPasajero.setText(model.getValueAt(row, 0).toString());
                    dni.setText(model.getValueAt(row, 1).toString());
                    fechaNacimiento.setText(model.getValueAt(row, 2).toString());
                    nombre.setText(model.getValueAt(row, 3).toString());
                    apellido.setText(model.getValueAt(row, 4).toString());
                    telefono.setText(model.getValueAt(row, 5).toString());
                    mail.setText(model.getValueAt(row, 6).toString());
                    //comboBoxHabitacion.setSelectedItem(model.getValueAt(row, 7).toString()); // Si tienes un ComboBox para la habitación
                }
            }
        });
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePassenger = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ButtAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ButtModificar = new javax.swing.JButton();
        ButtEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        nPasajero = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        fechaNacimiento = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ComboBoxHabitacion = new javax.swing.JComboBox<>();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablePassenger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº", "DNI", "Fecha", "Nombre", "Apellido", "Teléfono", "Mail", "Habitación"
            }
        ));
        tablePassenger.setName("tablePassenger"); // NOI18N
        jScrollPane1.setViewportView(tablePassenger);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jLabel1.setText("Nº de Pasajero");

        jLabel2.setText("DNI");

        jLabel3.setText("Fecha de Nacimiento");

        jLabel4.setText("Nombre");
        jLabel4.setToolTipText("");

        ButtAgregar.setText("Agregar");
        ButtAgregar.setName("BotAgregar"); // NOI18N
        ButtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtAgregarActionPerformed(evt);
            }
        });

        jLabel5.setText("Apellido");

        jLabel6.setText("Teléfono");

        ButtModificar.setText("Modificar");
        ButtModificar.setName("botModificar"); // NOI18N
        ButtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtModificarActionPerformed(evt);
            }
        });

        ButtEliminar.setText("Eliminar");
        ButtEliminar.setName("botEliminar"); // NOI18N
        ButtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtEliminarActionPerformed(evt);
            }
        });

        jLabel7.setText("Cantidad de pasajeros");
        jLabel7.setToolTipText("");

        nPasajero.setName("NPasajero"); // NOI18N

        dni.setName("dni"); // NOI18N

        fechaNacimiento.setName("fechaNacimiento"); // NOI18N

        nombre.setName("nombre"); // NOI18N

        apellido.setName("apellido"); // NOI18N
        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });

        telefono.setToolTipText("");
        telefono.setName("telefono"); // NOI18N

        jLabel8.setText("Nº");

        jLabel9.setText("Mail");

        mail.setName("mail"); // NOI18N

        jLabel10.setText("Habitación:");

        ComboBoxHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habitación 101", "Habitación 102", "Habitación 103", "Habitación 104", "Habitación 105", "Habitación 201", "Habitación 202", "Habitación 203", "Habitación 204", "Habitación 205" }));
        ComboBoxHabitacion.setName(""); // NOI18N
        ComboBoxHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxHabitacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaNacimiento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ButtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtModificar))
                                .addGap(15, 15, 15))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(apellido))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(nombre))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(mail))
                                    .addComponent(telefono))))
                        .addGap(142, 142, 142)
                        .addComponent(jLabel8)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nPasajero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtAgregar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ButtEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(ComboBoxHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel6.getAccessibleContext().setAccessibleName("Mail");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void ButtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtAgregarActionPerformed

          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
        
        //int NPasajero = NPasajero.getText();
        String dn = dni.getText();
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento.getText(), formatter);
        String formattedDate =  fechaNac.format(formatter); 
        String nom= nombre.getText();
        String apel= apellido.getText();
        String telef= telefono.getText();
        String mai= mail.getText();
        //String habN=(String)comboBoxHabitacion.getSelectedItem();
    
      
      
        
        
        
        model.Passengers p = new model.Passengers();
       // p.setNPasajero(NPasajero);
        p.setDni(dn);
        p.setFechaNacimiento(fechaNac);
        p.setNombre(nom);
        p.setApellido(apel);
        p.setTelefono(telef);
        p.setMail(mai);
        //p.setHabitacion(habN);
      
        
     // para guardar el pasajero en la BD   
        dao.save(p);
       
        DefaultTableModel model = (DefaultTableModel)tablePassenger.getModel();
        
        model.insertRow(0, new Object[]{p.getNPasajero(),p.getDni(),p.getFechaNacimiento(), p.getNombre(), p.getApellido(), p.getTelefono(),p.getMail()});
          loadPassengerData();
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtAgregarActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void ComboBoxHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxHabitacionActionPerformed

    private void ButtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtModificarActionPerformed
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //int id = Integer.parseInt(nPasajero.getText());
    String dn = dni.getText();
    LocalDate fechaNac = LocalDate.parse(fechaNacimiento.getText(), formatter);
    String nom = nombre.getText();
    String apel = apellido.getText();
    String telef = telefono.getText();
    String mai = mail.getText();
    //String habN = comboBoxHabitacion.getSelectedItem().toString(); // Si tienes un ComboBox para la habitación

    model.Passengers p = new model.Passengers();
  //  p.setNPasajero(id);
    p.setDni(dn);
    p.setFechaNacimiento(fechaNac);
    p.setNombre(nom);
    p.setApellido(apel);
    p.setTelefono(telef);
    p.setMail(mai);
    //p.setHabitacion(habN);

    // Actualizar el pasajero en la BD
    dao.update(p);

    // Actualizar la tabla
    loadPassengerData();

    }//GEN-LAST:event_ButtModificarActionPerformed

    private void ButtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtEliminarActionPerformed
      int selectedRow = tablePassenger.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un pasajero para eliminar.");
        return;
    }
    
    // Obtener el Npasajero del pasajero 
   Object nPasajero = tablePassenger.getValueAt(selectedRow, 0);
   
    
    // Crear un objeto Passengers con el Npasajero correspondiente
    model.Passengers p = new model.Passengers();
    p.setNPasajero((int) nPasajero);
    
    // Eliminar el pasajero utilizando el DAO
    dao.delete(p);
    loadPassengerData();

    // Eliminar la fila del modelo de la tabla
    DefaultTableModel model = (DefaultTableModel) tablePassenger.getModel();
    model.removeRow(selectedRow);

    // Decrementar el contador de pasajeros
    /*totalPasajeros--;
    jLabel9.setText("" +totalPasajeros); */
                 
    
    
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Passengers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Passengers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Passengers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Passengers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Passengers().setVisible(true);
            }
        });
    }
    private DefaultTableModel model; 
    private PassengerDao dao;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtAgregar;
    private javax.swing.JButton ButtEliminar;
    private javax.swing.JButton ButtModificar;
    private javax.swing.JComboBox<String> ComboBoxHabitacion;
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField fechaNacimiento;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField nPasajero;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tablePassenger;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
