package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // String inputPath = "src/main/resources/fuente.txt";
        String outputPath = "src/main/resources/output.txt";

        AnalizadorLexico analizador = new AnalizadorLexico();
        String basePath = System.getProperty("user.dir") + "/compiladores/compiladores";

        try (
            BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    Main.class.getClassLoader().getResourceAsStream("fuente.txt")
                )
            );

            BufferedWriter bw = new BufferedWriter(
                new FileWriter(basePath + "/src/main/resources/output.txt")
            );
        ) {

            String linea;
            int numLinea = 1;

            while ((linea = br.readLine()) != null) {
                int espacios = 0;
                while (espacios < linea.length() && Character.isWhitespace(linea.charAt(espacios))) {
                    espacios++;
                }

                List<Token> tokens = analizador.analizarLinea(linea);
                if (tokens == null) {
                    // Error léxico: escribir mensaje en consola y en archivo de salida
                    String msg = "Error léxico en línea " + numLinea;
                    System.err.println(msg);
                    bw.write(msg);
                } else {
                    for (int i = 0; i < espacios; i++) {
                        bw.write(" ");
                    }
                    for (int i = 0; i < tokens.size(); i++) {
                        bw.write(tokens.get(i).getTipo());
                        if (i < tokens.size() - 1) {
                            bw.write(" ");
                        }
                    }
                }
                bw.newLine();
                numLinea++;
            }

            System.out.println("Análisis completado. Archivo de salida generado en " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
