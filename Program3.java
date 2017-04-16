package Arushee_Algos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arushee on 4/16/17.
 */
public class Program3 {

    public static void main(String[] args) throws IOException, FileNotFoundException{

        //a). Reading the text file into an array using generate() method
        ArrayList<String> lines = generate("/Users/Arushee/Desktop/Algorithms/Arushee_Algos/ThingsMachineLearning.txt");
        //Print out number of words
        System.out.println("***The number of words are " + lines.size());

        //b). Storing only the unique words
        Set<String> uniqueWords = new HashSet<String>();
        for (String word : lines) {
            uniqueWords.add(word);
            System.out.print(word+" ");
        }
        System.out.println();
        //Print out the number of unique words
        System.out.println("***The number of unique words are " + uniqueWords.size());

        //c). Making a BST out of the unique words
        GenericBST<String> bt = new GenericBST<String>();
        for (String unique_word : uniqueWords) {
            bt.root = bt.Insert(bt.root, unique_word);
        }
        bt.InorderWalk(bt.root);
        System.out.println();
        //d). Finding out the Height of the BST formed

        int h = bt.findHeight(bt.root);
        System.out.println("***Height of BST tree is " + h);

    }

    public static ArrayList<String> generate(String filename) throws IOException, FileNotFoundException{

        //a). Reading the text file into an array while removing punctuations and making it case insensitive
        BufferedReader in = new BufferedReader(new FileReader(filename));

        String str;
        ArrayList<String> lines = new ArrayList<String>();

        while ((str = in.readLine()) != null) {
            String[] arr = str.replaceAll("[^a-zA-Z ]", "").toLowerCase().replaceAll("\\s+", " ").split(" ");
            for (String word : arr) {
                lines.add(word);
            }
        }
        in.close();
        return lines;
    }
}
