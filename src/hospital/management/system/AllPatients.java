package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class AllPatients extends JFrame {

    AllPatients() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(1, 1, 1198, 498);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JLabel heading = new JLabel("PATIENT-INFO");
        heading.setBounds(525 , 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.setForeground(Color.black);
        panel.add(heading);

        // Table
        JTable table = new JTable();
        table.setBackground(Color.lightGray);
        table.setForeground(Color.black);
        table.setFont(new Font("Tahoma", Font.BOLD, 13));
        table.setOpaque(true);
        table.setRowHeight(25);
        // Hide column names
        table.setTableHeader(null);
        // table.setFillsViewportHeight(true);

        // Scroll Pane
        JScrollPane pane = new JScrollPane(table);
        pane.getViewport().setBackground(Color.lightGray);
        pane.setBounds(35, 180, 1130, 150);
        pane.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        // pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(pane);

        try {
            Connect c = new Connect();
            ResultSet result = c.statement.executeQuery("select * from patient");
            table.setModel(DbUtils.resultSetToTableModel(result));
            pane.revalidate();
            pane.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton button = new JButton("Back");
        button.setFont(new Font("Tahoma", Font.BOLD, 13));
        button.setBounds(550, 420, 100, 30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
            }
        });

        JLabel id = new JLabel(" ID");
        id.setBounds(90, 110, 30, 25);
        id.setFont(new Font("Tahoma", Font.BOLD, 13));
        id.setBackground(Color.lightGray);
        id.setForeground(Color.black);
        id.setOpaque(true);
        panel.add(id);

        JLabel number = new JLabel(" ID Number");
        number.setBounds(205, 110, 80, 25);
        number.setFont(new Font("Tahoma", Font.BOLD, 13));
        number.setForeground(Color.black);
        number.setBackground(Color.lightGray);
        number.setOpaque(true);
        panel.add(number);

        JLabel name = new JLabel("  Name");
        name.setBounds(360, 110, 50, 25);
        name.setFont(new Font("Tahoma", Font.BOLD, 13));
        name.setForeground(Color.black);
        name.setBackground(Color.lightGray);
        name.setOpaque(true);
        panel.add(name);

        JLabel gender = new JLabel(" Gender");
        gender.setBounds(500, 110, 55, 25);
        gender.setFont(new Font("Tahoma", Font.BOLD, 13));
        gender.setForeground(Color.black);
        gender.setBackground(Color.lightGray);
        gender.setOpaque(true);
        panel.add(gender);

        JLabel disease = new JLabel(" Disease");
        disease.setBounds(630, 110, 60, 25);
        disease.setFont(new Font("Tahoma", Font.BOLD, 13));
        disease.setForeground(Color.black);
        disease.setBackground(Color.lightGray);
        disease.setOpaque(true);
        panel.add(disease);

        JLabel room = new JLabel("  Room");
        room.setBounds(775, 110, 50, 25);
        room.setFont(new Font("Tahoma", Font.BOLD, 13));
        room.setForeground(Color.black);
        room.setBackground(Color.lightGray);
        room.setOpaque(true);
        panel.add(room);

        JLabel time = new JLabel(" Time");
        time.setBounds(910, 110, 40, 25);
        time.setFont(new Font("Tahoma", Font.BOLD, 13));
        time.setForeground(Color.black);
        time.setBackground(Color.lightGray);
        time.setOpaque(true);
        panel.add(time);

        JLabel deposite = new JLabel(" Deposite");
        deposite.setBounds(1050, 110, 70, 25);
        deposite.setFont(new Font("Tahoma", Font.BOLD, 13));
        deposite.setForeground(Color.black);
        deposite.setBackground(Color.lightGray);
        deposite.setOpaque(true);
        panel.add(deposite);

        setUndecorated(true);
        setLayout(null);
        setLocation(85, 200);
        setSize(1200, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AllPatients();
    }
}
