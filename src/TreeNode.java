public class TreeNode<E> {

    public E val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(E val, TreeNode left ,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;

    }

    TreeNode(E val){
        this.val = val;
    }


}
