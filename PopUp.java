import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUp implements ActionListener{

    private JFrame myframe;
    JButton playButton; 

    public void getWinningFrame() {
        myframe = new JFrame("");
     
	JPanel buttonPanel = new JPanel();
	JLabel gameLabel = new JLabel();
        JPanel gamePanel = new JPanel();

        gameLabel = new JLabel("Congradulations! You found all 3 minerals!"); 
	gamePanel.add(gameLabel);

	playButton = new JButton("Play Again?");
	playButton.addActionListener(this);
	buttonPanel.add(playButton);

	myframe.add(gamePanel, BorderLayout.PAGE_START);
	myframe.add(buttonPanel, BorderLayout.PAGE_END);
        myframe.setSize(450, 100);
        myframe.setResizable(false);
        myframe.setLocationRelativeTo(null);
	myframe.setVisible(true);
    } 

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if (e.getSource().equals(playButton)) {
	    	myframe.setVisible(false);	
		new Game(); 
	    }
	}
	catch (Exception ex) 
	{
	    System.out.println("Error");
	}	
    }
}
