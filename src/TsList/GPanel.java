package TsList;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GPanel extends JPanel
{
	JTextField txt = null;
	TrTreeGr tr = new TrTreeGr();
	int[] arr = { 50, 80, 30, 40, 27, 29, 35, 38, 42, 44, 60, 65, 57, 59, 61, 64, 66, 69, 90, 110, 85, 87, 115, 120 };

	public GPanel()
	{
		setLayout(null);
		setBackground(Color.white);

		JButton btn_show = new JButton("Show");
		btn_show.setBounds(20, 20, 120, 30);
		btn_show.addActionListener(new ShowAction());
		add(btn_show);

		JButton btn_vert = new JButton("Show Vertical");
		btn_vert.setBounds(140, 20, 120, 30);
		btn_vert.addActionListener(new AddAction());
		add(btn_vert);

		JButton btn_clear = new JButton("Clear");
		btn_clear.setBounds(260, 20, 120, 30);
		btn_clear.addActionListener(new ClearAction());
		add(btn_clear);

		tr.init(arr);
	}

	class ShowAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			tr.show(GPanel.this);
		}
	}

	class AddAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			tr.showVert(GPanel.this);
		}
	}

	class ClearAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		}
	}
}