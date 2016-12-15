package Yue.LexicalAnalyzer;

/**
 * 结尾符
 */
public class AllEnd extends Token {
    public String lexme = "";

    public AllEnd(String s) {
        super(Tag.ALL_END);
        this.lexme = s;
        this.name = "结尾符";
    }

    public String toString() {
        return this.lexme;
    }

    public static final AllEnd allEnd = new AllEnd("#");
}
