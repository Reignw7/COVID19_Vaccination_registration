/*
Walker
Reign
4144021
CSC211 Practical 2
Citizen class
 */

public class Node {

    Citizen citizen;
    Node nextNode;

    public Node(Citizen citizen1){
        this.citizen = citizen1;
        this.nextNode= null;
    }


    public Citizen getCitizen() {
        return citizen;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
