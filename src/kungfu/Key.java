package kungfu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Key {
	
	private int x;
	private int y;
	private int w;
	private int h;
    BufferedImage keyimg;
    BufferedImage fruitimg;

	Key(int x,int y,int w,int h)
	{
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		 try {
			keyimg=ImageIO.read(Key.class.getResource("keys.png"));
			fruitimg=ImageIO.read(Key.class.getResource("banana.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public BufferedImage getKeyimg() {
		return keyimg;
	}

	public void setKeyimg(BufferedImage keyimg) {
		this.keyimg = keyimg;
	}
	public void drawFruit(Graphics g)
	{
		g.drawImage(fruitimg, x, y, w,h,null);
	}

	public void drawKey(Graphics g)
	{
		g.drawImage(keyimg, x, y,w,h,null);
	}
}
