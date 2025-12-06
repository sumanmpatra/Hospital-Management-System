package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PatientUpdate extends JFrame{

    PatientUpdate(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1, 798, 498);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JLabel heading = new JLabel("UPDATE-PATIENT-DETAILS");
        heading.setBounds(275, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD , 20));
        heading.setForeground(Color.black);
        panel.add(heading);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img);
        JLabel imglabel = new JLabel(icon2);
        imglabel.setBounds(570, 150, 150, 150);
        panel.add(imglabel);

        // ID
        JLabel label1 = new JLabel("Id");
        label1.setBounds(80, 120, 100, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.white);
        panel.add(label1);

        Choice c1 = new Choice();
        c1.setBounds(320, 121, 150, 30);
        c1.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(c1);

        try{
            Connect c = new Connect();
            ResultSet result = c.statement.executeQuery("select * from patient");
            while(result.next()){
                c1.add(result.getString("Number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // Name 
        JLabel label2 = new JLabel("Name");
        label2.setBounds(80, 160, 100, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.white);
        panel.add(label2);

        JTextField text1 =  new JTextField();
        text1.setBounds(320, 165, 150, 22);
        text1.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(text1);


        // Room Number
        JLabel label3 = new JLabel("Room number");
        label3.setBounds(80, 200,150, 30);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField text2 = new JTextField();
        text2.setBounds(320, 205, 150, 22);
        text2.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(text2);

        // Time-In
        JLabel label4 = new JLabel("In-Time");
        label4.setBounds(80, 240, 100, 30);
        label4.setFont(new Font("Tahoma", Font.BOLD ,15));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField text3 = new JTextField();
        text3.setBounds(320, 245 ,210, 22);
        text3.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(text3);

        // paid amount
        JLabel label5 = new JLabel("Paid Amount");
        label5.setBounds(80, 280, 100, 30);
        label5.setFont(new Font("Tahoma", Font.BOLD , 15));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField text4 = new JTextField();
        text4.setBounds(320, 285, 150, 22);
        text4.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(text4);

        // Pending amount
        JLabel label6 = new JLabel("Pending Amount");
        label6.setBounds(80, 320, 150, 30);
        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.white);
        panel.add(label6);

        JLabel text5 = new JLabel();
        text5.setBounds(320, 325,150, 22);
        text5.setFont(new Font("Tahoma", Font.BOLD, 13));
        text5.setForeground(Color.white);
        panel.add(text5);

        // update button
        JButton button1 = new JButton("Update");
        button1.setBounds(80, 430, 100, 25);
        button1.setBackground(Color.black);
        button1.setForeground(Color.white);
        button1.setFont(new Font("Tahoma", Font.BOLD ,13));
        panel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(text1.getText().length() != 0  && text2.getText().length() != 0 && text3.getText().length() != 0 && text4.getText().length() != 0){
                    try{
                        // code
                        Connect c = new Connect();
                        ResultSet result = c.statement.executeQuery("select room from patient where number = '"+c1.getSelectedItem()+"'");
                        String temp = null;
                        while(result.next()){
                            temp = result.getString("room");
                        }
                        c.statement.executeUpdate("update patient set name = '"+text1.getText()+"' , room = '"+text2.getText()+"' , time = '"+text3.getText()+"', deposite = '"+text4.getText()+"'");
                        c.statement.executeUpdate("update room set availaibility = 'Available' where room_no ='"+temp+"'");
                        c.statement.executeUpdate("update room set availaibility = 'Occupied' where room_no ='"+text2.getText()+"'");
                        
                        JOptionPane.showMessageDialog(null, "Done");
                        setVisible(false);
                    }
                    catch(Exception E){
                        E.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please fill all the details!");
                }
            }
        });

        // back button
        JButton button2 = new JButton("Back");
        button2.setBounds(220, 430, 100, 25);
        button2.setFont( new Font("Tahoma", Font.BOLD, 13));
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        panel.add(button2);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });

        // check button
        JButton button3 = new JButton("Check");
        button3.setBounds(360, 430, 100, 25);
        button3.setFont(new Font("Tahoma", Font.BOLD, 13));
        button3.setForeground(Color.white);
        button3.setBackground(Color.black);
        panel.add(button3);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    Connect c = new Connect();
                    ResultSet result = c.statement.executeQuery("select * from patient where number = '"+c1.getSelectedItem()+"'");
                    while(result.next()){
                        text1.setText(result.getString("name"));
                        text2.setText(result.getString("room"));
                        text3.setText(result.getString("time"));
                        text4.setText(result.getString("deposite"));
                    }
                    ResultSet result1 = c.statement.executeQuery("select price from room where room_no='"+text2.getText()+"'");
                    while(result1.next()){
                        int amountleft = Integer.parseInt(result1.getString("price")) - Integer.parseInt(text4.getText());
                        text5.setText(""+amountleft);
                    }
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(800, 500);
        setLocation(280, 200);
        setVisible(true);
    }

    public static void main(String[] args){
        new PatientUpdate();
    }
}
