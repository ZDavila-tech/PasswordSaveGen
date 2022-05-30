
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;

public class Main{
    //All static variables that are shared in all methods throughout the code
    static JFrame mainframe;
    static JPanel p1, p2;
    static JPasswordField savekey;
    static JButton view = new JButton("View Saved Passwords");
    static JButton generate = new JButton("Generate Password");
    static JLabel key, used, username;
    static JTextField password;
    static char[] newpass;


    public static void main(String args[]) throws IOException {
        createPanel();
        createFrame();
      }
    
    //create the main frame of the project
    static void createFrame(){
        mainframe = new JFrame("Password Saver and Generator");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(500,500);
        mainframe.add(p1);
        mainframe.setVisible(true);
    }

    //generate random password
    private static char[] GenPass(int length){
        String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String combinedChar = capital + lower + numbers;
        Random random = new Random();
        newpass =  new char[length];

        newpass[0] = capital.charAt(random.nextInt(capital.length()));
        newpass[1] = numbers.charAt(random.nextInt(numbers.length()));
        newpass[2] = lower.charAt(random.nextInt(lower.length()));

        for(int i = 3; i < length; i++){
            newpass[i] = combinedChar.charAt(random.nextInt(combinedChar.length()));
        }

        return newpass;
    }

    private static void viewList(){
        JFrame list = new JFrame("Saved Passwords");
        list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        list.setSize(500, 500);
        list.setVisible(true);
        JList savpass = new JList<>();


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
                GenPass(9);
                password = new JTextField();
                p1.add(password);  
                password.setEditable(false);
                password.setBounds(150, 250, 200, 25);
                password.setText(String.valueOf(newpass));
                
            }
        });
    }


}