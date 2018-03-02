package kungfu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Player {

	private int x;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	private int y;
	private int h;
	private int w;
	private int xspeed;
    private int yspeed=20;
	
	public Player()
	{
		this.w=90;
		this.h=90;
		this.y=400;
		this.x=400;
	}
    public int currentMove=0;
	int index=0;
	public int playerHealth=199;
	
	
	
	
	SpriteLoader s1=new SpriteLoader();
	BufferedImage arrofPunch[] = s1.punch();
	BufferedImage arrofWalk[] = s1.walk();
    BufferedImage stand=s1.stand();
	BufferedImage arrofBack[]=s1.backwalk();
	BufferedImage arrofKick[]=s1.kick();
	BufferedImage backStandImg=s1.backStand();
    BufferedImage arrofBackPunch[]=s1.backPunch();
	BufferedImage arrofBackKick[]=s1.backkick();
    BufferedImage arrofJump[]=s1.jump();
    BufferedImage arrofJumpFrontFacing[]=s1.jumpFrontFacing();
	
	
    ArrayList<Bullet> bulletList=new ArrayList<>();
    private ArrayList<Bullet> bulletList2=new ArrayList<>();
    
    public void fire()
    {
    	Bullet bullet=new Bullet((x),(y));
    	bulletList.add(bullet); 
    }
    
    public void backFire()
    {
    	Bullet bullet2=new Bullet(x,y);
    	bulletList2.add(bullet2);
    }
    
    
	public ArrayList<Bullet> getBulletList2() {
		return bulletList2;
	}

	public void setBulletList2(ArrayList<Bullet> bulletList2) {
		this.bulletList2 = bulletList2;
	}

	public ArrayList<Bullet> getBulletList() {
		return bulletList;
	}

	public void setBulletList(ArrayList<Bullet> bulletList) {
		this.bulletList = bulletList;
	}

	public void stand(Graphics g)
	{
		
		if(currentMove==0)
		{
			
			g.drawImage(stand,x,y,w,h,null);
		}
	}
	
	public void backStand(Graphics g){
		
		if (currentMove==5)
		{
			g.drawImage(backStandImg, x, y,w,h, null);
		
		
		}
		
	}
	
	public void walk(Graphics g){
		if(currentMove ==1){
		 g.drawImage(arrofWalk[index], x, y, w,h,null);
		 index++;
		}
	 
	 if(index>1){
		 currentMove = 0;
		 index = 0;
	 }
}
	
public void jump(Graphics g)
{
	if(currentMove==8)
	{
		g.drawImage(arrofJump[index], x, y, w,h,null);
		index++;
	}
	if(index>1)
	{
		//currentMove=0;
	    index=0;
	}
	if(y==400 && currentMove==8)
	{
		currentMove=0;
	}
}

public void jumpFrontFacing(Graphics g)
{
	if(currentMove==9)
	{
		g.drawImage(arrofJumpFrontFacing[index], x, y, w,h,null);
		index++;
	}
	if(index>1)
	{
		index=0;
	}
	if(y==400 && currentMove==9)
	{
		currentMove=3;
	}
	
}
	
public void climbStairs()
{
	y=y-6;
	x=x-6;
}

public void punch(Graphics g)
{
	if (currentMove==2)
	{
		g.drawImage(arrofPunch[index],x, y,w,h, null);
		index++;
	}
	
	if(index>1)
	{
		currentMove=0;
		index=0;
	}
}


public void backPunch(Graphics g)
{
	
	if (currentMove==6)
	{
		g.drawImage(arrofBackPunch[index], x, y, w,h,null);
		index++;
		
	}
	
	if(index>1)
	{
		currentMove=5;
		index=0;
	}
	
}


public void kick(Graphics g)
{
	if(currentMove==4)
	{
		g.drawImage(arrofKick[index], x, y,w,h ,null);
		index++;
	}
	if(index>1)
	{
		currentMove=0;
		index=0;
	}
}

public void backKick(Graphics g)
{
	if(currentMove==7)
	{
		g.drawImage(arrofBackKick[index],x, y,w,h ,null);
		index++;
	
	}
	
	if(index>1)
	{
		currentMove=5;
		index=0;
	}
}


public int getH() {
	return h;
}

public void setH(int h) {
	this.h = h;
}

public int getW() {
	return w;
}

public void setW(int w) {
	this.w = w;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public void backwalk(Graphics g)
{
	if(currentMove==3)
	{
		g.drawImage(arrofBack[index], x, y, w,h,null);
		index++;
	}
	if(index>1)
	{
		currentMove=5;
		index=0;
	}
	
	
}
		
void left()
{
	xspeed=10;
}

void right()
{
	xspeed=-10;
}

void up()
{
	yspeed=6;
}

void jumpUp()
{
	y=y-50;
}
void fallDown()
{
	y=y+50;
}

void move()
{
	x=x-xspeed;
//	y=y-yspeed;
}
	}


