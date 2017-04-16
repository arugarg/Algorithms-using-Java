package Arushee_Algos;

/**
 * Created by Arushee on 4/16/17.
 */
public class Program2 {

    public static void main(String[] args){

        //Part 2. Running the loop 1000 times where input is an array with numbers from 1 to 2^14

        int sum_of_height = 0;
        int h_min = 0;
        int h_max = 0;
        for(int j = 0; j < 1000; j++) {
            //a). creating a random array of max size 100
            int array_size = (int) (Math.random() * 100);
            InputArray array = new InputArray(array_size, 16383);
            //System.out.println("array_size is "+ array.array_size);
            //System.out.println("the array is");
            //System.out.println(array.ToString());

            //b). inserting the array into BST
            GenericBST<Integer> bt = new GenericBST<Integer>();
            for (int i = 0; i < array_size; i++) {
                bt.root = bt.Insert(bt.root, array.array[i]);
            }
            //bt.InorderWalk(bt.root);

            //c). Finding Height of BST
            int h = bt.findHeight(bt.root);
            //System.out.println("Height of BST tree is " + h);
            sum_of_height += h;
            if(h > h_max) h_max = h;
            if(h< h_min) h_min = h;
        }
        int h_avg = sum_of_height/1000;
        System.out.println("The min Height is " + h_min);
        System.out.println("The max Height is " + h_max);
        System.out.println("The average Height is " + h_avg);

    }
}
