package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField  pinTextField;
    Login(){
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,30,100,100);
        add(label);

        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Osward",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField); 

        login=new JButton("Sign In");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

       setTitle("ATM");
       setLocation(280,70);
       setSize(800,480);
       setVisible(true); 

       
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
         }
        else if(e.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=new String(pinTextField.getPassword());
            String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
            try{
               ResultSet rs= conn .s.executeQuery(query);
               if(rs.next()){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
               }
               else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
            
            }catch(Exception ae){
                System.out.println(e);
            }
        }
        else if(e.getSource()==signup){
            setVisible(false);
            new Signupone().setVisible(true);
        }


    }
    public static void main(String[] args) {
        
    new Login();
}
}