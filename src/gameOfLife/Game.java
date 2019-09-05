package gameOfLife;

/**
 * @author Mario Breitenbach
 * @version 20150628-2100
 */
public class Game
{
	private final double dead = 0.0;
	private final int edges = 2;
	public Cell[][] field;
	public int generation;

	public Game(int height, int width)
	{
		/**
		 * Spielfeld wird um 2 Felder in jeder Dimension größer angelegt,
		 * da für die berechnung der Generationen ein Rand benötigt wird.
		 * Übereinkunft: unsichtbarer Rand besteht nur aus toten Zellen
		 * (ChanceOfLiving = 0)
		 * Wahrscheinlichkeit, dass Zellen bei Initialisierung als lebend
		 * markiert werden: 25% (ChanceOfLiving = 25).
		 */
		field = new Cell[height + edges][width + edges];
		for (int i = 0; i < field.length; i++)
		{
			for (int j = 0; j < field[i].length; j++)
			{
				if (i == 0 || i == field.length - 1 || j == 0 || j == field[i].length - 1)
				{
					field[i][j] = cellsWithChanceOfLiving(dead);
				} else
				{
					field[i][j] = cellsWithChanceOfLiving(25.0);
				}

			}
		}
		/**
		 * erzeugtes Spielfeld wird erneut Reihe für Reihe durchlaufen,
		 * um den Zellen ihre Nachbarn zuzuordnen
		 */
		for (int i = 1; i < field.length - 1; i++)
		{
			for (int j = 1; j < field[i].length - 1; j++)
			{
				field[i][j].setNeighbours(field, i, j);
			}
		}
		generation = 0;
	}

	private Cell cellsWithChanceOfLiving(double chanceOfLiving)
	{
		/**
		 * erzeugt Cell-Objekte mit einer angegebenen Wahrscheinlichkeit in %,
		 * dass sie lebend markiert werden.
		 */
		Cell cell;
		if (Math.random() * 100 < chanceOfLiving)
		{
			cell = new Cell(true);
		} else
		{
			cell = new Cell(false);
		}
		return cell;
	}


	public void changeGeneration()
	{
		/**
		 *
		 * durchläuft das Spielfeld,
		 * lässt die Zellen ihre lebenden Nachbarn zählen,
		 * errechnet den Zustand der Zellen in der nächsten Generation
		 * und speichert diesen im Attribut nextAlive der Cell-Objekte
		 */
		for (int i = 1; i < field.length - 1; i++)
		{
			for (int j = 1; j < field[i].length - 1; j++)
			{
				if (field[i][j].countLivingNeighbours() == 3)
				{
					field[i][j].setNextAlive(true);
				} else if (field[i][j].countLivingNeighbours() == 2 && field[i][j].isCurrentAlive())
				{
					field[i][j].setNextAlive(true);
				} else
				{
					field[i][j].setNextAlive(false);
				}
			}
		}
		/**
		 * überführt die Zustände der Cell-Objekte der nächsten Runde in die currentAlive-Variable.
		 */
		for (int i = 1; i < field.length - 1; i++)
		{
			for (int j = 1; j < field[i].length - 1; j++)
			{
				field[i][j].setCurrentAlive(field[i][j].isNextAlive());

			}

		}
		generation++;
	}
}
