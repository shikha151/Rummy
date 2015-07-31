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
	
	public static int getdifference (String str1,String  str2)
        {
            String[] card1 = str1.split("\\|");
            String[] card2 = str2.split("\\|");
            
            int [] intcards1 = new int[card1.length];
            int [] intcards2 = new int[card2.length];
            
            for( int i=0;i<13;i++)
            {
                intcards1[i] = Integer.parseInt(card1[i]);
                intcards2[i] = Integer.parseInt(card2[i]);
            }
            
            Arrays.sort(intcards1);
            Arrays.sort(intcards2);
            
           int a=0,b=0,count=0;
           while(a<13&&b<13)
           {
               if(intcards1[a]>intcards2[b])
                   b++;
               else if(intcards1[a]<intcards2[b])
                   a++;
               else
               {
                   a++;
                   b++;
                   count++;
               }
               
           }
           
            return 13-count;
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
		Groups group = new Groups();
		TreeMap<String, Integer> groupOf3 = group.getGrouplength3();
		TreeMap<String, Integer> groupOf4 = group.getGrouplength4();
		TreeMap<String, Integer> groupOf5 = group.getGrouplength5();
		
		String  input = "05|24|41|20|24|07|29|38|42|28|22|37|16|";
		input = piecewiseSort(input);
		int minCardsToDeclare = 11;
		for (Map.Entry<String, Integer> i : groupOf4.entrySet()) {
			for (Map.Entry<String, Integer> j : groupOf3.entrySet()) {
				for (Map.Entry<String, Integer> k : groupOf3.entrySet()) {
					for (Map.Entry<String, Integer> l : groupOf3.entrySet()) {
						String hopefulDeclare = i.getKey() + j.getKey()
								+ k.getKey() + l.getKey();
						if (sanityCheck(hopefulDeclare)) {
							int numOfSeq = 0;
							if (i.getValue() >= 3) {
								numOfSeq++;
							}
							if (j.getValue() >= 3) {
								numOfSeq++;
							}
							if (k.getValue() >= 3) {
								numOfSeq++;
							}
							if (l.getValue() >= 3) {
								numOfSeq++;
							}
							if (numOfSeq >= 2) {
								String sortedHopefulDeclare = piecewiseSort(hopefulDeclare);
								if(minCardsToDeclare > getDifference(input,sortedHopefulDeclare))
								{
									minCardsToDeclare = getDifference(input,sortedHopefulDeclare);
								}
							}
						}
					}
				}
			}
		}
	
	}

}
