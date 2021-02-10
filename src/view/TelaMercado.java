/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import modelo.bean.Produto;
import modelo.dao.ProdutoDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class TelaMercado extends javax.swing.JFrame {

    
    public TelaMercado() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        jTProdutos.setRowSorter (new TableRowSorter (modelo) );
        
        readJTable(); 
    }
    
    public void readJTable() {
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        
        for (Produto p: pdao.read() ) {                        //laço de repetiçao para percorrer a lista
            
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getTipo(),
                p.getDescricao(),
                p.getQuantidade(),
                p.getPreco()    
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Marca do Produto:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(380, 100, 130, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Quantidade:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(380, 160, 120, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Preço:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(790, 130, 45, 40);
        jPanel1.add(txtDesc);
        txtDesc.setBounds(520, 100, 230, 40);
        jPanel1.add(txtQtd);
        txtQtd.setBounds(520, 160, 230, 40);
        jPanel1.add(txtPreco);
        txtPreco.setBounds(850, 130, 140, 40);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(310, 260, 120, 38);

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(450, 260, 120, 39);

        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(590, 260, 118, 38);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Nome:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 100, 90, 40);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Tipo:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 160, 90, 40);

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel6.setText("Cadastre aqui");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(400, 0, 210, 50);
        jPanel1.add(txtNome);
        txtNome.setBounds(100, 100, 230, 40);
        jPanel1.add(txtTipo);
        txtTipo.setBounds(100, 160, 230, 40);

        jButton5.setText("Sair");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(940, 300, 70, 30);

        jButton6.setText("Voltar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(0, 300, 70, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1010, 330);

        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(766, 215, 51, 23);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Tabela com seus Produtos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel4.setLayout(null);

        jTProdutos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Tipo", "Descriçao", "Quantidade", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        jTProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTProdutos);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 990, 360);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 330, 1010, 410);

        setSize(new java.awt.Dimension(1025, 780));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutosKeyReleased

    }//GEN-LAST:event_jTProdutosKeyReleased

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked

        if (jTProdutos.getSelectedRow() != -1) {

            txtNome.setText  (jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1).toString() );
            txtTipo.setText  (jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2).toString() );
            txtDesc.setText  (jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString() );
            txtQtd.setText   (jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString() );   //clicando em uma linha da tabele e aparecer os dados em cima nos campos
            txtPreco.setText (jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 5).toString() );
        }
    }//GEN-LAST:event_jTProdutosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (jTProdutos.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setNome       (txtNome.getText() );
            p.setTipo       (txtTipo.getText() );
            p.setDescricao  (txtDesc.getText() );
            p.setQuantidade (Integer.parseInt (txtQtd.getText() ));
            p.setPreco      (Double.parseDouble (txtPreco.getText() ));
            p.setId         ((int)jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0) );
            dao.update(p);

            txtNome.setText  ("");
            txtTipo.setText  ("");
            txtDesc.setText  ("");
            txtQtd.setText   ("");       //limpando os tres campos manualmente sem funçao
            txtPreco.setText ("");

            readJTable();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jTProdutos.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setId ((int)jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0) );
            dao.Delete(p);

            txtNome.setText  ("");
            txtTipo.setText  ("");
            txtDesc.setText  ("");
            txtQtd.setText   ("");
            txtPreco.setText ("");

            readJTable();

        } else {
            JOptionPane.showMessageDialog (null, "Selecione um produto pra excluir");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        p.setNome       (txtNome.getText() );
        p.setTipo       (txtTipo.getText() );
        p.setDescricao  (txtDesc.getText() );
        p.setQuantidade (Integer.parseInt (txtQtd.getText() ));        //pegando os valores dos campos a cima
        p.setPreco      (Double.parseDouble (txtPreco.getText() ));
        dao.create(p);

        txtNome.setText  ("");
        txtTipo.setText  ("");
        txtDesc.setText  ("");
        txtQtd.setText   ("");       //limpando os tres campos manualmente sem funçao
        txtPreco.setText ("");

        readJTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        TelaUsuario y = new TelaUsuario();
        y.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMercado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
