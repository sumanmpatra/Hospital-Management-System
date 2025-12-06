package hospital.management.system;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class SearchRoom extends JFrame{
    
    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1 ,798, 498);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JLabel heading = new JLabel("SEARCH-FOR-ROOM");
        heading.setBounds(300, 20, 250, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD , 20));
        panel.add(heading);

        JLabel status = new JLabel("Status");
        status.setBounds(80, 90, 100, 25);
        status.setFont(new Font("Tahoma", Font.BOLD, 13));
        status.setForeground(Color.white);
        panel.add(status);

        Choice c1 = new Choice();
        c1.setBounds(250, 90, 150,25);
        c1.setFont(new Font("Tahoma", Font.BOLD, 12));
        c1.add("Available");
        c1.add("Occupied");
        panel.add(c1);

        JTable table = new JTable();
        table.setBounds(50, 180, 700, 210);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBackground(new Color(109, 164, 170));
        // table.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        panel.add(table);

        try{
            Connect c = new Connect();
            ResultSet result = c.statement.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(result));   
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room-No");
        label1.setBounds(100, 145, 100, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 12));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(280, 145, 100, 25);
        label2.setFont( new Font("Tahoma", Font.BOLD, 12));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(470, 145, 100, 25);
        label3.setFont(new Font("Tahoma", Font.BOLD, 12));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel label4 = new JLabel("Type");
        label4.setBounds(640, 145, 100, 25);
        label4.setFont(new Font("Tahoma", Font.BOLD, 12));
        label4.setForeground(Color.white);
        panel.add(label4);

        JButton button = new JButton("Search");
        button.setBounds(200, 430, 100,25);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    Connect  c = new Connect();
                    ResultSet result = c.statement.executeQuery("select * from room where availaibility = '"+c1.getSelectedItem()+"'");
                    table.setModel(DbUtils.resultSetToTableModel(result));
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton button1 = new JButton("Back");
        button1.setBounds(500, 430, 100, 25);
        button1.setFont(new Font("Tahoma", Font.BOLD, 12));
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        panel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setLocation(280, 200);
        setSize(800, 500);
        setVisible(true);
    }

    public static void main(String[] args){
        new SearchRoom();
    }
}
