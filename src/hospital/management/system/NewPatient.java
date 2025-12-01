package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class NewPatient extends JFrame{
    JComboBox<String> combobox;
    JTextField namefield, numberfield,  diseasefield, depositefield;
    JRadioButton r1, r2;
    JLabel datelabel;
    JButton b1, b2;

    NewPatient(){

        // Panel setup

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 790, 490);
        panel.setBackground(new Color( 90, 90, 90));
        add(panel);

        // Added image

        ImageIcon imgicon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image img = imgicon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(img);
        JLabel imglabel = new JLabel(imageicon1);
        imglabel.setBounds(495, 100, 250, 250);
        panel.add(imglabel);

        // Added heading

        JLabel headinglabel = new JLabel("NEW PATIENT FORM");
        headinglabel.setBounds(215, 10, 500, 50);
        headinglabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        headinglabel.setForeground(new Color( 144,238,144));
        panel.add(headinglabel);


        // ID input

        JLabel idlabel = new JLabel("ID :");
        idlabel.setBounds(30, 90, 100, 30);
        idlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        idlabel.setForeground(new Color(135, 206, 235));
        panel.add(idlabel);

        combobox = new JComboBox<>(new String[]{"Aadhar Card", "PAN Card", "Driving Licence", "Ration Card", "Voter ID","Passport"});
        combobox.setBounds(300, 90, 130,25);
        combobox.setFont(new Font("Tahoma", Font.BOLD, 12));
        combobox.setBackground(Color.lightGray);
        panel.add(combobox);


        // Number input

        JLabel numberlabel = new JLabel("Number :");
        numberlabel.setBounds(30, 130, 100, 30);
        numberlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        numberlabel.setForeground(new Color(135, 206, 235));
        panel.add(numberlabel);

        numberfield = new JTextField();
        numberfield.setBounds(300, 130, 130, 25);
        numberfield.setFont(new Font("Tahoma", Font.BOLD, 12));
        numberfield.setBackground(Color.orange);
        panel.add(numberfield);

        // Name input

        JLabel namelabel = new JLabel("Name :");
        namelabel.setBounds(30, 165, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        namelabel.setForeground(new Color(135, 206, 235));
        panel.add(namelabel);

        namefield = new JTextField();
        namefield.setBounds(300, 165, 130, 25);
        namefield.setFont(new Font("Tahoma", Font.BOLD, 12));
        namefield.setBackground(Color.orange);
        panel.add(namefield);

        // Gender input

        JLabel genderlabel = new JLabel("Gender :");
        genderlabel.setBounds(30, 200, 100, 30);
        genderlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        genderlabel.setForeground(new Color(135, 206, 235));
        panel.add(genderlabel);

        r1 = new JRadioButton("Male");
        r1.setBounds(300, 200, 61, 25);
        r1.setBackground(Color.lightGray);
        r1.setFont(new Font("Tahoma",Font.BOLD, 12));
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(361, 200, 70, 25);
        r2.setFont(new Font("Tahoma", Font.BOLD, 12));
        r2.setBackground(Color.lightGray);
        panel.add(r2);


        // Disease input
        JLabel diseaselabel = new JLabel("Disease :");
        diseaselabel.setBounds(30, 235, 100, 30);
        diseaselabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        diseaselabel.setForeground(new Color(135, 206, 235));
        panel.add(diseaselabel);

        diseasefield = new JTextField();
        diseasefield.setBounds(300 , 235, 130, 25);
        diseasefield.setFont(new Font("Tahoma", Font.BOLD, 12));
        diseasefield.setBackground(Color.orange);
        panel.add(diseasefield);



        // Room input
        JLabel roomlabel = new JLabel("Room :");
        roomlabel.setBounds(30, 270, 100, 30);
        roomlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        roomlabel.setForeground(new Color(135, 206, 235));
        panel.add(roomlabel);


        // Currently no room class is available so we will skip this part


        // Time input
        JLabel timelabel = new JLabel("Time :");
        timelabel.setBounds(30, 305, 100, 30);
        timelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        timelabel.setForeground(new Color(135, 206, 235));
        panel.add(timelabel);

        Date date = new Date();
        datelabel = new JLabel(date.toString());
        datelabel.setBounds(300, 305, 200, 25);
        datelabel.setForeground(Color.white);
        panel.add(datelabel);


        // Deposite input
        JLabel depositelabel = new JLabel("Deposite :");
        depositelabel.setBounds(30, 340, 100, 30);
        depositelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        depositelabel.setForeground(new Color(135, 206, 235));
        panel.add(depositelabel);

        depositefield = new JTextField();
        depositefield.setBounds(300, 340, 130, 25);
        depositefield.setFont(new Font("Tahoma", Font.BOLD, 12));
        depositefield.setBackground(Color.orange);
        panel.add(depositefield);


        // creating buttons
        b1 = new JButton("Add");
        b1.setBounds(80 , 420, 120, 30 );
        b1.setBackground(Color.red);
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setForeground(Color.white);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // action

                
            }
        
        });
        panel.add(b1);


        b2 = new JButton("Back");
        b2.setBounds(250, 420, 120, 30);
        b2.setBackground(Color.black);
        b2.setFont(new Font("Tahoma", Font.BOLD, 15));
        b2.setForeground(Color.white);
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // action


            }
        });
        panel.add(b2);


        // Frame setup

        setUndecorated(true);
        setLayout(null);
        setSize(800, 500);
        setLocation(280, 200);
        setVisible(true);
    }
    public static void main(String[] args){
        new NewPatient();
    }
}
