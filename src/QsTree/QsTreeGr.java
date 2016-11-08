package QsTree;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public class QsTreeGr extends QsTree
{
	public void show(JPanel p)
	{
		showNode(root, (Graphics2D) p.getGraphics(), 0, p.getWidth(), 0, p.getWidth() /2, 0);
	}

	private void showNode(Node p, Graphics2D gg, int left, int right, int lvl, int x2, int y2)
	{
		if (p == null)
			return;
		int x = (right + left) / 2;
		int y = 150 * ++lvl;

		gg.drawRect(x - 33, y, 70, 20);
		gg.drawString("" + p.val1, x - 40, y + 20);
		gg.drawString(" , " + p.val2, x - 30, y + 20);
		gg.drawString(" , " + p.val3, x - 10, y + 20);
		gg.drawLine(x, y, x2, y2 + 33);

		int mLeft = left + (right - left) / 3;
		int mRight = left + (right - left) / 2;
		int mR = left + (right - left) / 3 * 2;

		showNode(p.left, gg, mLeft, left, lvl, x, y);
		showNode(p.midLeft, gg, mLeft, mRight, lvl, x, y);
		showNode(p.midRight, gg, mR, mRight, lvl, x, y);
		showNode(p.right, gg, right, mRight, lvl, x, y);
	}

	public void showVert(JPanel jp)
	{
		showNodeVert(root, (Graphics2D) jp.getGraphics(), 0, jp.getHeight(), 0, jp.getHeight() * (-10), 0);
	}

	private void showNodeVert(Node p, Graphics2D gg, int up, int down, int lvl, int x2, int y2)
	{
		if (p == null)
			return;

		int y = (up + down) / 2;
		int x = 50 * ++lvl;

		gg.drawRect(x, y - 15, 25, 25);
		gg.drawString("" + p.val1, x + 5, y - 5);
		gg.drawString(",  " + p.val2, x + 15, y - 5);
		gg.drawString(",  " + p.val2, x + 25, y - 5);
		gg.drawLine(x, y, x2, y2 + 15);

		int tUp = up + (down - up) / 4;
		int mRight = up + (up + down) / 14;
		int tDown = up + (down - up) / 4 * 3;

		showNodeVert(p.left, gg, tDown, down, lvl, x, y);
		showNode(p.midLeft, gg, tDown, mRight, lvl, x, y);
		showNode(p.midLeft, gg, tUp, mRight, lvl, x, y);
		showNodeVert(p.right, gg, up, tUp, lvl, x, y);
	}
}
