package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;
    SearchRoom() {


        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(252, 186, 3));
        panel.setLayout(null);
        add(panel);


        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.BLACK);
        For.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("Status");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.BLACK);
        status.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(status);


        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(200, 245, 66));
        table.setForeground(Color.BLACK);
        panel.add(table);


        // whatever data is inside "room" table, we are putting
        // it inside our table and showing the table to the user
        try {

            conn c = new conn();
            String q = "select * from Room";

            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("Examination Room Type");
        Roomno.setBounds(0,162,200,20);
        Roomno.setForeground(Color.BLACK);
        Roomno.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(Roomno);


        JLabel available = new JLabel("Availability");
        available.setBounds(300,162,150,20);
        available.setForeground(Color.BLACK);
        available.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(500,162,150,20);
        price.setForeground(Color.BLACK);
        price.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(price);

//        JLabel Bed = new JLabel("Bed Type");
//        Bed.setBounds(550,162,150,20);
//        Bed.setForeground(Color.BLACK);
//        Bed.setFont(new Font("Tahoma", Font.BOLD,14));
//        panel.add(Bed);


        JButton Search = new JButton("Search");
        Search.setBackground(Color.black);
        Search.setBounds(200,420,120,25);
        Search.setForeground(Color.white);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String q = "select * from Room where Availability = '" + choice.getSelectedItem() + "'";

                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }
                catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        JButton Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setBounds(380,420,120,25);
        Back.setForeground(Color.white);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        //setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setVisible(true);
        setLocation(450,250);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }

}
