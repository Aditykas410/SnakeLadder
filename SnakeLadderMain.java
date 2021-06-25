package snake.ladder;

import java.util.Scanner;

public class SnakeLadderMain 
{
	public static final int bordSize =100;
	
	public final int snakeFacePosition =14;
	public final int snakeTailPosition =7 ;
	
	public int noOfTurns = 10; 
	
	int gameStartPosition, playerCurrentPostiton = 0 ;
	public static final String NULL = "NULL";
	
	
	public static void main(String[] args)
	{
		Scanner sc = null ;
		try
		{
			SnakeLadderMain sl = new SnakeLadderMain();

			System.out.println("Your game is about to begin...!!!");
			sc = new Scanner(System.in);
			
			System.out.println("Please enter how many turns would you like to play : ");
			String turnsInput = sc.nextLine();
			boolean isCorrectInput = false;

			int wrongInputAllowed = 2; 
			while(!isCorrectInput)
			{
				if(wrongInputAllowed<=0 &&  (isInputEmpty(turnsInput) || !turnsInput.matches("^[0-9]$")  || 0 >=Integer.parseInt(turnsInput)))
				{
					System.out.println("Invalid Input Please retry.... ");
					turnsInput = sc.nextLine();
					wrongInputAllowed --;
				}
				else
				{ 
					if(wrongInputAllowed >0)
					{
						sl.noOfTurns = Integer.parseInt(turnsInput);
					}
					else 
					{
						System.out.println("Going ahead with turn : "+ sl.noOfTurns);
					}
					isCorrectInput = true ;
				}
				
			}
			
			isCorrectInput = false ; 
			System.out.println("Please choose dice, from which you want to play..");
			System.out.println("Please enter 1 for normal dice or 2 for crooked dice :: \n");
			
			String input = sc.nextLine();

			while(!isCorrectInput)
			{
				if(isInputEmpty(input) || !input.matches("^[0-2]$") )
				{
					System.out.println("Invalid Input Please retry.... ");
					System.out.println("Please enter 1 for normal dice or 2 for crooked dice :: \n");
					input = sc.nextLine(); 
				}
				else
				{
					isCorrectInput = true; 
					System.out.println("Game Begins..!!\n");
					Thread.sleep(1000);
					
					sl.startGame(input) ;
				}

			}
		}
		catch(Exception e)
		{
			System.out.println("Some Exception occured.. ");
		}
		finally
		{
			if(null !=sc )
			{
				sc = null;
			}
		}
	}
	
	public static boolean isInputEmpty(String str)
	{
		return str == null || str.isEmpty() || str.equalsIgnoreCase(NULL) || str.trim().length()== 0;
	}
	
	public void startGame(String dice)
	{
		DiceOutput dO = null;
		
		if("1".equals(dice))
		{
			 dO= new NormalDiceOutput();
		}
		else
		{
			 dO = new CroockedDiceOutput();
		}
		
		for( int i = noOfTurns; i>0 ;i--)
		{
			System.out.println("player Current Postiton before move :  " + playerCurrentPostiton);
			
			int diceOutput = dO.getDiceOutput();
			System.out.println("Dice output : " + diceOutput );
			
			playerCurrentPostiton = playerCurrentPostiton + diceOutput;
			if(bordSize < playerCurrentPostiton)
			{
				/*
				 * need to reduce the chance 
				 * player wont move and will be on the same position 
				 */
				noOfTurns --;
				playerCurrentPostiton =  playerCurrentPostiton -diceOutput;
				System.out.println("player is not moving please continue.. ");
				continue ;
				
			}
			else if(bordSize == playerCurrentPostiton)
			{
				/*
				 * no matter how many chances are remaining 
				 * no need to play further 
				 */
				noOfTurns =0;
				System.out.println("player has reached the finish line :)  ");
				break;
			}
			
			if(snakeFacePosition== playerCurrentPostiton )
			{
				/*
				 * if snake bites, player need to go to back 
				 * eg. if at 14th position bites then player need to go back to 7th position 
				 */
				System.out.println("SnakeBites");
				playerCurrentPostiton = snakeTailPosition;
			}
			
			System.out.println("player Current Postiton after move : " + playerCurrentPostiton +"\n");
			noOfTurns --;
		}
	}
}