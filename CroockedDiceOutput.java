package snake.ladder;

import java.util.Random;

public class CroockedDiceOutput implements DiceOutput
{

	@Override
	public int getDiceOutput() 
	{
		Random randNum = new Random(); 
		int randomNum = ( randNum.nextInt(3)+1)*2;
		
		return randomNum;
	}

}
