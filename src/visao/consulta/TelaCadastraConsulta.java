/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.consulta;

import controle.*;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author Aluno
 */
public class TelaCadastraConsulta extends javax.swing.JFrame {

    private GerenciaAnimal ga;
    private GerenciaCliente gc;
    private GerenciaServicos gs;
    private GerenciaConsulta gct;
    
    private Config cfg;
    private Animal animal = null;
    private Servico servico = null;
    private int posiItem, posiID;
    List<Servico> servicos;
   
    
    public TelaCadastraConsulta() {
        
        initComponents();
            ga = new GerenciaAnimal();
            gc = new GerenciaCliente();
            gs = new GerenciaServicos();
            gct = new GerenciaConsulta();
            cfg = new Config();
            
        
        servicos = gs.listaServicos();
        
        for(Servico s : servicos){
            jcListaServicos.addItem(s.getNomeServico());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClinicaComBancoPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("ClinicaComBancoPU").createEntityManager();
        servicoQuery = java.beans.Beans.isDesignTime() ? null : ClinicaComBancoPUEntityManager.createQuery("SELECT s FROM Servico s");
        servicoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : servicoQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfIdentificacaoAnimal = new javax.swing.JTextField();
        jbuttonBuscaAnimal = new javax.swing.JButton();
        jbuttonCadastrar = new javax.swing.JButton();
        jbuttonVoltar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlNomeCliente = new javax.swing.JLabel();
        jlRgCliente = new javax.swing.JLabel();
        jlResidencialCliente = new javax.swing.JLabel();
        jlCelularCliente = new javax.swing.JLabel();
        jlCpfCliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jlSexoAnimal = new javax.swing.JLabel();
        jlNomeAnimal = new javax.swing.JLabel();
        jlRacaAnimal = new javax.swing.JLabel();
        jlIdadeAnimal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jcListaServicos = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        tfFormatedDataDaConsulta = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jfValor = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jcHora = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jtDiagnostico = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ficha de Consulta - Cadastro");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setText("Informe o código do animal:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 22, -1, -1));
        jPanel2.add(tfIdentificacaoAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 19, 90, -1));

        jbuttonBuscaAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Checked-Checkbox-32.png"))); // NOI18N
        jbuttonBuscaAnimal.setText("  Busca Animal");
        jbuttonBuscaAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonBuscaAnimalActionPerformed(evt);
            }
        });
        jPanel2.add(jbuttonBuscaAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 6, -1, -1));

        jbuttonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Checked-Checkbox-32.png"))); // NOI18N
        jbuttonCadastrar.setText("Marcar Consulta");
        jbuttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonCadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(jbuttonCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, -1));

        jbuttonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Redo-32.png"))); // NOI18N
        jbuttonVoltar.setText("Cancelar");
        jbuttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(jbuttonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel4.setText("Nome:");

        jLabel11.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel11.setText("CPF:");

        jLabel14.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel14.setText("RG:");

        jLabel15.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel15.setText("Telefone Residencial:");

        jLabel16.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel16.setText("Telefone Celular:");

        jlNomeCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jlNomeCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlResidencialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlCpfCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(8, 8, 8)))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlRgCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jlResidencialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jlCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 101, 810, -1));

        jLabel2.setText("DADOS DA CONSULTA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, 818, 12));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel10.setText("Nome do Animal :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel8.setText("Raca do Animal :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 258, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel9.setText("Nome do animal:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel6.setText("Raça:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel7.setText("Sexo:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel18.setText("Idade:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));
        jPanel4.add(jlSexoAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 90, 20));
        jPanel4.add(jlNomeAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 190, 20));
        jPanel4.add(jlRacaAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 90, 20));
        jPanel4.add(jlIdadeAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 90, 20));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 810, 80));

        jLabel17.setText("DADOS DO CLIENTE:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 80, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 102, 102)));

        jcListaServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcListaServicosActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel13.setText("Hora da Consulta :");

        jLabel12.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel12.setText("Data da Consulta :");

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel5.setText("Valor da Consulta:");

        jLabel19.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel19.setText("Tipo de serviço:");

        jcHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00" }));

        jLabel20.setText("Diagnóstico: ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFormatedDataDaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcHora, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcListaServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 223, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtDiagnostico)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfFormatedDataDaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jcListaServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jcHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtDiagnostico, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 810, 170));

        jLabel21.setText("DADOS DO ANIMAL:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(840, 630));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonVoltarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbuttonVoltarActionPerformed

    private void jbuttonBuscaAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonBuscaAnimalActionPerformed
        
        
        
        int idAnimal = Integer.parseInt(tfIdentificacaoAnimal.getText());
        
        animal = ga.buscaAnimal(idAnimal);
        
        if(animal != null){
            try {
                
                Cliente cli = animal.getIdCliente();
                
                // Preenche dados cliente
                jlNomeCliente.setText(cli.getNomeCli());
                jlCpfCliente.setText(cli.getCpfCli());
                jlRgCliente.setText(cli.getRgCli());
                jlCelularCliente.setText(cli.getTel2Cli());
                jlResidencialCliente.setText(cli.getTel1Cli());
                
                // Preenche dados animal
                jlNomeAnimal.setText(animal.getNomeAnimal());
                jlRacaAnimal.setText(animal.getRaca());
                jlSexoAnimal.setText(animal.getSexo());
                
                
                
            } catch (Exception e) {
                
             JOptionPane.showMessageDialog(null, "Cliente não encontrado");
             
            }
        }else{
            JOptionPane.showMessageDialog(null, "Animal não existe!");
        }
        
    
        
    }//GEN-LAST:event_jbuttonBuscaAnimalActionPerformed

    private void jcListaServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcListaServicosActionPerformed

        
        
    }//GEN-LAST:event_jcListaServicosActionPerformed

    private void jbuttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonCadastrarActionPerformed
        Consulta c = new Consulta();
        Date dConsulta = cfg.formataData(tfFormatedDataDaConsulta.getText());        
        Servico s = (Servico) servicos.get(jcListaServicos.getSelectedIndex());
        
        c.setDataConsulta(dConsulta);
        c.setHoraConsulta(jcHora.getSelectedItem().toString());
        c.setIdAnimal(animal);
        c.setServico((String) jcListaServicos.getSelectedItem());
        c.setValor(Double.parseDouble(jfValor.getText()));
        c.setDiagnostico(jtDiagnostico.getText());
        
        gct.cadastrar(c);
    }//GEN-LAST:event_jbuttonCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastraConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastraConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastraConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager ClinicaComBancoPUEntityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbuttonBuscaAnimal;
    private javax.swing.JButton jbuttonCadastrar;
    private javax.swing.JButton jbuttonVoltar;
    private javax.swing.JComboBox<String> jcHora;
    private javax.swing.JComboBox<String> jcListaServicos;
    private javax.swing.JFormattedTextField jfValor;
    private javax.swing.JLabel jlCelularCliente;
    private javax.swing.JLabel jlCpfCliente;
    private javax.swing.JLabel jlIdadeAnimal;
    private javax.swing.JLabel jlNomeAnimal;
    private javax.swing.JLabel jlNomeCliente;
    private javax.swing.JLabel jlRacaAnimal;
    private javax.swing.JLabel jlResidencialCliente;
    private javax.swing.JLabel jlRgCliente;
    private javax.swing.JLabel jlSexoAnimal;
    private javax.swing.JTextField jtDiagnostico;
    private java.util.List<modelo.Servico> servicoList;
    private javax.persistence.Query servicoQuery;
    private javax.swing.JFormattedTextField tfFormatedDataDaConsulta;
    private javax.swing.JTextField tfIdentificacaoAnimal;
    // End of variables declaration//GEN-END:variables
}
