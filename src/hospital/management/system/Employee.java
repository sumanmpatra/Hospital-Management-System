package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Employee extends JFrame{
    
    Employee(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1, 798, 498);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JLabel heading = new JLabel("EMPLOYEE INFO");
        heading.setBounds(320, 50, 200, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.black);
        panel.add(heading);

        JLabel name = new JLabel("  Name");
        name.setBounds(50, 150, 51, 25);
        name.setOpaque(true);
        name.setBackground(Color.lightGray);
        name.setFont(new Font("Tahoma", Font.BOLD, 13));
        name.setForeground(Color.black);
        panel.add(name);

        JLabel age = new JLabel(" Age");
        age.setBounds(190, 150, 40, 25);
        age.setFont(new Font("Tahoma", Font.BOLD, 13));
        age.setForeground(Color.black);
        age.setBackground(Color.lightGray);
        age.setOpaque(true);
        panel.add(age);

        JLabel number = new JLabel(" Ph Number");
        number.setBounds(295, 150, 80, 25);
        number.setFont(new Font("Tahoma", Font.BOLD, 13));
        number.setBackground(Color.lightGray);
        number.setForeground(Color.black);
        number.setOpaque(true);
        panel.add(number);

        JLabel salary = new JLabel("  Salary");
        salary.setBounds(435, 150, 61, 25);
        salary.setFont(new Font("Tahoma", Font.BOLD, 13));
        salary.setBackground(Color.lightGray);
        salary.setForeground(Color.black);
        salary.setOpaque(true);
        panel.add(salary);

        JLabel mail = new JLabel("  Email");
        mail.setBounds(550, 150, 50, 25);
        mail.setFont(new Font("Tahoma", Font.BOLD, 13));
        mail.setForeground(Color.black);
        mail.setBackground(Color.lightGray);
        mail.setOpaque(true);
        panel.add(mail);

        JLabel aadhar = new JLabel("  Aadhar Card");
        aadhar.setBounds(660, 150, 100, 25);
        aadhar.setFont(new Font("Tahoma", Font.BOLD, 13));
        aadhar.setForeground(Color.black);
        aadhar.setBackground(Color.lightGray);
        aadhar.setOpaque(true);
        panel.add(aadhar);

        JTable table = new JTable();
        table.setBounds(25, 200, 750, 50);
        table.setFont(new Font("Tahoma", Font.BOLD, 13));
        table.setBackground(Color.lightGray);
        panel.add(table);

        try{
            Connect c = new Connect();
            ResultSet result = c.statement.executeQuery("select * from Employee");
            table.setModel(DbUtils.resultSetToTableModel(result));
        }catch(Exception e){
            e.printStackTrace();
        }

        JButton button = new JButton("Back");
        button.setBounds(350, 400, 100, 25);
        button.setFont(new Font("Tahoma", Font.BOLD, 13));
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(800, 500);
        setLocation(280, 200);
        setVisible(true);
    }

    public static void main(String[] args){
        new Employee();
    }
}
