package mygroup.workbench;

import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class UpdateTable  extends JFrame implements ActionListener
{
    ArrayList<JTextField> jText_ar;
    Statement stmt;
    JButton submit,reset,and_button,or_button;
    String sql,condition="";
    Object[] columns;
    JLabel cdtn,cdtn_col;
    JComboBox<Object> cols_list;
    JTextField cdtn_value;
    MySQLGUI mygui;
    public UpdateTable(TableData tableData,Statement s,String table,MySQLGUI my)
    {
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        
        mygui=my;
        jText_ar=new ArrayList<>();
        columns=tableData.createColumn().toArray();
        stmt=s;
        sql="Update "+table+" set ";
        
        int x=50,y=50;
        for(Object col:columns)
        {
            JLabel lab=new JLabel(col.toString()+" ");
            lab.setBounds(x, y, 150, 25);
            add(lab);
            x+=151;
            JTextField field=new JTextField();
            field.setBounds(x,y,200,25);
            add(field);
            jText_ar.add(field);
            y+=30;
            x-=151;
        }
        cdtn=new JLabel("Condition");
        cdtn.setBounds(x,y,200,30);
        add(cdtn);
        y+=30;
        
        cdtn_col=new JLabel("Column :");
        cdtn_col.setBounds(x, y, 150, 25);
        add(cdtn_col);
                
        cols_list=new JComboBox<>(columns);
        cols_list.setBounds(200, y, 150, 25);
        add(cols_list);
        y+=30;
        
        JLabel cdtnVLab=new JLabel("Enter Value");
        cdtnVLab.setBounds(x, y,150, 25);
        add(cdtnVLab);
        
        cdtn_value=new JTextField();
        cdtn_value.setBounds(200, y, 150, 25);
        add(cdtn_value);
        y+=30;
        
        and_button=new JButton("and");
        and_button.setBounds(x, y,100, 25);
        and_button.addActionListener(this);
        add(and_button);
        
        or_button=new JButton("or");
        or_button.setBounds(200, y,100, 25);
        or_button.addActionListener(this);
        add(or_button);
        y+=30;
        submit=new JButton("Submit");
        submit.addActionListener(this);
        submit.setBounds(50,y, 200, 30);
        add(submit);
        reset=new JButton("Reset");
        reset.setBounds(275, y, 200, 30);
        reset.addActionListener(this);
        add(reset);
        
        setVisible(true);
    }  
    private String getFieldData()
    {
        String data="";
        int i=0;
        for(JTextField field:jText_ar)
        {
            if(!field.getText().isBlank())  
                data+=columns[i]+"='"+field.getText()+"',";
            field.setText("");
            i++;
        }
        clearData();
        return data.substring(0,data.length()-1)+" where ";
    }
    private String createCondition()
    {
        String co="";
        if(condition.length()==0) condition=" where "; 
        if(!cdtn_value.getText().isBlank()) 
           co=cols_list.getItemAt(cols_list.getSelectedIndex())+"='"+cdtn_value.getText()+"'";       
        return co;
    }
    private void clearData() 
    {
        for(JTextField field:jText_ar) field.setText("");
        cols_list.setSelectedIndex(0);
        cdtn_value.setText("");
    }
    private void clearCondtion()
    {
        cols_list.setSelectedIndex(0);
        cdtn_value.setText("");
    }
    private void executeQuery()
    {
        condition+=createCondition();
        String m;
        String query=sql+getFieldData()+condition;
        try
        {
        	int n=stmt.executeUpdate(query);
        	if(n>0)
        	{
        		m="Success";
        		mygui.showTable(0);
        	}
        	else m="failed";
        }
        catch (Exception e) {
			m="Syntax Error";
		}
        JOptionPane.showMessageDialog(this,m);
        condition="";
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==submit)
           executeQuery();
       else if(e.getSource()==reset) clearData();
       else if(e.getSource()==and_button)
       {
           condition+=createCondition()+" and ";
           clearCondtion();
       }
       else if(e.getSource()==or_button)
       {
           condition+=createCondition()+" or ";
           clearCondtion();
       }
    }

}
