import java.util.ArrayList;

class main {
    public static void main(String[] args) {

        AnalisadorLexico analisador = new AnalisadorLexico();


        final String codigoFonte =  
          "//teste\n" +
    " main() {\n" +
    "    int num = 123;\n" +
    "    prinln(\"funcionou\");\n" +
    "    \n" +
    "    float soma = 100 + 100.1\n" +
                  "/* Este é um comentário\n" +
       "de múltiplas linhas */\n" +
                  "Boolean x == true */\n" +
    "}";

        ArrayList<Token> tokens = analisador.analisar(codigoFonte);

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}

