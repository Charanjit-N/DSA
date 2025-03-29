class Node{
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data = data;
    }
}
// Creating Binary Tree
class BinaryTreeImplementation{
    public static void main(String args[]){
        Node rootNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(30);
        Node fourthNode = new Node(40);
        Node fifthNode = new Node(50);
        Node sixthNode = new Node(60);

        rootNode.left = secondNode;
        rootNode.right = thirdNode;
        secondNode.right = fourthNode;
        thirdNode.left  = fifthNode;
        thirdNode.right = sixthNode;



    }

}