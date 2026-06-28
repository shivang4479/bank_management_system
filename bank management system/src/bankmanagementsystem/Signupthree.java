package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Signupthree extends JFrame implements ActionListener{

     JRadioButton r1,r2,r3,r4;
     JCheckBox c1,c2,c3,c4,c5,c6,c7;
     JButton submit,cancel;
     String formo;

    Signupthree(String formo){
        this.formo=formo;
        setLayout(null);

        JLabel l1=new JLabel("Page:3 Account Deatails");
        l1.setFont(new Font("raleway",Font.BOLD,22));
        l1.setBounds(250,20,400,40);
        add(l1);

        JLabel type=new JLabel("Account Tyoe");
        type.setFont(new Font("raleway",Font.BOLD,22));
        type.setBounds(80,80,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("raleway",Font.BOLD,16));
        r1.setBounds(80,120,220,25);
        r1.setBackground(Color.white);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("raleway",Font.BOLD,16));
        r2.setBounds(330,120,250,25);
        r2.setBackground(Color.white);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("raleway",Font.BOLD,16));
        r3.setBounds(80,150,220,25);
        r3.setBackground(Color.white);
        add(r3);

        r4=new JRadioButton( "Reccuring Account");
        r4.setFont(new Font("raleway",Font.BOLD,16));
        r4.setBounds(330,150,250,25);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);


        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("raleway",Font.BOLD,22));
        card.setBounds(80,210,200,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-4104");
        number.setFont(new Font("raleway",Font.BOLD,22));
        number.setBounds(330,210,300,30);
        add(number);

        JLabel carddetails=new JLabel("Your 12 digit card no");
        carddetails.setFont(new Font("raleway",Font.BOLD,12));
        carddetails.setBounds(80,240,300,20);
        add(carddetails);

        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("raleway",Font.BOLD,22));
        pin.setBounds(80,270,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("raleway",Font.BOLD,22));
        pnumber.setBounds(330,270,300,30);
        add(pnumber);

        JLabel pindetail=new JLabel("Your PIN");
        pindetail.setFont(new Font("raleway",Font.BOLD,12));
        pindetail.setBounds(80,300,300,20);
        add(pindetail);

        JLabel services=new JLabel("Services Required");
        services.setFont(new Font("raleway",Font.BOLD,22));
        services.setBounds(80,350,400,30);
        add(services);


        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setBounds(80,390,200,25);
        c1.setFont(new Font("raleway",Font.BOLD,16));
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(330,390,220,25);
        c2.setFont(new Font("raleway",Font.BOLD,16));
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(80,425,200,25);
        c3.setFont(new Font("raleway",Font.BOLD,16));
        add(c3);

        c4=new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.white);
        c4.setBounds(330,425,220,25);
        c4.setFont(new Font("raleway",Font.BOLD,16));
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setBounds(80,460,200,25);
        c5.setFont(new Font("raleway",Font.BOLD,16));
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setBounds(330,460,220,25);
        c6.setFont(new Font("raleway",Font.BOLD,16));
        add(c6);

        c7=new JCheckBox("I hereby declare that above enter detail are corret.");
        c7.setBackground(Color.white);
        c7.setBounds(80,510,650,25);
        c7.setFont(new Font("raleway",Font.BOLD,12));
        add(c7);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("raleway",Font.BOLD,12));
        submit.setBounds(80,560,100,25);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("raleway",Font.BOLD,12));
        cancel.setBounds(330,560,100,25);
        cancel.addActionListener(this);
        add(cancel);


        setSize(850,650);
        setLocation(260,30);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String formo = this.formo;
            String accounttype=null;
            if(r1.isSelected()){
                accounttype="saving";
            }
            else if(r2.isSelected()){
                accounttype="fixed deposit";
            }
            else if(r3.isSelected()){
                accounttype="current account";
            }
            else if(r4.isSelected()){
                accounttype="recurring account";
            }
        
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()%900000000000L)+100000000000L);
            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility="";
            if(c1.isSelected()){
                facility=facility+"atm card";
            }
            if(c2.isSelected()){
                facility=facility+"internet banking";
            }
            if(c3.isSelected()){
                facility=facility+"mobile banking";
            }
            if(c4.isSelected()){
                facility=facility+"email & SMS alert ";
            }
            if(c5.isSelected()){
                facility=facility+"cheque book";
            }
            if(c6.isSelected()){
                facility=facility+"e-statement ";
            }

            try{
                if(accounttype==null){
                    JOptionPane.showMessageDialog(null,"account tyoe required");
                }
                else{
                    Conn conn=new Conn();
                    String query1="insert into signupthree values('"+formo+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    conn.s.executeUpdate(query1);
                    String query2="insert into login values('"+formo+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin: "+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);

                }
  
            }
            catch(Exception e){
                System.out.println(e);
            }
        }   
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Signupthree("");
        
    }
    
}
