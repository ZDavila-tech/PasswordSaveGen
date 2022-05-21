
import java.io.IOException;

import javax.swing.*;

class Main{
    //All static variables that are shared in all methods throughout the code
    static JFrame mainframe;
    static JPanel p1, p2;
    static JPasswordField savekey;
    static JButton view = new JButton("View Saved Passwords");
    static JButton generate = new JButton("Generate Password");
    static JLabel key, used, username;


    
    //create the main frame of the project
    static void createFrame(){
        mainframe = new JFrame("Password Saver and Generator");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(500,500);
        mainframe.add(p1);
        mainframe.setVisible(true);
    }

    static void GenPass(){

    }
    static void createPanel(){
        p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
    }
    public static void main(String args[]) throws IOException{
        createFrame();
        createPanel();
    }
}