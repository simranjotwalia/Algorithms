package algorithms.playground.tree;
import java.util.*;

class PostOrderIterator{

    public void iterate(BinaryTreeNode root){
        BinaryTreeNode current = root;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        while (!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                BinaryTreeNode temp = stack.peek().right;
                if(temp != null){
                    current = temp;
                }else{
                    BinaryTreeNode popped = stack.pop();
                    System.out.println(popped.data);
                    while(!stack.isEmpty() && stack.peek().right == popped){
                        popped = stack.pop();
                        System.out.println(popped.data);
                    }
                }
            }
        }
    }
}
public class PostOrderIteration {
    public static void main(String nodes[]){

        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode l1 = new BinaryTreeNode(2);
        BinaryTreeNode r1 = new BinaryTreeNode(3);
        root.setLeft(l1);
        root.setRight(r1);

        BinaryTreeNode l2 = new BinaryTreeNode(4);
        BinaryTreeNode r2 = new BinaryTreeNode(5);
        BinaryTreeNode l3 = new BinaryTreeNode(6);
        BinaryTreeNode r3 = new BinaryTreeNode(7);

        l1.setLeft(l2);
        l1.setRight(r2);

        r1.setLeft(l3);
        r1.setRight(r3);

        PostOrderIterator i = new PostOrderIterator();
        i.iterate(root);

    }
}
