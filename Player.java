import java.awt.Image;
import javax.swing.ImageIcon;

public class Player {

	private int tileX, tileY;
	private boolean flip;
	private Image player;
	private Image playerNormal;
	private Image playerFlipped;
	private ImageIcon img;
	private ImageIcon flipped;

	public Player() {
		
		ClassLoader cl = this.getClass().getClassLoader();
		img = new ImageIcon(cl.getResource("player1.png"));
		flipped = new ImageIcon(cl.getResource("flipped.png"));
		playerNormal = img.getImage().getScaledInstance(32, 32, 1);
		player = img.getImage().getScaledInstance(32, 32, 1);
		playerFlipped = flipped.getImage().getScaledInstance(32, 32, 1);
		tileX = 1;
		tileY = 1;
	}

	public void setFlipped(boolean flip) {
		this.flip = flip;
	}

	public boolean getFlipped() {
		return flip;
	}
	
	public Image getPlayer() {
		if(flip) player = playerFlipped;
		else player = playerNormal;
		return player;
	}
	
	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}


	public void move(int dx, int dy) {
		tileX += dx;
		tileY += dy;		
	}


}
