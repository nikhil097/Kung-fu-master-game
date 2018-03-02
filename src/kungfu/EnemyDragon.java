package kungfu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EnemyDragon {
	
	private int x;
	private int y;
	private int w;
	private int h;
	int index=0;
	int speed=20;
	public int enemyDragonHealth=199;
	
	public EnemyDragon()
	{
		this.w=this.h=130;
		this.y=370;
		this.x=20;
	}
	
	SpriteLoader s2=new SpriteLoader();
	BufferedImage enemyDragonWalk[]=s2.enemyDragonWalk();
	BufferedImage enemyDragonFrontWalk[]=s2.enemyDragonFrontWalk();
	
	public void enemyDragonWalk(Graphics g)
	{
		g.drawImage(enemyDragonWalk[index], x, y, w,h,null);
		index++;
		if(index>1)
		{
			index=0;
			return;
		}
	}
	
	public void enemyDragonFrontWalk(Graphics g)
	{
		g.drawImage(enemyDragonFrontWalk[index],x,y,w,h,null);
		index++;
		if(index>1)
		{
			index=0;
			return;
		}
	}
	
	public void enemyDragonJumpUp()
	{
		//x=x+20;
		y=y-150;
	}
	
	public void enemyDragonFallDown()
	{
		//if(this.y<=370)
	//	x=x+20;
		y=y+150;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public SpriteLoader getS2() {
		return s2;
	}

	public void setS2(SpriteLoader s2) {
		this.s2 = s2;
	}

	public BufferedImage[] getEnemyDragonWalk() {
		return enemyDragonWalk;
	}

	public void setEnemyDragonWalk(BufferedImage[] enemyDragonWalk) {
		this.enemyDragonWalk = enemyDragonWalk;
	}

	public BufferedImage[] getEnemyDragonFrontWalk() {
		return enemyDragonFrontWalk;
	}

	public void setEnemyDragonFrontWalk(BufferedImage[] enemyDragonFrontWalk) {
		this.enemyDragonFrontWalk = enemyDragonFrontWalk;
	}

	public void enemyDragonMove()
	{
		x=x+speed;
	}
	
	public void enemyDragonFrontMove()
	{
		x=x-speed;
	}
	


}
