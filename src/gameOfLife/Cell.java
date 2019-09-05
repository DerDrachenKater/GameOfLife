package gameOfLife;

/**
 * @author Mario Breitenbach
 * @version 20150628-2100
 */
public class Cell implements CellInterface
{

	/**
	 * Jede Zelle speichert selbst ein Array seiner Nachbarn, den Zustand in der aktuellen Generation
	 * und den Zustand der naechsten Generation.
	 */
	private boolean currentAlive;                //Zustand in der aktuellen Spielrunde
	private boolean nextAlive;                    //Zustand in der naechsten Spielrunde
	private CellInterface[] neighbours = new CellInterface[8];    //Array der Nachbarn im Spielfeld

	public Cell(boolean currentAlive)
	{
		/**
		 * Konstruktor von Zellen
		 * erzeugt ein Cell-Objekt und speichert es mit dem übergebenen Zustand ab
		 */
		setCurrentAlive(currentAlive);
	}

	/* (non-Javadoc)
	 * @see testat2.CellInterface#isNextAlive()
	 */
	@Override
	public boolean isNextAlive()
	{
		return nextAlive;
	}

	/* (non-Javadoc)
	 * @see testat2.CellInterface#setNextAlive(boolean)
	 */
	@Override
	public void setNextAlive(boolean nextAlive)
	{
		this.nextAlive = nextAlive;
	}

	/* (non-Javadoc)
	 * @see testat2.CellInterface#isCurrentAlive()
	 */
	@Override
	public boolean isCurrentAlive()
	{
		return currentAlive;
	}

	/* (non-Javadoc)
	 * @see testat2.CellInterface#setCurrentAlive(boolean)
	 */
	@Override
	public void setCurrentAlive(boolean currentAlive)
	{
		this.currentAlive = currentAlive;
	}

	/* (non-Javadoc)
	 * @see testat2.CellInterface#setNeighbours(testat2.Cell[][])
	 */
	@Override
	public void setNeighbours(Cell[][] field, int i, int j)
	{
		/**
		 * befüllt ein Array von Cell-Objekten mit den 8 direkt benachbarten Zellen
		 */
		this.neighbours[0] = field[i - 1][j - 1];
		this.neighbours[1] = field[i - 1][j];
		this.neighbours[2] = field[i - 1][j + 1];
		this.neighbours[3] = field[i][j - 1];
		this.neighbours[4] = field[i][j + 1];
		this.neighbours[5] = field[i + 1][j - 1];
		this.neighbours[6] = field[i + 1][j];
		this.neighbours[7] = field[i + 1][j + 1];
	}

	/* (non-Javadoc)
	 * @see testat2.CellInterface#countLivingNeighbours()
	 */
	@Override
	public int countLivingNeighbours()
	{
		/**
		 * durchläuft das Array von Zell-Nachbarn und zählt die Anzahl der lebenden Nachbarn
		 * und speichert die Anzahl in der counter-Variablen, die dann zurückgegeben wird
		 */
		int counter = 0;
		for (int i = 0; i < neighbours.length; i++)
		{
			if (neighbours[i].isCurrentAlive())
			{
				counter = counter + 1;
			}
		}
		return counter;
	}
}