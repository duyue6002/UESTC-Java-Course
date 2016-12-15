package Yue.LexicalAnalyzer;

/**
 * 运算符
 */
public class CalcWord extends Token {
    public String lexme = "";

    public CalcWord(String s, int t) {
        super(t);
        this.lexme = s;
        this.name = "运算符";
    }

    public String toString() {
        return this.lexme;
    }

    public static final CalcWord
            add = new CalcWord("+", Tag.ADD),
            sub = new CalcWord("-", Tag.SUB),
            mul = new CalcWord("*", Tag.MUL),
            div = new CalcWord("/", Tag.DIV),
            le = new CalcWord("<=", Tag.LE),
            ge = new CalcWord(">=", Tag.GE),
            ne = new CalcWord("!=", Tag.NE),
            assign = new CalcWord(":=", Tag.ASSIGN);
}
