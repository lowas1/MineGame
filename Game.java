import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class Game implements ActionListener {
    private JFrame myframe, choiceFrame, infoFrame;    
    private JButton continueButton, b1, b2, b3;
    int type;
    public static void main(String args[]) {
        new Game();
    }

    public Game() {
        getInfoFrame();
    }

    public void getInfoFrame() {
	infoFrame = new JFrame("");
	String str1 = "<html>The obective of the game is to find all three minerals which are<br>hidden in their respective mines.<br><br><html>";
	
	String str2 = "<html>In the igneous rock mine you will be able to find <b>diamond</b>, <b>gold</b>,<br>and <b>garnet</b>. All three are formed due to some combination of high<br>heat and pressure. Additionally, all three can be formed due to a<br>volcanic eruption.<br><br><html>";
	String str3 = "<html>In the metamorphic rock mine you will be able to find <b>ruby</b>, <br><b>sapphire</b>, and <b>jade</b>. All are formed when magma cools. The slower<br>magma cools the larger rubies and sapphires will grow.<br><br><html>";
	String str4 = "<html>In the sedimentary rock mine you will be able to find <b>opal</b>, <br><b>quartz</b>, and <b>turquoise</b>. Turquoise can actually be found in both<br>igneous rock and sedimentary rock because igneous can be changed<br>into sedimentary which is made up of pre-existing rocks. Both<br>opal and quartz can be found in sandstone.<br><br><html>";
	JLabel text = new JLabel(str1 + str2 + str3 + str4 + "Click 'Continue' to begin playing!");
        text.setForeground(Color.GREEN);
	JPanel textPanel = new JPanel();
	textPanel.setBackground(Color.BLACK);
	textPanel.add(text);
	
	continueButton = new JButton("Continue");
	JPanel buttonPanel = new JPanel();
	buttonPanel.add(continueButton);
	continueButton.addActionListener(this);

	infoFrame.add(textPanel, BorderLayout.LINE_START);
	infoFrame.add(buttonPanel, BorderLayout.PAGE_END);
	infoFrame.setSize(450, 490);
        infoFrame.setResizable(false);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.getContentPane().setBackground(Color.BLACK);
	infoFrame.setVisible(true);
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    }

    public void getChoiceFrame() {
	choiceFrame = new JFrame("");

        JLabel text = new JLabel("What type of rock would you like to mine?");
        JPanel textPanel = new JPanel();
        textPanel.add(text);

        b1 = new JButton("Igneous");
        b2 = new JButton("Metamorphic");
        b3 = new JButton("Sedimentary");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        choiceFrame.add(textPanel, BorderLayout.PAGE_START);
        choiceFrame.add(buttonPanel, BorderLayout.PAGE_END);
        choiceFrame.pack();
        choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choiceFrame.setLocationRelativeTo(null);
        choiceFrame.setResizable(false);
	infoFrame.setVisible(false);
        choiceFrame.setVisible(true);
    }

    public void getStartFrame() {
        JPanel startPanel = new JPanel();
        JLabel startLabel = new JLabel();
	if (type == 1) startLabel = new JLabel("Use arrow keys to move around and 'M' to mine igneous rock...");
	else if (type == 2) startLabel = new JLabel("Use arrow keys to move around and 'M' to mine in metamorphic rock...");
	else if (type == 3) startLabel = new JLabel("Use arrow keys to move around and 'M' to mine in sedimentary rock...");
        startPanel.add(startLabel);
        myframe.add(startPanel, BorderLayout.PAGE_START);
     }
  

    public void makeFrame(int x) {
	//System.out.println("here");
	type = x;
	myframe = new JFrame("Game");
	if (x == 1) myframe.add(new Board(1));
	else if(x == 2) myframe.add(new Board(2));
	else if(x == 3) myframe.add(new Board(3));
        
	getStartFrame();
        
	myframe.setSize(450, 490);
        myframe.setResizable(false);
        myframe.setLocationRelativeTo(null);
        choiceFrame.setVisible(false);
	myframe.setVisible(true);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource().equals(continueButton)) getChoiceFrame(); 
            else if (e.getSource().equals(b1)) makeFrame(1);
	    else if (e.getSource().equals(b2)) makeFrame(2);
            else if (e.getSource().equals(b3)) makeFrame(3);
	}
	
	catch(Exception ex) {
	    System.out.println(ex);
	}
    }
}
