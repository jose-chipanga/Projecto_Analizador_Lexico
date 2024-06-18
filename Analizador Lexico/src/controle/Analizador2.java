/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package controle;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import visao.Tela;

/**
 *
 * @author Administrator
 */
public class Analizador2 {

    String codigo;
    int linha = 0;
    int coluna = 0;
    int cont = 0;
    int pos = 0;
    private final ArrayList<Token> listatokens;
    Tela tela;

    public Analizador2(String filename, NumeroLinea numeroLinea, Tela tela) {
        this.tela = tela;
        codigo = filename + " ";
        listatokens = new ArrayList<>();
        parser1(filename, numeroLinea, tela);

    }

    public void parser1(String filename, NumeroLinea numeroLinea, Tela tela) {
        long tempoInicial = System.currentTimeMillis();
        while (!isEOF()) {
            //limpa os primeiros espacos em branco
            while (codigo.charAt(0) == ' ') {
                codigo = codigo.substring(1);
            }

            if (codigo.charAt(0) != ' ') {
                while (codigo.charAt(0) == '\n') {
                    codigo = codigo.substring(1);
                    linha++;
                }

                int posi = posicaoDoProximoEspaco();
                if (posi != -1) {
                    Token tk = null;
                    if (isPalavraReservada(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_KEYWORD, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isNumber(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_NUMBER, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isAtribuicao(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_ATRIBUICAO, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isOperator(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_OPERATOR, codigo.substring(0, posi));
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tk.setLine(linha + 1);
                    } else if (isAt(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_At, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isDivOp(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_DIVISION, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isSubOp(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_SUBTRACTION, codigo.substring(0, posi));
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tk.setLine(linha + 1);
                    } else if (isSumOp(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_SUM, codigo.substring(0, posi));
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tk.setLine(linha + 1);
                    } else if (isTimOp(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_MULTIPLICATION, codigo.substring(0, posi));
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tk.setLine(linha + 1);
                    } else {
                        String cod = codigo.substring(0, posi);
                        verificarEspacadores(cod, tk);
                        if (!codigo.substring(0, posi).contains("{") && !codigo.substring(0, posi).contains("}") && !codigo.substring(0, posi).contains("(") && !codigo.substring(0, posi).contains(")") && !codigo.substring(0, posi).contains(";") && !codigo.substring(0, posi).contains(":")) {
                            tk = new Token(Token.TK_IDENTIFIER, codigo.substring(0, posi));
                            tk.setId(listatokens.size());
                            listatokens.add(tk);
                            tk.setLine(linha + 1);
                        }
                    }
                    codigo = codigo.substring(posi, codigo.length());
                }
            }
            if (codigo.length() == 0) {
                break;
            }
        }
        long tempoFinal = System.currentTimeMillis();
        tela.getLblTimer().setText("Tampo de execucao: " + (tempoFinal - tempoInicial) + " ms");
        retornarTokens();
    }

    public void parser(String filename) {
        Token tk = null;
        if (isPalavraReservada(filename)) {
            tk = new Token(Token.TK_KEYWORD, filename);
            tk.setLine(linha + 1);
            tk.setId(listatokens.size());
            listatokens.add(tk);
        } else if (isNumber(filename)) {
            tk = new Token(Token.TK_NUMBER, filename);
            tk.setLine(linha + 1);
            tk.setId(listatokens.size());
            listatokens.add(tk);
        } else if (isAtribuicao(filename)) {
            tk = new Token(Token.TK_ATRIBUICAO, filename);
            tk.setLine(linha + 1);
            tk.setId(listatokens.size());
            listatokens.add(tk);
        } else if (isOperator(filename)) {
            tk = new Token(Token.TK_OPERATOR, filename);
            tk.setId(listatokens.size());
            listatokens.add(tk);
            tk.setLine(linha + 1);
        } else if (isAt(filename)) {
            tk = new Token(Token.TK_At, filename);
            tk.setLine(linha + 1);
            tk.setId(listatokens.size());
            listatokens.add(tk);
        } else if (isDivOp(filename)) {
            tk = new Token(Token.TK_DIVISION, filename);
            tk.setLine(linha + 1);
            tk.setId(listatokens.size());
            listatokens.add(tk);
        } else if (isSubOp(filename)) {
            tk = new Token(Token.TK_SUBTRACTION, filename);
            tk.setId(listatokens.size());
            listatokens.add(tk);
            tk.setLine(linha + 1);
        } else if (isSumOp(filename)) {
            tk = new Token(Token.TK_SUM, filename);
            tk.setId(listatokens.size());
            listatokens.add(tk);
            tk.setLine(linha + 1);
        } else if (isTimOp(filename)) {
            tk = new Token(Token.TK_MULTIPLICATION, filename);
            tk.setId(listatokens.size());
            listatokens.add(tk);
            tk.setLine(linha + 1);
        } else {
            String cod = filename;
            verificarEspacadores(cod, tk);
            if (contem1(filename)) {
                tk = new Token(Token.TK_IDENTIFIER, filename);
                tk.setId(listatokens.size());
                listatokens.add(tk);
                tk.setLine(linha + 1);
            }
        }
    }

    private void verificarEspacadores(String cod, Token tk) {
        if (contem(cod)) {
            int i = 0;
            while (i < cod.length()) {
                if (isSpecial(cod.charAt(i))) {
                    parser(cod.substring(0, i));
                    tk = new Token(Token.TK_SPECIAL, cod.substring(i, i + 1));
                    tk.setId(listatokens.size());
                    listatokens.add(tk);
                    tk.setLine(linha + 1);
                    parser(cod.substring(i + 1, cod.length()));
                    cod = cod.substring(i + 1, cod.length());
                    cont++;
                } else if (isOperator(cod.charAt(i))) {
                    parser(cod.substring(0, i));
                    tk = new Token(Token.TK_OPERATOR, cod.substring(i, i + 1));
                    tk.setId(listatokens.size());
                    listatokens.add(tk);
                    tk.setLine(linha + 1);
                    
                    parser(cod.substring(i + 1, cod.length()));
                    cod = cod.substring(i + 1, cod.length());
                    cont++;
                } else if (cod.charAt(i) == '"') {
                    parser(cod.substring(0, i));
                    tk = new Token(Token.TK_OPERATOR, cod.substring(i, i + 1));
                    tk.setId(listatokens.size());
                    listatokens.add(tk);
                    tk.setLine(linha + 1);
                    parser(cod.substring(i + 1, cod.length()));
                    cod = cod.substring(i + 1, cod.length());
                    cont++;
                } else if (cod.charAt(i) == ':') {
                    if (i + 2 < cod.length()) {
                        if (cod.charAt(i + 1) == '=') {
                            tk = new Token(Token.TK_ATRIBUICAO, cod.substring(i, i + 2));
                            tk.setId(listatokens.size());
                            listatokens.add(tk);
                            tk.setLine(linha + 1);
                            parser(cod.substring(i + 2, cod.length()));
                            cod = cod.substring(i + 2, cod.length());
                            i++;
                        } else {
                            parser(cod.substring(0, i));
                            tk = new Token(Token.TK_SPECIAL, cod.substring(i, i + 1));
                            tk.setId(listatokens.size());
                            listatokens.add(tk);
                            tk.setLine(linha + 1);
                            parser(cod.substring(i + 1, cod.length()));
                            cod = cod.substring(i + 1, cod.length());
                        }
                    }
                }
                i++;
            }
        }
    }

    public void retornarTokens() {
        DefaultTableModel tabModel = (DefaultTableModel) tela.getTabela().getModel();
        for (Token listatoken : listatokens) {
            if (listatoken.getText().length() != 0) {
                tabModel.addRow(new Object[]{
                    listatoken.getLine(), listatoken.getText(),
                    verTipo(listatoken.getType()),
                    listatoken.getText(),
                    listatoken.getId()});
            }
        }
    }

    private int posicaoDoProximoEspaco() {
        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) == ' ' || codigo.charAt(i) == '\n') {
                return i;
            }
        }
        return -1;
    }

    private int posicaoDoProximoLiteral() {
        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) == '"') {
                return i;
            }
        }
        return -1;
    }

    private boolean isEOF() {
        return pos == codigo.length() - 1;

    }

    private boolean isPonctuation(String c) {
        return c.equals(";")
                || c.equals(".")
                || c.equals(",");
    }

    private boolean isSpecial(char c) {
        return c == ('{')
                || c == ('}') || c == (',')
                || c == ('(') || c == (')')
                || c == ('[') || c == (']') || c == (';')|| c == ('.');
    }

    private boolean isOperator(char c) {
        return c == ('>')
                || c == ('<')
                || c == ('+')
                || c == ('-')
                || c == ('/')
                || c == ('*')
                || c == ('!');
    }

    private boolean isOperator(String c) {
        return c.equals(">")
                || c.equals("<")
                || c.equals("!");
    }

    private boolean contem1(String filename) {
        return !filename.contains("{") && !filename.contains("}")
                && !filename.contains(",") && !filename.contains("(")
                && !filename.contains(")") && !filename.contains(";")
                && !filename.contains(":") && !filename.contains(">")
                && !filename.contains("<")
                && !filename.contains("+")
                && !filename.contains("-")
                && !filename.contains("/")
                && !filename.contains("*")
                && !filename.contains("!");
    }

    private boolean contem(String cod) {
        return cod.contains("{") || cod.contains("}")
                || cod.contains(",") || cod.contains("(")
                || cod.contains(")") || cod.contains(";")
                || cod.contains(":") || cod.contains(";")
                || cod.contains(">")
                || cod.contains("<")
                || cod.contains("+")
                || cod.contains("-")
                || cod.contains("/")
                || cod.contains("*")
                || cod.contains("!");
    }

    private boolean isPalavraReservada(String word) {
        return word.equalsIgnoreCase("program") || word.equalsIgnoreCase("true")
                || word.equalsIgnoreCase("false") || word.equalsIgnoreCase("char")
                || word.equalsIgnoreCase("string") || word.equalsIgnoreCase("integer")
                || word.equalsIgnoreCase("boolean") || word.equalsIgnoreCase("write")
                || word.equalsIgnoreCase("read") || word.equalsIgnoreCase("if")
                || word.equalsIgnoreCase("else") || word.equalsIgnoreCase("begin")
                || word.equalsIgnoreCase("end") || word.equalsIgnoreCase("function")
                || word.equalsIgnoreCase("procedure") || word.equalsIgnoreCase("for")
                || word.equalsIgnoreCase("var") || word.equalsIgnoreCase("then")
                || word.equalsIgnoreCase("while") || word.equalsIgnoreCase("not")
                || word.equalsIgnoreCase("and") || word.equalsIgnoreCase("or")
                || word.equalsIgnoreCase("real") || word.equalsIgnoreCase("writeln")
                || word.equalsIgnoreCase("print") || word.equalsIgnoreCase("println");
    }

    private boolean isNumber(String substring) {
        try {
            int num = Integer.parseInt(substring);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isAtribuicao(String c) {
        return c.equals(":=") || c.equals(":");
    }

    private boolean isSumOp(String c) {
        return c.equals("+");
    }

    private boolean isSubOp(String c) {
        return c.equals("-");
    }

    private boolean isTimOp(String c) {
        return c.equals("*");
    }

    private boolean isDivOp(String c) {
        return c.equals("/");
    }

    private boolean isAt(String c) {
        return c.equals("@");
    }

    public ArrayList<Token> getListatokens() {
        return listatokens;
    }

    private String verTipo(int type) {
        return Token.TK_TEXT[type];
    }

}
