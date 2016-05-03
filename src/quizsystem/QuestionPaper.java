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
import java.util.concurrent.TimeUnit;

/**
 *
 * @author abdullahalmashuk
 */
public class QuestionPaper extends javax.swing.JFrame {

    String JDBCConName = "jdbc:derby://localhost:1527/C:/Users/Mashuk/.netbeans-derby/QUIZ";
    String JDBCusername = "quiz";
    String JDBCpassword = "123";
    
    public int seconds;
    public int id=0;
    public int tQues=0,cAns=0,wAns=0;
    int max = 2;
    boolean exit= false;
    /**
     * Creates new form QuestionPaper
     */
    public QuestionPaper() {
        initComponents();
        this.setTitle("Take A Test");
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
            int qid = Integer.parseInt(rs.getString(1))-1;
            tQues= qid;
            id = 1;
            rs=stmt.executeQuery("select question,a,b from APP.QUIZ where quizid= "+id+"");
            rs.first();
            
            qs.setText(rs.getString(1));
            answerA.setText(rs.getString(2));
            answerB.setText(rs.getString(3));
            
            rs=stmt.executeQuery("select profile from APP.CPROFILE");
            rs.last();
            profileID.setText(rs.getString(1));
            
            rs=stmt.executeQuery("select currenttime from APP.TIME");
            rs.last();
            seconds = Integer.parseInt(rs.getString(1));
            
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seconds--;
                    int day = (int) TimeUnit.SECONDS.toDays(seconds);
                    long hours = TimeUnit.SECONDS.toHours(seconds) - (day * 24);
                    long minute = TimeUnit.SECONDS.toMinutes(seconds)
                            - (TimeUnit.SECONDS.toHours(seconds) * 60);
                    long second = TimeUnit.SECONDS.toSeconds(seconds)
                            - (TimeUnit.SECONDS.toMinutes(seconds) * 60);
                    timeLabelLarge.setText(hours+":" +minute + ":"
                            +second);
                    if (seconds == 0) {
                        showmassege();
                    }
                }
            });
            timer.start();
        }
        catch(Exception px) 
        {
//            JOptionPane.showMessageDialog(null,px.getMessage());
        }
        
        setBar();
        if(id==tQues)
            next.setText("Finish");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        qs = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        answerB = new javax.swing.JTextField();
        answerA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        clickA = new javax.swing.JButton();
        clickB = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        timeLabelLarge = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        profileID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        progBar = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        qs.setEditable(false);
        qs.setColumns(20);
        qs.setLineWrap(true);
        qs.setRows(5);
        qs.setWrapStyleWord(true);
        qs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));
        qs.setMaximumSize(new java.awt.Dimension(164, 2147483647));
        jScrollPane1.setViewportView(qs);

        jLabel1.setText("Question: ");

        jLabel2.setText("Option A:");

        jLabel3.setText("Option B:");

        answerB.setEditable(false);
        answerB.setBackground(new java.awt.Color(255, 255, 255));
        answerB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        answerA.setEditable(false);
        answerA.setBackground(new java.awt.Color(255, 255, 255));
        answerA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel4.setText("Choose the Correct Option: ");

        clickA.setBackground(new java.awt.Color(204, 255, 255));
        clickA.setText("A");
        clickA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickAActionPerformed(evt);
            }
        });

        clickB.setBackground(new java.awt.Color(204, 255, 255));
        clickB.setText("B");
        clickB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickBActionPerformed(evt);
            }
        });

        next.setBackground(new java.awt.Color(204, 255, 255));
        next.setText("Next >");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quiz Test");

        timeLabelLarge.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        timeLabelLarge.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeLabelLarge, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(timeLabelLarge, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(265, 45));

        profileID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        profileID.setForeground(new java.awt.Color(153, 204, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 204, 255));
        jLabel7.setText("Profile:");

        time.setForeground(new java.awt.Color(255, 153, 0));

        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Time:");

        date.setForeground(new java.awt.Color(255, 153, 0));

        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Date:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(profileID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(profileID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        progBar.setForeground(new java.awt.Color(153, 204, 255));
        progBar.setBorderPainted(false);
        progBar.setStringPainted(true);

        jLabel8.setText("Progress:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(clickA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clickB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(answerB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                        .addComponent(answerA, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(54, 54, 54))
                            .addComponent(progBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(answerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(answerB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clickA)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(next)
                        .addComponent(clickB))
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void showmassege()
    {
        if(!exit){
            JOptionPane.showMessageDialog(null,"Time's Up!");
            try{
                    Connection con;
                    Statement stmt;
                    ResultSet rs;
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con=DriverManager.getConnection(JDBCConName,JDBCusername,JDBCpassword);
                    stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    
                    rs=stmt.executeQuery("select correctanswer,wronganswer from APP.RESULT");
                    rs.last();
                    String correctAnswer = rs.getString(1);
                    String wrongAnswer = rs.getString(2);
                    
                    rs=stmt.executeQuery("select profile from APP.CPROFILE");
                    rs.last();
                    String profileId = rs.getString(1);
                    stmt.execute("insert into APP.MARK values('"+profileId+"','"+correctAnswer+"','"+wrongAnswer+"')");
                }
                catch(Exception px) 
                {
                    if(id<=tQues)
                    {
//                        JOptionPane.showMessageDialog(null,px.getMessage());
                    }
                }
            new Result().setVisible(true);
            this.setVisible(false);
        }
    }
    private void setBar()
    {
        progBar.setMinimum(0);
        progBar.setMaximum(tQues);
        progBar.setValue(1);
        progBar.setString("1 of "+tQues);
        progBar.setStringPainted(true);
    }
    
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        
        String msgA = clickA.getText();
        String msgB = clickB.getText();
        
        if((msgA.equals("Done")==false)&&(msgB.equals("Done")==false))
        {
            JOptionPane.showMessageDialog(null,"Choose Options Correctly!");
        }
        else
        {
            id++;
            if(id==tQues)
                next.setText("Finish");
            else if(id>tQues)
            {
                try{
                    Connection con;
                    Statement stmt;
                    ResultSet rs;
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con=DriverManager.getConnection(JDBCConName,JDBCusername,JDBCpassword);
                    stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    
                    rs=stmt.executeQuery("select correctanswer,wronganswer from APP.RESULT");
                    rs.last();
                    String correctAnswer = rs.getString(1);
                    String wrongAnswer = rs.getString(2);
                    
                    rs=stmt.executeQuery("select profile from APP.CPROFILE");
                    rs.last();
                    String profileId = rs.getString(1);
                    stmt.execute("insert into APP.MARK values('"+profileId+"','"+correctAnswer+"','"+wrongAnswer+"')");
                }
                catch(Exception px) 
                {
                    if(id<=tQues)
                    {
//                        JOptionPane.showMessageDialog(null,px.getMessage());
                    }
                }
                exit = true;
                new Result().setVisible(true);
                this.setVisible(false);
            }
            
            clickA.setText("A");
            clickB.setText("B");
            try{
                Connection con;
                Statement stmt;
                ResultSet rs;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con=DriverManager.getConnection(JDBCConName,JDBCusername,JDBCpassword);
                stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                
                
                rs=stmt.executeQuery("select question,a,b from APP.QUIZ where quizid= "+id+"");
                rs.first();

                qs.setText(rs.getString(1));
                answerA.setText(rs.getString(2));
                answerB.setText(rs.getString(3));
                
                progBar.setString(max+" of "+tQues);
                progBar.setValue(max);
                max++;
            }
            catch(Exception px) 
            {
                if(id<=tQues)
                {
//                    JOptionPane.showMessageDialog(null,px.getMessage());
                }
            }
        }
        
    }//GEN-LAST:event_nextActionPerformed

    private void clickBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickBActionPerformed
        // TODO add your handling code here:
        if(clickB.getText().equals("Done")==true)
        {
            JOptionPane.showMessageDialog(null, "Sorry, Can't Click Twice!");
        }
        else
        {
            try{
                Connection con;
                Statement stmt;
                ResultSet rs;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con=DriverManager.getConnection(JDBCConName,JDBCusername,JDBCpassword);
                stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

                clickA.setText("Done");
                clickB.setText("Done");

                rs=stmt.executeQuery("select correctanswer from APP.QUIZ where quizid= "+id+" ");
                rs.first();
                String clicked = "B";
                String correctAns = rs.getString(1);
                if(clicked.equals(correctAns)==true)
                {
                    cAns++;
                    stmt.execute("insert into APP.RESULT values("+id+","+tQues+","+cAns+","+wAns+")");
                }
                else
                {
                    wAns++;
                    stmt.execute("insert into APP.RESULT values("+id+","+tQues+","+cAns+","+wAns+")");
                }
            }
            catch(Exception px)
            {
                JOptionPane.showMessageDialog(null,px.getMessage());
            }
        }
    }//GEN-LAST:event_clickBActionPerformed

    private void clickAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickAActionPerformed
        // TODO add your handling code here:
        if(clickA.getText().equals("Done")==true)
        {
            JOptionPane.showMessageDialog(null, "Sorry, Can't Click Twice!");
        }
        else
        {
            try{
                Connection con;
                Statement stmt;
                ResultSet rs;
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con=DriverManager.getConnection(JDBCConName,JDBCusername,JDBCpassword);
                stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

                clickA.setText("Done");
                clickB.setText("Done");

                rs=stmt.executeQuery("select correctanswer from APP.QUIZ where quizid= "+id+"");
                rs.first();
                String clicked = "A";
                String correctAns = rs.getString(1);
                if(clicked.equals(correctAns)==true)
                {
                    cAns++;
                    stmt.execute("insert into APP.RESULT values("+id+","+tQues+","+cAns+","+wAns+")");
                }
                else
                {
                    wAns++;
                    stmt.execute("insert into APP.RESULT values("+id+","+tQues+","+cAns+","+wAns+")");
                }
            }
            catch(Exception px)
            {
                JOptionPane.showMessageDialog(null,px.getMessage());
            }
        }

    }//GEN-LAST:event_clickAActionPerformed

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
            java.util.logging.Logger.getLogger(QuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionPaper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerA;
    private javax.swing.JTextField answerB;
    private javax.swing.JButton clickA;
    private javax.swing.JButton clickB;
    private javax.swing.JLabel date;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JLabel profileID;
    private javax.swing.JProgressBar progBar;
    private javax.swing.JTextArea qs;
    private javax.swing.JLabel time;
    private javax.swing.JLabel timeLabelLarge;
    // End of variables declaration//GEN-END:variables
}