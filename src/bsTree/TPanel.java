package bsTree;

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

	public TPanel()
	{
		setLayout(null);
		
		JButton btn = new JButton("show");

		JButton clear = new JButton("Clear");
		clear.addActionListener(new Clear());
		clear.setBounds(150, 10, 120, 20);

		JButton btnDel = new JButton("show Vertical");
		btnDel.addActionListener(new ShowVertAction());

		btn.setBounds(10, 10, 120, 20);
		btn.addActionListener(new ShowAction());

		btnDel.setBounds(300, 10, 120, 20);

		add(btn);
		add(clear);
		add(btnDel);

		setBounds(20, 20, 1000, 800);
		setBackground(Color.white);

	}

	class ShowAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int[] ar = {50, 25, 30, 11, 7, 12, 75, 90, 110, 13, 70, 35, 28};

			BsTreeGr gr = new BsTreeGr();
			gr.init(ar);
			// gr.delete(25);

			gr.show(TPanel.this);

		}
	}

	class ShowVertAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int[] ar = { 50, 25, 30, 11, 7, 12, 75, 90, 110, 13, 70, 35, 28 };

			BsTreeGr gr = new BsTreeGr();
			gr.init(ar);
			// gr.delete(25);

			gr.showVert(TPanel.this);

		}
	}

	class Clear implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		}
	}

}
