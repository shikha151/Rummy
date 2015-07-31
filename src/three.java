import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by test on 7/30/2015.
 */


public class three {
    String suites = "SHCD";
    String rank = "123456789TJQK";
    TreeMap<String, Integer> naturalSequencesOfLengthThree = new TreeMap<String, Integer>();
final int CARDSINSUITE = 13;
    public String addLeadingZero(int i) {
        String withLeadingZero = "00" + String.valueOf(i);
        return withLeadingZero.substring(withLeadingZero.length() - 2);
    }

    public void generateNaturalSequencesOfLengthThree(int i){
        int j = i+1;
        String sequence;
        if (j % 13 == 0) {
            int addNumber = i+2-CARDSINSUITE;
            sequence = addLeadingZero(addNumber) + "|" +addLeadingZero(i) + "|" +addLeadingZero(i + 1) + "|";
        } else if (i % 13 == 0) {
            return;
        } else {
            sequence = addLeadingZero(i) + "|" + addLeadingZero(i + 1) + "|" +addLeadingZero(i + 2) + "|";
        }
        naturalSequencesOfLengthThree.put(sequence, 3);
    }
    public void generateNaturalSequencesOfLengthFour(int i){
        String sequence;
        if((i+2)%13==0){
            //JQKA
            int addNumber = i+3-CARDSINSUITE;
            sequence = addLeadingZero(addNumber) + "|" +addLeadingZero(i) + "|" +addLeadingZero(i + 1) + "|"+addLeadingZero(i + 2) + "|";
        }else if((i+1)%13==0){
            //QKA
           return;

        }else if(i%13==0){
            return;
            //K
        }else{
            //regular insertion
            sequence = addLeadingZero(i) + "|" +addLeadingZero(i+1) + "|" +addLeadingZero(i + 2) + "|"+addLeadingZero(i + 3)+"|";
        }
        naturalSequencesOfLengthThree.put(sequence, 3);
    }
    public void generateNaturalSequencesOfLengthFive(int i){
        String sequence;
        if((i+3)%13==0){
            //10JQKA
            int addNumber = i+4-CARDSINSUITE;
            sequence = addLeadingZero(addNumber) + "|" +addLeadingZero(i) + "|" +addLeadingZero(i + 1) + "|"+addLeadingZero(i + 2) + "|"+addLeadingZero(i + 3) + "|";
        }else if((i+2)%13==0){
            //JQKA
            return;

        }else if((i+1)%13==0){
            //QKA
            return;

        }else if(i%13==0){
            //K
            return;

        }else{
            //regular insertion
            sequence = addLeadingZero(i) + "|" +addLeadingZero(i+1) + "|" +addLeadingZero(i + 2) + "|"+addLeadingZero(i + 3)+"|"+addLeadingZero(i + 4)+"|";
        }
        naturalSequencesOfLengthThree.put(sequence, 3);
    }

    public static void main(String args[]) {
        three threeOne = new three();

        for (int i = 1; i <= 52; i++) {

            threeOne.generateNaturalSequencesOfLengthThree(i);
            threeOne.generateNaturalSequencesOfLengthFour(i);
            threeOne.generateNaturalSequencesOfLengthFive(i);

        }


        System.out.println(threeOne.naturalSequencesOfLengthThree);
    }
}
