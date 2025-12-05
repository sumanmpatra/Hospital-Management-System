package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Discharge extends JFrame{

    Discharge(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1, 798, 498);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);
    
        JLabel heading = new JLabel("CHECK-OUT");
        heading.setBounds(330, 40, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.black);
        panel.add(heading);


        // id
        JLabel id = new JLabel("Patient ID");
        id.setBounds(200, 130, 100, 25);
        id.setFont(new Font("Tahoma", Font.BOLD, 13));
        id.setForeground(Color.white);
        panel.add(id);

        Choice c1  = new Choice();
        c1.setBounds(450, 130, 150, 25);
        c1.setFont(new Font("Tahoma", Font.BOLD, 13));
        c1.setBackground(Color.lightGray);
        panel.add(c1);

        try{
            Connect c = new Connect();
            ResultSet result = c.statement.executeQuery("select * from patient");
            while(result.next()){
                c1.add(result.getString("number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // room
        JLabel  room = new JLabel("Room Number");
        room.setBounds(200, 180, 100, 25);
        room.setFont(new Font("Tahoma", Font.BOLD, 13));
        room.setForeground(Color.white);
        panel.add(room);

        // button will provide the input
        JLabel room1  = new JLabel();
        room1.setBounds(450, 180, 30, 25);
        room1.setFont(new Font("Tahoma", Font.BOLD, 13));
        room1.setForeground(Color.white);
        panel.add(room1);

        // intime
        JLabel timein = new JLabel("Time In");
        timein.setBounds(200, 230, 100, 25);
        timein.setForeground(Color.white);
        timein.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(timein);

        // button will provide the input
        JLabel timeinn = new JLabel();
        timeinn.setBounds(450, 230, 250, 25);
        timeinn.setFont(new Font("Tahoma", Font.BOLD, 13));
        timeinn.setForeground(Color.white);
        panel.add(timeinn);

        // outtime
        JLabel timeout = new JLabel("Time Out");
        timeout.setBounds(200, 280, 100, 25);
        timeout.setFont(new Font("Tahoma", Font.BOLD, 13));
        timeout.setForeground(Color.white);
        panel.add(timeout);

        Date date = new Date();
        JLabel timeout1 = new JLabel(date.toString());
        timeout1.setBounds(450, 280, 250, 25);
        timeout1.setFont(new Font("Tahoma", Font.BOLD, 13));
        timeout1.setForeground(Color.white);
        panel.add(timeout1);

        JButton button1 = new JButton("Discharge");
        button1.setBounds(200, 400, 100, 25);
        button1.setFont(new Font("Tahoma", Font.BOLD, 13));
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        panel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String room2 = null;            
                    Connect c = new Connect();
                    ResultSet result = c.statement.executeQuery("select room from patient where number = '"+c1.getSelectedItem()+"'");
                    while(result.next()){
                        room2 = result.getString("room");
                    }
                    c.statement.executeUpdate("delete from patient where number ='"+c1.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set availaibility = 'Available' where room_no = '"+room2+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton button2 = new JButton("Check");
        button2.setBounds(350, 400, 100, 25);
        button2.setFont(new Font("Tahoma", Font.BOLD,13));
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        panel.add(button2);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    Connect c = new Connect();
                    String query = "select room, time from patient where number = '"+c1.getSelectedItem()+"'";
                    ResultSet result = c.statement.executeQuery(query);
                    while(result.next()){
                        room1.setText(result.getString("room"));
                        timeinn.setText(result.getString("time"));
                    }
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
    
        JButton button3 = new JButton("Back");
        button3.setBounds(500, 400, 100, 25);
        button3.setFont(new Font("Tahoma", Font.BOLD, 13));
        button3.setForeground(Color.white);
        button3.setBackground(Color.black);
        panel.add(button3);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
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
        new Discharge();
    }
    
}
