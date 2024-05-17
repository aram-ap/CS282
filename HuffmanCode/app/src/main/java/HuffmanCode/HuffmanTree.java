package HuffmanCode;

public class HuffmanTree {

    private String msg;
    private Node head;

    public HuffmanTree(String msg) {
        this.msg = msg;
        this.head = getTreeHead();
    }

    public PriorityQueue getPriority() {
        Node[] nodes = new Node[msg.length()];
        int numNodes = 0;

        for(char c : msg.toCharArray()) {
            Node n = null;
            for(int i = 0; i < numNodes; i++) {
                if(nodes[i].letter == c) {
                    n = nodes[i];
                    break;
                }
            }
            if(n == null) {
                n = new Node(c);
                nodes[numNodes++] = n;
            }
            n.freq++;
        }

        PriorityQueue q = new PriorityQueue(numNodes);
        for(Node n : nodes) {
            if(n == null)
                break;
            q.insert(n);
        }

        return q;
    }

    public Node getTreeHead() {
        PriorityQueue q = getPriority();

        while(q.size() > 1) {
            Node root = new Node();
            Node n1 = q.remove();
            Node n2 = q.remove();

            if(n2 == null) {
                root.right = n1;
                root.freq += n1.freq;
            } else {
                root.left = n1.freq < n2.freq? n1 : n2;
                root.right = root.left == n1? n2 : n1;
                root.freq += n1.freq + n2.freq;
            }

            q.insert(root);
        }

        return q.remove();
    }

    public void assignTextPreorderRecursive(Node current, String[] table) {
        if(current == null) {
            return;
        }

        table[current.letter] = current.getCode();

        if(current.left != null) {
            current.left.setCode(current.getCode() + "0");
            assignTextPreorderRecursive(current.left, table);
        }

        if(current.right != null) {
            current.right.setCode(current.getCode() + "1");
            assignTextPreorderRecursive(current.right, table);
        }
    }

    public String[] getTable() {
        String[] table = new String[256];

        assignTextPreorderRecursive(head, table);

        // for(int i = 0; i < table.length; i++) {
        //     if(table[i] == null)
        //         continue;
        //
        //
        //     System.out.println((char)(i + 97) + ": " + table[i]);
        // }

        return table;
    }

    public String getEncoded() {
        StringBuilder sb = new StringBuilder();
        String[] table = getTable();

        for(char c : msg.toCharArray()) {
            sb.append(table[c] + " ");
        }

        return sb.toString();
    }

    public String decodeMessage(String msg) {
        String[] splitBinary = msg.split(" ");
        StringBuilder decoded = new StringBuilder();

        for(String s : splitBinary) {
            decoded.append(getCharFromBinary(s));
        }

        return decoded.toString();
    }

    public char getCharFromBinary(String binString) {
        Node temp = head;
        for(char c : binString.toCharArray()) {
            if(c == ' ')
                continue;
            temp = c == '1'? temp.right: temp.left;
        }

        return temp.letter;
    }

    public String getTableString() {
        StringBuilder sb = new StringBuilder();
        String[] table = getTable();

        for(int i = 0; i < table.length; i++) {
            String s = table[i];
            if(s == null)
                continue;

            char c = (char)i;

            if(sb.isEmpty()) {
                sb.append("[");
                sb.append(c + ": ");
                sb.append(s);
            } else {


                sb.append(", ");
                sb.append(c);
                sb.append(": ");
                sb.append(s);
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
