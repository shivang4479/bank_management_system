package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    JButton Withdraw,back;
    JTextField amount;
    String pinnumber;

    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,230,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("raleway",Font.BOLD,22));
        amount.setBounds(160,270,320,25);
        image.add(amount);

        Withdraw=new JButton("Withdrawl");
        Withdraw.setBounds(340,378,150,25);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        back=new JButton("Back");
        back.setBounds(340,404,150,25);
        back.addActionListener(this);
        image.add(back);



        setSize(850,700);
        //setUndecorated(true);
        setLocation(250,0);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Withdraw){
            String number=amount.getText();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
                return;
            }
            else{
                try{
                  Conn conn = new Conn();
                  int balance = 0;
                  ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");

                while(rs.next()){
                   String type = rs.getString("type");

                if(type.equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else if(type.equals("Withdrawl")){
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        

                int withdrawAmount = Integer.parseInt(number);
                if(withdrawAmount > balance){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance! Current Balance: " + balance);
                    return;
                }

               //  withdrawal
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawn Successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);

                }catch(Exception e){
                    System.out.println(e);
                }
            
            }

        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
    
}

    

