package list;


import node.SingleDirectionNode;

/**
 * 单项链表类
 * 单项列表由 SingleDirectionList组成SingleDirectionNode组成，实现了添加和next迭代功能
 * 插入的对象存放在SingleDirectionNode
 *
 */
public class SingleDirectionList {
    //列表头元素
    public SingleDirectionNode headNode = null;
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
        //itrator为游标，表示迭代的元素的位置，初始值为0，当itrator大于size（超过长度后）时，返回null并将itrator归0
        if(itrator >= size){
            itrator = 0;
        }

        //判断列表是否为空
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

    //取出链表中索引为index节点中存放的对象
    public Object getElememt(int index){
        if (index >= size){
            return null;
        }
        Object elem = null;
        if(headNode == null){
            return elem;
        }
        int i = 0;
        SingleDirectionNode curNode = headNode;
        while (i < index){
            curNode = curNode.next;
            i++;
        }
        elem = curNode.elem;
        return elem;
    }

    public static void main(String[] args) {
        SingleDirectionList sdl = new SingleDirectionList();
        for (int i = 1; i < 100; i++) {
            if (0 == i % 3) {
                sdl.add(new SingleDirectionNode(i));
            }
        }

        System.out.println(sdl.size);
//        while (true) {
//            SingleDirectionNode tmp = sdl.next();
//            if (null == tmp) {
//                break;
//            }
//            System.out.println(tmp.elem);
//        }
        System.out.println(sdl.next().elem);
        System.out.println(sdl.next().elem);
        System.out.println(sdl.next().elem);
        System.out.println(sdl.getElememt(2));
    }
}
