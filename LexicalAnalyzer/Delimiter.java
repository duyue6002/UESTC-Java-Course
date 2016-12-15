package Yue.LexicalAnalyzer;

/**
 * 界符
 */
public class Delimiter extends Token {
    public String lexme = "";

    public Delimiter(String s, int t) {
        super(t);
        this.lexme = s;
        this.name = "界符";
    }

    public String toString() {
        return this.lexme;
    }

    public static final Delimiter
            lpar = new Delimiter("(", Tag.LPAR),
            rpar = new Delimiter(")", Tag.RPAR),
            sem = new Delimiter(";", Tag.SEM);
}
