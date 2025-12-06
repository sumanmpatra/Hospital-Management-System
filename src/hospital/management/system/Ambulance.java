package hospital.management.system;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Ambulance extends JFrame{


    Ambulance(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1, 798, 498);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/hospital.png"));
        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(img);
        JLabel imglabel = new JLabel(icon1);
        imglabel.setBounds(350, 65,  100, 100);
        panel.add(imglabel);

        JLabel heading = new JLabel("AMBULANCE-DETAILS");
        heading.setBounds(285, 20, 250, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD, 20));
        panel.add(heading);

        JTable table = new JTable();
        table.setBounds(75, 280, 650, 80);
        table.setFont(new Font("Tahoma", Font.BOLD, 13));
        table.setForeground(Color.black);
        table.setBackground(Color.lightGray);
        panel.add(table);

        try{
            Connect c = new Connect();
            ResultSet result = c.statement.executeQuery("select * from ambulance");
            table.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception E){
            E.printStackTrace();
        }


        JLabel label1 = new JLabel("Vehicle-Number");
        label1.setBounds(110, 250, 150, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD , 13));
        label1.setForeground(Color.white);
        panel.add(label1);


        JLabel label2 = new JLabel("Model");
        label2.setBounds(295, 250, 150, 25);
        label2.setFont(new Font("Tahoma", Font.BOLD, 13));
        label2.setForeground(Color.white);
        panel.add(label2);


        JLabel label3 = new JLabel("Driver");
        label3.setBounds(450, 250, 150, 25);
        label3.setFont( new Font("Tahoma", Font.BOLD, 13));
        label3.setForeground(Color.white);
        panel.add(label3);


        JLabel label4 = new JLabel("Ph Number");
        label4.setBounds(620, 250, 100, 25);
        label4.setFont(new Font("Tahoma", Font.BOLD, 13));
        label4.setForeground(Color.white);
        panel.add(label4);

        JButton button = new JButton("Back");
        button.setBounds(340, 400, 100, 25);
        button.setFont(new Font("Tahoma", Font.BOLD, 13));
        button.setForeground(Color.white);
        button.setBackground(Color.black);
        panel.add(button);
        button.addActionListener(new ActionListener(){
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
        new Ambulance();
    }
}
