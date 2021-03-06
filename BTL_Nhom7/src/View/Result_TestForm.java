/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DatabaseIO.AccountDAO;
import DatabaseIO.QuestionDAO;
import DatabaseIO.TestDAO;
import Model.Account;
import Model.Answer;
import Model.Question;
import Model.Result;
import Model.Test;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mrloc
 */
public class Result_TestForm extends javax.swing.JDialog {

    /**
     * Creates new form Result_Test
     */
    public Result_TestForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Result_TestForm(List<Answer> list, Result resuld) {
        initComponents();
        loadData(list, resuld);
    }

    
    //Load data lên trên table và text
    private void loadData(List<Answer> list, Result res) {
        Account user = new AccountDAO().getAccount(res.getAccount());
        Test test = new TestDAO().getTest(res.getTest());
        jTextFieldName.setText(user.getName());
        jTextFieldTestCode.setText(test.getTest_Code());
        jTextFieldCorrectQT.setText(res.getCorrect_QT() + " / " + test.getNumber_Of_Question());
        jTextFieldTime.setText(res.getTime() + " phút");
        jTextFieldMark.setText(Double.toString((double) res.getCorrect_QT() / test.getNumber_Of_Question() * 10));

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (Answer item : list) {
            Question qt = new QuestionDAO().getQuestionById(item.getQuestion());
            model.addRow(new Object[]{qt.getQuestion(), item.getAnswer(), (item.isCorrect() ? "Đúng" : "Sai")});
        }
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
        jPaneInfor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldTestCode = new javax.swing.JTextField();
        jTextFieldCorrectQT = new javax.swing.JTextField();
        jTextFieldTime = new javax.swing.JTextField();
        jTextFieldMark = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPaneInfor.setPreferredSize(new java.awt.Dimension(876, 200));

        jLabel1.setText("Họ và Tên :");

        jLabel2.setText("Mã đề :");

        jLabel3.setText("Số câu đúng :");

        jLabel4.setText("Thời gian làm :");

        jLabel5.setText("Điểm :");

        jTextFieldName.setEditable(false);

        jTextFieldTestCode.setEditable(false);

        jTextFieldCorrectQT.setEditable(false);

        jTextFieldTime.setEditable(false);

        jTextFieldMark.setEditable(false);

        javax.swing.GroupLayout jPaneInforLayout = new javax.swing.GroupLayout(jPaneInfor);
        jPaneInfor.setLayout(jPaneInforLayout);
        jPaneInforLayout.setHorizontalGroup(
            jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneInforLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldName)
                    .addComponent(jTextFieldTestCode)
                    .addComponent(jTextFieldCorrectQT)
                    .addComponent(jTextFieldTime)
                    .addComponent(jTextFieldMark, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPaneInforLayout.setVerticalGroup(
            jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneInforLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTestCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCorrectQT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPaneInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1.add(jPaneInfor, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Câu hỏi", "Câu trả lời", "Đúng | Sai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setMinWidth(80);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(89);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Result_TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result_TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result_TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result_TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Result_TestForm dialog = new Result_TestForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPaneInfor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCorrectQT;
    private javax.swing.JTextField jTextFieldMark;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldTestCode;
    private javax.swing.JTextField jTextFieldTime;
    // End of variables declaration//GEN-END:variables
}
