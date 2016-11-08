package QsTree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TPanel extends JPanel
{
	JTextField jtf = null;
	QsTreeGr gr = new QsTreeGr();
	int[] ar = { 50, 80, 30, 40, 27, 29, 35, 38, 42, 44, 60, 65, 57, 59, 61, 64, 66, 69, 90, 110, 85, 87, 115, 120 };

	public TPanel()
	{
		setLayout(null);
		jtf = new JTextField("0");
		JButton btn = new JButton("show");
		JButton btnDel = new JButton("Delete");

		JButton btnVert = new JButton("vert");
		btnVert.addActionListener(new VerticalShow());
		btnVert.setBounds(150, 10, 120, 20);

		jtf.setBounds(450, 10, 120, 20);
		add(jtf);

		btn.setBounds(10, 10, 120, 20);
		btn.addActionListener(new ShowAction());

		btnDel.setBounds(300, 10, 120, 20);

		add(btn);
		add(btnVert);
		add(btnDel);

		setBounds(20, 20, 1000, 800);
		setBackground(Color.white);
	}

	class ShowAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{

			gr.init(ar);
			// gr.delete(25);

			gr.show(TPanel.this);

		}
	}

	class VerticalShow implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			gr.init(ar);
			gr.showVert(TPanel.this);
		}
	}
}
