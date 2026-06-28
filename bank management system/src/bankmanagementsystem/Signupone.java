package bankmanagementsystem;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener {
    long Random;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    Signupone()
    {
        revalidate();
        repaint();
        setLayout(null);
        Random ran=new Random();
        Random=Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formo=new JLabel("APPLICATION FORM NO"+Random);
        formo.setFont(new Font("raleway",Font.BOLD,38));
        formo.setBounds(140,20,600,40);
        add(formo);

        JLabel personaldetails=new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("raleway",Font.BOLD,22));
        personaldetails.setBounds(290,75,400,30);
        add(personaldetails);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,130,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,130,400,30);
        add(nameTextField);

        JLabel fname=new JLabel("Father Name");
        fname.setFont(new Font("raleway",Font.BOLD,20));
        fname.setBounds(100,175,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,175,400,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date of Birth");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,220,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setMaxSelectableDate(new java.util.Date());
        add(dateChooser);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(100,265,200,30);
        add(gender);

         male=new JRadioButton("Male");
        male.setBounds(300,265,60,30);
        male.setBackground(Color.white);
        add(male);

         female=new JRadioButton("Female");
        female.setBounds(450,265,120,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email=new JLabel("Email Address");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,310,200,30);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,310,400,30);
        add(emailTextField);

        JLabel martial=new JLabel("Martial Status");
        martial.setFont(new Font("raleway",Font.BOLD,20));
        martial.setBounds(100,355,200,30);
        add(martial);

        
        married=new JRadioButton("Married");
        married.setBounds(300,355,100,30);
        married.setBackground(Color.white);
        add(married);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,355,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other=new JRadioButton("Other");
        other.setBounds(630,355,100,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address=new JLabel("Address");
        address.setFont(new Font("raleway",Font.BOLD,20));
        address.setBounds(100,400,200,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,400,400,30);
        add(addressTextField);

        JLabel city=new JLabel("City");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(100,445,200,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,445,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State");
        state.setFont(new Font("raleway",Font.BOLD,20 ));
        state.setBounds(100,490,200,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,490,400,30);
        add(stateTextField);

        JLabel pincode=new JLabel("Pincode");
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        pincode.setBounds(100,535,200,30);
        add(pincode);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,535,400,30);
        add(pinTextField);

         next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("raleway",Font.BOLD,14));
        next.setBounds(620 ,600,80,30);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.WHITE);
        setSize(850,730);
        setLocation(240,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String formo="" + Random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        String email=emailTextField.getText();
        String martial=null;
        if(married.isSelected()){
            martial="Married";
        }
        else if(unmarried.isSelected()){
            martial="Unmarried";
        }
        else if(other.isSelected()){
            martial="Other";
        }
        
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();


        try{
            if(name.equals("") || fname.equals("")||dob.equals("")||gender.equals("")||email.equals("")||martial.equals("")||address.equals("")||city.equals("")||state.equals("")||pin.equals("")){
                JOptionPane.showMessageDialog(null, "All Feild are Required");
            }
            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signuptwo(formo).setVisible(true);
            }
            }

            catch(Exception e){
                System.out.println(e);
            }
        }    

    
    public static void main(String[] args) {
        new Signupone();
    }}


