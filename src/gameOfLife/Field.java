package gameOfLife;

import javax.swing.*;
import java.awt.*;

public class Field implements FieldInterface
{
	/**
	 * deklaration von einem JFrame
	 * und einem zweidimensionalen JPanel-Array
	 * im JPanel-Array werden die einzelnen Zellen visualisiert
	 */
	JFrame window;
	JPanel[][] panelArray;

	public Field(int height, int width, Game game)
	{
		/**
		 * Erzeugung des JFrames und des JPanel-Arrays und Befüllung des Arrays mit den einzelnen visualisierten Zellen
		 * lebende Zellen werden schwarz, tote Zellen weiß
		 * der Tote Rand wird gelb gezeichnet
		 */

		super();
		window = new JFrame("GameOfLife");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(height + 2, width + 2, -1, -1));

		panelArray = new JPanel[height + 2][width + 2];

		for (int i = 0; i < height + 2; i++)
		{
			for (int j = 0; j < width + 2; j++)
			{
				panelArray[i][j] = new JPanel();
				panelArray[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				panelArray[i][j].setPreferredSize(new Dimension(12, 12));
				if (game.field[i][j].isCurrentAlive())
				{
					setCellAlive(i, j);
				} else if (i == 0 || j == 0 || i == height + 1 || j == height + 1)
				{
					//toter Spielfeldrand wird gelb eingefärbt
					panelArray[i][j].setBackground(Color.YELLOW);
				} else
				{
					setCellDead(i, j);
				}
				window.add(panelArray[i][j]);

			}
		}
		window.pack();
		window.setVisible(true);
		window.setTitle("Game Of Life - Generation: " + game.generation);

	}

	/* (non-Javadoc)
	 * @see testat2.FieldInterface#changeField(testat2.Game)
	 */
	@Override
	public void changeField(Game game)
	{
		/**
		 * überführt die Zustände des Zellen in die Visualisierung
		 * lebend weiß, tot schwarz
		 */
		for (int i = 1; i < game.field.length - 1; i++)
		{
			for (int j = 1; j < game.field[i].length - 1; j++)
			{
				if (game.field[i][j].isCurrentAlive())
				{
					setCellAlive(i, j);
				} else
				{
					setCellDead(i, j);
				}
			}
		}
		window.setTitle("Game Of Life - Generation: " + game.generation);
	}

	/* (non-Javadoc)
	 * @see testat2.FieldInterface#setCellAlive(int, int)
	 */
	@Override
	public void setCellAlive(int i, int j)
	{
		/**
		 * Methode zum einfärben der lebenden zellen
		 */
		panelArray[i][j].setBackground(Color.RED);
	}

	/* (non-Javadoc)
	 * @see testat2.FieldInterface#setCellDead(int, int)
	 */
	@Override
	public void setCellDead(int i, int j)
	{
		/**
		 * Methode zum einfärben der toten Zellen
		 */
		panelArray[i][j].setBackground(Color.LIGHT_GRAY);
	}
}