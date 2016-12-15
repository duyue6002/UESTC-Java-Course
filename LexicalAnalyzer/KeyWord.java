package Yue.LexicalAnalyzer;

/**
 * 保留字
 */
public class KeyWord extends Token {
    public String lexme = "";

    public KeyWord(String s, int t) {
        super(t);
        this.lexme = s;
        this.name = "保留字";
    }

    public String toString() {
        return this.lexme;
    }

    public static final KeyWord
            begin = new KeyWord("begin", Tag.BEGIN),
            end = new KeyWord("end", Tag.END),
            integer = new KeyWord("integer", Tag.INTEGER),
            function = new KeyWord("function", Tag.FUNCTION),
            read = new KeyWord("read", Tag.READ),
            write = new KeyWord("write", Tag.WRITE),
            aIf = new KeyWord("if", Tag.IF),
            aThen = new KeyWord("then", Tag.THEN),
            aElse = new KeyWord("else", Tag.ELSE);
}
