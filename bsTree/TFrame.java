package bsTree;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TFrame extends JFrame
{
	public TFrame()
	{
		setLayout(null);
		setBounds(200, 200, 1200, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		BsTree t = new BsTree();

		add(new TPanel());

		setVisible(true);
	}
}
