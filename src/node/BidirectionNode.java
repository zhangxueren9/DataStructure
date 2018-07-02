package node;

public class BidirectionNode extends Node {
    public Node next;
    public Node last;

    BidirectionNode(Object elem) {
        super(elem);
    }
}
