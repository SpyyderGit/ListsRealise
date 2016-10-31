package bsTree;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BsTreeGr extends BsTree
{
	public void show(JPanel p)
	{
		showNode(root, (Graphics2D) p.getGraphics(), 0, p.getWidth(), 0, p.getWidth() / 2, 0);
	}

	private void showNode(Node p, Graphics2D gg, int left, int right, int lvl, int x2, int y2)
	{
		if (p == null)
			return;
		int x = (left + right) / 2;
		int y = 150 * ++lvl;

		gg.drawOval(x - 33, y, 70, 70);
		gg.drawString("" + p.val, x + 20, y + 45);
		gg.drawLine(x, y, x2, y2 + 70);

				
		showNode(p.left, gg, left, x, lvl, x, y);
		showNode(p.right, gg, x, right, lvl, x, y);
	}

}
