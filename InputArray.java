package Arushee_Algos;

public class InputArray{

    int array_size ;
    int[] array;

    public InputArray(int size){

        this.array_size = size;
        this.array = new int[array_size];
        for(int i = 0 ; i < array_size; i++){
            array[i] = (int)(Math.random()*100);
        }
    }
    public InputArray(int size, int range){

        this.array_size = size;
        this.array = new int[array_size];
        for(int i = 0 ; i < array_size; i++){
            array[i] = (int)(Math.random()*range + 1);
        }
    }
    //
    public int ArrayLength(InputArray array){
        return array.array_size;
    }
    //
    public String ToString(){
        String s = "";
        s += "[";
        for(int i = 0 ; i < array_size; i++){
            s += array[i] + " , ";
        }
        s+= "]";

        return s;
    }
}
