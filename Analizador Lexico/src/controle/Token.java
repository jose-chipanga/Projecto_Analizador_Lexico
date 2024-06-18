
package controle;

/**
 *
 * @author Dell
 */
public class Token {
    public static final int TK_IDENTIFIER = 0;
    public static final int TK_NUMBER = 1;
    public static final int TK_OPERATOR = 2;
    public static final int TK_PONCTUATION = 3;
    public static final int TK_ATRIBUICAO = 4;
    public static final int TK_KEYWORD = 5;
    public static final int TK_SUM = 6;
    public static final int TK_SUBTRACTION = 7;
    public static final int TK_MULTIPLICATION= 8; 
    public static final int TK_DIVISION = 9; 
    public static final int TK_SPECIAL = 10;
    public static final int TK_At = 11;
    public static final int TK_VIRGULA = 12;
    public static final int TK_A_PAR= 13;
    public static final int TK_F_PAR= 14;
    public static final int TK_LITERAL= 15;
    public static final int TK_IGUALIDADE= 16;
    public static final int TK_PONTO= 17;
    public static final int TK_ERRO_LEXICO= 18;
    public static int TK_PONTO_VIRGULA=19;
    
    
    public static final String TK_TEXT[] = {
           "Identificador", "Numero", "Operador", "Pontuacao",
        "Atribuicao", "Palavra Reservada", "Operador Soma", 
        "Operador Subtracao", "Operador Multiplicacao", 
        "Operador Divisor", "Especial","AROBA","Virgula"
            ,"Abrir de Parenteses","Fechar de Parenteses"
            ,"Literal" ,"Operador de igualidade","ponto","Erro -> Nao reconhecido","Ponto e virgula"
    };
    
    
    private int type;
    private String text;
    private int line;
    private int column;
    private int id;

    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }
    

    public Token() {
        
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        if(type == 5 || type == 10){
            //return "Token{" + "type=" + text + ", text=" + text  +'}';
             return "Tipo Token= " + text + "|| Token=" + text;
        }
        
       // return "Token{" + "type=" + TK_TEXT[type] + ", text=" + text  +'}';
         return "Tipo Token= " + TK_TEXT[type] + " || Token= " + text+" Line = "+line;
    }
   

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
