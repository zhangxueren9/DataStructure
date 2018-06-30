package node;

public class ThreeDirectionNode extends Node {
    Node father;
    Node lChild;
    Node rChild;

    ThreeDirectionNode(Object elem) {
        super(elem);
    }
}
