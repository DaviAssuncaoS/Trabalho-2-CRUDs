import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número N

        for (int i = 0; i < N; i++) {
            String expressao = scanner.nextLine();
            if (verificarParenteses(expressao)) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
        scanner.close();
    }

    public static boolean verificarParenteses(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char caractere : expressao.toCharArray()) {
            if (caractere == '(') {
                pilha.push(caractere);
            } else if (caractere == ')') {
                if (pilha.isEmpty() || pilha.pop() != '(') {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }
}

