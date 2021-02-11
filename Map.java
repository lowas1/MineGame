import java.awt.*;
import javax.swing.ImageIcon;

public class Map {
	private String igMap[] = {"wwwwwwwwwwwwww", "wfffwffffffffw", "wwdfwfwwwwwgfw", "wfwfwfwffffwfw", "wfwfwfwfwwfwfw", "wfwfffwfwwfwfw",
		"wfwwwwwfwffwfw", "wfffffwfwwwwfw", "wfwwwfwffffffw", "wfwfwfwwwwwrfw", "wfwfffwffffwfw", "wfwwwwwfwwfwfw", "wfffffffwwfffw", "wwwwwwwwwwwwww"};
	private String metaMap[] = {"wwwwwwwwwwwwww", "wfffwffffffffw", "wwwfwfuwwwwwfw", "wfwfwfwffffwfw", "wfwfwfwfwwfwfw", "wfwfffwfswfwfw",
                "wfwwwwwfwffwfw", "wfffffwfwwwwfw", "wfwwwfwffffffw", "wfwfwfwwwwwwfw", "wfwfffwffffwfw", "wfwwwwwfwwfwfw", "wfffffffjwfffw", "wwwwwwwwwwwwww"};
	private String sedMap[] = {"wwwwwwwwwwwwww", "wfffwffffffffw", "wwwfwfwwwwwwfw", "wfwfwfwffffwfw", "wfwfwfwfwwfwfw", "wfwfffwfwofwfw",
                "wfwwwwwfwffwfw", "wfffffwfwwwwfw", "wfwwqfwffffffw", "wfwfwfwwwwwwfw", "wfwfffwffffwfw", "wfwwwwwfwwfwfw", "wfffffffwtfffw", "wwwwwwwwwwwwww"};
	private int type;
	private Image free, lava, wall, diamond, gold, garnet, ruby, sapphire, jade, opal, quartz, turq;
	private ImageIcon img;	
	
	public Map(int x) {
		type = x;
		ClassLoader cl = this.getClass().getClassLoader(); 
		img = new ImageIcon(cl.getResource("free.png"));
		free = img.getImage();
		img = new ImageIcon(cl.getResource("lava.png"));
		lava = img.getImage();
		img = new ImageIcon(cl.getResource("rock.png"));
		wall = img.getImage();
		img = new ImageIcon(cl.getResource("diamond.png"));
		diamond = img.getImage().getScaledInstance(32, 32, 1);
		img = new ImageIcon(cl.getResource("gold.png"));
		gold = img.getImage().getScaledInstance(32, 32, 1);
		img = new ImageIcon(cl.getResource("garnet.png"));
                garnet = img.getImage().getScaledInstance(32, 32, 1);
		img = new ImageIcon(cl.getResource("ruby.png"));
                ruby = img.getImage().getScaledInstance(32, 32, 1);
		img = new ImageIcon(cl.getResource("sapphire.png"));
		sapphire = img.getImage().getScaledInstance(32, 32, 1);
		img = new ImageIcon(cl.getResource("jade.png"));
                jade = img.getImage().getScaledInstance(32, 32, 1);
		img = new ImageIcon(cl.getResource("opal.png"));
		opal = img.getImage().getScaledInstance(32, 32, 1);
		img = new ImageIcon(cl.getResource("quartz.png"));
		quartz = img.getImage().getScaledInstance(32, 32, 1);
		img = new ImageIcon(cl.getResource("turquoise.png"));
		turq = img.getImage().getScaledInstance(32, 32, 1);
	}

	public Image getFree() {
		return free;
	}

	public Image getWall() {
		if(type == 1) return lava;
		return wall;
	}
	
	public Image getDiamond() {
		return diamond;
	}
	
	public Image getGold() {
		return gold;
	}

	public Image getGarnet() {
		return garnet;
	}
	
	public Image getRuby() {
		return ruby;
	}
	
	public Image getSapphire() {
		return sapphire;
	}

	public Image getJade() {
		return jade;
	}

	public Image getOpal() {
		return opal;
	}

	public Image getQuartz() {
		return quartz;
	}

	public Image getTurq() {
		return turq;
	}

	public String getMap(int x, int y) {
		String index = "";
		if(type == 1) index = igMap[y].substring(x, x + 1);
		if(type == 2) index = metaMap[y].substring(x, x + 1);
		if(type == 3) index = sedMap[y].substring(x, x + 1);
		return index;
	}
}
