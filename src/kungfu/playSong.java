package kungfu;


import jaco.mp3.player.MP3Player;





public class playSong {
	static MP3Player song=new MP3Player(playSong.class.getResource("backgroundMusic.mp3"));
	
    public static void playbackgroundsong()
    {
    	
	    song.play();
    }
    public static void stopbackgroundsong()
    {
    	song.stop();
    }
    
    public static void dragonSound()
    {
    	MP3Player song=new MP3Player(playSong.class.getResource("dragon.mp3"));
    	song.play();
    }
    
    public static void playLevelCompletesong()
    {
    	MP3Player song=new MP3Player(playSong.class.getResource("levelFinish.mp3"));
	    song.play();
    }
    public static void fireSong()
    {
    	MP3Player song=new MP3Player(playSong.class.getResource("fire.mp3"));
    	song.play();
    }
    public static void kickSong()
    {
    	MP3Player song=new MP3Player(playSong.class.getResource("playerKick.mp3"));
	    song.play();
    }
    public static void punchSong()
    {
    	MP3Player song=new MP3Player(playSong.class.getResource("playerPunch.mp3"));
	    song.play();
    }
    
  
}
