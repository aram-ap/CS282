package HuffmanCode;

public class Node{
    public int freq = 0;
    public char letter;

    public Node left;
    public Node right;
    private String code = "";

    public Node(char c) {
        this.letter = c;
    }

    public Node() {
    }

    public void setCode(String newCode) {
        this.code = newCode;
    }

    public String getCode() {
        return code;
    }
}
