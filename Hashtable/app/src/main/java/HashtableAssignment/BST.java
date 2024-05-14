package HashtableAssignment;

/**
 *
 * @author juneja_u
 */
public class BST {
    private Node root;

     public BST(){
         root = null;
     }
    public boolean isEmpty(){
        return root == null;
    }
    public Node search(int item){
        Node curr = root;
        while(curr.data != item){
            if(curr.data < item)
                curr = curr.rightChild;
            else
                curr = curr.leftChild;
            if(curr == null)
                return null;
        }
        //found it
        return curr;
    }
    public void insert(int item){
        Node n = new Node(item);
        if(isEmpty())
            root = n;
        else{
            Node prev =root;
            Node curr = root;
            boolean isLeft = true;
            while(curr != null){
                prev = curr;
                if(item < curr.data){
                    curr = curr.leftChild;
                    isLeft = true;
                }
                 else {
                    curr = curr.rightChild;
                    isLeft = false;
                }

            }
            if(isLeft)
                prev.leftChild = n;
            else
                prev.rightChild = n;

        }
    }
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node r){
        if(r != null){
            inorder(r.leftChild);
            System.out.print(r + " ");
            inorder(r.rightChild);
        }

    }
    public void preorder(){
        preorder(root);
    }
    private void preorder(Node r){
        if(r != null){
        System.out.println(r);
        preorder(r.leftChild);
        preorder(r.rightChild);
        }
    }
    public void postorder(){
        postorder(root);
    }
    private void postorder(Node r){
        if(r != null){
        postorder(r.leftChild);
        postorder(r.rightChild);
        System.out.println(r);
        }
    }
    public int min(){
        Node curr = root;
        while(curr.leftChild != null){
            curr = curr.leftChild;
        }
        return curr.data;
    }
    public boolean delete(int item){
       Node curr = root;
       Node prev = root;

        boolean isLeft = true;

        while (curr.data != item) {//find the item to delete
            prev = curr;
            if (item < curr.data) {
                curr = curr.leftChild;
                isLeft = true;
            } else {
                curr = curr.rightChild;
                isLeft = false;
            }
            if(curr == null)//not found
                return false;
        }
        //found it , now delete
        if(curr.leftChild == null && curr.rightChild == null){
            if(curr == root)
                root = null;
            else if(isLeft)
                prev.leftChild = null;
            else
                prev.rightChild = null;
        }
        else if (curr.leftChild == null) {
            if (curr == root) {
                root = curr.rightChild;
            } else if (isLeft) {
                prev.leftChild = curr.rightChild;
            } else {
                prev.rightChild = curr.rightChild;
            }
        }
        else if(curr.rightChild == null){
            if (curr == root) {
                root = curr.leftChild;
            } else if (isLeft) {
                prev.leftChild = curr.leftChild;
            } else {
                prev.rightChild = curr.leftChild;
            }
        }
        else{
            //get successor of the curr node
            Node successor = getSuccessor(curr);
            if(curr == root)
                root = successor;
            else if(isLeft)
                prev.leftChild = successor;
            else
                prev.rightChild = successor;
            successor.leftChild = curr.leftChild;
        }
        return true;
    }
   private Node getSuccessor(Node del){
       Node curr = del.rightChild;
       Node prev = del;
       while(curr.leftChild != null){
           prev = curr;
           curr = curr.leftChild;
       }
       if(curr != del.rightChild){
           prev.leftChild = curr.rightChild;
       }
       return curr;
   }
}

