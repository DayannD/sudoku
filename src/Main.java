import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sudoku sudoku = new Sudoku();
        Integer line = null;
        Integer colonne = null;
        Integer val = null;


        while (sudoku.again){
            sudoku.affiche();
            try{
                System.out.println("Dans quelle ligne souhaiter vous mettre votre saisie");
                line = scanner.nextInt();
                System.out.println("Dans quelle colonne souhaiter vous mettre votre saisie");
                colonne = scanner.nextInt();
                System.out.println("Quelle valeur voulez vous rendrer dans le sudoku ? ");
                val = scanner.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("La valeur rentrer est erroné !! réessayer");
                scanner.nextLine();
            }
            sudoku.start(val,(line-1),(colonne-1));
        }
    }
}
