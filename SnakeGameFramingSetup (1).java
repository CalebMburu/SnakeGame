import javax.swing.JFrame;

public class SnakeGameFramingSetup extends JFrame{

	SnakeGameFramingSetup(){
			
		this.add(new GamePanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}