package mygroup.workbench;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModifyTable extends javax.swing.JFrame {

    String sql = "alter table ";
    Statement stmt = null;
    String column = "", dtype = "int";
    int dsize = 0;
    MySQLGUI mygui;
    public ModifyTable(String table, ArrayList<String> Columns, Statement st,MySQLGUI my) {
    	mygui=my;
        initComponents();
        WorkBench.setLook();
        sql += table;
        stmt = st;
        for (String s : Columns) {
            Cols_list.addItem(s);
        }
        column = Cols_list.getItemAt(Cols_list.getSelectedIndex());
        data_size.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cols_list = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        new_col_name = new javax.swing.JTextField();
        rename = new javax.swing.JButton();
        drop = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        data_type = new javax.swing.JComboBox<>();
        data_size = new javax.swing.JSpinner();
        modify = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        constraint1 = new javax.swing.JCheckBox();
        constraint2 = new javax.swing.JCheckBox();
        constraint3 = new javax.swing.JCheckBox();
        constraint4 = new javax.swing.JCheckBox();
        constraint5 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Structure");
        setAlwaysOnTop(true);
        setResizable(false);

        Cols_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Column --" }));
        Cols_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cols_listActionPerformed(evt);
            }
        });

        jLabel1.setText("Column             :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Enter Necessary Datails only");

        jLabel3.setText("New Name        :");

        rename.setText("Rename");
        rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameActionPerformed(evt);
            }
        });

        drop.setText("Drop");
        drop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropActionPerformed(evt);
            }
        });

        jLabel4.setText("Data Type          :");

        data_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INT", "CHAR", "VARCHAR", "DATE" }));
        data_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_typeActionPerformed(evt);
            }
        });

        data_size.setToolTipText("");

        modify.setText("Modify");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel5.setText("Constraints         :");

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

        constraint5.setText("Auto Increment");
        constraint5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constraint5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(drop)
                        .addGap(18, 18, 18)
                        .addComponent(rename)
                        .addGap(18, 18, 18)
                        .addComponent(modify))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cols_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(new_col_name)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(data_type, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(data_size, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(constraint1)
                                    .addComponent(constraint2)
                                    .addComponent(constraint3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(constraint4)
                                    .addComponent(constraint5))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cols_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_col_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(constraint1)
                    .addComponent(constraint4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(constraint2)
                    .addComponent(constraint5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(constraint3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(drop)
                    .addComponent(rename)
                    .addComponent(modify))
                .addGap(26, 26, 26))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropActionPerformed
        int i = Cols_list.getSelectedIndex();
        if (i == 0)
            JOptionPane.showMessageDialog(rootPane, "Please select Column");
        else {
            String sql2 = " drop column " + Cols_list.getItemAt(i);
            try {
                if (!stmt.execute(sql + sql2)) {
                    JOptionPane.showMessageDialog(rootPane, "Column Deleted");
                    Cols_list.removeItemAt(i);
                    mygui.showTable(2);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
        }
    }//GEN-LAST:event_dropActionPerformed

    private void renameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameActionPerformed
        int i = Cols_list.getSelectedIndex();
        String newcol = new_col_name.getText();
        String sql2;
        if (i == 0)
            JOptionPane.showMessageDialog(rootPane, "Please select Column");
        else if (newcol == null || newcol == "")
            JOptionPane.showMessageDialog(rootPane, "Enter valid name for new Column");
        else {
            String oldcol = Cols_list.getItemAt(Cols_list.getSelectedIndex());
            sql2 = " rename column " + oldcol + " to " + newcol;
            try {
                newcol.length();
                int n = JOptionPane.showConfirmDialog(rootPane, oldcol + " will be renamed as " + newcol);
                if (n == 0) {
                    if (!stmt.execute(sql + sql2)) {
                        JOptionPane.showMessageDialog(rootPane, "Column Name Changed");
                        mygui.showTable(2);
                        Cols_list.removeItemAt(i);
                        Cols_list.addItem(newcol);
                        new_col_name.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Canceled");
                }
            } catch (SQLException | NullPointerException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
        }
    }//GEN-LAST:event_renameActionPerformed

    private void data_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_typeActionPerformed
        int i = data_type.getSelectedIndex();
        if (i == 2 || i == 1)
            data_size.setEnabled(true);
        else
            data_size.setEnabled(false);
    }//GEN-LAST:event_data_typeActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
        String msg;
        if (Cols_list.getSelectedIndex() == 0) {
            msg = "Select Column to Modify";
        } else {
            dtype = data_type.getItemAt(data_type.getSelectedIndex());
            dsize = (int) data_size.getValue();
            String constraint = createConstraint();
            String sql2 = " modify " + column + " " + dtype + "(" + dsize + ")" + constraint;
            try {
                int n = JOptionPane.showConfirmDialog(rootPane, "Data type : " + dtype + "\n Size: " + dsize + "\nConstraints as" + constraint, "Modify Column as", JOptionPane.INFORMATION_MESSAGE);
                if (n == 0) {
                    if (stmt.executeUpdate(sql + sql2) > 0) {
                        msg = "Success";
                        mygui.showTable(2);
                    } else {
                        msg = "Failed";
                    }
                } else {
                    msg = "Canceled";
                }
            } catch (SQLException e) {
                msg = e.getMessage();
            }
        }
        JOptionPane.showMessageDialog(rootPane, msg);

    }//GEN-LAST:event_modifyActionPerformed

    private void Cols_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cols_listActionPerformed
        column = Cols_list.getItemAt(Cols_list.getSelectedIndex());
    }//GEN-LAST:event_Cols_listActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String newcol = new_col_name.getText();
        String msg;
        String constraint = "";
        if (newcol == "" || newcol == null) {
            msg = "Enter Valid Column Name";
        } else {
            try {
                dtype = data_type.getItemAt(data_type.getSelectedIndex());
                dsize = (int) data_size.getValue();
                constraint = createConstraint();
                String sql2 = " add column " + newcol + " " + dtype + "(" + dsize + ")" + constraint;
                stmt.execute(sql + sql2);
                msg = "Success";
                Cols_list.addItem(newcol);
                mygui.showTable(2);
                new_col_name.setText("");
            } catch (SQLException e) {
                msg = "Column name already Exists or Wrong column structure.\nCheck Table Structure.";
            }
        }
        JOptionPane.showMessageDialog(rootPane, msg);
    }//GEN-LAST:event_addActionPerformed
    private String createConstraint() {
        String constraint = "";
        if (constraint1.isSelected()) {
            constraint += " " + constraint1.getText();
        }
        if (constraint2.isSelected()) {
            constraint += " " + constraint2.getText();
        }
        if (constraint4.isSelected()) {
            constraint += " " + constraint4.getText();
        }
        if (constraint5.isSelected()) {
            constraint += " " + constraint5.getText();
        }
        if (constraint3.isSelected()) {
            String str = JOptionPane.showInputDialog(rootPane, "Enter Default Value");
            if (str.length() != 0) {
                constraint += " " + constraint3.getText() + " '" + str + "'";
            }
        }
        return constraint;
    }
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
    private void constraint5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constraint5ActionPerformed

    }//GEN-LAST:event_constraint5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cols_list;
    private javax.swing.JButton add;
    private javax.swing.JCheckBox constraint1;
    private javax.swing.JCheckBox constraint2;
    private javax.swing.JCheckBox constraint3;
    private javax.swing.JCheckBox constraint4;
    private javax.swing.JCheckBox constraint5;
    private javax.swing.JSpinner data_size;
    private javax.swing.JComboBox<String> data_type;
    private javax.swing.JButton drop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton modify;
    private javax.swing.JTextField new_col_name;
    private javax.swing.JButton rename;
    // End of variables declaration//GEN-END:variables
}
