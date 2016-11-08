package TsList;

import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TrTreeGr extends TrTree
{
	public void show(JPanel jp)
	{
		showNode(root, (Graphics2D) jp.getGraphics(), 0, jp.getWidth(), 0, jp.getWidth() / 2, 0);
	}

	private void showNode(Node p, Graphics2D gg, int left, int right, int lvl, int x2, int y2)
	{
		if (p == null)
			return;

		int x = (left + right) / 2;
		int y = 150 * ++lvl;

		gg.drawRect(x - 36, y, 75, 20);
		gg.drawString("" + p.valLeft, x - 12, y + 15);
		gg.drawString(",  " + p.valRight, x, y + 15);
		gg.drawLine(x, y, x2, y2 + 20);

		int xL = left + (right - left) / 3;
		int xR = left + (right - left) / 3 * 2;

		showNode(p.left, gg, xL, left, lvl, x, y);
		showNode(p.middle, gg, xL, xR, lvl, x, y);
		showNode(p.right, gg, right, xR, lvl, x, y);
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
		int x = 250 * ++lvl;

		gg.drawRect(x, y - 15, 75, 25);
		gg.drawString("" + p.valLeft, x + 5, y - 5);
		gg.drawString(",  " + p.valRight, x + 15, y - 5);
		gg.drawLine(x, y, x2 + 75, y2 + 15);

		int xL4 = up + (down - up) / 4;
		int xR4 = up + (down - up) / 4 * 3;

		showNodeVert(p.left, gg, xR4, down, lvl, x, y);
		showNodeVert(p.right, gg, up, xL4, lvl, x, y);
	}
}
