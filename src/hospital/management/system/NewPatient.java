package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;


public class NewPatient extends JFrame implements ActionListener{
    JComboBox<String> combobox;
    JTextField namefield, numberfield,  diseasefield, depositefield;
    JRadioButton r1, r2;
    ButtonGroup group; 
    JLabel datelabel;
    JButton b1, b2;
    Choice c1;

    NewPatient(){

        // Panel setup
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1, 798, 498);
        panel.setBackground(new Color(109, 164, 170));
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
        headinglabel.setBounds(290, 10, 500, 50);
        headinglabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        headinglabel.setForeground(Color.black);
        panel.add(headinglabel);

        // ID input
        JLabel idlabel = new JLabel("ID :");
        idlabel.setBounds(30, 90, 100, 30);
        idlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        idlabel.setForeground(Color.white);
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
        numberlabel.setForeground(Color.white);
        panel.add(numberlabel);

        numberfield = new JTextField();
        numberfield.setBounds(300, 130, 130, 25);
        numberfield.setFont(new Font("Tahoma", Font.BOLD, 12));
        numberfield.setBackground(Color.white);
        panel.add(numberfield);

        // Name input
        JLabel namelabel = new JLabel("Name :");
        namelabel.setBounds(30, 165, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        namelabel.setForeground(Color.white);
        panel.add(namelabel);

        namefield = new JTextField();
        namefield.setBounds(300, 165, 130, 25);
        namefield.setFont(new Font("Tahoma", Font.BOLD, 12));
        namefield.setBackground(Color.white);
        panel.add(namefield);

        // Gender input
        JLabel genderlabel = new JLabel("Gender :");
        genderlabel.setBounds(30, 200, 100, 30);
        genderlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        genderlabel.setForeground(Color.white);
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

        group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        // Disease input
        JLabel diseaselabel = new JLabel("Disease :");
        diseaselabel.setBounds(30, 235, 100, 30);
        diseaselabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        diseaselabel.setForeground(Color.white);
        panel.add(diseaselabel);

        diseasefield = new JTextField();
        diseasefield.setBounds(300 , 235, 130, 25);
        diseasefield.setFont(new Font("Tahoma", Font.BOLD, 12));
        diseasefield.setBackground(Color.white);
        panel.add(diseasefield);

        // Room input
        JLabel roomlabel = new JLabel("Room :");
        roomlabel.setBounds(30, 270, 100, 30);
        roomlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        roomlabel.setForeground(Color.white);
        panel.add(roomlabel);

        c1 = new Choice();
        try{
            Connect c = new Connect();
            ResultSet result = c.statement.executeQuery("select * from room");
            while(result.next()){
                String data = result.getString("room_no") + " - "+ result.getString("Availaibility");
                c1.add(data);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(300, 270, 130, 25);
        c1.setFont(new Font("Tahoma", Font.BOLD, 12));
        c1.setBackground(Color.LIGHT_GRAY);
        panel.add(c1);

        // Time input
        JLabel timelabel = new JLabel("Time :");
        timelabel.setBounds(30, 305, 100, 30);
        timelabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        timelabel.setForeground(Color.white);
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
        depositelabel.setForeground(Color.white);
        panel.add(depositelabel);

        depositefield = new JTextField();
        depositefield.setBounds(300, 340, 130, 25);
        depositefield.setFont(new Font("Tahoma", Font.BOLD, 12));
        depositefield.setBackground(Color.white);
        panel.add(depositefield);

        // creating buttons
        b1 = new JButton("Add");
        b1.setBounds(80 , 420, 120, 30 );
        b1.setBackground(Color.red);
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(250, 420, 120, 30);
        b2.setBackground(Color.black);
        b2.setFont(new Font("Tahoma", Font.BOLD, 15));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e){
        // action
        if(e.getSource() == b1){
            try{

                String s1 = (String)combobox.getSelectedItem();
                String s2 = numberfield.getText();
                String s3 = namefield.getText();
                String s4 = null; //gender
                if(r1.isSelected()){
                    s4 = "Male";
                }
                else if(r2.isSelected()){
                    s4 = "Female";
                }
                String s5 = diseasefield.getText();
                String s6 = c1.getSelectedItem();
                String s7 = datelabel.getText();
                String s8 = depositefield.getText();

                Connect c = new Connect();
                String query1 = "insert into patient values (\"" + s1 + "\", \"" + s2 + "\", \"" + s3 + "\", \"" + s4 + "\", \"" + s5 + "\", \"" + s6.substring(0, 3) + "\", \"" + s7 + "\", \""+ s8 + "\")";

                String query2 = "update room set availaibility = 'occupied' where room_no =\""+s6.substring(0,3)+"\"";

                c.statement.executeUpdate(query1);
                c.statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Added Successfully!");
                setVisible(false);
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
            // JOptionPane.showConfirmDialog(rootPane, e, getTitle(), ABORT)
            setVisible(false);
        }
    }
}
