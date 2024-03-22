package mygroup.workbench;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class CreateTable extends javax.swing.JFrame {

    Statement stmt;
    String sql = null, sql2 = "";
    JCheckBox[] cons_arr;

    public CreateTable(Statement s) {
        stmt=s;
        initComponents();
        WorkBench.setLook();
        setVisible(true);
        data_size.setEnabled(false);
        cons_arr = new JCheckBox[]{constraint1, constraint2, constraint3, constraint4, constraint5};
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        new_table = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        column_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        constraint5 = new javax.swing.JCheckBox();
        data_type = new javax.swing.JComboBox<>();
        data_size = new javax.swing.JSpinner();
        constraint1 = new javax.swing.JCheckBox();
        constraint2 = new javax.swing.JCheckBox();
        constraint3 = new javax.swing.JCheckBox();
        constraint4 = new javax.swing.JCheckBox();
        add = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Table");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Table Name       :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Column Details  ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Name            :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Data Type     :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Constraint     :");

        constraint5.setText("Auto Increment");
        constraint5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constraint5ActionPerformed(evt);
            }
        });

        data_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INT", "CHAR", "VARCHAR", "DATE" }));
        data_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_typeActionPerformed(evt);
            }
        });

        data_size.setToolTipText("");

        constraint1.setText("Primary Key");
        constraint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constraint1ActionPerformed(evt);
            }
        });

        constraint2.setText("Not NULL");
        constraint2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constraint2ActionPerformed(evt);
            }
        });

        constraint3.setText("Default");
        constraint3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constraint3ActionPerformed(evt);
            }
        });

        constraint4.setText("unique");
        constraint4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constraint4ActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(column_name, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(data_type, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(data_size, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(constraint2)
                                                .addComponent(constraint3))
                                            .addGap(29, 29, 29))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(constraint1)
                                            .addGap(18, 18, 18)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(constraint4)
                                        .addComponent(constraint5))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(add)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(new_table, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(reset)))))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(new_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(column_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(data_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(data_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(constraint1)
                            .addComponent(constraint4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(constraint2)
                            .addComponent(constraint5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(constraint3)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(31, 31, 31))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void constraint5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constraint5ActionPerformed

    }//GEN-LAST:event_constraint5ActionPerformed

    private void data_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_typeActionPerformed
        int i = data_type.getSelectedIndex();
        if (i == 2 || i == 1)
            data_size.setEnabled(true);
        else
            data_size.setEnabled(false);
    }//GEN-LAST:event_data_typeActionPerformed

    private void constraint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constraint1ActionPerformed
        if (constraint1.isSelected()) {
            constraint2.setEnabled(false);
            constraint3.setEnabled(false);
            constraint4.setEnabled(false);
        } else {
            constraint2.setEnabled(true);
            constraint3.setEnabled(true);
            constraint4.setEnabled(true);
        }
    }//GEN-LAST:event_constraint1ActionPerformed

    private void constraint2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constraint2ActionPerformed

    }//GEN-LAST:event_constraint2ActionPerformed

    private void constraint3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constraint3ActionPerformed
        if (constraint3.isSelected()) {
            constraint4.setEnabled(false);
            constraint2.setEnabled(false);
        } else {
            constraint4.setEnabled(true);
            constraint2.setEnabled(true);
        }
    }//GEN-LAST:event_constraint3ActionPerformed

    private void constraint4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constraint4ActionPerformed
        if (constraint4.isSelected()) {
            constraint3.setEnabled(false);
        } else
            constraint3.setEnabled(true);
    }//GEN-LAST:event_constraint4ActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        clear();
    }//GEN-LAST:event_resetActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String col_name, dtype;
        String cons = "";
        int dsize;
        String msg;
        col_name = column_name.getText();
        if (col_name.isBlank()) {
            msg = "Column name Can't Be empty";
        } else {
            dtype = data_type.getItemAt(data_type.getSelectedIndex());
            dsize = (int) data_size.getValue();
            sql2 += col_name + " " + dtype;
            if (dsize > 0) {
                sql2 += "(" + dsize + ")";
            }
            if (constraint1.isSelected()) {
                cons += " Primary Key";
            }
            if (constraint2.isSelected()) {
                cons += " Not Null";
            }
            if (constraint3.isSelected()) {
                cons += " Default '"+JOptionPane.showInputDialog(rootPane,"Enter Default value")+"'";
            }
            if (constraint4.isSelected()) {
                cons += " Unique";
            }
            if (constraint5.isSelected()) {
                cons += " Auto Increment";
            }
            sql2 += cons + ",";
            clear();
        }

    }//GEN-LAST:event_addActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String table_name, msg;
        table_name = new_table.getText();
        sql = "Create table ";
        if (table_name.isBlank()) {
            msg = "Table name Can't Be blank";
        } else {
            sql += table_name + "(" + sql2.substring(0, sql2.length() - 1) + ")";
            try {
                stmt.execute(sql);
                msg = "Success";
            } catch (SQLException e) {
                msg = "Failed";
            }
            clear();
            new_table.setText("");
            sql = sql2 = "";
        }
        JOptionPane.showMessageDialog(rootPane, msg);
    }//GEN-LAST:event_submitActionPerformed
    private void clear() {
        column_name.setText("");
        for (JCheckBox obj : cons_arr) {
            obj.setEnabled(true);
            obj.setSelected(false);
        }
        data_type.setSelectedIndex(0);
        data_size.setValue(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField column_name;
    private javax.swing.JCheckBox constraint1;
    private javax.swing.JCheckBox constraint2;
    private javax.swing.JCheckBox constraint3;
    private javax.swing.JCheckBox constraint4;
    private javax.swing.JCheckBox constraint5;
    private javax.swing.JSpinner data_size;
    private javax.swing.JComboBox<String> data_type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField new_table;
    private javax.swing.JButton reset;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
