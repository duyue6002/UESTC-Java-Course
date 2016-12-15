package Yue.LexicalAnalyzer;

/*
 * 常数
 */
public class Num extends Token {
    public final int value;

    public Num(int v) {
        super(Tag.CONSTANT);
        this.value = v;
        this.name = "常数";
    }

    public String toString() {
        return "" + value;
    }
}