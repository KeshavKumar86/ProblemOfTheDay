package year2025.february;

public class ConstructTreeFromInorderAndPreorder {
    public static void main(String[] args) {

    }

    public static Node buildTree(int[] inorder, int[] preorder) {

        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new Node(inorder[0]);
        }
        int iindex = 0, pindex = 0;
        int mid;
        for (mid = 0; mid < inorder.length; mid++) {
            if (preorder[pindex] == inorder[mid]) {
                iindex = mid;
                break;
            }
        }
        Node node = new Node(inorder[iindex]);
        int[] linorder = new int[mid];
        int[] lpreorder = new int[mid];
        int[] rinorder = new int[inorder.length - mid - 1];
        int[] rpreorder = new int[inorder.length - mid - 1];

        System.arraycopy(inorder, 0, linorder, 0, mid);
        System.arraycopy(preorder, 1, lpreorder, 0, mid);
        System.arraycopy(inorder, mid + 1, rinorder, 0, inorder.length - mid - 1);
        System.arraycopy(preorder, mid + 1, rpreorder, 0, inorder.length - mid - 1);

        node.left = buildTree(linorder, lpreorder);
        node.right = buildTree(rinorder, rpreorder);
        return node;
    }
}
