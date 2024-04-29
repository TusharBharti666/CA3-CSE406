package hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Register extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2, b3;

    Register() {

        JFrame f = new JFrame();


        JLabel password = new JLabel("UserName");
        password.setBounds(40, 20, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);

        JLabel namelabel = new JLabel("password");
        namelabel.setBounds(40, 70, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);


        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setBackground(new Color(66, 135, 245));


        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(66, 135, 245));


        //for displaying icon , first of all collect the icon through ImageIcon class
        //then convert it into an image to change its dimensions using Image class
        // then again convert it back into icon and add it on top of a label to display it
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/register.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(320, -30, 400, 300);


        b1 = new JButton("Register");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);




        f.add(namelabel);
        f.add(password);
        f.add(textField);
        f.add(jPasswordField);
        f.add(label);
        f.add(b1);
        f.getContentPane().setBackground(new Color(109,164,170));
        f.setSize(750,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(400,270);

    }

    public static void main(String[] args) {

        new Register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        try {
            conn c = new conn();
            String userName = textField.getText();
            String passWord = jPasswordField.getText();

            if(userName.length() == 0 || passWord.length() == 0) {
                JOptionPane.showMessageDialog(null,"invalid");
            }
            else {

                String query = "insert into login(ID,PW) values('"+userName+"', '"+passWord+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Register Successfully");
                new Login();

            }

        }
        catch (Exception E) {
            E.printStackTrace();
        }

    }
}