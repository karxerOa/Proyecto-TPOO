/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PackDiseño;

import Clases.Doctor;
import Clases.Especialidad;
import Clases.Usuario;
import Controladores.ControladorAdministrador;
import Controladores.ControladorDoctor;
import Controladores.ControladorUsuarios;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import util.Placeholders;
/**
 *
 * @author William
 */
public class PanelRegistarDoctor extends javax.swing.JPanel {

    /**
     * Creates new form PanelRegistarDoctor
     */
    private ArrayList<Especialidad> lista;
    public PanelRegistarDoctor() {
        initComponents();
        inicializarPlaceholders();
        cargarCombobox();
       
    }
    public void cargarCombobox(){
        lista = new ArrayList();
        
        ControladorAdministrador admin = new ControladorAdministrador();
        lista = admin.Obtener_Especilidad();
        
        cbEspecialidad.removeAllItems();
        
        for (Especialidad esp : lista){
            cbEspecialidad.addItem(esp.getNombre());
        }
    }
    public void inicializarPlaceholders(){
        Placeholders.configurarPlaceholder(txtNombre, "Ingrese sus nombres");
        Placeholders.configurarPlaceholder(txtAPaterno, "Ingrese su apellido aterno");
        Placeholders.configurarPlaceholder(txtAMaterno, "Ingrese su apellido materno");
        Placeholders.configurarPlaceholder(txtTelefono, "Ingrese su numero de telefono");
        Placeholders.configurarPlaceholder(txtCorreo, "Ingrese su correo electronico");
        Placeholders.configurarPlaceholder(txtDireccion, "Ingrese su direccion");
        Placeholders.configurarPlaceholder(txtCMP, "Ingrese CMP");       
        Placeholders.configurarPlaceholder(txtNunDoc, "Ingrese su doc. de indentidad");
        Placeholders.configurarPlaceholder(txtUsuario, "Ingrese Usuario");
        Placeholders.configurarPlaceholder(txtContraseña, "Ingrese Contraseña");
        
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
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnRegistar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAPaterno = new javax.swing.JTextField();
        txtAMaterno = new javax.swing.JTextField();
        txtNunDoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCMP = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        dpFN = new org.jdesktop.swingx.JXDatePicker();
        cbEspecialidad = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Doct.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("USUARIO");

        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));

        txtContraseña.setForeground(new java.awt.Color(153, 153, 153));
        txtContraseña.setText("Contraseña");
        txtContraseña.setDoubleBuffered(true);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Usuario:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistar.setText("Registrar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCorreo.setForeground(new java.awt.Color(153, 153, 153));
        txtCorreo.setText("Ingrese su correo electronico");
        jPanel5.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 360, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Correo Electronico");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombres:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Apellido Materno:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Documento de Identidad:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Ingrese sus nombre");
        jPanel5.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 360, 30));

        txtAPaterno.setForeground(new java.awt.Color(153, 153, 153));
        txtAPaterno.setText("Ingrese su apellido paterno");
        jPanel5.add(txtAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 360, 30));

        txtAMaterno.setForeground(new java.awt.Color(153, 153, 153));
        txtAMaterno.setText("Ingrese su apellido materno");
        jPanel5.add(txtAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 360, 30));

        txtNunDoc.setForeground(new java.awt.Color(153, 153, 153));
        txtNunDoc.setText("Ingrese N° Documento");
        jPanel5.add(txtNunDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 170, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Especialidad:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Direccion");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Telefono");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 30));

        txtCMP.setForeground(new java.awt.Color(153, 153, 153));
        txtCMP.setText("Ingrese CMP");
        jPanel5.add(txtCMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 110, 30));

        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setText("Ingrese su direccion");
        jPanel5.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 360, 30));

        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setText("Ingrese su numero de telefono");
        jPanel5.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 360, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Fecha Nacimiento:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Genero:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, 30));

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cbGenero.setSelectedIndex(-1);
        jPanel5.add(cbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 120, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Codigo CMP:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 30));
        jPanel5.add(dpFN, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 130, 30));

        cbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medico General", "Cardiología  ", "Neurología  ", "Pediatría  ", "Ginecología  ", "Dermatología  ", "Urología  ", "Oftalmología  ", "Otorrinolaringología  ", "Neumología  ", "Reumatología  ", "Gastroenterología  ", "Psiquiatría  ", "Cirugía General  ", "Obstetricia" }));
        cbEspecialidad.setSelectedIndex(-1);
        jPanel5.add(cbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        try{     
        // Ingresar datos---------------------------------------------------------------------------
        Date Fecha = dpFN.getDate();
        LocalDate FechaNacimiento = Fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();      
    
        //Ingresar datos propios del doctor---------------------------------------------------------
     
        int Index = cbEspecialidad.getSelectedIndex();
        Especialidad EspecialidadesSleccionada = lista.get(Index);
        ArrayList<Especialidad> ListaEspecialidadDoctor = new ArrayList();
        ListaEspecialidadDoctor.add(EspecialidadesSleccionada);
        
        //Crear UsuarioTT
        
        String Usser = txtUsuario.getText();
        String Password = txtContraseña.getText();      
        Usuario newUsser = new Usuario(0,Usser, Password, "Doctor");
        
        ControladorUsuarios U = new ControladorUsuarios();
        int IdUsuario = U.RegistrarUser(newUsser);
        
        if(IdUsuario!=-1){
            
            //Mandar ID
            newUsser.setIdUsuario(IdUsuario);
            ControladorAdministrador A = new ControladorAdministrador(); 
            Doctor newdoc = new Doctor();
            //Set clase persona
            newdoc.setNombre(txtNombre.getText());
            newdoc.setApellidoPaterno(txtAPaterno.getText());
            newdoc.setApellidoMaterno(txtAMaterno.getText());
            newdoc.setNumDoc(txtNunDoc.getText());     
            newdoc.setTipoDoc(A.determinarTipoDocumento(txtNunDoc.getText()));
            newdoc.setTelefono(txtTelefono.getText());
            newdoc.setFechaNacimiento(FechaNacimiento);
            newdoc.setGenero(cbGenero.getSelectedItem().toString());
            newdoc.setCorreo(txtCorreo.getText());
            newdoc.setDireccion(txtDireccion.getText());
            
            //Set clase doctor
            newdoc.setEspecialidades(ListaEspecialidadDoctor);
            newdoc.setCodigoColegiatura(txtCMP.getText());
            newdoc.setUser(newUsser);
            
            //Agregar doctor
          
            
            //Relacion Especialidad_doctor
            int DoctorID = A.Agregar_Doctor(newdoc);
            int EspecialdiadID = EspecialidadesSleccionada.getIdEspecialidad();
            
            ControladorDoctor CD = new ControladorDoctor();
            CD.AsignarEspecialidad(DoctorID, EspecialdiadID);
            
            JOptionPane.showMessageDialog(this, "Doctor registrado exitosamente");  
        }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }  
    }//GEN-LAST:event_btnRegistarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistar;
    private javax.swing.JComboBox<String> cbEspecialidad;
    private javax.swing.JComboBox<String> cbGenero;
    private org.jdesktop.swingx.JXDatePicker dpFN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JTextField txtCMP;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNunDoc;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
