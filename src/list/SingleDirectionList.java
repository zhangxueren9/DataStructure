package list;


import node.SingleDirectionNode;

public class SingleDirectionList {
    public SingleDirectionNode headNode = null;//列表头元素
    int itrator = 0;
    public int size = 0;

    public void add(SingleDirectionNode node) {
        //将Node.next置为null 标记为最后一个元素
        node.next = null;
        size++;
        //如果列表为空列表，则将node插入到headNode位置,如果不为空则插入到最后一个位置
        if (null == headNode) {
            headNode = node;
            return;
        } else {
            SingleDirectionNode curNode = headNode;
            while (null != curNode.next) {
                curNode = curNode.next;
            }
            curNode.next = node;
        }
    }

    public SingleDirectionNode next() {
        if (null == headNode) {
            return null;
        }
        int i = 0;
        SingleDirectionNode curNode = headNode;
        while (i < itrator) {
            curNode = curNode.next;
            i++;
        }
        itrator++;
        return curNode;
    }

    public static void main(String[] args) {
        SingleDirectionList sdl = new SingleDirectionList();
        for (int i = 1; i < 100; i++) {
            if (0 == i % 3) {
                sdl.add(new SingleDirectionNode(i));
            }
        }

        System.out.println(sdl.size);
        while (true) {
            SingleDirectionNode tmp = sdl.next();
            if (null == tmp) {
                break;
            }
            System.out.println(tmp.elem);
        }
    }
}
