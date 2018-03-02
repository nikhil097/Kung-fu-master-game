package kungfu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet {

	private int x;
	private int y;
	private int w;
	private int h;
	private int speed=10;
    boolean isBulletVisible=true;
	
	Bullet(int x,int y)
	{
		this.x=x;
		this.y=y;
		w=50;
		h=50;
	}
	
	SpriteLoader s1=new SpriteLoader();
	BufferedImage bulletimg=s1.bullet();
	BufferedImage bulletFrontimg=s1.bulletFront();
	
	public void drawBullet(Graphics g)
	{
		g.drawImage(bulletimg,x,y,w,h,null);
	}
	
	public void drawFrontBullets(Graphics g)
	{
		g.drawImage(bulletFrontimg, x, y, w,h,null);
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public SpriteLoader getS1() {
		return s1;
	}

	public void setS1(SpriteLoader s1) {
		this.s1 = s1;
	}

	public BufferedImage getBulletimg() {
		return bulletimg;
	}

	public void setBulletimg(BufferedImage bulletimg) {
		this.bulletimg = bulletimg;
	}

	public BufferedImage getBulletFrontimg() {
		return bulletFrontimg;
	}

	public void setBulletFrontimg(BufferedImage bulletFrontimg) {
		this.bulletFrontimg = bulletFrontimg;
	}

	public void moveBulletFront()
	{
		x=x-speed;
	}
	
	public void moveBullet()
	{
		x=x+speed;
	}
	
}
