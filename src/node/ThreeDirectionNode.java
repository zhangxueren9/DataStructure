package node;

public class ThreeDirectionNode extends Node {
    public Node father;
    public Node lChild;
    public Node rChild;

    ThreeDirectionNode(Object elem) {
        super(elem);
    }
}
