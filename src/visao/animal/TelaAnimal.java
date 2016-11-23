package visao.animal;

import DAO.AnimalDAO;
import DAO.ClienteDAO;
import controle.GerenciaAnimal;
import controle.Relatorios;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Animal;
import modelo.Cliente;
import modelo.Servico;

public class TelaAnimal extends javax.swing.JFrame {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaComBancoPU");
    private Cliente cli;
    private final ClienteDAO cliDao;
    private AnimalDAO aniDao;
    //private final AnimalDAO aniDao;
    private final GerenciaAnimal ga;
    TelaCadastroAnimal tcAnimal;
    TelaAlteraAnimal taAnimal;
    TelaExcluiAnimal teAnimal;
    ArrayList <Integer> idClientes = new ArrayList<Integer>();

    public TelaAnimal() {
        initComponents();
        setLocationRelativeTo(null);
        
        ga = new GerenciaAnimal();
        cliDao = new ClienteDAO(emf);
        
        //preenche lista de cliente no combobox
        List <Cliente> listaClientes;
        
        listaClientes = cliDao.listaClientes();
        
        for(Cliente c : listaClientes){
            jcListaClientes.addItem(c.getNomeCli().toUpperCase());
            idClientes.add(c.getIdCli());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jButton4 = new javax.swing.JButton();
        ClinicaComBancoPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ClinicaComBancoPU").createEntityManager();
        animalQuery = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT a FROM Animal a");
        animalList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : animalQuery.getResultList();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT c FROM Cliente c");
        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery.getResultList();
        clienteQuery1 = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT c FROM Cliente c");
        clienteList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery1.getResultList();
        clienteQuery2 = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT c FROM Cliente c");
        clienteList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery2.getResultList();
        clienteQuery3 = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT c FROM Cliente c");
        clienteList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery3.getResultList();
        clienteQuery4 = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT c FROM Cliente c");
        clienteList4 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery4.getResultList();
        animalQuery1 = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT a FROM Animal a");
        animalList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : animalQuery1.getResultList();
        animalQuery2 = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT a FROM Animal a");
        animalList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : animalQuery2.getResultList();
        clienteQuery5 = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT c FROM Cliente c");
        clienteList5 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery5.getResultList();
        jButton3 = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonBuscaCliente = new javax.swing.JButton();
        buttonVoltar = new javax.swing.JButton();
        jbAlteraAnimal = new javax.swing.JButton();
        buttonCadastro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AnimaisLista = new javax.swing.JTable();
        jcListaClientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnExcluiAnimal = new javax.swing.JButton();
        jbRelatorioAnimais = new javax.swing.JButton();

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Checked-Checkbox-32.png"))); // NOI18N
        jButton4.setText("  Cadastrar");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Redo-32.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete-Trash-32.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh-32.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reviewer-32.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de Animais no Sistema ");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Escolher cliente:");

        buttonBuscaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reviewer-32.png"))); // NOI18N
        buttonBuscaCliente.setText("Filtrar");
        buttonBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscaClienteActionPerformed(evt);
            }
        });

        buttonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Redo-32.png"))); // NOI18N
        buttonVoltar.setText("Sair");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        jbAlteraAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh-32.png"))); // NOI18N
        jbAlteraAnimal.setText("Alterar");
        jbAlteraAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlteraAnimalActionPerformed(evt);
            }
        });

        buttonCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reviewer-32.png"))); // NOI18N
        buttonCadastro.setText("Novo");
        buttonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastroActionPerformed(evt);
            }
        });

        AnimaisLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, animalQuery, org.jdesktop.beansbinding.ELProperty.create("${resultList}"), AnimaisLista, org.jdesktop.beansbinding.BeanProperty.create("selectedElements"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(AnimaisLista);

        jcListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcListaClientesActionPerformed(evt);
            }
        });

        jLabel4.setText("LISTA DE ANIMAIS:");

        btnExcluiAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete-Trash-32.png"))); // NOI18N
        btnExcluiAnimal.setText("Excluir");
        btnExcluiAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiAnimalActionPerformed(evt);
            }
        });

        jbRelatorioAnimais.setText("Relatório de animais");
        jbRelatorioAnimais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRelatorioAnimaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonBuscaCliente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jLabel4)))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlteraAnimal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluiAnimal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbRelatorioAnimais)
                        .addGap(77, 77, 77)
                        .addComponent(buttonVoltar)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buttonBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCadastro)
                    .addComponent(jbAlteraAnimal)
                    .addComponent(buttonVoltar)
                    .addComponent(btnExcluiAnimal)
                    .addComponent(jbRelatorioAnimais))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(322, 322, 322))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAlteraAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlteraAnimalActionPerformed
        taAnimal = new TelaAlteraAnimal();
        taAnimal.setVisible(true);
    }//GEN-LAST:event_jbAlteraAnimalActionPerformed

    private void buttonBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscaClienteActionPerformed

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setNumRows(0);
        List<Animal> animais = ga.listaAnimais();
        int posiItem, posiId;
        
        posiItem = jcListaClientes.getSelectedIndex();
        posiId = (int) idClientes.get(posiItem);
        
        modelo.addColumn("ID");
        modelo.addColumn("Nome do Animal");
        modelo.addColumn("Raça");
        modelo.addColumn("Espécie");
        for(Animal a : animais){
           int posi = a.getIdCliente().getIdCli();
           
           
            
           if(posi == posiId){
                         
               modelo.addRow(new Object[]{a.getIdAnimal(),a.getNomeAnimal(),
                   a.getRaca(), a.getEspecie()});
           } 
            
        
        }
        
        AnimaisLista.setModel(modelo);


    }//GEN-LAST:event_buttonBuscaClienteActionPerformed

    private void buttonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastroActionPerformed
        
       tcAnimal = new TelaCadastroAnimal();
       tcAnimal.setVisible(true);
       
            
    }//GEN-LAST:event_buttonCadastroActionPerformed

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        
            this.dispose();
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed


    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed


    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed


    }//GEN-LAST:event_jbNovoActionPerformed

    private void btnExcluiAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiAnimalActionPerformed
        teAnimal = new TelaExcluiAnimal();
        teAnimal.setVisible(true);
    }//GEN-LAST:event_btnExcluiAnimalActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

    private void jcListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcListaClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcListaClientesActionPerformed

    private void jbRelatorioAnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRelatorioAnimaisActionPerformed
        Relatorios.callRelatorio("Animais", "Relatório de animais", new HashMap());
    }//GEN-LAST:event_jbRelatorioAnimaisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AnimaisLista;
    private javax.persistence.EntityManager ClinicaComBancoPUEntityManager;
    private java.util.List<modelo.Animal> animalList;
    private java.util.List<modelo.Animal> animalList1;
    private java.util.List<modelo.Animal> animalList2;
    private javax.persistence.Query animalQuery;
    private javax.persistence.Query animalQuery1;
    private javax.persistence.Query animalQuery2;
    private javax.swing.JButton btnExcluiAnimal;
    private javax.swing.JButton buttonBuscaCliente;
    private javax.swing.JButton buttonCadastro;
    private javax.swing.JButton buttonVoltar;
    private java.util.List<modelo.Cliente> clienteList;
    private java.util.List<modelo.Cliente> clienteList1;
    private java.util.List<modelo.Cliente> clienteList2;
    private java.util.List<modelo.Cliente> clienteList3;
    private java.util.List<modelo.Cliente> clienteList4;
    private java.util.List<modelo.Cliente> clienteList5;
    private javax.persistence.Query clienteQuery;
    private javax.persistence.Query clienteQuery1;
    private javax.persistence.Query clienteQuery2;
    private javax.persistence.Query clienteQuery3;
    private javax.persistence.Query clienteQuery4;
    private javax.persistence.Query clienteQuery5;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAlteraAnimal;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbRelatorioAnimais;
    private javax.swing.JComboBox<String> jcListaClientes;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
