package hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.*;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox comboBox,comboBox1;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposit;
    JRadioButton r1, r2;

    Choice c1;
    JLabel date;

    JButton b1, b2;


    NEW_PATIENT() {


        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(200, 245, 66));
        panel.setLayout(null);
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);


        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(labelName);


        JLabel labelID = new JLabel("PATIENT ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma", Font.BOLD,14));
        labelID.setForeground(Color.BLACK);
        panel.add(labelID);

        //comboBox is used to create drop-down lists
        comboBox = new JComboBox(new String[] {"Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("PATIENT NUMBER :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD,14));
        labelNumber.setForeground(Color.BLACK);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);


        JLabel labelName1 = new JLabel("PATIENT NAME :");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD,14));
        labelName1.setForeground(Color.BLACK);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);


        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.BLACK);
        panel.add(labelGender);


        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.BLACK);
        //r1.setBackground(new Color(218, 66, 245));
        r1.setBounds(271,191,80,15);
        panel.add(r1);


        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.BLACK);
        //r2.setBackground(new Color(218, 66, 245));
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Eye Condition: ");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD,14));
        labelDisease.setForeground(Color.BLACK);
        panel.add(labelDisease);


        comboBox1 = new JComboBox(new String[] {"Cataract", "Diabetic Retinopathy", "Myopia", "Glaucoma",
                "hypermetropia"});
        comboBox1.setBounds(271,231,200,25);
        comboBox1.setBackground(new Color(3,45,48));
        comboBox1.setForeground(Color.WHITE);
        comboBox1.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(comboBox1);

//
//        textFieldDisease = new JTextField();
//        textFieldDisease.setBounds(271,231,150,20);
//        panel.add(textFieldDisease);


        JLabel labelRoom = new JLabel("Examination Room :");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD,14));
        labelRoom.setForeground(Color.BLACK);
        panel.add(labelRoom);


        //resultset is used to store the data you are getting through the
        //query from the database
        //whatever room_no we are getting, we are adding it into our choice of rooms

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while(resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        c1.setBounds(271,274,250,20);
        c1.setBackground(new Color(218, 66, 245));
        c1.setForeground(Color.WHITE);
        c1.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(c1);


        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD,14));
        labelDate.setForeground(Color.BLACK);
        panel.add(labelDate);


        //Date is a utility class in java inside java.util.Date package
        Date date1 = new Date();

        date = new JLabel("" + date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        JLabel labelDeposit = new JLabel("Consultation Fee");
        labelDeposit.setBounds(35,359,200,17);
        labelDeposit.setForeground(Color.BLACK);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271,359,150,20);
        panel.add(textFieldDeposit);


        b1 = new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        panel.add(b1);


        b2 = new JButton("BACK");
        b2.setBounds(260,430,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);










        //it is use to remove the frame
        //setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);

    }

    public static void main(String[] args) {

        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {


            String radioBTN = null;

            if(r1.isSelected()) {

                radioBTN = "Male";
            }
            else if(r2.isSelected()) {
                radioBTN = "Female";
            }

            //whatever the user is entering in the form , we are extracting
            // that information and storing it inside different strings
            // after that through sql query we are adding the data inside the
            //database and also updating the room number from "available" to "occupied"
            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = (String)comboBox1.getSelectedItem();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposit.getText();

            if(s1.length() == 0 || s2.length() == 0 || s3.length() == 0 || s4.length() == 0
            || s5.length() == 0 || s6.length() == 0 || s7.length() == 0 || s8.length() == 0) {

                JOptionPane.showMessageDialog(null,"Invalid");
            }

            else {

                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "toor@66_root$$666");

                    String q1 = "UPDATE Room SET Availability = 'Occupied' WHERE room_no = ?";

                    PreparedStatement preparedStatement1 = connection.prepareStatement(q1);
                    preparedStatement1.setString(1, s6);

                    preparedStatement1.executeUpdate();


                    String q = "INSERT INTO patient_info (ID, Numberr, Namee, Gender , Patient_Disease, Room_Number, Timee, Deposit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement preparedStatement = connection.prepareStatement(q);
                    preparedStatement.setString(1, s1);
                    preparedStatement.setString(2, s2);
                    preparedStatement.setString(3, s3);
                    preparedStatement.setString(4, s4);
                    preparedStatement.setString(5, s5);
                    preparedStatement.setString(6, s6);
                    preparedStatement.setString(7, s7);
                    preparedStatement.setString(8, s8);

                    preparedStatement.executeUpdate();

                    // String q = "insert into patient_info values('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s5+"', '"+s6+"', '"+s7+"', '"+s8+"')";
                    //String q1 = "update Room set Availability = 'Occupied' where room_no = " + s6;

//                c.statement.executeUpdate(q);
//                c.statement.executeUpdate(q1);




                    JOptionPane.showMessageDialog(null,"Added Successfully");
                    setVisible(false); // it means after adding the details we will close the form panel automatically
                }


                catch (Exception E) {
                    E.printStackTrace();
                }
            }


        }


        //it means the user clicked on "Back" button
        else {

            setVisible(false); // it means when user clicks on "back" button , we will close the form panel automatically
        }




    }
}
