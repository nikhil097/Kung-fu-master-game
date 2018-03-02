package kungfu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Camera implements GameConstants{

	Image bg;
	BufferedImage backgroundimage;
	int x=1792-300;
	int y;
	int speed;
	
	void loadImage()
	{
		try
		{
		backgroundimage= ImageIO.read(Camera.class.getResource("background.png"));
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	void left(){
		speed=5;
	}
	
	void right()
	{
		speed=-5;
		
	}
	
	void move()
	{
	
			
		x=x-speed;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	void drawBackground(Graphics g)
	{
		bg=backgroundimage.getSubimage(x,0 ,300, 192);
		g.drawImage(bg,0,0,GAME_WIDTH,GAME_HEIGHT,null);
	    
	}
	
}
