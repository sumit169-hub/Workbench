package mygroup.workbench;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InsertData extends JFrame {

	Statement stmt;
	ArrayList<String> columns;
	ArrayList<JTextField> jText_ar;
	String table;
	MySQLGUI mygui;

	JButton submit, reset;

	public InsertData(Statement s, ArrayList<String> ar, String t, MySQLGUI my) {
		setLayout(null);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		stmt = s;
		columns = ar;
		table = t;
		mygui = my;

		jText_ar = new ArrayList<JTextField>();
		int x = 50, y = 50;
		for (String col : columns) {
			JLabel lab = new JLabel(col);
			lab.setBounds(x, y, 150, 25);
			add(lab);
			x += 151;
			JTextField field = new JTextField();
			field.setBounds(x, y, 200, 25);
			add(field);
			jText_ar.add(field);

			x -= 151;
			y += 30;
		}
		submit = new JButton("Submit");
		submit.setBounds(x, y, 100, 30);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executeQue();
			}
		});
		add(submit);
		x += 150;
		reset = new JButton("Reset");
		reset.setBounds(x, y, 100, 30);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});
		add(reset);
		x -= 150;
		setVisible(true);
	}

	private void clearData() {
		for (JTextField field : jText_ar)
			field.setText("");
	}

	private void executeQue() {
		String sql = "Insert into " + table + " values(";
		String values = "", msg = "";
		for (JTextField field : jText_ar)
			values += "'" + field.getText() + "',";
		sql += values.substring(0, values.length() - 1) + ")";
		try {
			int n = stmt.executeUpdate(sql);
			if (n > 0) {
				msg = "Success";
				clearData();
				mygui.showTable(0);
			} else
				msg = "Failed";
		} catch (Exception e) {
			msg = e.getMessage();
		}
		JOptionPane.showMessageDialog(mygui, msg);
	}
}
