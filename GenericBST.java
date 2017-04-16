package Arushee_Algos;

public class GenericBST<T extends Comparable<T>> {

    Node<T> root;

    public GenericBST(){
        root = null;
    }

    public Node Insert(Node root,T data){

        if(root == null){
            root = new Node<T>(data);
            return root;
        }
        if(data.compareTo((T) root.data) <= 0){root.left = Insert(root.left,data);
        }
        else if(data.compareTo((T) root.data) > 0){root.right = Insert(root.right, data);
        }
        return root;
    }

    public void InorderWalk(Node<T> root){

        if(root != null){
            InorderWalk(root.left);
            System.out.print(root.data + " ");
            InorderWalk(root.right);
        }
    }

    public Node findMax(Node<T> root){
        if(root.right != null)
            root = root.right;
        return root;
    }

    public Node Delete(T value,Node<T> root)
    {
        //delete
        if (Is_Search(root,value)== true) {

            if (value.compareTo((T) root.data) < 0) root.left = Delete(value, root.left);
            else if (value.compareTo((T) root.data) > 0) root.right = Delete(value, root.right);
            else {
                if (root.right == null && root.left == null)
                    return null;
                if (root.right == null)
                    return root.left;
                if (root.left == null)
                    return root.right;

                Node<T> successor = findMax(root.left);
                T data = successor.data;
                Delete(data, root.left);
                root.data = data;
            }
        }
        else if(root==null)
        {
            System.out.println("the value " + value + " is not found");
            return null;
        }
        else System.out.println("the value " + value + " is not found");
        return root;
    }

    public boolean Is_Search(Node<T> root, T key){

        if(root != null){
            if(key.compareTo((T) root.data) == 0)
                return true;
            if(key.compareTo((T) root.data) <= 0)
                return Is_Search(root.left, key);
            else return Is_Search(root.right, key);
        }
        return false;
    }


    public int findHeight(Node<T> aNode) {
        if (aNode == null) {
            return -1;
        }

        int lefth = findHeight(aNode.left);
        int righth = findHeight(aNode.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    public static void main(String[] args){

        //int array_size = (int)(Math.random()*3);
        int array_size = 3;
        InputArray array = new InputArray(array_size);
        System.out.println(array.ToString());

        GenericBST<Integer> bt = new GenericBST<Integer>();

        //Testing InsertBST.root,
        for(int i = 0 ; i < array_size; i++){
            bt.root = bt.Insert(bt.root, array.array[i]);
        }

        //Testing InorderWalk
        bt.InorderWalk(bt.root);

        //Testing InSearch
        System.out.println();
        System.out.println(array.array[0] + " is found in BST : " + bt.Is_Search(bt.root,array.array[0]));

        //Testing Delete
        System.out.println("deleting " + array.array[0] + " from BST");
        bt.root = bt.Delete(array.array[0],bt.root);
        System.out.println();
        bt.InorderWalk(bt.root);
        System.out.println();

        //Testing HeightofTree
        int h = bt.findHeight(bt.root);
        System.out.println("Height of BST tree is " + h);
    }
}

