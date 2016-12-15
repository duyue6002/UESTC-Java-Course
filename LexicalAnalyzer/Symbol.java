package Yue.LexicalAnalyzer;

/*
 * 标识符
 */
public class Symbol extends Token {
    public String lexme = "";

    public Symbol(String s) {
        super(Tag.SYMBOL);
        this.lexme = s;
        this.name = "标识符";
    }

    public String toString() {
        return this.lexme;
    }

}
