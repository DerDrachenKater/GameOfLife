package gameOfLife;

public interface CellInterface
{

	boolean isNextAlive();

	void setNextAlive(boolean nextAlive);

	boolean isCurrentAlive();

	void setCurrentAlive(boolean currentAlive);

	void setNeighbours(Cell[][] field, int i, int j);

	int countLivingNeighbours();

}