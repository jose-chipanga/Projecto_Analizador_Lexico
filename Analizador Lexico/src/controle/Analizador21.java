/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
package controle;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import visao.Tela;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Administrator
 */
public class Analizador21 {

    String codigo;
    int linha = 0;
    int coluna = 0;
    int cont = 0;
    int pos = 0;
    private ArrayList<Token> listatokens;
    private ArrayList<String> historico;
    Tela tela;
    String textoParaErro;
    Highlighter high;

    public Analizador21(Tela tela) {
        this.tela = tela;
        textoParaErro = tela.getTxtEditor().getText();
        high = tela.getTxtEditor().getHighlighter();
    }

    public void init(String filename, Tela tela) {
        high = tela.getTxtEditor().getHighlighter();
        high.removeAllHighlights();
        this.tela = tela;
        codigo = textoParaErro = filename + " ";
        listatokens = new ArrayList<>();
        historico = new ArrayList<>();
        parser1(filename, tela);

    }

    public void parser1(String filename, Tela tela) {
        long tempoInicial = System.currentTimeMillis();
        codigo = addSpacos(codigo);
        while (!isEOF()) {
            //limpa os primeiros espacos em branco
            while (codigo.charAt(0) == ' ') {
                if (codigo.length() == 1) {
                    break;
                }
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
                    if (erroAcentos(codigo.substring(0, posi))) {
                        pintarErro(Color.RED, posi);
                        tk = new Token(Token.TK_ERRO_LEXICO, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tela.getTxtConsole().setForeground(Color.red);
                        tela.getTxtConsole().append("Ocoreu um erro na linha: " + tk.getLine() + ", Descricao: " + verTipo(tk.getType()) + " \"" + tk.getText() + "\" nao esperado \n");

                    } else if (isPalavraReservada(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_KEYWORD, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isNumber(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_NUMBER, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (codigo.substring(0, posi).equals(":")) {
                        if (posi + 3 < codigo.length()) {
                            if (codigo.substring(0, posi + 3).equals(":  =")) {
                                tk = new Token(Token.TK_ATRIBUICAO, codigo.substring(0, posi + 3));
                                tk.setId(listatokens.size());
                                listatokens.add(tk);
                                tk.setLine(linha + 1);
                                posi = posi + 3;
                            } else {
                                tk = new Token(Token.TK_ATRIBUICAO, codigo.substring(0, posi));
                                tk.setId(listatokens.size());
                                listatokens.add(tk);
                                tk.setLine(linha + 1);

                            }
                        }
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
                    } else if (isVirgula(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_VIRGULA, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isApar(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_A_PAR, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isFpar(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_F_PAR, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isDivOp(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_DIVISION, codigo.substring(0, posi));
                        tk.setLine(linha + 1);
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                    } else if (isPonto(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_PONTO, codigo.substring(0, posi));
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
                    } else if (isSpecial(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_SPECIAL, codigo.substring(0, posi));
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tk.setLine(linha + 1);
                    } else if (isOpIgual(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_IGUALIDADE, codigo.substring(0, posi));
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tk.setLine(linha + 1);
                    } else if (isLiteral(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_LITERAL, codigo.substring(0, posi));
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tk.setLine(linha + 1);
                    } else if (isPontoVirgula(codigo.substring(0, posi))) {
                        tk = new Token(Token.TK_PONTO_VIRGULA, codigo.substring(0, posi));
                        tk.setId(listatokens.size());
                        listatokens.add(tk);
                        tk.setLine(linha + 1);
                    } else {
                        if (isNumber(codigo.substring(0, 1))) {
                            pintarErro(Color.red, posi);
                            tk = new Token(Token.TK_ERRO_LEXICO, codigo.substring(0, posi));
                            tk.setId(listatokens.size());
                            listatokens.add(tk);
                            tk.setLine(linha + 1);
                            tela.getTxtConsole().setForeground(Color.red);
                            tela.getTxtConsole().append("Ocoreu um erro na linha: " + tk.getLine() + ", Descricao: " + verTipo(tk.getType()) + " \"" + tk.getText() + "\" nao esperado \n");

                        } else {
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
        this.tela.getLblTimer().setText("Tempo: "+(tempoFinal - tempoInicial) + "ms");
        retornarTokens();
        listatokens.clear();
        codigo = "";
        linha = 0;
    }

    public boolean erroAcentos(String value) {
        return value.contains("á") || value.contains("à")
                || value.contains("ã") || value.contains("ä") || value.contains("â")
                || value.contains("Á") || value.contains("À") || value.contains("Ã")
                || value.contains("Ä") || value.contains("é")
                || value.contains("è") || value.contains("ë")
                || value.contains("ê") || value.contains("É") || value.contains("È")
                || value.contains("Ë") || value.contains("Ê") || value.contains("í")
                || value.contains("ì") || value.contains("ï") || value.contains("î") || value.contains("Í")
                || value.contains("Ì") || value.contains("Ï") || value.contains("Î")
                || value.contains("ó") || value.contains("ò") || value.contains("õ")
                || value.contains("ö") || value.contains("ô") || value.contains("Ó")
                || value.contains("Ò") || value.contains("Õ") || value.contains("Ö")
                || value.contains("Ô") || value.contains("ú") || value.contains("ù")
                || value.contains("ü") || value.contains("û") || value.contains("ý")
                || value.contains("ÿ") || value.contains("ñ") || value.contains("ç")
                || value.contains("Ú") || value.contains("Ù") || value.contains("Ü")
                || value.contains("Û") || value.contains("Ý") || value.contains("Ñ")
                || value.contains("Ç");

    }

    private void verificarEspacadores(String cod, Token tk) {
        if (contem(cod)) {

        }
    }

    public void retornarTokens() {

        DefaultTableModel tabModel = (DefaultTableModel) tela.getTabela().getModel();
        DefaultTableModel tabModelHistorico = (DefaultTableModel) tela.getTabelaHistoico().getModel();
        for (Token listatoken : listatokens) {
            historico.add(listatoken.getText().replace(" ", ""));
            if (listatoken.getText().length() != 0) {
                tabModel.addRow(new Object[]{
                    listatoken.getLine(), listatoken.getText().replace(" ", ""),
                    verTipo(listatoken.getType())});
                tabModelHistorico.addRow(new Object[]{listatoken.getText().replace(" ", "")
                });
            }
        }
    }

    public int posicaoDoProximoEspaco() {
        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) == ' ' || codigo.charAt(i) == '\n') {
                return i;
            }
        }
        return -1;
    }

    public static int posicaoDoUltimoEspaco(String codigo) {
        for (int i = codigo.length() - 1; i > 0; i--) {
            if (codigo.charAt(i) == ' ' || codigo.charAt(i) == '\n') {
                return i;

            }
        }
        return -1;
    }

    public static int posicaoDoUltimoenter(String codigo) {

        for (int i = codigo.length() - 1; i > 0; i--) {
            if (codigo.charAt(i) == '\n') {
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

    public static String addSpacos(String value) {
        return value.replace("{", " { ").replace("}", " } ").replace(
                "(", " ( ").replace(")", " ) ").replace("[", " [ ").replace(
                ";", " ; ").replace(">", " > ").replace("<", " < ").replace("+", " + ")
                .replace("-", " - ").replace("/", " / ").replace("*", " * ")
                .replace(",", " , ").replace(":", " : ").replace("=", " = ").replace(".", " . ");
    }

    private boolean isSpecial(char c) {
        return c == ('{')
                || c == ('}') || c == (',')
                || c == ('(') || c == (')')
                || c == ('[') || c == (']')
                || c == (';') || c == ('.');
    }

    private boolean isSpecial(String c) {
        return c.equals('{')
                || c.equals('}') || c.equals(',')
                || c.equals('(') || c.equals(')')
                || c.equals('[') || c.equals(']')
                || c.equals(';') || c.equals('.');
    }

    private boolean isLiteral(String c) {
        return c.contains("\"");
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
                //                 || c.equals("=")
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
            long num = Long.parseLong(substring);
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

    private boolean isOpIgual(String c) {
        return c.equals("=");
    }

    private boolean isSubOp(String c) {
        return c.equals("-");
    }

    private boolean isTimOp(String c) {
        return c.equals("*");
    }

    private boolean isApar(String c) {
        return c.equals("(");
    }

    private boolean isFpar(String c) {
        return c.equals(")");
    }

    private boolean isPonto(String c) {
        return c.equals(".");
    }

    private boolean isDivOp(String c) {
        return c.equals("/");
    }

    private boolean isAt(String c) {
        return c.equals("@");
    }

    private boolean isVirgula(String c) {
        return c.equals(",");
    }

    private boolean isPontoVirgula(String c) {
        return c.equals(";");
    }

    public ArrayList<Token> getListatokens() {
        return listatokens;
    }

    private String verTipo(int type) {
        return Token.TK_TEXT[type];
    }

    public static String removeAcentos(String value) {
        return value.replace("á", "a").replace("à", "a").replace(
                "ã", "a").replace("ä", "a").replace("â", "a").replace(
                "Á", "A").replace("À", "A").replace("Ã", "A").replace(
                "Ä", "A").replace("Â", "A").replace("é", "e").replace(
                "è", "e").replace("ë", "e").replace("ê", "e").replace(
                "É", "E").replace("È", "E").replace("Ë", "E").replace(
                "Ê", "E").replace("í", "i").replace("ì", "i").replace(
                "ï", "i").replace("î", "i").replace("Í", "I").replace(
                "Ì", "I").replace("Ï", "I").replace("Î", "I").replace(
                "ó", "o").replace("ò", "o").replace("õ", "o").replace(
                "ö", "o").replace("ô", "o").replace("Ó", "O").replace(
                "Ò", "O").replace("Õ", "O").replace("Ö", "O").replace(
                "Ô", "O").replace("ú", "u").replace("ù", "u").replace(
                "ü", "u").replace("û", "u").replace("ý", "y").replace(
                "ÿ", "y").replace("ñ", "n").replace("ç", "c").replace(
                "Ú", "U").replace("Ù", "U").replace("Ü", "U").replace(
                "Û", "U").replace("Ý", "Y").replace("Ñ", "N").replace("Ç", "C");
    }

    public String getCodigo() {
        return codigo;
    }

    public void resolverErros() {
        codigo = removeAcentos(tela.getTxtEditor().getText());
        tela.getTxtEditor().setText(codigo);
        init(codigo, tela);
    }
    int contaErros = 0;

    private void pintarErro(Color RED, int posi) {
        if (posi > -1) {
            int y = textoParaErro.substring(
                    0, textoParaErro.lastIndexOf(
                            codigo.substring(
                                    0, posi))).length() + codigo.substring(
                            0, posi).length();

            int t = Analizador21.posicaoDoUltimoenter(textoParaErro.substring(0, textoParaErro.lastIndexOf(codigo.substring(0, posi))));
            try {
                HighlightPainter cor = new DefaultHighlighter.DefaultHighlightPainter(RED);
                if (t > -1) {
                    high.addHighlight(t, y, cor);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(Analizador21.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setTextoParaErro(String textoParaErro) {
        tela.getTxtEditor().setText(tela.getTxtEditor().getText());
        high = tela.getTxtEditor().getHighlighter();
        high.removeAllHighlights();
        //   init(textoParaErro, tela);
    }

    public void pesquisa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void pesquisa(Point point, String str) {

       
        int x = point.getLocation().x;
        int y = point.getLocation().y;
        int width = 200;
        tela.getTabelaSugestao().setBounds(tela.getTxtEditor().getWidth() - 250, y, width, 100);
      
        DefaultTableModel tabModelHistorico = (DefaultTableModel)  tela.getTabelaSugestao().getModel();
        for (Token listatoken : listatokens) {
            historico.add(listatoken.getText().replace(" ", ""));
            if (listatoken.getText().length() != 0) {
                tabModelHistorico.addRow(new Object[]{listatoken.getText().replace(" ", "")
                });
            }
        }
         tela.getTabelaSugestao().setVisible(true);
    }

}
