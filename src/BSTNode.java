import java.util.LinkedList;
import java.util.Queue;

public class BSTNode {
        int value;
        BSTNode leftChild;
        BSTNode rightChild;

        BSTNode(int val)
        {
            this.value = val;
            this.leftChild = null;
            this.rightChild = null;
        }

    public static BSTNode insert(int value, BSTNode current) {
        if (current == null) {
            return new BSTNode(value);
        } else {
            if (value < current.value)
                current.leftChild = insert(value, current.leftChild);
            else
                current.rightChild = insert(value, current.rightChild);
        }
        return current;
    }

    public static BSTNode delete(int value, BSTNode current) {
        if (current == null)
            return null;
        if (value < current.value)
            current.leftChild = delete(value, current.leftChild);
        else if (value > current.value)
            current.rightChild = delete(value, current.rightChild);
        else {
            if (current.leftChild != null && current.rightChild != null) {
                int min = current.rightChild.value;
                BSTNode temp = current.rightChild;
                while (temp.leftChild != null) {
                    min = temp.leftChild.value;
                    temp = temp.leftChild;
                }
                current.value = min;
                current.rightChild = delete(min, current.rightChild);
            } else if (current.leftChild == null)
                return current.rightChild;
            else return current.leftChild;
        }
        return current;
    }

    public static void preorder(BSTNode current)
    {
        if(current == null) {
        }
        else
        {
            System.out.print(current.value + " ");
            preorder(current.leftChild);
            preorder(current.rightChild);
        }
    }

    public static void postorder(BSTNode current)
    {
        if(current == null) {
        }
        else
        {
            postorder(current.leftChild);
            postorder(current.rightChild);
            System.out.print(current.value + " ");
        }
    }

    public static void inorder(BSTNode current)
    {
        if(current == null) {
        }
        else
        {
            inorder(current.leftChild);
            System.out.print(current.value + " ");
            inorder(current.rightChild);
        }
    }

    public static void levelOrder(BSTNode current)
    {
        if(current == null)
            return;
        Queue<BSTNode> q = new LinkedList<>();
        q.add(current);
        while(!q.isEmpty())
        {
            BSTNode temp = q.remove();
            System.out.print(temp.value + " ");

            if(temp.leftChild != null)
                q.add(temp.leftChild);
            if(temp.rightChild != null)
                q.add(temp.rightChild);
        }
    }

    public static void main(String[] args) {
        //Inserting nodes
        BSTNode root = new BSTNode(12);
        root = insert(7, root);
        root = insert(20, root);
        root = insert(5, root);
        root = insert(9, root);
        root = insert(21, root);

        //Traversals
        System.out.println("Memasukkan nodes");
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.print("\nPostorder Traversal: ");
        postorder(root);
        System.out.print("\nInorder Traversal: ");
        inorder(root);
        System.out.print("\nLevel Order Traversal: ");
        levelOrder(root);

        //Deleting nodes
        root = delete(12, root);
        root = delete(9, root);

        //Traversals
        System.out.println("\n\n--------------------");
        System.out.println("Setelah menghapus nodes");
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.print("\nPostorder Traversal: ");
        postorder(root);
        System.out.print("\nInorder Traversal: ");
        inorder(root);
        System.out.print("\nLevel Order Traversal: ");
        levelOrder(root);
    }
}

