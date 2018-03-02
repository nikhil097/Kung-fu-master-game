package kungfu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy {

	
	private int x;
	private int y;
	private int w;
	private int h;
	int index=0;
	private int speed=40;
	SpriteLoader s1=new SpriteLoader();
	BufferedImage arrofenemywalk[] = s1.enemywalk();
    BufferedImage enemystandimg=s1.enemystand();
    BufferedImage arrofenemyFrontWalk[]=s1.enemyFrontWalk();
    BufferedImage enemyFrontImg=s1.enemyFrontStand();
    BufferedImage enemyKill[]=s1.enemyKill();
    BufferedImage backEnemyKill[]=s1.backEnemyKill();
    
	public void EnemyWalk(Graphics g){
		//
		 g.drawImage(arrofenemywalk[index], x, y, 100,100,null);
		 index++;
		 if(index>1)
		 {
			 index=0;
		 }
		 
		}
	
	public void enemyKill(Graphics g)
	{
		g.drawImage(enemyKill[index], x, y, 100,100,null);
		index++;
		if(index>1)
		{
			index=0;
			return;
		}
	}
	
	 
	public void backEnemyKill(Graphics g)
	{
		g.drawImage(backEnemyKill[index], x, y,100,100 ,null);
		index++;
		if(index>1)
		{
			index=0;
			return;
		}
		
	}
	
	
	public Enemy(int x)
	{
		this.w=this.h=20;
		this.y=400;
		this.x=x;	
		
	}
	
	public void move()
	{
		x=x+speed;
	}
	
	public void frontMove()
	{
		x=x-speed;
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


	public void enemyprint(Graphics g)
	{
		
		g.drawImage(enemystandimg,x, y,100,100 ,null);
		
	}
	
	public void enemyFrontPrint(Graphics g)
	{
		g.drawImage(enemyFrontImg, x, y, 100,100,null);
	}


	public void EnemyFrontWalk(Graphics g) {
	
		 g.drawImage(arrofenemyFrontWalk[index], x, y, 100,100,null);
		 index++;
		 if(index>1)
		 {
			 index=0;
		 }
		 
		}
	 
	
	
	
	
	
}
