package Client1;

import java.util.ArrayList;

import sjuan.Card;

public class AI {
	private ClientController controller; 
	private ArrayList<Card> AICard = controller.getPlayerCards();
	
	public void addACard() {
		for(int i = 0; i < AICard.size(); i++) {
			controller.newRequest("playCard", AICard.get(i).toString());

			}
		controller.newRequest("pass");
		}
		

		
		// jämför första kort i handen med rules.correct
		// if true, lägg ut kortet, break

		// if false fortsätt genom hela handen
		// if never true, pass
	
	
	public Card giveACard() {
		return AICard.get(0);
		
		// Senare utveckling
		// Parameter för kort i handen och eftersökt kort

		// jämför första kort i handen, if kung eller ess, ge bort kortet
		// else loopa om för nästa kort
		// if ingen kung/ess leta efter dam/2 osv
		// använd rekrusivt anrop med ny parameter
	}
	
	
}
