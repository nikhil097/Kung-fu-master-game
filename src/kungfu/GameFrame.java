package kungfu;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants {

	public GameFrame()
	{
		setSize(GAME_WIDTH,GAME_HEIGHT);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Board board=new Board();
		add(board);
		setVisible(true);
	}

	public static void main(String[] args) {

		GameFrame obj=new GameFrame();

}
}