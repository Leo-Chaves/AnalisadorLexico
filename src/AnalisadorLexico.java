import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalisadorLexico {

    private static final String[] padroes = {
            "\\d+\\.\\d+", "NUM_DEC",
            "\\d+", "NUM_INT",
            "\"[^\"]*\"", "TEXTO",
            "\\b(int|float|char|boolean|void|if|else|for|while|scanf|println|main|return)", "PALAVRA_RESERVADA",
            "//[^\n]*", "COMENTARIO_LINHA",
            "/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "COMENTARIO_BLOCO",
            "[a-zA-Z_][a-zA-Z_0-9]*", "ID",
            "[=+\\-*/%=!><]=?|&&|\\|\\|", "OPERADOR",
            "[()\\[\\]{}\\,;]", "SIMBOLO",
            "\\s+", "VAZIO",
            ".", "ERRO"
    };

    public static ArrayList<Token> analisar(String codigo) {
        ArrayList<Token> tokens = new ArrayList<>();
        int i = 0;
        int len = codigo.length();

        while (i < len) {
            boolean casou = false;
            for (int j = 0; j < padroes.length; j += 2) {
                Pattern pattern = Pattern.compile("^" + padroes[j]);
                Matcher matcher = pattern.matcher(codigo.substring(i));

                if (matcher.find()) {
                    String valor = matcher.group();
                    String tipo = padroes[j + 1];
                    tokens.add(new Token(valor, tipo));
                    i += valor.length();
                    casou = true;
                    break;
                }

            }
            if (!casou) {
                String valor = String.valueOf(codigo.charAt(i));
                tokens.add(new Token(valor, "ERRO"));
                i++;
            }
            while (i < len && Character.isWhitespace(codigo.charAt(i))) {
                i++;
            }
        }

        return tokens;
    }

}
