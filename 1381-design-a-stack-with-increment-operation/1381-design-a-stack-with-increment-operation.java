class CustomStack {

    private int maxSize;
    private int size;
    private Node pointer = null;
    private Node first = null;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (size == maxSize) return;

        Node node = new Node(x);

        if (size == 0) {
            pointer = node;
            first = node;
        } else {
            node.next = pointer;
            pointer.prev = node;
            pointer = node;
        }

        size += 1;
    }
    
    public int pop() {
        if (size == 0) return -1;

        int popNum = pointer.num;

        pointer = pointer.next;
        size -= 1;
        return popNum;
    }
    
    public void increment(int k, int val) {
        Node tmp = first;

        for (int i = 0; i < k; i++) {
            if (tmp == null) return;

            tmp.num += val;
            tmp = tmp.prev;
        }
    }

    static class Node {
        Node next;
        Node prev;
        int num;

        public Node(int num) {
            this.num = num;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */