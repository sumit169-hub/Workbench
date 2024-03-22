package mygroup.workbench;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
public class MySQLGUI extends javax.swing.JFrame {

    protected String user, pass, database, sql = "";
    protected Connection con;
    protected Statement stmt;
    protected Connect con_exe;
    String table;
    JButton[] table_buttons;

    public MySQLGUI() {
    }

    public MySQLGUI(String username, String password, String data, Connection connection) {
        user = username;
        pass = password;
        database = data;
        con = connection;
        setTitle("Workbench-" + data);
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            con_exe = new Connect(con, stmt, rootPane);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
        }
        
        initComponents();
        showDatabases();
        WorkBench.setLook();
        setVisible(true);
        table_buttons = new JButton[]{show, insert_row, update_row, delete_row, clear_table, copy, manual, run_manual, modify_struct, rename};
        disableTableButtons();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    stmt.close();
                    con.close();
                    new HomePage();
                    dispose();
                } catch (SQLException ex) {
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        createdb_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        create_table_button = new javax.swing.JButton();
        table_list = new javax.swing.JComboBox<>();
        datab_list = new javax.swing.JComboBox<>();
        deletedb_button = new javax.swing.JButton();
        delete_table_button = new javax.swing.JButton();
        show = new javax.swing.JButton();
        table_scroll = new javax.swing.JScrollPane();
        insert_row = new javax.swing.JButton();
        update_row = new javax.swing.JButton();
        delete_row = new javax.swing.JButton();
        clear_table = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        copy = new javax.swing.JButton();
        manual = new javax.swing.JButton();
        describe = new javax.swing.JButton();
        run_manual = new javax.swing.JButton();
        modify_struct = new javax.swing.JButton();
        rename = new javax.swing.JButton();
        cols_list = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Select Database :");

        createdb_button.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        createdb_button.setText("Create Database");
        createdb_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createdb_buttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Select Table       :");

        create_table_button.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        create_table_button.setText("Create Table");
        create_table_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_table_buttonActionPerformed(evt);
            }
        });

        table_list.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Available Tables --" }));
        table_list.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                table_listFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                table_listFocusLost(evt);
            }
        });
        table_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_listMouseClicked(evt);
            }
        });
        table_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table_listActionPerformed(evt);
            }
        });

        datab_list.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        datab_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Available Databases--" }));
        datab_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datab_listActionPerformed(evt);
            }
        });

        deletedb_button.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        deletedb_button.setText("Delete Database");
        deletedb_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletedb_buttonActionPerformed(evt);
            }
        });

        delete_table_button.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        delete_table_button.setText("Delete Table");
        delete_table_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_table_buttonActionPerformed(evt);
            }
        });

        show.setText("Show Table");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        insert_row.setText("Insert Data");
        insert_row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_rowActionPerformed(evt);
            }
        });

        update_row.setText("Update");
        update_row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_rowActionPerformed(evt);
            }
        });

        delete_row.setText("Delete ");
        delete_row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_rowActionPerformed(evt);
            }
        });

        clear_table.setText("Clear");
        clear_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_tableActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel3.setText("Table Operation");
        copy.setText("Copy");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        manual.setText("Manual view");
        manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualActionPerformed(evt);
            }
        });

        describe.setText("Describe");
        describe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                describeActionPerformed(evt);
            }
        });

        run_manual.setText("Run Manual");
        run_manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                run_manualActionPerformed(evt);
            }
        });

        modify_struct.setText("Modify Structure");
        modify_struct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_structActionPerformed(evt);
            }
        });

        rename.setText("Rename Table");
        rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameActionPerformed(evt);
            }
        });

        cols_list.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Column to Sort" }));
        cols_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cols_listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(table_list, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datab_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(describe))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(createdb_button, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(create_table_button, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deletedb_button, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delete_table_button, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modify_struct)
                                .addGap(18, 18, 18)
                                .addComponent(rename)
                                .addGap(29, 29, 29)
                                .addComponent(cols_list, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(table_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(show, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(insert_row, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update_row, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete_row, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(copy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(run_manual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(datab_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createdb_button, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletedb_button, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create_table_button, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(delete_table_button, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rename, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cols_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(describe)
                        .addComponent(modify_struct)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(show)
                .addGap(18, 18, 18)
                .addComponent(insert_row)
                .addGap(18, 18, 18)
                .addComponent(update_row)
                .addGap(18, 18, 18)
                .addComponent(delete_row)
                .addGap(18, 18, 18)
                .addComponent(clear_table)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(copy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(run_manual)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createdb_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createdb_buttonActionPerformed
        String new_database = "";
        new_database = JOptionPane.showInputDialog(rootPane, "Enter Database Name", "Create Database", JOptionPane.OK_CANCEL_OPTION);
        if (new_database.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Enter database name", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            sql = "CREATE DATABASE " + new_database;
        }
        try {
            if (stmt.executeUpdate(sql) > 0) {
                JOptionPane.showMessageDialog(rootPane, "Database Created Successfully ", "Congratulation", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Database Error ", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
            }
            datab_list.addItem(new_database);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Database Creation Failed ", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_createdb_buttonActionPerformed

    private void create_table_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_table_buttonActionPerformed
        if (datab_list.getSelectedIndex() == 0)
            JOptionPane.showMessageDialog(rootPane, "Select Database", "Alert", JOptionPane.WARNING_MESSAGE);
        else {
               new CreateTable(stmt);
        }
    }//GEN-LAST:event_create_table_buttonActionPerformed

    private void table_listFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_table_listFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_table_listFocusGained

    private void table_listFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_table_listFocusLost
        // TODO add your handling code here:
        if (table_list.getSelectedIndex() == 0)
            JOptionPane.showMessageDialog(rootPane, "Select Valid Table", "Alert", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_table_listFocusLost

    private void table_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_listMouseClicked
        if (datab_list.getSelectedIndex() == 0)
            JOptionPane.showMessageDialog(rootPane, "Select Database", "Alert", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_table_listMouseClicked

    private void table_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table_listActionPerformed
        if (datab_list.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Select Database First", "Alert", JOptionPane.ERROR_MESSAGE);
        } else {
            table = table_list.getItemAt(table_list.getSelectedIndex());
        }
        disableTableButtons();
    }//GEN-LAST:event_table_listActionPerformed

    private void datab_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datab_listActionPerformed
        if (datab_list.getSelectedIndex() != 0) {
            try {
                stmt.executeUpdate("use " + datab_list.getItemAt(datab_list.getSelectedIndex()));
                showTablesList();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Something Went Wrong", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            table_list.removeAllItems();
            table_list.addItem("--Available Table--");
            JOptionPane.showMessageDialog(rootPane, "Please Select Database", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_datab_listActionPerformed
    private void deletedb_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletedb_buttonActionPerformed
        int n = datab_list.getSelectedIndex();
        String db = datab_list.getItemAt(n);
        sql = "drop database " + db;
        if (n == 0)
            JOptionPane.showMessageDialog(rootPane, "Select Database", "Alert", JOptionPane.ERROR_MESSAGE);
        else {
            try {
                if (JOptionPane.showConfirmDialog(rootPane, "Do you want to delete database " + db, "Confirmation", JOptionPane.OK_CANCEL_OPTION) == 0) {
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(rootPane, "Database Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    datab_list.removeItemAt(n);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Something Went Wrong", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deletedb_buttonActionPerformed
    private void delete_table_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_table_buttonActionPerformed

        int n = table_list.getSelectedIndex();
        String tb = table_list.getItemAt(n);
        sql = "drop table " + tb;
        if (n == 0)
            JOptionPane.showMessageDialog(rootPane, "Select Table", "Alert", JOptionPane.ERROR_MESSAGE);
        else {
            try {
                if (JOptionPane.showConfirmDialog(rootPane, "Do you want to delete table " + tb, "Confirmation", JOptionPane.OK_CANCEL_OPTION) == 0) {
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(rootPane, "Table Deleted", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    table_list.removeItemAt(n);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Something Went Wrong", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_delete_table_buttonActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        if (table_list.getSelectedIndex() == 0)
            JOptionPane.showMessageDialog(rootPane, "Please select a table", "Alert", JOptionPane.WARNING_MESSAGE);
        else
            showTable(0);
    }//GEN-LAST:event_showActionPerformed

    private void insert_rowActionPerformed(java.awt.event.ActionEvent evt) {
//        if (con_exe.excuteInsert(con, table) > 0) {
//            JOptionPane.showMessageDialog(rootPane, "Data Inserted Sucessfully", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Error", JOptionPane.WARNING_MESSAGE);
//        }
        con_exe.excuteInsert(table,this);
    }
    private void clear_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_tableActionPerformed
        int n = JOptionPane.showConfirmDialog(rootPane, "Are you Sure ?", "Clear Data from " + table, JOptionPane.OK_CANCEL_OPTION);
        if (n == 0) {
            con_exe.truncateQuery(table);
        }
        showTable(0);
    }//GEN-LAST:event_clear_tableActionPerformed

    private void delete_rowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_rowActionPerformed
        try {
            if (con_exe.deleteQuery(table)) {
                JOptionPane.showMessageDialog(rootPane, "Data Deleted Successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
            showTable(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Data Not Deleted", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        showTable(0);
    }//GEN-LAST:event_delete_rowActionPerformed

    private void update_rowActionPerformed(java.awt.event.ActionEvent evt) {
        con_exe.updateQuery(table,this);
    }

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        int n = con_exe.copyData();
        JOptionPane.showMessageDialog(rootPane, n + " rows copied", "Info", JOptionPane.INFORMATION_MESSAGE);
        showTablesList();
    }//GEN-LAST:event_copyActionPerformed

    private void manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualActionPerformed
        showTable(1);
    }//GEN-LAST:event_manualActionPerformed

    private void describeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_describeActionPerformed
        if (table_list.getSelectedIndex() != 0) {
            showTable(2);
            cols_list.removeAllItems();
            ArrayList<String> cols = new TableData(stmt, table).createColumn();
            for(String s:cols) cols_list.addItem(s);
            enableTableButtons();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please select a table", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_describeActionPerformed

    private void run_manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_run_manualActionPerformed
        con_exe.runQuery();
        showTable(0);
    }//GEN-LAST:event_run_manualActionPerformed

    private void modify_structActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify_structActionPerformed
        if (table_list.getSelectedIndex() == 0)
            JOptionPane.showMessageDialog(rootPane, "Select Table");
        else {
            ArrayList<String> cols = new TableData(stmt, table).createColumn();
            new ModifyTable(table, cols, stmt,this).setVisible(true);
        }
    }//GEN-LAST:event_modify_structActionPerformed

    private void renameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameActionPerformed
        String msg=con_exe.renameTable(table);
        if(msg!=table) 
        {
            table_list.removeItemAt(table_list.getSelectedIndex());
            table_list.addItem(msg);
        }
    }//GEN-LAST:event_renameActionPerformed

    private void cols_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cols_listActionPerformed
        if(show.isEnabled()) showTable(3);
    }//GEN-LAST:event_cols_listActionPerformed
    private void showDatabases() {
        try {
            ResultSet result = stmt.executeQuery("show databases");
            while (result.next()) {
                datab_list.addItem(result.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showTablesList() {
        try {
            ResultSet result = con_exe.showTableList();
            if (result != null) {
                table_list.removeAllItems();
                table_list.addItem("--Available Tables--");
                while (result.next()) {
                    table_list.addItem(result.getString(1));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error Occurred While Fetching Tables", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void showTable(int n) {
        String str = switch (n) {
            case 1 ->
                "manual";
            case 2 ->
                "desc";
            case 3 ->
                "orderby"+cols_list.getItemAt(cols_list.getSelectedIndex());
            default ->
                "auto";
        };
        table_scroll.setViewportView(con_exe.getTablePane(table, str));
    }

    private void disableTableButtons() {
        for (JButton obj : table_buttons) {
            obj.setEnabled(false);
        }
        cols_list.setEnabled(false);
    }

    private void enableTableButtons() {
        for (JButton obj : table_buttons) {
            obj.setEnabled(true);
        }
        cols_list.setEnabled(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_table;
    private javax.swing.JComboBox<String> cols_list;
    private javax.swing.JButton copy;
    private javax.swing.JButton create_table_button;
    private javax.swing.JButton createdb_button;
    private javax.swing.JComboBox<String> datab_list;
    private javax.swing.JButton delete_row;
    private javax.swing.JButton delete_table_button;
    private javax.swing.JButton deletedb_button;
    private javax.swing.JButton describe;
    private javax.swing.JButton insert_row;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton manual;
    private javax.swing.JButton modify_struct;
    private javax.swing.JButton rename;
    private javax.swing.JButton run_manual;
    private javax.swing.JButton show;
    private javax.swing.JComboBox<String> table_list;
    private javax.swing.JScrollPane table_scroll;
    private javax.swing.JButton update_row;
    // End of variables declaration//GEN-END:variables
}
