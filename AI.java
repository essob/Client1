package Client1;

import java.util.ArrayList;

import sjuan.Card;

public class AI {
	private ClientController controller; 
	
	public void addACard(Card card, String cardName) {
		controller.newRequest("playCard", cardName);
		
		if(card == false) {
			addACard(card.next, cardName);
		}
		
		// jämför första kort i handen med rules.correct
		// if true, lägg ut kortet, break

		// if false fortsätt genom hela handen
		// if never true, pass
			else{
			controller.newRequest("pass");
			}
	}
	
	
	
	public void giveACard(Card card) {
		// Parameter för kort i handen och eftersökt kort

		// jämför första kort i handen, if kung eller ess, ge bort kortet
		// else loopa om för nästa kort
		// if ingen kung/ess leta efter dam/2 osv
		// använd rekrusivt anrop med ny parameter
	}
	
	
}
