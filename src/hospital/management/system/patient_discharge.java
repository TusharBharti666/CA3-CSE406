package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {

    patient_discharge() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(252, 186, 3));
        panel.setLayout(null);
        add(panel);


        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        panel.add(label);



        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);


        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);


        try {

            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()) {

                // we extract whole patient_info table from db and store it
                //inside resultset and then we know that inside the table , we have one column
                // whose name is "numberr" and we want its values to be shown in the choice drop-down
                //that's why we have wrote the below line
                choice.add(resultSet.getString(2));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        //we will fill the value for this label by extracting
        //the date from database
        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma", Font.BOLD,14));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);


        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);


        //check-in time of a patient
        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma", Font.BOLD,14));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);



        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.BLACK);
        panel.add(label5);

        Date date = new Date();

        //check-out time of the patient
        //we will put the current date in outtime,because
        //the patient leaves at that time
        JLabel OUTTime = new JLabel("" + date);
        OUTTime.setBounds(200,230,250,20);
        OUTTime.setFont(new Font("Tahoma", Font.BOLD,14));
        OUTTime.setForeground(Color.white);
        panel.add(OUTTime);


        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                conn c = new conn();

                // here as soon as we click on discharge button, we have to do two things, first is to delete the patient information
                // from the table, and second thing is to make the room "available" again where the patient was residing
                try {

                    c.statement.executeUpdate("delete from patient_info where Numberr = '" + choice.getSelectedItem() + "'");
                    c.statement.executeUpdate("update Room set Availability = 'Available' where room_no = '" + RNo.getText() + "'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                }
                catch(Exception E) {
                    E.printStackTrace();
                }
            }
        });


        JButton check = new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);

        // it means as soon as you click on check button, the check-in time of the patient and the room-no in which the
        // patient was will get extracted from the db will get shown to the user
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                conn c = new conn();

                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where Numberr = '"+ choice.getSelectedItem() + "'");
                    while(resultSet.next()) {
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Timee"));
                    }


                }
                catch(Exception E) {
                    E.printStackTrace();
                }

            }
        });


        JButton back = new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            }
        });




        //setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new patient_discharge();
    }
}
