import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    
    private Timer timer;
    private Map m;
    private Player p;
    private PopUp pop;
    boolean show1, show2, show3;
    boolean[][] ig_arr = new boolean[14][14];
    boolean[][] meta_arr = new boolean[14][14];
    boolean[][] sed_arr = new boolean[14][14];
    int count;
    
    public Board(int x) {
        count = 3;
	if(x == 1) m = new Map(1);
	if(x == 2) m = new Map(2);
	if(x == 3) m = new Map(3);
	p = new Player();
        pop = new PopUp();
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
    }


    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
	for (int y = 0; y < 14; y++) {
		for(int x = 0; x < 14; x++) {
			if(m.getMap(x, y).equals("f")) g.drawImage(m.getFree(), x * 32, y * 32, null);
			if(m.getMap(x, y).equals("w")) g.drawImage(m.getWall(), x * 32, y * 32, null);
			
			if(m.getMap(x, y).equals("d")) {
                                if(ig_arr[x][y] && (p.getFlipped() || show1)) {
					g.drawImage(m.getDiamond(), (x) * 32, y * 32, null);
					show1 = true;
				}
			
				else g.drawImage(m.getWall(), x * 32, y * 32, null);
			}	
			if(m.getMap(x, y).equals("g")) {
				if(ig_arr[x][y] && (p.getFlipped() || show2)) {
					g.drawImage(m.getGold(), (x) * 32, y * 32, null);
					show2 = true;	
				}
                                else g.drawImage(m.getWall(), x * 32, y * 32, null);
                        }
			if(m.getMap(x, y).equals("r")) {
                                if(ig_arr[x][y] && (p.getFlipped() || show3)) {
					g.drawImage(m.getGarnet(), (x) * 32, y * 32, null);
                                	show3 = true;
				}
				else g.drawImage(m.getWall(), x * 32, y * 32, null);
                        }
			
			if(m.getMap(x, y).equals("u")) {
                                if(meta_arr[x][y] && (!p.getFlipped() || show1)) { 
					g.drawImage(m.getRuby(), (x) * 32, y * 32, null);
					show1 = true;
				}
                                else g.drawImage(m.getWall(), x * 32, y * 32, null);
                        }
			if(m.getMap(x, y).equals("s")) {
                                if(meta_arr[x][y] && (!p.getFlipped() || show2)) { 
					g.drawImage(m.getSapphire(), (x) * 32, y * 32, null);
                                	show2 = true;
				}
				else g.drawImage(m.getWall(), x * 32, y * 32, null);
                        }	
			if(m.getMap(x, y).equals("j")) {
                                if(meta_arr[x][y] && (!p.getFlipped() || show3)) { 
					g.drawImage(m.getJade(), (x) * 32, y * 32, null);
                                	show3 = true;
				}
				else g.drawImage(m.getWall(), x * 32, y * 32, null);
                        }

			 if(m.getMap(x, y).equals("o")) {
                                if(sed_arr[x][y] && (p.getFlipped() || show1)) {
					g.drawImage(m.getOpal(), (x) * 32, y * 32, null);
                                	show1 = true;
				}
				else g.drawImage(m.getWall(), x * 32, y * 32, null);
                        }
                        if(m.getMap(x, y).equals("q")) {
                                if(sed_arr[x][y] && (p.getFlipped() || show2)) {
					g.drawImage(m.getQuartz(), (x) * 32, y * 32, null);
                                	show2 = true;
				}
				else g.drawImage(m.getWall(), x * 32, y * 32, null);
                        }       
                        if(m.getMap(x, y).equals("t")) {
                                if(sed_arr[x][y] && (p.getFlipped() || show3)) { 
					g.drawImage(m.getTurq(), (x) * 32, y * 32, null);
                                	show3 = true;
				}
				else g.drawImage(m.getWall(), x * 32, y * 32, null);
                        }
		}
	}
	g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
    }

    public class Al extends KeyAdapter {	
    	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(keycode == KeyEvent.VK_UP) {
			String str = m.getMap(p.getTileX(), p.getTileY() - 1);
			if(str.equals("f")) p.move(0, -1);
		}
		if(keycode == KeyEvent.VK_DOWN) {
			String str = m.getMap(p.getTileX(), p.getTileY() + 1);
			if(str.equals("f")) p.move(0, 1);
		}
		if(keycode == KeyEvent.VK_LEFT) {
			p.setFlipped(true);
			String str = m.getMap(p.getTileX() - 1, p.getTileY());
			if(str.equals("f")) p.move(-1, 0);
		}
		if(keycode == KeyEvent.VK_RIGHT) {
			p.setFlipped(false);
			String str = m.getMap(p.getTileX() + 1, p.getTileY());
			if(str.equals("f")) p.move(1, 0); 
		}
		if(keycode == KeyEvent.VK_M) {	
			if(p.getFlipped() && (m.getMap(p.getTileX() - 1,  p.getTileY()).equals("d") || 
				m.getMap(p.getTileX() - 1, p.getTileY()).equals("g") || m.getMap(p.getTileX() - 1, p.getTileY()).equals("r"))) {
				if(!ig_arr[p.getTileX()-1][p.getTileY()]) {
					ig_arr[p.getTileX()-1][p.getTileY()] = true;
					count--;
					if (count == 0) pop.getWinningFrame();
				}
			}	
			else if(!p.getFlipped() && (m.getMap(p.getTileX() + 1,  p.getTileY()).equals("u") ||
				m.getMap(p.getTileX() + 1, p.getTileY()).equals("s") || m.getMap(p.getTileX() + 1, p.getTileY()).equals("j"))) {
                                if(!meta_arr[p.getTileX()+1][p.getTileY()]) {
                                        meta_arr[p.getTileX()+1][p.getTileY()] = true;
                                        count--;
                                        if (count == 0) pop.getWinningFrame();
                                }
                        }
			else if(p.getFlipped() && (m.getMap(p.getTileX() - 1,  p.getTileY()).equals("o") ||
                                m.getMap(p.getTileX() - 1, p.getTileY()).equals("q") || m.getMap(p.getTileX() - 1, p.getTileY()).equals("t"))) {
				if(!sed_arr[p.getTileX()-1][p.getTileY()]) {
                                        sed_arr[p.getTileX()-1][p.getTileY()] = true;
                                        count--;
                                        if (count == 0) pop.getWinningFrame();
                                }
                        }

			
		}

	}
	
	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
  
    }

}   
