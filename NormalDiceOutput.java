package snake.ladder;

import java.util.Random;

public class NormalDiceOutput implements DiceOutput
{

	@Override
	public int getDiceOutput() {
		Random randNum = new Random(); 
		int randomNum = randNum.nextInt(6);
		
		while (0==randomNum)
		{
			randomNum = randNum.nextInt(6);
		}
		return randomNum;
	}

}
