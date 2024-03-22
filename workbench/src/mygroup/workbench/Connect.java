package mygroup.workbench;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Connect {

    Connection con;
    Statement stmt;
    JRootPane rootpane;
    TableData tableData;

    public Connect(Connection connect, Statement st, JRootPane r) {
        rootpane = r;
        con = connect;
        stmt = st;
    }

    public Connect() {
    }

    public ResultSet showTableList() {
        ResultSet result = null;
        try {
            result = stmt.executeQuery("show tables");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootpane, "Error while Connecting", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }

    public JScrollPane getTablePane(String table, String str) {
        JScrollPane scrollPane = null;
        try {
            tableData = new TableData(stmt, table);
            tableData.model.setData(stmt, str);
            JTable table1 = new JTable(tableData.model);
            scrollPane = new JScrollPane(table1);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootpane, "Error occurred while fetching table data", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        return scrollPane;
    }

    public TableData getTableObject() {
        return tableData;
    }

    public void excuteInsert(String table,MySQLGUI mygui) {
//        String sql = "Insert into " + table + " values(";
//        try {
//            ResultSet result = stmt.executeQuery("desc " + table);
//            while (result.next()) {
//                String s = JOptionPane.showInputDialog(rootpane, "Enter " + result.getString(1), "Input", JOptionPane.INFORMATION_MESSAGE);
//                if (s != null) {
//                    if (!"int".equals(result.getString(2))) {
//                        sql += "'" + s + "',";
//                    } else {
//                        sql += s + ",";
//                    }
//                }
//            }
//            sql = sql.substring(0, sql.length() - 1);
//            sql += ")";
//            int n = stmt.executeUpdate(sql);
//            return n;
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(rootpane, "Incorrect Values", "Alert", JOptionPane.ERROR_MESSAGE);
//        }
//        return 0;
    	ArrayList<String> ar=tableData.createColumn();
    	new InsertData(stmt,ar,table,mygui);
    }

    public void truncateQuery(String table) {
        try {
            if (stmt.execute("truncate table " + table)) {
                JOptionPane.showMessageDialog(rootpane, "Data Cleared Successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(rootpane, e.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean deleteQuery(String table) throws SQLException {
        String sql = "";
        String str = JOptionPane.showInputDialog(rootpane, "Enter Condition \n syntax:col_name='value' \nIf condition is not Entered then \nall data of " + table + " will be deleted.", "Validation", JOptionPane.QUESTION_MESSAGE);
        int n = JOptionPane.showConfirmDialog(rootpane, "Sure to Delete all data ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        if (n == 0) {
            if (str == null || "".equals(str)) {
                sql = "delete from " + table;
            } else {
                sql = "delete from " + table + " where " + str;
            }
            return stmt.execute(sql);
        }
        return false;
    }

    public void updateQuery(String table,MySQLGUI mygui) {
        new UpdateTable(tableData,stmt,table,mygui);
    }
    public int copyData() {
        String source = JOptionPane.showInputDialog(rootpane, "Enter Source Table name", "Source", JOptionPane.OK_CANCEL_OPTION);
        try {
            if (source.length() != 0) {
                String dest = JOptionPane.showInputDialog(rootpane, "Enter Destination Table name", "Destiantion", JOptionPane.OK_CANCEL_OPTION);
                if (dest.length() != 0) {
                    String sql = "INSERT INTO " + dest + " SELECT * FROM " + source;
                    stmt.execute("CREATE TABLE IF NOT EXISTS " + dest + " LIKE " + source);
                    String condition = JOptionPane.showInputDialog(rootpane, "Any condition? \nif not then leave blank.\nex:roll='10'", "Condition", JOptionPane.INFORMATION_MESSAGE);
                    if (condition.length() != 0) {
                        sql += " WHERE " + condition;
                    }
                    return stmt.executeUpdate(sql);
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(rootpane, "Table Name can't be blank", "Alert", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootpane, "Syntax Error", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public void runQuery() {
        String sql = JOptionPane.showInputDialog(rootpane, "Enter Query\n", "Manual run", JOptionPane.OK_CANCEL_OPTION);
        if (sql.length() != 0) {
            try {
                stmt.execute(sql);
                JOptionPane.showMessageDialog(rootpane, "Excution Success", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootpane, ex.getMessage(), "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String renameTable(String oldname) {
        String msg,table=oldname;
        String newname = JOptionPane.showInputDialog(rootpane, "Enter New Table Name");
        if (newname == "" || newname == null) {
            msg = "Canceled";
        } else {
            try {
                if (JOptionPane.showConfirmDialog(rootpane, "Confirm to rename " + oldname + " to " + newname) == 0) {
                    stmt.executeUpdate("rename table " + oldname + " to " + newname);
                    msg = "Success";
                    table=newname;
                } else {
                    msg = "Canceled";
                }
            } catch (HeadlessException | SQLException e) {
                msg = e.getMessage();
            }
        }
        JOptionPane.showMessageDialog(rootpane, msg);
        return table;
    }
}
