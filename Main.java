
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;

public class Main{
    //All static variables that are shared in all methods throughout the code
    static JFrame mainframe;
    static JPanel p1;
    static JPasswordField savekey;
    static JButton view = new JButton("View Saved Passwords");
    static JButton generate = new JButton("Generate Password");
    static JLabel key, used, username;
    static JTextField password;
    static String newpass;
    static JTextField length = new JTextField();
    static JTextField website = new JTextField("Website or App Name");
    static JButton submit = new JButton("Submit");
    static JButton yes = new JButton("Yes");
    static JButton no = new JButton("No");
    static JLabel question = new JLabel("How long do you want the password?");
    static JLabel question1 = new JLabel("Would you like to save this password?");
    static JLabel question2 = new JLabel("What website/app is this for?");
    static JLabel unipass = new JLabel();
    static int lengthpass;

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

    private static void viewList(){
        JFrame list = new JFrame("Saved Passwords");
        list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        list.setSize(500, 500);
        list.setVisible(true);


    }

    //creating the Panel to put in the frame
    static void createPanel(){
        p1 = new JPanel();
        p1.setLayout(null);
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
                p1.add(question);
                p1.add(length);
                p1.add(submit);
                question.setBounds(150, 250, 300, 25);
                length.setBounds(200, 280, 100, 25);
                submit.setBounds(200, 310, 100, 25);;
            }
        });

        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
                lengthpass = Integer.parseInt(length.getText());
                GenPass();
                p1.add(unipass);
                unipass.setText(newpass);
                unipass.setBounds(310, 310, 100, 25);
                p1.add(question1);
                question1.setBounds(150, 340, 300, 25);
                p1.add(yes);
                p1.add(no);
                yes.setBounds(150, 370, 100, 25);
                no.setBounds(250, 370, 100, 25);

            }
        });

        yes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
               

            }
        });

        no.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
               

            }
        });
    }


}