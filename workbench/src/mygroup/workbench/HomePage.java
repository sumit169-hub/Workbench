package mygroup.workbench;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class HomePage extends javax.swing.JFrame {
    String address = "localhost:3306";
    String database = "MySQL";
    Connection con = null;
    public HomePage() {
        initComponents();
        WorkBench.changeLook(this);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reset_button = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        datab_label = new javax.swing.JLabel();
        user_label = new javax.swing.JLabel();
        user_field = new javax.swing.JTextField();
        pass_label = new javax.swing.JLabel();
        pass_field = new javax.swing.JPasswordField();
        submit_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        config = new javax.swing.JButton();
        theme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        reset_button.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        reset_button.setText("Reset");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        title.setText("WorkBench");

        datab_label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        datab_label.setText("     Database");
        datab_label.setPreferredSize(new java.awt.Dimension(100, 25));

        user_label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        user_label.setText("Enter Username");
        user_label.setPreferredSize(new java.awt.Dimension(100, 25));

        user_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        pass_label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pass_label.setText("Enter Password");
        pass_label.setPreferredSize(new java.awt.Dimension(100, 25));

        pass_field.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        submit_button.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel1.setText("MySQL");

        config.setText("Config");
        config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configActionPerformed(evt);
            }
        });

        theme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/theme.png"))); // NOI18N
        theme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(theme))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(datab_label, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(78, 78, 78)
                                .addComponent(config))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reset_button, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pass_label, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pass_field))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(user_label, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(user_field, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(theme)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(datab_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(config))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit_button)
                    .addComponent(reset_button))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed

        user_field.setText("");
        pass_field.setText("");
    }//GEN-LAST:event_reset_buttonActionPerformed

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed

        String password = "";
        String username = user_field.getText();
        char[] chara = pass_field.getPassword();
        for (char c : chara) {
            password += c;
        }
        if ("".equals(username)) {
            JOptionPane.showMessageDialog(rootPane, "Enter Username ", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(password)) {
            JOptionPane.showMessageDialog(rootPane, "Enter Password ", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://" + address + "/", username, password);
                if (con.isValid(1)) {
                    new MySQLGUI(username, password, database, con);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Unable TO Connect", "Alert", JOptionPane.ERROR_MESSAGE);
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
            }
            close();
        }
        dispose();
    }//GEN-LAST:event_submit_buttonActionPerformed

    private void configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configActionPerformed
        // TODO add your handling code here:
        new ConfigF().setVisible(true);
    }//GEN-LAST:event_configActionPerformed

    private void themeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeActionPerformed
       WorkBench.changeLook(this);
    }//GEN-LAST:event_themeActionPerformed
    private void close() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    con.close();
                    System.exit(0);
                } catch (SQLException ex) {
                }
            }
        });
    }

    public class ConfigF extends javax.swing.JFrame {

        public ConfigF() {
            initComponents();
        }

        private void initComponents() {
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            port = new javax.swing.JTextField();
            host = new javax.swing.JTextField();
            jButton1 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Configuration");
            setAlwaysOnTop(true);
            setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
            setResizable(false);

            jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
            jLabel1.setText("Port             :");

            jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
            jLabel2.setText("Host             :");

            port.setText("3306");
            host.setText("localhost");
            jButton1.setText("Sumit");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(71, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(jLabel2)
                                            .addContainerGap(275, Short.MAX_VALUE)))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1)
                                    .addContainerGap(15, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(54, 54, 54)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(103, Short.MAX_VALUE)))
            );

            getAccessibleContext().setAccessibleParent(this);

            pack();
        }// </editor-fold>                        

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            address = host.getText() + ":" + port.getText();
            JOptionPane.showMessageDialog(this, "Configuration Changed", "Alert", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
        private javax.swing.JTextField host;
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JTextField port;
        // End of variables declaration                   
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton config;
    private javax.swing.JLabel datab_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField pass_field;
    private javax.swing.JLabel pass_label;
    private javax.swing.JButton reset_button;
    private javax.swing.JButton submit_button;
    private javax.swing.JButton theme;
    private javax.swing.JLabel title;
    private javax.swing.JTextField user_field;
    private javax.swing.JLabel user_label;
    // End of variables declaration//GEN-END:variables
}
