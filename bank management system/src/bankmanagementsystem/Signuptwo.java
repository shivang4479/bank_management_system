package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener {
    long Random;
    String formo;
    JTextField panTextField,aadharTextField ;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    
    JComboBox<String>religion,category,income,education,occupation;
    Signuptwo(String formo )
    {
        this.formo=formo;
        revalidate();
        repaint();
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");
       

        JLabel additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,75,400,30);
        add(additionaldetails);

        JLabel name=new JLabel("Religion");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,130,100,30);
        add(name);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian"};
        religion=new JComboBox<String>(valReligion);
        religion.setBounds(300,130,400,30);
        add(religion);

        JLabel cate=new JLabel("Category ");
        cate.setFont(new Font("raleway",Font.BOLD,20));
        cate.setBounds(100,175,200,30);
        add(cate);

        String valcategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox<String>(valcategory);
        category.setBounds(300,175,400,30);
        add(category);

        JLabel dob=new JLabel("Income");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,220,200,30);
        add(dob);

        String incomecategory[]={"NULL","< 1,50,000","< 2,50,000","5,00,000","Upto 10,00,000"};
        income=new JComboBox<String>(incomecategory);
        income.setBounds(300,220,400,30);
        add(income);

        JLabel gender=new JLabel("Education");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(100,265,200,30);
        add(gender);

        JLabel email=new JLabel("Qualification");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,285,200,30);
        add(email);

        String educationvalues[]={"Non Graduation","Graduate","Post Graduate","Doctrate","Others"};
        education=new JComboBox<String>(educationvalues);
        education.setBounds(300,285,400,30);
        add(education);

        JLabel martial=new JLabel("Occupation");
        martial.setFont(new Font("raleway",Font.BOLD,20));
        martial.setBounds(100,355,200,30);
        add(martial);

        String occupationvalues[]={"Salaried","Self employed","Bussinessman","Student","other"};
        occupation=new JComboBox<String>(occupationvalues);
        occupation.setBounds(300,355,400,30);
        add(occupation);


        JLabel pan=new JLabel("Pan no");
        pan.setFont(new Font("raleway",Font.BOLD,20));
        pan.setBounds(100,400,200,30);
        add(pan);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,400,400,30);
        add(panTextField);

        JLabel aadhar=new JLabel("Aadhar no");
        aadhar.setFont(new Font("raleway",Font.BOLD,20));
        aadhar.setBounds(100,445,200,30);
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,445,400,30);
        add(aadharTextField);

        JLabel state=new JLabel("Senior Citizen");
        state.setFont(new Font("raleway",Font.BOLD,20 ));
        state.setBounds(100,490,200,30);
        add(state);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,490,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sno=new JRadioButton("NO");
        sno.setBounds(450,490,100,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorcitizen=new ButtonGroup();
        seniorcitizen.add(syes);
        seniorcitizen.add(sno);

        JLabel existingacc=new JLabel("Existing account");
        existingacc.setFont(new Font("raleway",Font.BOLD,20));
        existingacc.setBounds(100,535,200,30);
        add(existingacc);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,535,100,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno=new JRadioButton("NO");
        eno.setBounds(450,535,100,30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup existingaccount=new ButtonGroup();
        existingaccount.add(eyes);
        existingaccount.add(eno);


        next=new JButton("next");
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
        String formo = this.formo;
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String sseniorcitizen=null;
        if(syes.isSelected()){
            sseniorcitizen="yes";
        }
        else if(sno.isSelected()){
            sseniorcitizen="no";
        }
    
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="yes";
        }
        else if(eno.isSelected()){
            existingaccount="no";
        }
        
        String span=panTextField.getText();
        String saadhar=aadharTextField.getText();
        if(span.equals("") || saadhar.equals("")){
           JOptionPane.showMessageDialog(null,"PAN and Aadhar are required");
           return;
        }

        if(sseniorcitizen==null){
            JOptionPane.showMessageDialog(null,"Please select Senior Citizen");
            return;
        }

        if(existingaccount==null){
            JOptionPane.showMessageDialog(null,"Please select Existing Account");
            return;
        }
        if(saadhar.length()!=12){
            JOptionPane.showMessageDialog(null,"Aadhar number must be exactly 12 digits");
            return;
        }

        try{
          Long.parseLong(saadhar);
        }
        catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null,"Aadhar number should contain only digits");
          return;
        }


        try{
            
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formo+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signupthree(formo).setVisible(true);
            }
            

            catch(Exception e){
                System.out.println(e);
            }
        }    

    
    public static void main(String[] args) {
        new Signuptwo("");
    }}


