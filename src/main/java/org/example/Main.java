package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/main/resources/fuente.txt";
        String outputPath = "src/main/resources/output.txt";

        AnalizadorLexico analizador = new AnalizadorLexico();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            String linea;
            int numLinea = 1;
            while ((linea = br.readLine()) != null) {
                List<Token> tokens = analizador.analizarLinea(linea);
                if (tokens == null) {
                    // Error léxico: escribir mensaje en consola y en archivo de salida
                    String msg = "Error léxico en línea " + numLinea;
                    System.err.println(msg);
                    bw.write(msg);
                } else {
                    for (Token token : tokens) {
                        bw.write(token.toString() + " ");
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
