package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;
    Room() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(252, 186, 3));
        panel.setLayout(null);
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);


        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(200, 245, 66));
        panel.add(table);


        //so here we are extracting the data from database and adding it
        //into our table model which will be visible to users on our panel

        try {

            conn c = new conn();
            String q = "select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);

            //for using DbUtils ,we have to import one jar file inside our library
            // that jar file is called "ResultSet2XML"
            //setModel method is used to create the table
            // we have converted the resultSet into table model to display it in front of the user
            //in the form of a table
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Examination Room");
        label1.setBounds(12,15,150,15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(180,15,80,15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Examination Fee");
        label3.setBounds(350,15,150,15);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);


        JButton back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            }
        });











        //setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
