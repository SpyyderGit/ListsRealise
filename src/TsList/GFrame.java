package TsList;
import javax.swing.JFrame;

public class GFrame extends JFrame
{
	public GFrame()
	{
		setTitle("Tree");
		setBounds(10, 10, 1600, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		GPanel pan = new GPanel();
		pan.setBounds(10, 10, 1600, 1000);
		add(pan);
		
		setVisible(true);
	}
}
