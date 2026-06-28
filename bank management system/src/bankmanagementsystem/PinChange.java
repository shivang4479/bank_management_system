package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(250,230,400,20);
        image.add(text);

        JLabel pintext=new JLabel("New PIN:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("system",Font.BOLD,16));
        pintext.setBounds(140,260,400,20);
        image.add(pintext);

        pin=new JPasswordField();
        pin.setFont(new Font("system",Font.BOLD,16));
        pin.setBounds(320,260,150,20);
        image.add(pin);

        JLabel repintext=new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("system",Font.BOLD,16));
        repintext.setBounds(140,290,400,20);
        image.add(repintext);

        repin=new JPasswordField();
        repin.setFont(new Font("system",Font.BOLD,16));
        repin.setBounds(320,290,150,20);
        image.add(repin);

        change=new JButton("Change");
        change.setBounds(346,378,150,25);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(346,404,150,25);
        back.addActionListener(this);
        image.add(back);


        setSize(850,700);
        //setUndecorated(true);
        setLocation(250,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String npin=new String(pin.getPassword());
            String rpin=new String(pin.getPassword());
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"ENtered PIN does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter pin");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                return;
            }
            Conn conn=new Conn();
            String query1="update bank set pin='"+rpin+"'where pin='"+pinnumber+"'";
            String query2="update login set pin='"+rpin+"'where pin='"+pinnumber+"'";
            String query3="update signupthree set pin='"+rpin+"'where pin='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null, "PIN changed Sucessfully");

            setVisible(false);
            new Transaction(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }

    }
    


public static void main(String args[]){
    new PinChange("").setVisible(true);

}
}