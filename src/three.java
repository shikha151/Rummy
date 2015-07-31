import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by test on 7/30/2015.
 */



public class Three {
    String suites = "SHCD";
    String rank = "123456789TJQK";

    public static void main(String args[]) {
        HashMap<String,Integer> naturalSequencesOfLengthThree = new HashMap<String,Integer>();
        for(int i=1;i<=50;i++){
            String sequence = String.valueOf(i)+"|"+String.valueOf(i+1)+"|"+String.valueOf(i+2);
            naturalSequencesOfLengthThree.put(sequence, 3);
        }



        System.out.println(naturalSequencesOfLengthThree);
    }
}
