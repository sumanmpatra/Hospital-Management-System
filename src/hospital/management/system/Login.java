package hospital.management.system;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    JTextField textfield;
    JPasswordField passwordfield;
    JButton b1, b2;

    Login(){

        // Frame layout -> null
        setLayout(null);

        // Username label 
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20 , 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        // Password Label 
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);


        // Username input text area 

        textfield = new JTextField();
        textfield.setBounds(150, 20, 150, 30);
        textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textfield.setBackground(Color.ORANGE);
        add(textfield);


        // password input text area

        passwordfield = new JPasswordField();
        passwordfield.setBounds(150, 70, 150, 30);
        passwordfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordfield.setBackground(Color.ORANGE);
        add(passwordfield);


        // Login Page Image

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image image = imageicon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageicon1);
        imglabel.setBounds(320, 40, 400,200);
        add(imglabel);


        // Login Button

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        add(b1);


        // Cancel Button

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.red);
        b2.setForeground(Color.white);
        add(b2);


        // Frame Settings
        
        getContentPane().setBackground(new Color(109, 164, 170));
        setSize(750, 300);
        setLocation(300, 200);
        setVisible(true);
    }
    public static void main(String[] args){
        new Login();
    }
}
