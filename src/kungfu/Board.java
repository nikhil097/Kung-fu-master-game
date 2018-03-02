package kungfu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants {
	
	Camera camera;
	Player player;
	Key key;
	Key fruit;
	EnemyDragon dragon;
	Enemy[] enemies=new Enemy[30];
	Enemy[] backenemies=new Enemy[30];
	boolean isEnemyVisible;
	private Timer timer;
	int w=0;	
	int noOfEnemies=4;
	boolean killEnemy;
	boolean killBackEnemy;
	boolean isCameraMove=true;
	boolean isEnemyPrepare1=true;
	boolean isEnemyPrepare2=true;
	boolean isEnemyPrepare3=true;
	boolean isEnemyPrepare4=true;
	boolean isLevelCompleteTrue;
	boolean isDragonVisible;
	boolean isDragonBornCameraStill;
	boolean isDragonBorn;
	boolean isKeyEnabled=true;
	boolean playLevelCompleteSong=true;
	boolean isEnemyDragonMoving=true;
	boolean isEnemyDragonMovingFront=false;
	boolean isEnemyDragonFirstTimeMoving=true;
	boolean isEnemyDragonSecondTimeMoving;
	boolean isEnemyDragonThirdTimeMoving;
	boolean isEnemyDragonFourthTimeMoving;
	boolean bulletShootFront;
	boolean bulletshootBack;
	boolean isKeyVisible=true;
	boolean isFruitVisible=true;
	boolean isFruitEaten;
	
	void bindEvent(){
		
			this.addKeyListener(new KeyAdapter() {
				
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_RIGHT  && isKeyEnabled)
					{
				
						player.currentMove=3;
						if(camera.getX()<=1487 && isCameraMove )
						{
						if(!isDragonBornCameraStill)
						{
						camera.right();
						camera.move();
					    }
						else
						{
							if(player.getX()<GAME_WIDTH-player.getW())
							{
							player.right();
							player.move();
							}
						}
						}
					}
					else if(e.getKeyCode()==KeyEvent.VK_LEFT && isKeyEnabled )
					{
						        
						if(camera.getX()==1442 && isEnemyPrepare1)
						{
							isEnemyVisible=true;
							prepareEnemy();
							camera.left();
							camera.move();
						//	isCameraMove=false;
						    isEnemyPrepare1=false;
						    
						    
				//			isCameraMove=false;
							
						}
				
						if(camera.getX()==987 && isEnemyPrepare2  )
						{
							prepareEnemy();
							camera.left();
							camera.move();
						//	isCameraMove=false;
							isEnemyPrepare2=false;
						}
						
						if(camera.getX()==682  && isEnemyPrepare3)
						{
							prepareBackEnemy();
							camera.left();
							camera.move();
					//		isCameraMove=false;
							isEnemyPrepare3=false;
						}
						
						if(camera.getX()==402  &&  isEnemyPrepare4)
						{
							prepareEnemy();
							camera.left();
							camera.move();
                           
						//	isCameraMove=false;
							isEnemyPrepare4=false;
						}
						
						
						if(camera.getX()==152 && !isDragonBorn)
						{
							 dragon=new EnemyDragon();
	                         isDragonVisible=true;
	                         isDragonBornCameraStill=true;
	                         isDragonBorn=true;
	                         playSong.dragonSound();
						}
						if(isDragonBornCameraStill)
						{
							if(player.getX()>0)
							{
	                         player.left();
	                         player.move();
							}
						}			
						
					//	System.out.println(camera.getX());
						
						if(player.getX()>=350)
						{
						player.currentMove=1;
						}
						else if(player.getX()<350)
						{
							player.currentMove=1;
						}
						if(camera.getX()>=30 && isCameraMove && !isDragonBornCameraStill)
						{
						camera.left();
						camera.move();
					    }
						else if(camera.getX()<=27 && player.getX()>=350)
						{
							player.left();
							player.move();
						}
						else if(camera.getX()<=27 && player.getX()<350)
						{
							isLevelCompleteTrue=true;
						}
						
						//System.out.println(camera.getX()+" "+player.getX());
					
					}
					
					else if(e.getKeyCode()==KeyEvent.VK_CONTROL)
					{
						if(player.currentMove==0)
						{
						playSong.punchSong();
						player.currentMove=2;
						}
						
						else if(player.currentMove==5)
						{
							playSong.punchSong();
							player.currentMove=6;
						}
					}
					
					else if(e.getKeyCode()==KeyEvent.VK_INSERT)
					{
						if(player.currentMove==0)
						{
						player.currentMove=4;
						playSong.kickSong();
				       	}
					
						else if(player.currentMove==5)
						{
							player.currentMove=7;
							playSong.kickSong();
						}
					}
						
						else if(e.getKeyCode()==KeyEvent.VK_SPACE)
						{
							if(isFruitEaten)
							{
							if(player.getY()==400)
							{
								if(player.currentMove==0 || player.currentMove==1)
								{
									player.currentMove=8;
								}
								else if(player.currentMove==3 || player.currentMove==5)
								{
									player.currentMove=9;
								}
							isPlayerGoingUp=true;
							isPlayerGoingDown=false;	
							//System.out.println(player.getY());
							}
							}
						}
						else if(e.getKeyCode()==KeyEvent.VK_SHIFT)
						{
							if(isFruitEaten)
							{
							playSong.fireSong();
							if(player.currentMove==0 || player.currentMove==1 || player.currentMove==8)
							{
								bulletShootFront=true;
								bulletshootBack=false;
								player.fire();
							}
							else if(player.currentMove==3 || player.currentMove==5 || player.currentMove==9)
							{
								bulletshootBack=true;
								bulletShootFront=false;
								player.backFire();
							}
							}
							
						}
				
					
				}});
	}
	
	boolean isPlayerGoingUp;
	boolean isPlayerGoingDown;
	
	
	public void playerJump()
	{
		if(player.getY()>150 && isPlayerGoingUp && !isLevelCompleteTrue)
		{
			player.jumpUp();
		}
		if(player.getY()==150 && !isLevelCompleteTrue)
		{
			isPlayerGoingUp=false;
			isPlayerGoingDown=true;
		}
		if(player.getY()<400 && isPlayerGoingDown && !isLevelCompleteTrue)
		{
			player.fallDown();
		}
	
	}


private void gameLoop(){
	    
		 timer = new Timer(DELAY,(e)->{
			
			repaint();
//			isCollision(player, enemies);
			isCollisionTrue();
			playerHealthDecrease();
			isLevelComplete();
			playerJump();
			if(isDragonVisible)
			{
			isCollisionWithBullets(dragon, player.getBulletList());
			isCollisionWithFrontBullets(dragon, player.getBulletList2());
			}		
			//	System.out.println(player.currentMove);
			if(isDragonVisible)
			{
				if(isCollisionWithDragon(player, dragon))
				{
					player.playerHealth-=5;
				}
			}
			if(isDragonVisible)
			{
				if(dragon.getX()==880)
				{
					isEnemyDragonMoving=false;
					isEnemyDragonMovingFront=true;
				}
				else if(dragon.getX()==20)
				{
					isEnemyDragonMoving=true;
					isEnemyDragonMovingFront=false;
				}
				/*if(isEnemyDragonMoving)
				{
			      dragon.enemyDragonMove();
			      if(dragon.getX()==200 && isEnemyDragonFirstTimeMoving)
					{
						dragon.enemyDragonJumpUp();
					}
				  if(dragon.getX()==300 && isEnemyDragonFirstTimeMoving)
					{
						dragon.enemyDragonFallDown();
						isEnemyDra
					}
				  if(dragon.getX()==340 && isEnemyDragonSecondTimeMoving)
				  {
					  dragon.enemyDragonJumpUp();
				  }
				  if(dragon.getX()==440 && isEnemyDragonSecondTimeMoving)
				  {
					  dragon.enemyDragonFallDown();
				  }
				  if(dragon.getX()==100 && isEnemyDragonThirdTimeMoving)
				  {
					  dragon.enemyDragonJumpUp();
				  }
				  if(dragon.getX()==200 && isEnemyDragonThirdTimeMoving)
				  {
					  dragon.enemyDragonFallDown();
				  }
					
				}
				else if(/*dragon.getX()>GAME_WIDTH &&*/ /*isEnemyDragonMovingFront)
				{
					dragon.enemyDragonFrontMove();
				}
				*/
				
				if(player.getX()-dragon.getX()>=0)
				{
					dragon.enemyDragonMove();
					
				}
				else if(dragon.getX()-player.getX()>=0)
				{
					dragon.enemyDragonFrontMove();
				}
				
			//	System.out.println(dragon.getX());
			}
			if(isEnemyVisible)
			{
			enemyWalk();
			}
			
			if(isDragonVisible)
			{
				if(dragon.enemyDragonHealth<1)
				{
					dragon=null;
					isDragonVisible=false;
				}
			}
			
			/*if(dragon==null)
			{
				isDragonBornCameraStill=false;
			}
			*/
			}
		 );
		timer.start();
}

public Board()
{
	setSize(GAME_WIDTH,GAME_HEIGHT);
	camera=new Camera();
	 new playSong();
	 playSong.playbackgroundsong();
	camera.loadImage();
    player=new Player();
    key=new Key(400,450,150,50);
    fruit=new Key(250,450,100,50);
    setFocusable(true);
    bindEvent();
	gameLoop();
}

int i=0;


/*public void prepareEnemy(){
	  int x=0;
	  
	    for(;i<noOfEnemies+w;i++)
	    {
	    	
	    	enemies[i]=new Enemy(x);
	    	x=x-70;
	         	
	    }
	   w=i;   
}
*/


public void prepareEnemy(){
	  int x=0;
	  
	    for(i=0;i<noOfEnemies;i++)
	    {
	    	
	    	enemies[i]=new Enemy(x);
	    	x=x-70;
	     
	    }
	    w=i;
	    
}


public void printBullets(Graphics g)
{
	ArrayList<Bullet> bulletList=player.getBulletList();
	ArrayList<Bullet> bulletList2=player.getBulletList2();
	if(bulletList.size()>0)
	{
		for(Bullet bullet:bulletList)
		{
			if(bullet.isBulletVisible)
			{
		         bullet.drawFrontBullets(g);
		         bullet.moveBulletFront();
		         //Rectangle rect3=new Rectangle(bullet.getX(),bullet.getY(),bullet.getW(),bullet.getH());
		         //Rectangle rect4=new Rectangle(dragon.getX(),dragon.getY(),bullet.getW(),bullet.getH());
			}
		}
	}
	if(bulletList2.size()>0)
	{
		for(Bullet bullet:bulletList2)
		{
			if(bullet.isBulletVisible)
			{
			bullet.drawBullet(g);
			bullet.moveBullet();
			}
		}
	}
}

public void isCollisionWithBullets(EnemyDragon dragon,ArrayList<Bullet> bulletList)
{
	if(bulletList.size()>0)
	{
	for(Bullet bullet:bulletList)
	{
		if(bullet.isBulletVisible)
		{
		Rectangle rect3=new Rectangle(bullet.getX(),bullet.getY(),bullet.getW(),bullet.getH());
	    Rectangle rect4=new Rectangle(dragon.getX(),dragon.getY(),bullet.getW(),bullet.getH());
	    if(rect3.intersects(rect4))
	    {
	    	dragon.enemyDragonHealth-=5;
	    	bullet.isBulletVisible=false;
	    }
	}
	}
	}
}

public void isCollisionWithFrontBullets(EnemyDragon dragon,ArrayList<Bullet> bulletList2)
{
	if(bulletList2.size()>0)
	{
		for(Bullet bullet:bulletList2)
		{
			if(bullet.isBulletVisible)
			{
			Rectangle rect5=new Rectangle(bullet.getX(),bullet.getY(),bullet.getW(),bullet.getH());
			Rectangle rect6=new Rectangle(dragon.getX(),dragon.getY(),dragon.getW(),dragon.getH());
			if(rect5.intersects(rect6))
			{
				dragon.enemyDragonHealth-=5;
				bullet.isBulletVisible=false;
			    
			}
		}
		}
	}
}

public boolean isCollisionWithDragon(Player player,EnemyDragon dragon)
{
	Rectangle rect1=new Rectangle(player.getX(),player.getY(),player.getW(),player.getH());
	Rectangle rect2=new Rectangle(dragon.getX(),dragon.getY(),dragon.getW(),dragon.getH());
	//System.out.println(rect1.getX()+" "+rect1.getY()+" "+rect1.getWidth()+" "+rect1.getHeight());
	//System.out.println(rect2.getX()+" "+rect2.getY()+" "+rect2.getWidth()+" "+rect2.getHeight());
	return rect1.intersects(rect2);
	
}

public void isCollisionTrue()
{
	for(i=0;i<enemies.length;i++)
	{
		if(enemies[i]!=null)
		{
			
		    if(enemies[i].getX()>280)
		    {
		    	killEnemy=true;
		    }
			
			}
	/*	killEnemy=true;
		System.out.println("hi");
		enemies[i]=null;
		*/
	}
	
	
	for(int i=0;i<backenemies.length;i++)
	{
		if(backenemies[i]!=null)
		{
			if(backenemies[i].getX()<480)
			{
				killBackEnemy=true;
			}
			
			
		}
	}
	
}




public boolean isCollisionWithKey(Player player,Key key)
{
	Rectangle rect7=new Rectangle(player.getX(),player.getY(), player.getW(), player.getH());
	Rectangle rect8=new Rectangle(key.getX(),key.getY(),key.getW(),key.getH());
	return rect7.intersects(rect8);
}

public boolean isCollisionWithFruit(Player player,Key fruit)
{
	Rectangle rect9=new Rectangle(player.getX(),player.getY(),player.getW(),player.getH());
	Rectangle rect10=new Rectangle(fruit.getX(),fruit.getY(),fruit.getW(),fruit.getH());
	return rect9.intersects(rect10);
}

public void isLevelComplete()
{
    if(isLevelCompleteTrue)
    {
    	    isKeyEnabled=false;
    	    player.currentMove=1;
    		//player.left();
			player.climbStairs();
			//player.move();
			if(playLevelCompleteSong)
			{
			playSong.stopbackgroundsong();
			playSong.playLevelCompletesong();
			playLevelCompleteSong=false;
			}
    }
}
    


public void playerHealthDecrease()
{
	if(killEnemy || killBackEnemy)
	{
		player.playerHealth-=5;
		
	}
}


boolean isEnemyKill;
boolean isBackEnemyKill;

public void KillEnemy(Graphics g)
{
	for(int i=0;i<enemies.length;i++){
		if(enemies[i]!=null){
	        if(player.currentMove==4 && enemies[i].getX()>280 || player.currentMove==2  && enemies[i].getX()>280)
	          {
	        	  enemies[i].enemyKill(g);
		          enemies[i]=null;
	              killEnemy=false;
	           }}}
	   
	for(int i=0;i<backenemies.length;i++)
	{
		if(backenemies[i]!=null)
		{
		if(player.currentMove==7 && backenemies[i].getX()<480 || player.currentMove==6 && backenemies[i].getX()<480)
		{
			backenemies[i].backEnemyKill(g);
			backenemies[i]=null;
			killBackEnemy=false;
		}}}
		/*
		 
	}*/
	
	 for(i=0;i<enemies.length;i++)
	    {
	    	if(enemies[i]!=null){
	    	    isEnemyKill=false;
	    	    break;
	    	}
	    	else {
	    		isEnemyKill=true;
	    	}
         }
	    
	/*    if(isEnemyKill)
	    {
	    	isCameraMove=true;
	    }
	  */  
	    for(i=0;i<backenemies.length;i++)
	    {
	    	if(backenemies[i]!=null){
	    	    isBackEnemyKill=false;
	    	    break;
	    	}
	    	else {
	    		isBackEnemyKill=true;
	    	}
         }
	    if(isBackEnemyKill && isEnemyKill)
	    {
	    	isCameraMove=true;
	    }

	    
		}

public void drawPlayerHealth(Graphics g)
{
	g.setColor(Color.BLACK);
	g.setFont(new Font("Arial",Font.BOLD,30));
	g.drawString("Player Health",600 ,25);
	g.draw3DRect(600, 40, 200, 25, true);
	g.setColor(Color.RED);
	g.fillRect(601, 41, 199, 24);
	g.setColor(Color.BLUE);
	g.fillRect(601, 41, player.playerHealth, 24);
}

public void drawEnemyDragonHealth(Graphics g)
{
	g.setColor(Color.BLACK);
	g.setFont(new Font("Arial",Font.BOLD,30));
	g.drawString("Enemy Health",50 ,25);
	g.draw3DRect(50, 40, 200, 25, true);
	g.setColor(Color.RED);
	g.fillRect(51, 41, 199, 24);
	g.setColor(Color.BLUE);
	g.fillRect(51, 41, dragon.enemyDragonHealth, 24);
}



public void isGameOver(Graphics g)
{
	if(player.playerHealth<2)
	{
		g.setFont(new Font("Arial",Font.BOLD,50));
		g.drawString(" Game Over", (GAME_WIDTH/2)-100, GAME_HEIGHT/2);
		timer.stop();
	}
}

public void isLevelComplete(Graphics g)
{
	if(player.getY()<10)
	{
		g.setFont(new Font("Arial",Font.BOLD,50));
		g.setColor(Color.BLUE);
		g.drawString(" Level Finish", (GAME_WIDTH/2)-100, GAME_HEIGHT/2);
		timer.stop();
	}
}

public void drawCopyRight(Graphics g)
{
	g.setFont(new Font("Arial", Font.BOLD, 20));
	g.setColor(Color.BLACK);
	g.drawString("©NIKHIL AGGARWAL", GAME_WIDTH-250, GAME_HEIGHT-50);
}



/*public void drawKillEnemy(Graphics g,Enemy enemy)
{
	if(killEnemy==true)
	enemy.enemyKill(g);
}

*/

/*public void prepareBackEnemy(){
	  int x=900;
	  
	    for(;i<noOfEnemies+w;i++)
	    {
	    	
	    	enemies[i]=new Enemy(x);
	    	x=x-70;
	         	
	    }
	   w=i;
}
*/

int v=0;
public void prepareBackEnemy(){
	 int x=900;
	 
	 for(i=0;i<noOfEnemies;i++)
	 {
		 backenemies[i]=new Enemy(x);
		 x=x-70;
	 }
	 
	 v=i;
}

public void enemyWalk()
{
	//isCameraMove=false;
	for(int i=0;i<w;i++)
	{
	//	System.out.println(noOfEnemies);
		if(enemies[i]!=null)
		{
		if (player.getX()-enemies[i].getX()>80 )
		{
		 //System.out.println(enemies[i].getX());	
		 enemies[i].move();
		}
		else
		{
		   isCameraMove=false;		
		}
			}
	}
	for(int i=0;i<v;i++)
	{
		if(backenemies[i]!=null)
		{
		if (backenemies[i].getX()-player.getX()>50)
		{
			backenemies[i].frontMove();
		    //System.out.println(backenemies[i].getX());
		}
		else
		{
			isCameraMove=false;
		}
	}
}
}
	
@Override
public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	camera.drawBackground(g);
	
	player.stand(g);
	player.backStand(g);
	printBullets(g);
	drawPlayerHealth(g);
	drawCopyRight(g);
	if(isDragonVisible)
	{
	drawEnemyDragonHealth(g);
	}
	player.walk(g);
	player.jump(g);
	player.jumpFrontFacing(g);
	player.punch(g);
	player.backPunch(g);
	player.kick(g);
	player.backKick(g);
	player.backwalk(g);
	isGameOver(g);
	isLevelComplete(g);
	KillEnemy(g);
	if(isFruitVisible && camera.getX()<=152)
	{
	    fruit.drawFruit(g);
	    if(isCollisionWithFruit(player, fruit))
	    {
	    	isFruitVisible=false;
	    	isFruitEaten=true;
	    }
	}
	if(dragon==null && isDragonBorn && isKeyVisible)
	{
		//isDragonBornCameraStill=false;

		key.drawKey(g);
		if(isCollisionWithKey(player, key))
		{
			isDragonBornCameraStill=false;
			isKeyVisible=false;
		}
	}
	/*if(isDragonVisible && isEnemyDragonMoving)
	{
	dragon.enemyDragonWalk(g);
	
	}
	else if(isDragonVisible && isEnemyDragonMovingFront)
	{
		dragon.enemyDragonFrontWalk(g);
	}*/
	/*else if(isDragonVisible )
	{
		dragon.enemyDragonWalk(g);
		dragon.enemyDragonJump();
	}*/
	if(isDragonVisible)
	{
	if(player.getX()-dragon.getX()>1)
	{
		dragon.enemyDragonWalk(g);
	}
	else if(dragon.getX()-player.getX()>0)
	{
		dragon.enemyDragonFrontWalk(g);
	}
	}
	for(int i=0;i<w;i++)
	{
		if(enemies[i]!=null){

		if(player.getX()-enemies[i].getX()>80){		
	
			enemies[i].EnemyWalk(g);
		}
		
		
		
		else
		{
			enemies[i].enemyprint(g);
		}
}
	}
	
	for(int i=0;i<v;i++)
	{
		if(backenemies[i]!=null)
		{
	   if (backenemies[i].getX()-player.getX()>50)
		{
			backenemies[i].EnemyFrontWalk(g);
		}
	   else  //(enemies[i].getX()-player.getX()<80  && enemies[i].getX()-player.getX()>0)
		{
			backenemies[i].enemyFrontPrint(g);
		}
		
	}
	}
}


	
}
