package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {
    JButton f1,f2,f3,f4,f5,f6,back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(210,230,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        f1=new JButton("Rs 100");
        f1.setBounds(170,322,150,25);
        f1.addActionListener(this);
        image.add(f1);

        f2=new JButton("Rs 500");
        f2.setBounds(355,322,150,25);
        f2.addActionListener(this);
        image.add(f2);

        f3=new JButton("Rs 1000");
        f3.setBounds(170,350,150,25);
        f3.addActionListener(this);
        image.add(f3);

        f4=new JButton("Rs 2000");
        f4.setBounds(355,350,150,25);
        f4.addActionListener(this);
        image.add(f4);

        f5=new JButton("Rs 5000");
        f5.setBounds(170,378,150,25);
        f5.addActionListener(this);
        image.add(f5);

        f6=new JButton("Rs 10000");
        f6.setBounds(355,378,150,25);
        f6.addActionListener(this);
        image.add(f6);

        back=new JButton("Back");
        back.setBounds(355,404,150,25);
        back.addActionListener(this);
        image.add(back);


        setSize(900,700);
        setUndecorated(true);
        setLocation(220,20);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date =new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Sucessfully" );

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }

    

    public static void main(String[] args) {
        new FastCash("");
    }
}


