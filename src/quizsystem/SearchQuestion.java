/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizsystem;

import java.awt.event.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.Timer;

/**
 *
 * @author abdullahalmashuk
 */
public class SearchQuestion extends javax.swing.JFrame {

    String JDBCConName = "jdbc:derby://localhost:1527/C:/Users/Mashuk/.netbeans-derby/QUIZ";
    String JDBCusername = "quiz";
    String JDBCpassword = "123";
    
    /**
     * Creates new form SearchPanel
     */
    public SearchQuestion() {
        initComponents();
        this.setTitle("Search Question");
        this.setLocationRelativeTo(null);
        
        DateFormat df = new SimpleDateFormat("dd.MM.yy");
        Date d = new Date();
        date.setText(df.format(d));
        
        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date d1 = new Date();
                time.setText(df2.format(d1));
            }
        };
        Timer t = new Timer(1000, timerListener);
        // to make sure it doesn't wait one second at the start
        t.setInitialDelay(0);
        t.start();
        
        try{
            Connection con;
            Statement stmt;
            ResultSet rs;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection(JDBCConName,JDBCusername,JDBCpassword);
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            rs=stmt.executeQuery("select qnum from APP.QNUM");
            rs.last();
            int qNum = Integer.parseInt(rs.getString(1))-1;
            qTotal.setText("There are Total "+qNum+" Question(s) Now");
        }
        catch(Exception px) 
        {
            JOptionPane.showMessageDialog(null,px.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        crAns = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        home = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sQuestion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        sOptA = new javax.swing.JTextField();
        sOptB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        qTotal = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        qID = new javax.swing.JTextField();
        qSetup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search Question");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        crAns.setEditable(false);
        crAns.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel4.setText("Correct Answer:");

        search.setBackground(new java.awt.Color(204, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        home.setBackground(new java.awt.Color(204, 255, 255));
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        sQuestion.setEditable(false);
        sQuestion.setColumns(20);
        sQuestion.setLineWrap(true);
        sQuestion.setRows(5);
        sQuestion.setWrapStyleWord(true);
        sQuestion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));
        sQuestion.setMaximumSize(new java.awt.Dimension(164, 2147483647));
        jScrollPane1.setViewportView(sQuestion);

        jLabel3.setText("Option A:");

        sOptA.setEditable(false);
        sOptA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        sOptB.setEditable(false);
        sOptB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel5.setText("Option B:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        qTotal.setForeground(new java.awt.Color(255, 153, 0));

        time.setForeground(new java.awt.Color(255, 153, 0));

        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Time:");

        date.setForeground(new java.awt.Color(255, 153, 0));

        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Date:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(qTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(qTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel6.setText("Question:");

        jLabel7.setText("Q. ID:");

        qID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        qSetup.setBackground(new java.awt.Color(204, 255, 255));
        qSetup.setText("Setup");
        qSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qSetupActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(153, 204, 255));
        jLabel2.setText("Note: Correct Answer Must Be Submitted As \"A\" or \"B\" Only.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(22, 22, 22)
                                .addComponent(sOptA, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sOptB, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(qID, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(search))))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(crAns, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(qSetup)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(home)))))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(search)
                    .addComponent(home)
                    .addComponent(qSetup))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sOptA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sOptB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        int getQId = Integer.parseInt(qID.getText());
        String getQuestion = sQuestion.getText();
        String getOptA = sOptA.getText();
        String getOptB = sOptB.getText();
        String getCrAns = crAns.getText();
        
        try{
            Connection con;
            Statement stmt;
            ResultSet rs;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con=DriverManager.getConnection(JDBCConName,JDBCusername,JDBCpassword);
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            if(getQId==0)
            {
                JOptionPane.showMessageDialog(null,"Fill up the Search Form Correctly!");
            }
            else
            {
                rs=stmt.executeQuery("select question,a,b,correctanswer from APP.QUIZ where quizid= "+getQId+" ");
                rs.first();
                
                sQuestion.setText(rs.getString(1));
                sOptA.setText(rs.getString(2));
                sOptB.setText(rs.getString(3));
                crAns.setText(rs.getString(4));
            }
            
        }
        catch(Exception px) 
        {
//            JOptionPane.showMessageDialog(null,px.getMessage());
            JOptionPane.showMessageDialog(null,"Such Question hasn't Set Yet!");
        }
    }//GEN-LAST:event_searchActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        new JoinPageAdmin().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeActionPerformed

    private void qSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qSetupActionPerformed
        // TODO add your handling code here:
        new QuestionSetting().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_qSetupActionPerformed

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
            java.util.logging.Logger.getLogger(SearchQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField crAns;
    private javax.swing.JLabel date;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField qID;
    private javax.swing.JButton qSetup;
    private javax.swing.JLabel qTotal;
    private javax.swing.JTextField sOptA;
    private javax.swing.JTextField sOptB;
    private javax.swing.JTextArea sQuestion;
    private javax.swing.JButton search;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}