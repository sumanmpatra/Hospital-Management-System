package hospital.management.system;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Reception extends JFrame {

    Reception() {
        setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 160, 1355, 530);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(5, 5, 1355, 150);
        panel2.setBackground(new Color(100, 100, 165));
        add(panel2);

        ImageIcon imgicon = new ImageIcon(ClassLoader.getSystemResource("icons/doctor.png"));
        Image img1 = imgicon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imgicon1 = new ImageIcon(img1);
        JLabel imglabel = new JLabel(imgicon1);
        imglabel.setBounds(1150, 0, 150, 200);
        panel2.add(imglabel);


        ImageIcon imgicon2 = new ImageIcon(ClassLoader.getSystemResource("icons/amb.png"));
        Image img2 = imgicon2.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
        ImageIcon imgicon3 = new ImageIcon(img2);
        JLabel imglabel2 = new JLabel(imgicon3);
        imglabel2.setBounds(850, 0, 300, 150);
        panel2.add(imglabel2);


        JButton button1 = new JButton("Add new Patient");
        button1.setBounds(40, 20, 150, 30);
        button1.setBackground(Color.orange);
        panel2.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new NewPatient();
            }
        });
        
        JButton button2 = new JButton("Room");
        button2.setBounds(40, 60, 150, 30);
        button2.setBackground(Color.orange);
        panel2.add(button2);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Room();
            }
        });


        JButton button3 = new JButton("Department");
        button3.setBounds(40, 100, 150, 30);
        button3.setBackground(Color.orange);
        panel2.add(button3);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Department();
            }
        });

        JButton button4 = new JButton("All Employee info");
        button4.setBounds(230, 20, 150, 30);
        button4.setBackground(Color.orange);
        panel2.add(button4);
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // action 



            }
        });


        JButton button5 = new JButton("Patient info");
        button5.setBounds(230, 60, 150, 30);
        button5.setBackground(Color.orange);
        panel2.add(button5);
        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // action


            }
        });

        JButton button6 = new JButton("Patient Discharge");
        button6.setBounds(230, 100, 150, 30);
        button6.setBackground(Color.orange);
        panel2.add(button6);
        button6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // action 



            }
        });

        JButton button7 = new JButton("Update Patient Details");
        button7.setBounds(420, 20, 150, 30);
        button7.setBackground(Color.orange);
        panel2.add(button7);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // action


            }
        });

        JButton button8 = new JButton("Hospital Ambulance");
        button8.setBounds(420, 60, 150, 30);
        button8.setBackground(Color.orange);
        panel2.add(button8);
        button8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // action


            }
        });


        JButton button9 = new JButton("Search Room");
        button9.setBounds(420, 100, 150, 30);
        button9.setBackground(Color.orange);
        panel2.add(button9);
        button9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // action


            }
        });

        JButton button10 = new JButton("Logout");
        button10.setBounds(610, 20, 150, 30);
        button10.setBackground(Color.orange);
        panel2.add(button10);
        button10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Login();
            }
        });


        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(1950, 1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
