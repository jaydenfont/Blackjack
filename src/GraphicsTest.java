import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * Test using graphics to display cards
 * Can pull an image from a folder, generate a frame, and display it
 * 
 * TODO: Animations (listeners?), incorporating with gameplay
 */


public class GraphicsTest extends JPanel{
	
	public JFrame frame;
	public LinkedList<BufferedImage> cardList; // holds all used card images
	
	// draw all cards
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			for (int i = 0; i < this.cardList.size(); i++) {
				BufferedImage card = this.cardList.get(i);
				// (image, x, y, w, h, object)
				g.drawImage(card, 90+(i*10), 100, 70, 100, this);
			}
		}
		catch (NoSuchElementException e) {
			;
		}
	}
	
	// get images from directory
	public static BufferedImage getImage(String name, char face) {
		try {
			BufferedImage card = ImageIO.read(new File("/Users/jaydenfont/Desktop/Code/Personal/Projects/blackjack/src/card_images/" + name + face + ".png"));
			return card;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// create frame
	public JFrame createFrame() {
		JFrame frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setVisible(true);
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}
	
	// constructor
	public GraphicsTest() {
		frame = this.createFrame();
		cardList = new LinkedList<BufferedImage>();
	}
	
	public static void main(String[] args) {
		GraphicsTest graph = new GraphicsTest();
		for (int i = 0; i < 52; i++) {
			graph.cardList.addLast(getImage("4", 'H'));
		}
		Graphics g = graph.frame.getGraphics();
		graph.paintComponent(g);
	}
}
