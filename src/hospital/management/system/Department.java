package hospital.management.system;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Department extends JFrame {

    Department(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1,798, 498);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JLabel heading = new JLabel("DEPARTMENT-INFO");
        heading.setBounds(290, 30, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.black);
        panel.add(heading);

        JLabel name  = new JLabel(" Department Name");
        name.setBounds(175, 130, 130, 25);
        name.setOpaque(true);
        name.setBackground(Color.lightGray);
        name.setForeground(Color.black);
        name.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(name);

        JLabel number = new JLabel(" Ph Number");
        number.setBounds(470, 130, 80, 25);
        number.setFont(new Font("Tahoma", Font.BOLD, 13));
        number.setForeground(Color.black);
        number.setBackground(Color.lightGray);
        number.setOpaque(true);
        panel.add(number);

        JTable table = new JTable();
        table.setBounds(140, 175, 500, 65);
        table.setBackground(Color.lightGray);
        table.setForeground(Color.black);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try{
            Connect c = new Connect();
            ResultSet result = c.statement.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JButton button = new JButton("Back");
        button.setBounds(350, 400, 100, 25);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(button);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
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
        new Department();
    }
}
