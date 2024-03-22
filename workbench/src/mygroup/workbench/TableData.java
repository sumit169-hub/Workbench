package mygroup.workbench;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TableData {

	Statement stmt;
	String table_name;
	ArrayList<Object[]> d;
	CustomModel model;

	public TableData(Statement s, String t) {
		stmt = s;
		table_name = t;
		d = new ArrayList<>();
		model = new CustomModel();
		createColumn();
		createData();
	}

	public CustomModel getData() {
		return model;
	}

	public ArrayList createColumn() {
		ArrayList<String> columns = new ArrayList<>();
		try {
			ResultSet result = stmt.executeQuery("desc " + table_name);
			while (result.next()) {
				String str = result.getString(1);
				if (str != null) {
					columns.add(str);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
		}
		return columns;
	}

	private void createData() {
		try {
			ResultSet result = stmt.executeQuery("select * from " + table_name);
			ResultSetMetaData meta = result.getMetaData();
			while (result.next()) {
				Object[] row = new Object[meta.getColumnCount()];
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					row[i - 1] = result.getObject(i);
				}
				d.add(row);
			}
		} catch (SQLException e) {
		}
	}

	class CustomModel extends AbstractTableModel {

		private final List<String[]> rowData = new ArrayList<>();
		private ArrayList<String> columnNames;
		ResultSet resultSet = null;

		public CustomModel() {
		}

		public void setData(Statement stmt, String manual) {
			String sql = "";
			try {
				if ("manual".equals(manual)) {
					sql = JOptionPane.showInputDialog(new JFrame(), "Enter Manual Query", "Manual data",
							JOptionPane.QUESTION_MESSAGE);
					if (sql.length() == 0) {
						sql = "SELECT * FROM " + table_name;
					}
				} else if ("desc".equals(manual)) {
					sql = "desc " + table_name;
				} else if ("auto".equals(manual))
					sql = "SELECT * FROM " + table_name;
				else if ("orderby".equals(manual.substring(0, 7)))
					sql = "SELECT * FROM " + table_name + " ORDER BY " + manual.substring(7);

				resultSet = stmt.executeQuery(sql);
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				columnNames = new ArrayList();
				for (int i = 0; i < columnCount; i++) {
					String name = metaData.getColumnName(i + 1);
					if (name != null)
						columnNames.add(name);
				}
				rowData.clear();
				while (resultSet.next()) {
					String[] row = new String[columnCount];
					for (int i = 0; i < columnCount; i++)
						row[i] = resultSet.getString(i + 1);
					rowData.add(row);
				}
				fireTableStructureChanged();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
			}
		}

		@Override
		public int getRowCount() {
			return rowData.size();
		}

		@Override
		public int getColumnCount() {
			return columnNames.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return rowData.get(rowIndex)[columnIndex];
		}

		@Override
		public String getColumnName(int column) {
			return columnNames.get(column);
		}
	}
}