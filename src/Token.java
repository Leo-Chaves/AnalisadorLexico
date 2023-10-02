import java.util.ArrayList;
import java.util.regex.*;

public class Token {
        String valor;
        String tipo;

        public Token(String valor, String tipo) {
            this.valor = valor;
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return "(" + valor + ", " + tipo + ")";
        }
    }


