package kungfu;


import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteLoader {
	BufferedImage img;
	BufferedImage flipimg;
    
	public SpriteLoader(){
		try{
		img = ImageIO.read(SpriteLoader.class.getResource("characters.png"));
	    flipimg=ImageIO.read(SpriteLoader.class.getResource("backcharacters.png"));
		}
		catch(Exception e){
			System.out.println("Can't Load the Player Sprite Image");
		}
	}
	
	
public BufferedImage[] enemywalk(){
	
	BufferedImage arr[]=new BufferedImage[2];
	arr[0] = img.getSubimage(56, 98, 24, 49);
	arr[1] = img.getSubimage(83,99, 23, 47);
	
	return arr;
	
}

public BufferedImage[] enemyFrontWalk() {
	
	BufferedImage arr[]=new BufferedImage[2];
	arr[0]=flipimg.getSubimage(364,98,22,49);
	arr[1]=flipimg.getSubimage(334,98,24,49);
	return arr;
}

public BufferedImage[] enemyDragonWalk() {
	
	BufferedImage arr[]=new BufferedImage[2];
	arr[0] = img.getSubimage(0, 48, 18, 46);
	arr[1] = img.getSubimage(27,48, 23, 46);
	return arr;
}

public BufferedImage[] enemyDragonFrontWalk(){
	BufferedImage arr[]=new BufferedImage[2];
	arr[0] = flipimg.getSubimage(423, 52, 19, 43);
	arr[1] = flipimg.getSubimage(394, 51, 25, 45);
	return arr;
}

public BufferedImage[] enemyKill() {
    BufferedImage arr[]=new BufferedImage[2];
    arr[0]=img.getSubimage(229,101,35,42);
    arr[1]=img.getSubimage(229,101,35,42);
    return arr;
}


public BufferedImage[] backEnemyKill() {
	
	BufferedImage arr[]=new BufferedImage[2];
	 //arr[0]=flipimg.getSubimage(424,52,18,40);
	 arr[0]=flipimg.getSubimage(179,101,34,41);
	 arr[1]=flipimg.getSubimage(179,101,34,41);
	return arr;
}
	
public BufferedImage[] walk(){
	
	BufferedImage arr[] = new BufferedImage[2];
	arr[0] = img.getSubimage(0, 3, 16, 38);
	arr[1] = img.getSubimage(28, 3, 18, 38);
	
	return arr;
	}

public BufferedImage[] jump()
{
	BufferedImage arr[]=new BufferedImage[2];
	arr[0]=img.getSubimage(236, 3, 23, 39);
	arr[1]=img.getSubimage(236, 3, 23, 39);
	return arr;
}

public BufferedImage[] jumpFrontFacing()
{
	BufferedImage arr[]=new BufferedImage[2];
	arr[0]=flipimg.getSubimage(182,4,28,36);
	arr[1]=flipimg.getSubimage(182,4,28,36);
	return arr;
}



public BufferedImage[] punch(){
	
	BufferedImage arr[] = new BufferedImage[3];
	arr[0] = img.getSubimage(174, 8, 21, 32);
	arr[1] = img.getSubimage(198, 6, 37, 36);
	arr[2] = img.getSubimage(232, 8, 22, 32);
	
	return arr;
	}

public BufferedImage[] backPunch(){
	
	BufferedImage arr[]= new BufferedImage[3];
	arr[0]=flipimg.getSubimage(183,5,24,34);
	arr[1]=flipimg.getSubimage(209,4,33,36);
	arr[2]=flipimg.getSubimage(245,8,24,33);
	return arr;
}

public BufferedImage[] kick(){
	BufferedImage arr[]=new BufferedImage[3];
	arr[0]=img.getSubimage(294, 0, 29, 45);
	arr[1]=img.getSubimage(322, 0, 31, 44);
	arr[2]=img.getSubimage(357, 0, 21, 40);
	return arr;
}


public BufferedImage[] backkick(){

	BufferedImage arr[]=new BufferedImage[3];
	arr[0]=flipimg.getSubimage(332, 3, 22, 39);
	arr[1]=flipimg.getSubimage(297, 3, 35, 40);
	arr[2]=flipimg.getSubimage(64, 5, 23, 40);
	return arr;
}


public BufferedImage[] backwalk()
{
	BufferedImage arr[]=new BufferedImage[2];
	{
		arr[0] = flipimg.getSubimage(395, 3, 20, 38);
		arr[1] = flipimg.getSubimage(424, 3, 18, 46);
	
		
		return arr;
	}
}

public BufferedImage bullet()
{
	Image bullet=img.getSubimage(209, 65, 18, 13);
	return (BufferedImage) bullet;
}

public BufferedImage bulletFront()
{
	Image bulletFront=flipimg.getSubimage(216, 65, 16, 14);
	return (BufferedImage) bulletFront;
}


public BufferedImage stand()
{
	
	Image standimg=img.getSubimage(56, 4, 18, 39);
	return (BufferedImage) standimg;
	
}

public BufferedImage backStand()
{
	Image backStandImg=flipimg.getSubimage(367, 4, 18, 39);
	return (BufferedImage) backStandImg;
}

public BufferedImage enemystand()
{
	 Image enemystandimg=img.getSubimage(112, 98, 24, 50);
	return (BufferedImage) enemystandimg;
}

public BufferedImage enemyFrontStand()
{
	Image enemyFrontImg=flipimg.getSubimage(301, 99, 29, 48);
	return (BufferedImage) enemyFrontImg;
}

}