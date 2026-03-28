package org.example;

import java.util.*;
import java.util.regex.*;

public class AnalizadorLexico {
    private static final LinkedHashMap<Pattern, String> patrones = new LinkedHashMap<>();

    static {
        patrones.put(Pattern.compile("^\\["), "L_CORCHETE");
        patrones.put(Pattern.compile("^\\]"), "R_CORCHETE");
        patrones.put(Pattern.compile("^\\{"), "L_LLAVE");
        patrones.put(Pattern.compile("^\\}"), "R_LLAVE");
        patrones.put(Pattern.compile("^,"), "COMA");
        patrones.put(Pattern.compile("^:"), "DOS_PUNTOS");
        patrones.put(Pattern.compile("^\"[^\"]*\""), "STRING"); // Cambiado de LITERAL_CADENA a STRING
        patrones.put(Pattern.compile("^[0-9]+(\\.[0-9]+)?([eE][+-]?[0-9]+)?"), "NUMBER"); // Cambiado de LITERAL_NUM a NUMBER
        patrones.put(Pattern.compile("^(?i)true"), "PR_TRUE");
        patrones.put(Pattern.compile("^(?i)false"), "PR_FALSE");
        patrones.put(Pattern.compile("^(?i)null"), "PR_NULL");
    }

    /**
     * Analiza una línea y retorna la lista de tokens encontrados.
     * Si hay error léxico, retorna null.
     */
    public List<Token> analizarLinea(String linea) {
        List<Token> tokens = new ArrayList<>();
        String input = linea.trim();

        while (!input.isEmpty()) {
            boolean matched = false;
            for (Map.Entry<Pattern, String> entry : patrones.entrySet()) {
                Matcher matcher = entry.getKey().matcher(input);
                if (matcher.find()) {
                    String lexema = matcher.group();
                    tokens.add(new Token(lexema, entry.getValue()));
                    input = input.substring(lexema.length());
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                // Error léxico: retorna null para indicar error en la línea
                return null;
            }
        }
        return tokens;
    }
}
