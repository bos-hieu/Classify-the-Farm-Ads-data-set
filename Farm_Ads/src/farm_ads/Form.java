/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm_ads;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;

/**
 *
 * @author Cau be mua he
 */
public class Form extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    JFileChooser uFile = new JFileChooser();
    MyClassifier cls = new MyClassifier();
    Instances train = null;
    Instances test = null;
    Hashtable att = new Hashtable();
    Hashtable num_att = new Hashtable();
    String iv = new String();
    Classifier model = null;
    Evaluation eval = null;

    /**
     * Creates new form Form
     */
    public Form() {
        this.test = null;
        this.train = null;
        readAttributes();
        initComponents();
    }

    private void readAttributes() {
        FarmAds a = new FarmAds();
        a.readAttFromFile("data\\attributes.txt");
        this.att = a.attributes;
        this.iv = a.ins_vecto;
        this.num_att = a.num_att;
    }

    private void status(int i) {
        if (i == 0) {
            this.jStatus.setText("Status: processing");
        } else if (i == 1) {
            this.jStatus.setText("Status: OK");
        } else if (i == 2) {
            this.jStatus.setText("Status: Error");
        }
    }
    
    private void detailInstances(Instances i)
    {
        String s = new String();
        s+="==== Thông tin dữ liệu ==== \n";
        s+="\n  Số lượng mẫu: " + i.numInstances();
        s+="\n  Số thuộc tính: 54877";
        this.tResult.setText(s);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        oTS = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        oTestSet = new javax.swing.JButton();
        jEval = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tResult = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        bCI = new javax.swing.JTextField();
        bOK = new javax.swing.JButton();
        bLoadModel = new javax.swing.JButton();
        bCMI = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSMO = new javax.swing.JButton();
        jNB = new javax.swing.JButton();
        jStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢNG CÁO NÔNG TRẠI");
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Training set:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 15, -1, -1));

        oTS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        oTS.setText("Open File");
        oTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oTSActionPerformed(evt);
            }
        });
        getContentPane().add(oTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Test set:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 56, -1, -1));

        oTestSet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        oTestSet.setText("Open File");
        oTestSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oTestSetActionPerformed(evt);
            }
        });
        getContentPane().add(oTestSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 52, -1, -1));

        jEval.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jEval.setText("Evaluation");
        jEval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEvalActionPerformed(evt);
            }
        });
        getContentPane().add(jEval, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 115, -1));

        tResult.setColumns(20);
        tResult.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        tResult.setRows(5);
        tResult.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Result", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane1.setViewportView(tResult);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 175, 697, 370));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Classify a Instance:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 143, -1, -1));

        bCI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(bCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 140, 470, -1));

        bOK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bOK.setText("Ok");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });
        getContentPane().add(bOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 139, -1, -1));

        bLoadModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bLoadModel.setText("Load Model");
        bLoadModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadModelActionPerformed(evt);
            }
        });
        getContentPane().add(bLoadModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 115, -1));

        bCMI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCMI.setText("Open File");
        bCMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCMIActionPerformed(evt);
            }
        });
        getContentPane().add(bCMI, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 103, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Classify Multi Instances:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 107, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Build Classifer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jSMO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSMO.setText("SMO");
        jSMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSMOActionPerformed(evt);
            }
        });
        jPanel1.add(jSMO);

        jNB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jNB.setText("Naive Bayes");
        jNB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNBActionPerformed(evt);
            }
        });
        jPanel1.add(jNB);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 200, 80));

        jStatus.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jStatus.setText("Status:");
        getContentPane().add(jStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 200, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // đọc file training set
    private void oTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oTSActionPerformed
        status(0);
        int oFile = uFile.showOpenDialog(this);
        if (oFile == JFileChooser.APPROVE_OPTION) {
            try {
                String url = uFile.getSelectedFile().getPath();
                String name = uFile.getSelectedFile().getName();
                int len = name.length();
                if (len >= 4 && name.substring(len - 4, len).equals(".txt")) {
                    //train = cls.readIntances(url);
                    train = cls.readIntances(url, att, num_att, iv);
                    JOptionPane.showMessageDialog(this, "Đọc file thành công!!");
                    detailInstances(train);
                    status(1);
                } else {
                    JOptionPane.showMessageDialog(this, "Kiểu file không hợp lệ!!"
                            + "\n Định dạng file: *.txt !!");
                    status(2);
                }
            } catch (Exception ex) {
                status(2);
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_oTSActionPerformed

    // đọc file test set
    private void oTestSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oTestSetActionPerformed
        // TODO add your handling code here:
        status(0);
        int oFile = uFile.showOpenDialog(this);
        if (oFile == JFileChooser.APPROVE_OPTION) {
            try {
                if (model != null && train != null) {
                    String url = uFile.getSelectedFile().getPath();
                    String name = uFile.getSelectedFile().getName();
                    int len = name.length();
                    if (len >= 4 && name.substring(len - 4, len).equals(".txt")) {
                        //test = cls.readIntances(url);
                        test = cls.readIntances(url, att, num_att, iv);
                        //eval = cls.evaluationModel(train, test, model);
                        //tResult.setText(cls.printEvaluation(eval));
                        JOptionPane.showMessageDialog(this, "Đọc file thành công!!");
                        detailInstances(test);
                        status(1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Kiểu file không hợp lệ!!"
                                + "\n Định dạng file: *.txt !!");
                        status(2);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn cần đọc file train và xây dựng mô hình trước!!");
                    status(2);
                }
            } catch (Exception ex) {
                status(2);
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_oTestSetActionPerformed

    // xây dựng mô hình sử dụng thuật toán SMO
    private void jSMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSMOActionPerformed
        status(0);
        try {
            // TODO add your handling code here:
            if (train != null) {
                JOptionPane.showMessageDialog(this, "Bắt đầu huấn luyện mô hình!!");
                model = cls.classifierSMO(train);
                tResult.setText(model.toString());
                cls.saveMoDel("data\\SMO", model);
                JOptionPane.showMessageDialog(this, "Huấn luyện mô hình thành công!!");
                status(1);
            } else {
                JOptionPane.showMessageDialog(this, "Bạn cần đọc file train trước!!");
                status(2);
            }
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            status(2);
        }
    }//GEN-LAST:event_jSMOActionPerformed

    // đánh giá mô hình
    private void jEvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEvalActionPerformed
        status(0);
        try {
            // TODO add your handling code here:            
            if (train != null && test != null) {
                JOptionPane.showMessageDialog(this, "Bắt đầu đánh giá mô hình!!");
                eval = cls.evaluationModel(train, test, model);
                tResult.setText(cls.printEvaluation(eval));
                JOptionPane.showMessageDialog(this, "Hoàn thành!!");
                status(1);
            } else {
                JOptionPane.showMessageDialog(this, "Ban can nhap file train va test!!");
                status(2);
            }
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jEvalActionPerformed

    // đọc mô hình từ file
    private void bLoadModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadModelActionPerformed
        // TODO add your handling code here:
        status(0);
        int oFile = uFile.showOpenDialog(this);
        if (oFile == JFileChooser.APPROVE_OPTION) {
            try {
                String url = uFile.getSelectedFile().getPath();
                String name = uFile.getSelectedFile().getName();
                int len = name.length();
                if (len >= 6 && name.substring(len - 6, len).equals(".model")) {
                    model = cls.loadModel(url);
                    JOptionPane.showMessageDialog(this, "Đọc file thành công!!");
                    tResult.setText(model.toString());
                    status(1);
                } else {
                    JOptionPane.showMessageDialog(this, "Kiểu file không hợp lệ!!"
                            + "\n Định dạng file: *.model !!");
                    status(2);
                }
            } catch (Exception ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bLoadModelActionPerformed

    // phân lớp nhiều mẫu bằng qua nhập file
    private void bCMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCMIActionPerformed
        // TODO add your handling code here:
        status(0);
        int oFile = uFile.showOpenDialog(this);
        if (oFile == JFileChooser.APPROVE_OPTION) {
            try {
                status(0);
                if (model != null) {
                    String url = uFile.getSelectedFile().getPath();
                    String name = uFile.getSelectedFile().getName();
                    int len = name.length();
                    if (len >= 4 && name.substring(len - 4, len).equals(".txt")) {
                        //test = cls.readIntances(url);
                        test = cls.readIntances(url, att, num_att, iv);

                        tResult.setText(cls.ClassifyMultiInstances(model, test));
                        JOptionPane.showMessageDialog(this, "Đọc file thành công!!"
                                + "\n Nhấn OK để xem kết quả phân lớp!!");
                        status(1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Kiểu file không hợp lệ!!"
                                + "\n Định dạng file: *.txt !!");
                        status(2);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn chưa xây dựng mô hình!!");
                }
            } catch (Exception ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bCMIActionPerformed

    //Xây dựng mô hình sử dụng thuật toán Naive Bayes
    private void jNBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNBActionPerformed
        // TODO add your handling code here:
        status(0);
        try {
            // TODO add your handling code here:
            if (train != null) {
                JOptionPane.showMessageDialog(this, "Bắt đầu huấn luyện mô hình!!");
                model = cls.classifierNB(train);
                tResult.setText(model.toString());
                cls.saveMoDel("data\\NB", model);
                JOptionPane.showMessageDialog(this, "Huấn luyện mô hình thành công!!");
                status(1);
            } else {
                JOptionPane.showMessageDialog(this, "Bạn cần đọc file train trước!!");
                status(2);
            }
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jNBActionPerformed

    // phân lớp cho một mẫu nhập từ bàn phím
    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        try {
            // TODO add your handling code here:
            status(0);
            if (model != null) {
                String s = cls.ClassifyInstance(model, bCI.getText().trim());
                tResult.setText(s);
                status(1);
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa xây dựng mô hình!!");
                status(2);
            }
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bOKActionPerformed

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
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Form().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bCI;
    private javax.swing.JButton bCMI;
    private javax.swing.JButton bLoadModel;
    private javax.swing.JButton bOK;
    private javax.swing.JButton jEval;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jNB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jSMO;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jStatus;
    private javax.swing.JButton oTS;
    private javax.swing.JButton oTestSet;
    private javax.swing.JTextArea tResult;
    // End of variables declaration//GEN-END:variables
}
