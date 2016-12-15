package Yue.LexicalAnalyzer;

import java.io.*;

/*
 * 主程序
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        lexer.printToken();
        lexer.printSymbolsTable();
    }
}
