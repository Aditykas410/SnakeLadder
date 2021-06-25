package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import snake.ladder.CroockedDiceOutput;
import snake.ladder.DiceOutput;
import snake.ladder.NormalDiceOutput;
public class SnakeLadderTest 
{

	/**
	 * This method will validate the crooked dice output 
	 * test covered : Dice output should be b/w 2 to 6 
	 * And it dice should only throw even number 
	 */
	@Test
	public void checkAndValidateCrookedDiceOutput()
	{
		DiceOutput dO = new CroockedDiceOutput();
		
		for( int i =0 ; i < 50 ; i++)
		{
			if(2 > dO.getDiceOutput() || 6< dO.getDiceOutput() || dO.getDiceOutput() %2 > 0 )
			{
				assertTrue(false);
			}
		}
	}
	
	/**
	 * This method will validate the normal dice output 
	 * test covered : Dice output should be b/w 1 to 6 
	 */
	@Test
	public void checkAndValidateNormalDiceOutput()
	{
		DiceOutput dO = new NormalDiceOutput();
		
		for( int i =0 ; i < 50 ; i++)
		{
			if(0 >= dO.getDiceOutput() || 6< dO.getDiceOutput())
			{
				assertTrue(false);
			}
		}
	}
}
