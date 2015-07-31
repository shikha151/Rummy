package rummygame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;

public class Utility {
	public static String piecewiseSort(String cardHand) {
		String sortedCardHand = "";
		String[] cardList = cardHand.split("\\|");
		Arrays.sort(cardList);
		for (String card : cardList) {
			sortedCardHand += card + "|";
		}
		return sortedCardHand;

	}

	public static boolean sanityCheck(String cardHand) {
		boolean sanityCheck = true;
		cardHand = piecewiseSort(cardHand);
		String[] cardList = cardHand.split("\\|");
		String prevCard = null;
		int maxSameCard = 3;
		for (String card : cardList) {
			if (prevCard == null) {
				prevCard = card;
				continue;
			}
			if (card.equals(prevCard)) {
				maxSameCard--;
				if (maxSameCard == 0) {
					sanityCheck = false;
					break;
				}
			} else {
				maxSameCard = 3;
			}
			prevCard = card;
		}
		return sanityCheck;
	}

	public static void main(String[] args) {
		TreeMap<String, Integer> groupOf3 = new TreeMap<String, Integer>();
		TreeMap<String, Integer> groupOf4 = new TreeMap<String, Integer>();
		TreeMap<String, Integer> validRummyDeclares = new TreeMap<String, Integer>();
		for (Map.Entry<String, Integer> i : groupOf4.entrySet()) {
			for (Map.Entry<String, Integer> j : groupOf3.entrySet()) {
				for (Map.Entry<String, Integer> k : groupOf3.entrySet()) {
					for (Map.Entry<String, Integer> l : groupOf3.entrySet()) {
						String hopefulDeclare = i.getKey() + j.getKey() + k.getKey() + l.getKey();
						if (sanityCheck(hopefulDeclare))
						{
							
						}
					}
				}
			}
		}
	}

}
