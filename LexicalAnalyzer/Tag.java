package Yue.LexicalAnalyzer;

/*
 * 单词类别赋值
 */
public class Tag {
    public final static int
            BEGIN = 1,          //保留字
            END = 2,            //保留字
            INTEGER = 3,        //保留字
            FUNCTION = 4,       //保留字
            READ = 5,           //保留字
            WRITE = 6,          //保留字
            IF = 7,             //保留字
            THEN = 8,           //保留字
            ELSE = 9,           //保留字
            SYMBOL = 11,        //标识符
            CONSTANT = 12,      //常数
            ADD = 13,           //运算符 "+"
            SUB = 14,           //运算符 "-"
            MUL = 15,           //运算符 "*"
            DIV = 16,           //运算符 "/"
            LE = 18,            //运算符 "<="
            GE = 19,            //运算符 ">="
            NE = 20,            //运算符 "!="
            ASSIGN = 23,        //运算符 ":="
            LPAR = 24,          //界符 "("
            RPAR = 25,          //界符 ")"
            SEM = 26,           //界符 ";"
            LINE_END = 27,      //行尾符
            ALL_END = 28;       //结尾符 "#"
}