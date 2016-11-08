package bsTree;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import bsTree.BsTree.Node;

public class BsTreeGr2 extends BsTree
{

	public void show(JPanel p)
	{
		showNode(root, (Graphics2D) p.getGraphics(), 0, p.getWidth() , 0, p.getWidth(), 0);
	}

	private void showNode(Node p, Graphics2D gg, int left, int right, int lvl, int x2, int y2)
	{

		{
			if (p == null)
			{
				return;
			}
			int x = (left + right) / 2;
			int y = 150 * ++lvl;
			gg.drawOval(y, x - 35, 70, 70);
			gg.drawString("" + p.val, y + 5, x + 5);

			gg.drawLine(y, x, y2 + 70, x2);
			showNode(p.right, gg, x/2, right, lvl, x, y);
			showNode(p.left, gg, left, x, lvl, x, y);

			// if (p == null)
			// return;
			// int x = 150 * ++lvl;
			// int y = (right + left) / 2;
			//
			// gg.drawOval(x, y - 35, 70, 70);
			// gg.drawString("" + p.val, x, y);
			// gg.drawLine(x, y, x2 + 70, y2);
			//
			// showNode(p.left, gg, right * 2, x * 2, lvl, x, y);
			// showNode(p.right, gg, x * 2, left, lvl, x, y);
		}
	}
}
