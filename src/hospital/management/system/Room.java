package hospital.management.system;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class Room extends JFrame {

    JTable table;

    Room(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1, 798, 498);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JLabel heading = new JLabel("ROOM - INFO");
        heading.setBounds(230, 15, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setForeground(Color.black);
        panel.add(heading);

        ImageIcon imgicon = new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png"));
        Image img = imgicon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imgicon1 = new ImageIcon(img);
        JLabel imglabel = new JLabel(imgicon1);
        imglabel.setBounds(565, 150, 200, 200);
        panel.add(imglabel);

        table = new JTable();
        table.setBounds(40, 125, 500, 210);
        table.setBackground(Color.lightGray);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try{
            Connect c = new Connect();
            String query = "select * from room";
            ResultSet result = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
            e.printStackTrace();
        }


        JLabel room_no = new JLabel("   Room No");
        room_no.setBounds(60,  80, 80, 25);
        room_no.setFont(new Font("Tahoma", Font.BOLD, 13));
        room_no.setOpaque(true);
        room_no.setBackground(Color.lightGray);
        room_no.setForeground(Color.black);
        panel.add(room_no);


        JLabel avail = new JLabel("   Availability");
        avail.setBounds(175, 80, 100, 25);
        avail.setOpaque(true);
        avail.setFont(new Font("Tahoma", Font.BOLD, 13));
        avail.setForeground(Color.black);
        avail.setBackground(Color.lightGray);
        panel.add(avail);

        JLabel price = new JLabel("    Price");
        price.setBounds(320, 80, 65, 25);
        price.setOpaque(true);
        price.setFont(new Font("Tahoma", Font.BOLD, 13));
        price.setForeground(Color.black);
        price.setBackground(Color.lightGray);
        panel.add(price);

        JLabel type = new JLabel("   Bed Type");
        type.setBounds(435, 80, 80, 25);
        type.setOpaque(true);
        type.setFont(new Font("Tahoma", Font.BOLD, 13));
        type.setForeground(Color.black);
        type.setBackground(Color.lightGray);
        panel.add(type);

        JButton button = new JButton("Back");
        button.setBounds(230, 400, 100, 30);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setBackground(Color.black);
        button.setForeground(Color.white);
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
        new Room();
    }
}
