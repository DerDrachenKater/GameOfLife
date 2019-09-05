package gameOfLife;

public interface FieldInterface
{

	void changeField(Game game);

	void setCellAlive(int i, int j);

	void setCellDead(int i, int j);

}