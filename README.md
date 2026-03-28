# Analizador Léxico JSON Simplificado

## Descripción
Este proyecto implementa un analizador léxico en Java para un lenguaje JSON simplificado. El programa lee un archivo fuente (`fuente.txt`), analiza cada línea y genera un archivo de salida (`output.txt`) con la secuencia de tokens reconocidos.

## Instrucciones de compilación y ejecución

1. Compila el proyecto con Maven o desde tu IDE.
2. Asegúrate de que `fuente.txt` esté en `src/main/resources`.
3. Ejecuta la clase `Main`. El resultado se guardará en `src/main/resources/output.txt`.

## Notas
1. El programa utiliza rutas basadas en la ubicación del proyecto.
2. En caso de que la ruta de salida no funcione correctamente, modificar la siguiente línea en el archivo Main.java:
String basePath = System.getProperty("user.dir") + "/compiladores/compiladores";
Reemplazar "/compiladores/compiladores" por la ruta correspondiente donde se encuentra el proyecto en su máquina.
3. Ejecutar preferentemente el programa desde la raíz del proyecto para evitar problemas de rutas.

## Integrantes
- Sabina Medina
- Aldo Medina

## Repositorio
https://github.com/sabi2204/compiladores
