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
	JTextField jtf = null;

	public TPanel()
	{
		setLayout(null);
		jtf = new JTextField("0");
		JButton btn = new JButton("show");
		JButton btnDel = new JButton("Delete");

		JButton add = new JButton("add");
		add.setBounds(150, 10, 120, 20);

		jtf.setBounds(450, 10, 120, 20);
		add(jtf);

		btn.setBounds(10, 10, 120, 20);
		btn.addActionListener(new ShowAction());

		btnDel.setBounds(300, 10, 120, 20);

		add(btn);
		add(add);
		add(btnDel);

		setBounds(20, 20, 1000, 800);
		setBackground(Color.white);

		add.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int[] ar = { 50, 25, 30, 11, 7, 12, 75, 90, 110, 13 };
				int d = Integer.parseInt(jtf.getText());
				BsTreeGr gr = new BsTreeGr();
				gr.init(ar);
				gr.add(d);
				gr.show(TPanel.this);

			}
		});

		btnDel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int[] ar = { 50, 25, 30, 11, 7, 12, 75, 90, 110, 13 };
				int d = Integer.parseInt(jtf.getText());
				BsTreeGr gr = new BsTreeGr();
				gr.init(ar);
				gr.delete(d);
				gr.show(TPanel.this);

			}
		});
	}

	class ShowAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int[] ar = { 50, 25, 30, 11, 7, 12, 75, 90, 110, 13 };

			BsTreeGr gr = new BsTreeGr();
			gr.init(ar);
//     		gr.delete(25);

			gr.show(TPanel.this);

		}
	}
}
