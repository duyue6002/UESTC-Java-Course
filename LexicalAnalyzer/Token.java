package Yue.LexicalAnalyzer;

/*
 * Token父类
 */
public class Token {
    public final int tag;
    public int line = 1;
    public String name = "";
    public int pos = 0;

    public Token(int t) {
        this.tag = t;
    }

    public String toString() {
        return "" + (char) tag;
    }

}
