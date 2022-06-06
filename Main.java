
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Main{
    //All static variables that are shared in all methods throughout the code
    static JFrame mainframe;
    static JPanel p1,p2;
    //Textfields
    static JPasswordField savekey;
    static JTextField password;
    static JTextField length = new JTextField();
    static JTextField website = new JTextField();
    static JTextField user = new JTextField();
    //Buttons
    static JButton view = new JButton("View Saved Passwords");
    static JButton generate = new JButton("Generate Password");
    static JButton submit = new JButton("Submit");
    static JButton yes = new JButton("Yes");
    static JButton no = new JButton("No");
    static JButton save = new JButton("Save");
    //Labels
    static JLabel question = new JLabel("How long do you want the password?");
    static JLabel question1 = new JLabel("Would you like to save this password?");
    static JLabel question2 = new JLabel("What website/app is this for?");
    static JLabel username = new JLabel("Provide username or email addess used to login.");
    static JLabel unipass = new JLabel();
    //Numbers, Strings, etc.
    static String newpass;
    static int lengthpass;
    static String usernme, webname, info;
    static ArrayList<String> series = new ArrayList<String>();

    public static void main(String args[]) throws IOException {
        createPanel();
        createFrame();
      }
    
    //create the main frame of the project
    static void createFrame(){
        mainframe = new JFrame("Password Saver and Generator");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(500,1000);
        mainframe.add(p1);
        mainframe.add(p2);
        mainframe.setVisible(true);
    }

    //generate random password
   static void GenPass(){
        String capital = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String number = "1234567890";
        String specialchar = "!@#$%^&*";
        String combo = lower + number + capital + specialchar;
        Random random = new Random();
        char[] password = new char[lengthpass];

        password[0] = lower.charAt(random.nextInt(lower.length()));
        password[1] = number.charAt(random.nextInt(number.length()));
        password[2] = capital.charAt(random.nextInt(capital.length()));
        password[3] = specialchar.charAt(random.nextInt(specialchar.length()));
        for(int i = 4; i<lengthpass;i++){
            password[i] = combo.charAt(random.nextInt(combo.length()));
        }

        newpass = new String(password);
        
   }

     static void viewList(){
        JFrame list = new JFrame("Saved Passwords");
        list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        list.setSize(500, 500);
        list.setVisible(true);
        JTextArea content = new JTextArea();
        content.setEditable(false);
        content.setBounds(0, 0, 300, 300);;
        content.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        list.add(content);
        for(String s:series){
            content.append(s + "\n"+"\n");
        }

    }
    static void clear(){
        p2.remove(question1);
        p2.remove(unipass);
        p2.remove(submit);
        p2.remove(length);
        p2.remove(question);
        p2.remove(no);
        p2.remove(yes);

    }

    //creating the Panel to put in the frame
    static void createPanel(){
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 500, 500);
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,500,500,500);
        p1.add(view);
        p1.add(generate);
        view.setBounds(150, 180, 200, 25);
        generate.setBounds(150, 220, 200, 25);
        

        //Button to view Saved Passwords 
        view.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e){
                view = (JButton)e.getSource();
                viewList();
            }
        });
        
        //Button to generate a unique Password that is not already saved
        generate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e){
                generate = (JButton)e.getSource();
                p2.add(question);
                p2.add(length);
                p2.add(submit);
                p2.revalidate();
                p2.repaint();
                question.setBounds(150, 250, 300, 25);
                length.setBounds(200, 280, 100, 25);
                submit.setBounds(200, 310, 100, 25);
            }
        });

        //Use the GenPass function to generate and display a password
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
                lengthpass = Integer.parseInt(length.getText());
                GenPass();
                p2.add(unipass);
                unipass.setText(newpass);
                unipass.setBounds(310, 310, 100, 25);
                p2.add(question1);
                question1.setBounds(150, 340, 300, 25);
                p2.add(yes);
                p2.add(no);
                yes.setBounds(150, 370, 100, 25);
                no.setBounds(250, 370, 100, 25);
                p2.revalidate();
                p2.repaint();

            }
        });
        //Chose to save the password. Will be given the chance to insert website and username
        yes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
               p2.add(question2);
               question2.setBounds(150, 400, 300, 25);
               p2.add(website);
               website.setBounds(150,430,200,25);
               p2.add(username);
               username.setBounds(125,460,300,25);
               p2.add(user);
               user.setBounds(150, 490, 200, 25);
                p2.add(save);
                save.setBounds(200, 520, 100, 25);
                p2.revalidate();
                p2.repaint();
            }
        });

        no.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
               no= (JButton)e.getSource();
               p2.removeAll();
               p2.revalidate();
               p2.repaint();
            }
        });

        //Retrieve user input from website and username and convert into strings to save in Hash Map
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
              usernme = user.getText();
              webname = website.getText();

            //Created one string for username, website, and password
              info = webname+"\n"+usernme+"\n"+newpass;
                series.add(info);
            p2.removeAll();
            p2.revalidate();
            p2.repaint();
                
            }
        });
    }


}