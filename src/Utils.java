import java.util.Scanner;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);

    public static int scanInt(String mensagem) {
        do {
            try {
                System.out.println(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Informe o valor correto");
            }
        } while (true);
    }

    public static String scanString(String mensagem){
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    public static void pula2linhas(){
        System.out.println("\n\n");
    }
}