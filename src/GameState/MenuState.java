package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import Main.GamePanel;
import TileMap.Background;

public class MenuState extends GameState{
	
	private Background bg;
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Help",
			"Quit"
	};
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	//Params
	private final String TITLE = "PERUDO";
	private final String BG_IMAGE = "/backgrounds/menubg2.png";
	private final String FONT_URL = "c:\\Users\\Samuel\\Documents\\Nouveau dossier\\GUI-Perudo\\Ressources\\Fonts\\ObelixProB-cyr.ttf";
	private final int FONT_SIZE = 20;
	private final int TITLEFONT_SIZE = 30;
	
	public MenuState(GameStateManager gsm){
		this.gsm = gsm;
		
		try{
			bg = new Background(BG_IMAGE, 1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(0,128,0);
			//titleFont = new Font("Century Gothic",Font.PLAIN,28); // 1 = family, 2 = Font.PLAIN, 3 = size
			titleFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(FONT_URL))).deriveFont(Font.PLAIN, TITLEFONT_SIZE);
			font = new Font("Arial",Font.PLAIN,FONT_SIZE);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void init() {
		
		
	}

	
	public void update() {
		
		bg.update();
		
	}

	
	public void draw(Graphics2D g) {
		
		//Draw bg
		bg.draw(g);
		
		//Draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		//g.drawString(TITLE, 80, 70); //x,y = Set the title's position
		g.drawString(TITLE, (GamePanel.WIDTH/2), 70);
		
		//Draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++){
			if(i == currentChoice){
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], 145, 140 + i * 30);			
		}
		
	}
	
	private void select(){
		if(currentChoice == 0){
			//Start
		} 
		
		if(currentChoice == 1) {
			//Help
		}
		
		if(currentChoice == 2) {
			//Quit
			System.exit(0);
		}
	}
	
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		
		if(k == KeyEvent.VK_UP){
			currentChoice--;
			if(currentChoice == -1){
				currentChoice = 0;
			}
		}
		
		if(k == KeyEvent.VK_DOWN){
			currentChoice++;
			if(currentChoice == options.length){
				currentChoice = options.length - 1;
			}
		}
		
	}

	
	public void keyReleased(int k) {
		
		
	}
	
	

}
