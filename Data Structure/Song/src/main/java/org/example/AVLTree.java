package org.example;
public class AVLTree<Item> {
    AVLNode<Item> root;public AVLTree() {
        root = null;
    }
    public int height(AVLNode<Item> d) {
        if (d == null) {
            return 0;
        } else {
            return d.height;
        }
    }


    boolean isBalanced(AVLNode node)
    {
        int lh;

        int rh;


        if (node == null)
            return true;


        lh = height(node.left);
        rh = height(node.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        return false;
    }
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.print(System.lineSeparator());
        }
    }
    void printGivenLevel(AVLNode root, int level)
    {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
        }
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
    public void inOrder(AVLNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf("%s ", node.data);
        inOrder(node.right);
    }

    public void traverseInOrder(AVLNode focus){

        if(focus.left != null)

            traverseInOrder(focus.left);

        System.out.println(focus);

        if(focus.right != null)

            traverseInOrder(focus.right);

    }

    public void postOrder(AVLNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.printf("%s ", node.data);
    }

    public void traversePostOrder(AVLNode node)
    {
        if (node == null)
            return;
        traversePostOrder(node.left);

        traversePostOrder(node.right);
        System.out.println(node+ " ");
    }
    public void traversePostOrder() {

        traversePostOrder(root);
    }
    public AVLNode SearchRecursive(AVLNode focus, int key){
        if (focus == null)
            return null;
        if(focus.key == key)
            return focus;
        else if (key<focus.key)
            return SearchRecursive(focus.left,key);
        else
            return SearchRecursive(focus.right,key);

    }
    public AVLNode<Item> find(int key) {
        AVLNode current = root;
        while (current!=null){
            if (current.key==key){
                break;
            }
            if( current.key < key){
                current=current.right;
            }
            else{
                current= current.left;
            }
        }return current;
    }

    AVLNode insertion(AVLNode node, Item data,int key) {

        if (node == null)
            return (new AVLNode(data,key));

        if (key < node.key)
            node.left = insertion(node.left, data,key);
        else if (key > node.key)
            node.right = insertion(node.right,data,key);
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = getBalanced(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;}
    int max(int a, int b) {
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }

    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }


    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalanced(AVLNode<Item> N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }


    public AVLNode<Item> rotateMyLeft(AVLNode<Item> focus) {
        AVLNode<Item> k = focus.left;
        focus.left = k.right;
        k.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }


    public AVLNode<Item> rotateMyRight(AVLNode<Item> focus) {
        AVLNode<Item> k = focus.right;
        focus.right = k.left;
        k.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode<Item> doubleRotateLeftSide(AVLNode focus) {
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }

    public AVLNode<Item> doubleRotateRightSide(AVLNode focus) {
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }

    int getBalance(AVLNode<Item> focus) {
        if (focus == null) {
            return 0;
        }
        return height(focus.left) - height(focus.right);
    }

    AVLNode deleteNode(AVLNode focus, int key) {
        if (focus == null) {
            return focus;
        }

        if (key < focus.key) {
            focus.left = deleteNode(focus.left, key);
        }
        else if (key > focus.key) {
            focus.right = deleteNode(focus.right, key);
        }
        else {

            if ((focus.left == null) || (focus.right == null)) {
                AVLNode temp = null;
                if (null == focus.left) {
                    temp = focus.right;
                } else {
                    temp = focus.left;
                }

                if (temp == null) {
                    temp = focus;
                    focus = null;
                } else
                {
                    focus = temp;
                }
            } else {

                AVLNode temp = minValueNode(focus.right);

                focus.key = temp.key;

                focus.right = deleteNode(focus.right, temp.key);
            }
        }
        if (focus == null) {
            return focus;
        }
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;

        int balance = getBalance(focus);


        if (balance > 1 && getBalance(focus.left) >= 0) {
            return rotateMyLeft(focus);
        }

        if (balance > 1 && getBalance(focus.left) < 0) {
            focus.left = rotateMyRight(focus.left);
            return rotateMyLeft(focus);
        }

        if (balance < -1 && getBalance(focus.right) <= 0) {
            return rotateMyRight(focus);
        }

        if (balance < -1 && getBalance(focus.right) > 0) {
            focus.right = rotateMyLeft(focus.right);
            return rotateMyRight(focus);
        }

        return focus;
    }
    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;

        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    public AVLNode findNode (Item data , AVLNode focus ){
        int key=0;
        AVLNode current = root;
        while (current != null) {
            if (current.data.equals(data)) {
                break;

            }
            if(current.key < key ){
                current=current.right;

            }
            else {
                current= current.left;
            }
            key++;
        }
        return current;
}
public int count(Item data, AVLNode focus){
        int cnt=0;
        int key=0;
    AVLNode current = root;
    while (current != null) {
        if (current.data.equals(data)) {
            cnt++;

        }
        if(current.key < key ){
            current=current.right;

        }
        else {
            current= current.left;
        }
        key++;
    }
       return cnt;
}





}



