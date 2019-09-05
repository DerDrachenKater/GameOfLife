package gameOfLife;

import javax.swing.*;

/**
 * @author Mario Breitenbach
 * @version 20150628-2100
 */
public class GameOfLife implements Runnable
{
	/**
	 * GameOfLife
	 * Hauptklasse zum Starten den Spiels
	 * deklariert ein Game, ein Field und die Höhe und Breite des Spielfelds
	 */

	Game game;
	FieldInterface field;
	int width, height;

	public GameOfLife()
	{
		/**
		 * Konstruktor von GameOfLife
		 * instanziiert die Höhe und Breite mit 100
		 * ein Game mit der Breite und der Höhe
		 * ein Field mit Breite, Höhe und dem Game
		 *
		 */
		width = 100;
		height = 100;
		game = new Game(height, width);
		field = new Field(height, width, game);
	}

	public static void main(String[] args)
	{
		/**
		 * main-Methode
		 * erzeugt ein Objekt von GameOfLife und übergibt es an einen Thread
		 */
		GameOfLife gol = new GameOfLife();
		Thread t = new Thread(gol);
		t.start();
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
		}
		/**
		 * Thread lässt in Endlosschleife die Game.changeGeneration-
		 * und Field.changeField-Methode laufen, unterbrochen von Pausen a 50ms
		 */
		while (true)
		{
			game.changeGeneration();
			field.changeField(game);
			try
			{
				Thread.sleep(25);
			} catch (InterruptedException e)
			{
				JOptionPane.showMessageDialog(null, "Fehler");
			}
		}
	}
}