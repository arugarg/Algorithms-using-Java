package Arushee_Algos;

public class Program1 {

    public static void main(String[] args){

        //Part 1. Inserting Randomn array into BST and then doing random deletions
        //a). creating a random array
        int array_size = (int)(Math.random()*10);
        InputArray array = new InputArray(array_size);
        System.out.println("array_size is "+ array.array_size);
        System.out.println("the array is");
        System.out.println(array.ToString());

        //b). inserting the array into BST
        GenericBST<Integer> bt = new GenericBST<Integer>();
        for(int i = 0 ; i < array_size; i++){
            bt.root = bt.Insert(bt.root, array.array[i]);
        }

        //c). Doing Inorder Walk for BST
        System.out.println("Inorder walk for BST");
        bt.InorderWalk(bt.root);
        System.out.println();


        //d). Random Deletion
        int number_of_deletions = (int)(Math.random()*10);
        int[] deletion = new int[number_of_deletions];
        for(int j = 0; j < number_of_deletions ; j++){
            deletion[j] = array.array[(int)(Math.random()*array_size)];
        }
        System.out.println("deletion array_size is "+ number_of_deletions);
        System.out.println("the deletion array is");
        for(int j = 0; j < number_of_deletions ; j++) {
            System.out.print(deletion[j] + " ");
        }
        System.out.println();
        //deleting from BST
        for(int i = 0; i < number_of_deletions; i++){
            bt.root = bt.Delete(deletion[i],bt.root);
        }

        //Doing Inorder Walk for BST after Deletion
        System.out.println("Inorder walk after the deletions array is");
        System.out.println();
        bt.InorderWalk(bt.root);

    }
}
