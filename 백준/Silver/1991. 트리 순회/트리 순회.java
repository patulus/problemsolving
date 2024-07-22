import java.util.Scanner;

class TreeNode {
    public char data;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    
    public TreeNode(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public TreeNode(char data, TreeNode left) {
        this.data = data;
        this.left = left;
        this.right = null;
    }
    
    public TreeNode(char data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    public void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data);
            inorder(node.right);
        }
    }
    
    public void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        TreeNode[] ns = new TreeNode[26];
        
        for (int i = 0; i < 26; i++) {
            TreeNode temp = new TreeNode();
            ns[i] = temp;
        }
        
        int cnt = sc.nextInt();
        
        sc.nextLine();
        
        for (int i = 0; i < cnt; i++) {
            String userin = sc.nextLine();
            String[] input = userin.trim().split(" ");
            
            ns[input[0].charAt(0) - 'A'].data = input[0].charAt(0);
            
            if (input[1].equals(".")) {
                ns[input[0].charAt(0) - 'A'].left = null;
            }
            else {
                ns[input[0].charAt(0) - 'A'].left = ns[input[1].charAt(0) - 'A'];
            }
            
            if (input[2].equals(".")) {
                ns[input[0].charAt(0) - 'A'].right = null;
            }
            else {
                ns[input[0].charAt(0) - 'A'].right = ns[input[2].charAt(0) - 'A'];
            }
        }
        
        bt.preorder(ns[0]);
        System.out.println();
        bt.inorder(ns[0]);
        System.out.println();
        bt.postorder(ns[0]);
        System.out.println();
    }
}
