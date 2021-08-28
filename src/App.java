import java.util.Scanner;

/**
 * Programa para criptografar e descriptograr utilizando a Cifra de César e o
 * suporte ASCII.
 *
 * @author Lucas Souza
 */
public class App {
    // Método para criptografar o texto.
    public static String encriptar(int chave, String texto) {

        StringBuilder textoCifrado = new StringBuilder();
        int tamanhoTexto = texto.length();

        for (int c = 0; c < tamanhoTexto; c++) {
            int letraCifradaASCII = ((int) texto.charAt(c)) + chave;

            while (letraCifradaASCII > 126)
                letraCifradaASCII -= 94;

            textoCifrado.append((char) letraCifradaASCII);
        }

        return textoCifrado.toString();
    }

    // Método para descriptografar o texto.
    public static String decriptar(int chave, String textoCifrado) {
        StringBuilder texto = new StringBuilder();
        int tamanhoTexto = textoCifrado.length();

        for (int c = 0; c < tamanhoTexto; c++) {
            int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - chave;

            while (letraDecifradaASCII < 32)
                letraDecifradaASCII += 94;

            texto.append((char) letraDecifradaASCII);
        }

        return texto.toString();
    }

    public static void main(String[] args) {

        try {
            Scanner entrada = new Scanner(System.in);

            System.out.println("\n**************A CRIFRA DE CESÁR********************\n");
            System.out.println("\n*****SEUS SEGREDOS GUARDADOS E NUNCA REVELADOS*****\n");

            System.out.print("Insira o texto a ser criptografado: ");
            String texto = entrada.nextLine();
            System.out.print("Insira a chave para deslocamento (1 - 126): ");
            int chave = entrada.nextInt();

            // Criptografando
            String textoCriptografado = encriptar(chave, texto);
            // Descriptografando
            String textoDescriptografado = decriptar(chave, textoCriptografado);

            System.out.println("\n\nTEXTO INSERIDO CRIPTOGRAFADO: " + textoCriptografado);
            System.out.println("TEXTO INSERIDO DESCRIPOGRAFADO: " + textoDescriptografado);

            System.out.println("\n*****************************************************\n");

        } catch (RuntimeException e) { // Trata erro de digitacao
            System.out.println("A chave de deslocamento foi informada incorretamente.");
            System.out.println("Execute o programa novamente e entre com uma chave valida.");
        }

    }
}