package advancedJava;

import java.util.Random;

import javax.swing.JOptionPane;

public class go_fish_game {
	public static void main(String[] args) {
		int i;
		deck card[] = new deck[52];
		for (i = 0; i <= 51; i++) {
			card[i] = new deck();
		}

		game_play value = new game_play();
		value.fish(card);
		System.exit(0);
	}
}

class game_play extends deck {
	int i, count;
	int card_flag;
	hand pFirst, pCurrent, pPrev, pNext, cFirst, cCurrent, cPrev, cNext, check, save, pBooks, cBooks, currentBook,
			pPrevBook, cPrevBook, Next, Prev;
	int card_count = 0;
	int deck_position;
	String player_name;

	void load(deck card[]) {

		card[0].card_name = "TWO";
		card[0].card_type = "heart";
		card[0].card_value = 2;
		card[0].dealt = false;
		card[1].card_name = "THREE";
		card[1].card_type = "heart";
		card[1].card_value = 3;
		card[1].dealt = false;
		card[2].card_name = "FOUR";
		card[2].card_type = "heart";
		card[2].card_value = 4;
		card[2].dealt = false;
		card[3].card_name = "FIVE";
		card[3].card_type = "heart";
		card[3].card_value = 5;
		card[3].dealt = false;
		card[4].card_name = "SIX";
		card[4].card_type = "heart";
		card[4].card_value = 6;
		card[4].dealt = false;
		card[5].card_name = "SEVEN";
		card[5].card_type = "heart";
		card[5].card_value = 7;
		card[5].dealt = false;
		card[6].card_name = "EIGHT";
		card[6].card_type = "heart";
		card[6].card_value = 8;
		card[6].dealt = false;
		card[7].card_name = "NINE";
		card[7].card_type = "heart";
		card[7].card_value = 9;
		card[7].dealt = false;
		card[8].card_name = "TEN";
		card[8].card_type = "heart";
		card[8].card_value = 10;
		card[8].dealt = false;
		card[9].card_name = "ACE";
		card[9].card_type = "heart";
		card[9].card_value = 1;
		card[9].dealt = false;
		card[10].card_name = "JACK";
		card[10].card_type = "heart";
		card[10].card_value = 10;
		card[10].dealt = false;
		card[11].card_name = "QUEEN";
		card[11].card_type = "heart";
		card[11].card_value = 10;
		card[11].dealt = false;
		card[12].card_name = "KING";
		card[12].card_type = "heart";
		card[12].card_value = 10;
		card[12].dealt = false;

		card[13].card_name = "TWO";
		card[13].card_type = "diamond";
		card[13].card_value = 2;
		card[13].dealt = false;
		card[14].card_name = "THREE";
		card[14].card_type = "diamond";
		card[14].card_value = 3;
		card[14].dealt = false;
		card[15].card_name = "FOUR";
		card[15].card_type = "diamond";
		card[15].card_value = 4;
		card[15].dealt = false;
		card[16].card_name = "FIVE";
		card[16].card_type = "diamond";
		card[16].card_value = 5;
		card[16].dealt = false;
		card[17].card_name = "SIX";
		card[17].card_type = "diamond";
		card[17].card_value = 6;
		card[17].dealt = false;
		card[18].card_name = "SEVEN";
		card[18].card_type = "diamond";
		card[18].card_value = 7;
		card[18].dealt = false;
		card[19].card_name = "EIGHT";
		card[19].card_type = "diamond";
		card[19].card_value = 8;
		card[19].dealt = false;
		card[20].card_name = "NINE";
		card[20].card_type = "diamond";
		card[20].card_value = 9;
		card[20].dealt = false;
		card[21].card_name = "TEN";
		card[21].card_type = "diamond";
		card[21].card_value = 10;
		card[21].dealt = false;
		card[22].card_name = "ACE";
		card[22].card_type = "diamond";
		card[22].card_value = 1;
		card[22].dealt = false;
		card[23].card_name = "JACK";
		card[23].card_type = "diamond";
		card[23].card_value = 10;
		card[23].dealt = false;
		card[24].card_name = "QUEEN";
		card[24].card_type = "diamond";
		card[24].card_value = 10;
		card[24].dealt = false;
		card[25].card_name = "KING";
		card[25].card_type = "diamond";
		card[25].card_value = 10;
		card[25].dealt = false;

		card[26].card_name = "TWO";
		card[26].card_type = "spade";
		card[26].card_value = 2;
		card[26].dealt = false;
		card[27].card_name = "THREE";
		card[27].card_type = "spade";
		card[27].card_value = 3;
		card[27].dealt = false;
		card[28].card_name = "FOUR";
		card[28].card_type = "spade";
		card[28].card_value = 4;
		card[28].dealt = false;
		card[29].card_name = "FIVE";
		card[29].card_type = "spade";
		card[29].card_value = 5;
		card[29].dealt = false;
		card[30].card_name = "SIX";
		card[30].card_type = "spade";
		card[30].card_value = 6;
		card[30].dealt = false;
		card[31].card_name = "SEVEN";
		card[31].card_type = "spade";
		card[31].card_value = 7;
		card[31].dealt = false;
		card[32].card_name = "EIGHT";
		card[32].card_type = "spade";
		card[32].card_value = 8;
		card[32].dealt = false;
		card[33].card_name = "NINE";
		card[33].card_type = "spade";
		card[33].card_value = 9;
		card[33].dealt = false;
		card[34].card_name = "TEN";
		card[34].card_type = "spade";
		card[34].card_value = 10;
		card[34].dealt = false;
		card[35].card_name = "ACE";
		card[35].card_type = "spade";
		card[35].card_value = 1;
		card[35].dealt = false;
		card[36].card_name = "JACK";
		card[36].card_type = "spade";
		card[36].card_value = 10;
		card[36].dealt = false;
		card[37].card_name = "QUEEN";
		card[37].card_type = "spade";
		card[37].card_value = 10;
		card[37].dealt = false;
		card[38].card_name = "KING";
		card[38].card_type = "spade";
		card[38].card_value = 10;
		card[38].dealt = false;

		card[39].card_name = "TWO";
		card[39].card_type = "club";
		card[39].card_value = 2;
		card[39].dealt = false;
		card[40].card_name = "THREE";
		card[40].card_type = "club";
		card[40].card_value = 3;
		card[40].dealt = false;
		card[41].card_name = "FOUR";
		card[41].card_type = "club";
		card[41].card_value = 4;
		card[41].dealt = false;
		card[42].card_name = "FIVE";
		card[42].card_type = "club";
		card[42].card_value = 5;
		card[42].dealt = false;
		card[43].card_name = "SIX";
		card[43].card_type = "club";
		card[43].card_value = 6;
		card[43].dealt = false;
		card[44].card_name = "SEVEN";
		card[44].card_type = "club";
		card[44].card_value = 7;
		card[44].dealt = false;
		card[45].card_name = "EIGHT";
		card[45].card_type = "club";
		card[45].card_value = 8;
		card[45].dealt = false;
		card[46].card_name = "NINE";
		card[46].card_type = "club";
		card[46].card_value = 9;
		card[46].dealt = false;
		card[47].card_name = "TEN";
		card[47].card_type = "club";
		card[47].card_value = 10;
		card[47].dealt = false;
		card[48].card_name = "ACE";
		card[48].card_type = "club";
		card[48].card_value = 1;
		card[48].dealt = false;
		card[49].card_name = "JACK";
		card[49].card_type = "club";
		card[49].card_value = 10;
		card[49].dealt = false;
		card[50].card_name = "QUEEN";
		card[50].card_type = "club";
		card[50].card_value = 10;
		card[50].dealt = false;
		card[51].card_name = "KING";
		card[51].card_type = "club";
		card[51].card_value = 10;
		card[51].dealt = false;
	}

	void start_game(deck card[]) {
		pFirst = new hand();
		pFirst.next = null;
		pPrev = pFirst;

		cFirst = new hand();
		cFirst.next = null;
		cPrev = cFirst;

		pBooks = new hand();
		pBooks.next = null;
		pPrevBook = pBooks;
		cBooks = new hand();
		cBooks.next = null;
		cPrevBook = cBooks;

		for (i = 0; i < 7; i++) {
			pCurrent = new hand();
			pCurrent.name = deal_card(card);
			pCurrent.next = null;
			pPrev.next = pCurrent;
			pCurrent.prev = pPrev;
			pPrev = pCurrent;

			cCurrent = new hand();
			cCurrent.name = deal_card(card);
			cCurrent.next = null;
			cPrev.next = cCurrent;
			cCurrent.prev = cPrev;
			cPrev = cCurrent;
		}

		cCurrent = cFirst.next;
		pCurrent = pFirst.next;
		System.out.println("Your Hand:");

		while (pCurrent != null) {
			System.out.print(pCurrent.name + " ");
			pCurrent = pCurrent.next;
		}
	}

	void printdeck(deck card[]) {
		// loop to print all cards
		for (i = 0; i <= 51; ++i) {
			if ((i == 13) || (i == 26) || (i == 39))
				System.out.println();
			System.out.println(
					card[i].card_name + " " + card[i].card_type + " " + card[i].card_value + " " + card[i].dealt);
		} // for loop
	}

	void fish(deck card[]) {
		Random rand = new Random();
		String ask, again = "y", added_card;
		int random;
		boolean extra = true;
		while (again.equalsIgnoreCase("y")) {
			String output ="Hello! Thanks for playing go fish! The rules will be as follows:\n";
			output = output + "We will be using one 52 card deck\n";
			output = output + "Each player will start with seven cards\n";
			output = output + "Each player will then ask for a card from the opposing player\n";
			output = output + "If the opponent has the card, they will then give all of those card to the asker\n";
			output = output + "If the opponent does not have the card they will say \"go fish\" which means you draw a card\n";
			output = output + "If you draw the card you asked for, you go again\n";
			output = output + "If at any point you have four of one number you get a book and the cards are removed from the hand\n";
			output = output + "The game ends when all the cards are used\n";
			output = output + "The winner is the one with the most books";
			JOptionPane.showMessageDialog(null, output, "Go Fish", JOptionPane.INFORMATION_MESSAGE);
			load(card);
			start_game(card);
			player_name = JOptionPane.showInputDialog(null, "Enter the player's name", "Input Data",
					JOptionPane.QUESTION_MESSAGE);
			player_name = player_name.toUpperCase();

			while (!all_delt(card)) {
				do {
					if(pFirst.next == null){
						add_card("p",card);
					}
					extra = false;
					ask = JOptionPane.showInputDialog(null,
							player_name + ", please enter the card name you would like to ask the computer for");
					ask = ask.toUpperCase();
					if (search(ask, "c")) {
						JOptionPane.showMessageDialog(null, "The computer had " + count + " " + ask + "s");
						take_cards("C", ask, count);
					}

					else {
						JOptionPane.showMessageDialog(null, "Go Fish!", "Input Data", JOptionPane.INFORMATION_MESSAGE);
						added_card = add_card("p", card);
						if (added_card.equalsIgnoreCase(ask)) {
							JOptionPane.showMessageDialog(null, "You pulled the card you asked for! You go again.");
							extra = true;
							show_hand("p");
						}
					}
					book();
				} while (extra);
				do {
					if(cFirst.next == null){
						add_card("c",card);
					}
					extra = false;
					random = number_in_hand("c");
					random = rand.nextInt(random) + 1;
					cCurrent = cFirst.next;
					for (i = 1; i < random; i++) {
						cCurrent = cCurrent.next;
					}
					ask = cCurrent.name;
					JOptionPane.showMessageDialog(null, "The computer would like all your: " + ask + "s", "Input Data",
							JOptionPane.INFORMATION_MESSAGE);
					if (search(ask, "p")) {
						take_cards("P", ask, count);
					} else {
						added_card = add_card("c", card);
						if (added_card.equalsIgnoreCase(ask)) {
							JOptionPane.showMessageDialog(null,
									"The computer gets to go again because it drew the card it asked for");
							extra = true;
						}
					}
					book();
					show_hand("P");
				} while (extra);
			}
			JOptionPane.showMessageDialog(null, "The deck has run out!");
			
			while(pFirst.next!=null && cFirst.next != null){
				ask = JOptionPane.showInputDialog(null,
						player_name + ", please enter the card name you would like to ask the computer for");
				ask = ask.toUpperCase();
				if (search(ask, "c")) {
					JOptionPane.showMessageDialog(null, "The computer had " + count + " " + ask + "s");
					take_cards("C", ask, count);
				}
				book();
				random = number_in_hand("c");
				random = rand.nextInt(random) + 1;
				cCurrent = cFirst.next;
				for (i = 1; i < random; i++) {
					cCurrent = cCurrent.next;
				}
				ask = cCurrent.name;
				JOptionPane.showMessageDialog(null, "The computer would like all your: " + ask + "s", "Input Data",
						JOptionPane.INFORMATION_MESSAGE);
				if (search(ask, "p")) {
					take_cards("P", ask, count);
				} 
				book();
			}
			end_game();
			again = JOptionPane.showInputDialog("Would you like to play again? (Y/N)");
		}
	}// end of go fish

	boolean search(String name, String player) {
		boolean found = false;
		count = 0;
		if (player.equalsIgnoreCase("C")) {
			cCurrent = cFirst.next;
			while (cCurrent != null) {
				if (cCurrent.name.equalsIgnoreCase(name)) {
					found = true;
					count++;
				}
				cCurrent = cCurrent.next;
			}
		} else {
			pCurrent = pFirst.next;
			while (pCurrent != null) {
				if (pCurrent.name.equalsIgnoreCase(name)) {
					found = true;
					count++;
				}
				pCurrent = pCurrent.next;
			}
		}
		return found;
	}

	void show_hand(String player) {
		String output;
		if (player.equalsIgnoreCase("P")) {
			output = "\nYour hand:\n";
			pCurrent = pFirst.next;
			while (pCurrent != null) {
				output = output + pCurrent.name + " ";
				pCurrent = pCurrent.next;
			}
			System.out.println(output);
		}
		if (player.equalsIgnoreCase("C")) {
			output = "\nComputer hand:\n";
			cCurrent = cFirst.next;
			while (cCurrent != null) {
				output = output + cCurrent.name + " ";
				cCurrent = cCurrent.next;
			}
			System.out.println(output);
		}
	}

	void take_cards(String player, String card, int number) {
		if (player.equalsIgnoreCase("C")) {
			for (i = 1; i <= number; i++) {
				pCurrent = new hand();
				pCurrent.next = null;
				pCurrent.name = card;
				pCurrent.prev = pPrev;
				pPrev.next = pCurrent;
				pPrev = pCurrent;
			}
			cCurrent = cFirst.next;
			while (cCurrent != null) {
				if (cCurrent.name.equalsIgnoreCase(card)) {
					if (cCurrent.next != null) {
						Next = cCurrent.next;
						Prev = cCurrent.prev;
						Prev.next = cCurrent.next;
						Next.prev = cCurrent.prev;
					} else if (cCurrent.next == null) {
						Prev = cCurrent.prev;
						cPrev = Prev;
						Prev.next = null;
					}
				}
				cCurrent = cCurrent.next;
			}

		} else {

			for (i = 1; i <= number; i++) {
				cCurrent = new hand();
				cCurrent.next = null;
				cCurrent.name = card;
				cCurrent.prev = cPrev;
				cPrev.next = cCurrent;
				cPrev = cCurrent;
			}

			pCurrent = pFirst.next;
			while (pCurrent.next != null) {
				if (pCurrent.name.equalsIgnoreCase(card)) {
					if (pCurrent.next != null) {
						Next = pCurrent.next;
						Prev = pCurrent.prev;
						Prev.next = pCurrent.next;
						Next.prev = pCurrent.prev;
					} else if (pCurrent.next == null) {
						pPrev = pCurrent.prev;
						pPrev.next = null;
					}
				}
				pCurrent = pCurrent.next;
			}

		}
	}

	String deal_card(deck card[]) {
		double num;
		card_flag = 0;
		while (card_flag != 1) {
			num = ((Math.random() * 51));
			deck_position = (int) Math.round(num);
			if (!card[deck_position].dealt) {
				card[deck_position].dealt = true;
				card_flag = 1;
			}
		}
		// show the card generated:
		card_count = card_count + 1;
		return card[deck_position].card_name;
	}

	boolean all_delt(deck card[]) {
		boolean out = true;
		for (i = 0; i <= 51; i++) {
			if (!card[i].dealt) {
				out = false;
				break;
			}
		}
		return out;
	}

	String add_card(String player, deck card[]) {
		String name;
		if (player.equalsIgnoreCase("P")) {
			pCurrent = new hand();
			pCurrent.name = deal_card(card);
			name = pCurrent.name;
			pCurrent.next = null;
			pPrev.next = pCurrent;
			pCurrent.prev = pPrev;
			pPrev = pCurrent;

		} else {
			cCurrent = new hand();
			cCurrent.name = deal_card(card);
			name = cCurrent.name;
			cCurrent.next = null;
			cPrev.next = cCurrent;
			cCurrent.prev = cPrev;
			cPrev = cCurrent;
		}
		return name;
	}

	int number_in_hand(String player) {
		int num = 0;
		pCurrent = pFirst.next;
		cCurrent = cFirst.next;
		if (player.equalsIgnoreCase("P")) {
			while (pCurrent != null) {
				num++;
				pCurrent = pCurrent.next;
			}

		} else {
			while (cCurrent != null) {
				num++;
				cCurrent = cCurrent.next;
			}
		}
		return num;
	}

	void book() {
		int num;
		String card_name;
		check = pFirst.next;
		while (check != null) {
			card_name = check.name;
			num = 0;
			pCurrent = pFirst.next;
			while (pCurrent != null) {
				if (pCurrent.name.equalsIgnoreCase(card_name)) {
					num++;
					if (num >= 4) {
						JOptionPane.showMessageDialog(null, "Congrats! You have a book.");
						currentBook = new hand();
						currentBook.next = null;
						pPrevBook.next = currentBook;
						pPrevBook = currentBook;

						save = pCurrent;
						pCurrent = pFirst.next;
						while (pCurrent != null) {
							if (pCurrent.name.equalsIgnoreCase(save.name)) {
								if (pCurrent.next != null) {
									Next = pCurrent.next;
									Prev = pCurrent.prev;
									Prev.next = Next;
									Next.prev = Prev;
								} else {
									pPrev = pCurrent.prev;
									pPrev.next = null;
								}
							}
							pCurrent = pCurrent.next;

						}
						pCurrent = save;
					}
				}
				pCurrent = pCurrent.next;
			}
			check = check.next;
		}

		check = cFirst.next;
		while (check != null) {
			card_name = check.name;
			cCurrent = cFirst.next;
			num=0;
			while (cCurrent != null) {
				if (cCurrent.name.equalsIgnoreCase(card_name)) {
					num++;
					if (num >= 4) {
						JOptionPane.showMessageDialog(null, "The computer got a book!");
						currentBook = new hand();
						currentBook.next = null;
						cPrevBook.next = currentBook;
						cPrevBook = currentBook;

						save = cCurrent;
						cCurrent = cFirst.next;
						while (cCurrent != null) {
							if (cCurrent.name.equalsIgnoreCase(save.name)) {
								if (cCurrent.next != null) {
									Next = cCurrent.next;
									Prev = cCurrent.prev;
									Prev.next = Next;
									Next.prev = Prev;
								} else {
									cPrev = cCurrent.prev;
									cPrev.next = null;
								}
							}
							cCurrent = cCurrent.next;
						}
						cCurrent = save;
					}
				}
				cCurrent = cCurrent.next;
			}
			check = check.next;
		}

	}

	void end_game() {
		int pPoints = 0, cPoints = 0;
		currentBook = pBooks;
		while (currentBook != null) {
			pPoints++;
			currentBook = currentBook.next;
		}
		currentBook = cBooks;
		while (currentBook != null) {
			cPoints++;
			currentBook = currentBook.next;
		}
		if (pPoints > cPoints) {
			JOptionPane.showMessageDialog(null,
					"You win with " + pPoints + " books.\nThe computer lost with " + cPoints + " books.");
		} else if (cPoints > pPoints) {
			JOptionPane.showMessageDialog(null,
					"The computer wins with " + cPoints + " books.\nYou lost with " + pPoints + " books.");
		} else {
			JOptionPane.showMessageDialog(null, "You tied with the computer. You both had " + pPoints + " books.");
		}
	}
}// end of game_play

class hand {
	String name;
	int value;
	boolean book;
	boolean trade;
	hand next;
	hand prev;
}

class deck extends hand {
	String card_name;
	String card_type;
	int card_value;
	boolean dealt;
}