import java.util.Arrays;

public class Sudoku {

    private int faute = 0;
    public static boolean again = true;
    int[][] grid = {
            {0,0,0,0,3,0,0,6,2},
            {0,0,0,0,7,2,0,0,1},
            {2,0,0,6,0,0,8,0,0},

            {1,0,9,4,0,6,0,8,7},
            {0,0,4,0,0,0,2,0,0},
            {5,8,0,1,0,7,6,0,4},

            {0,0,6,0,0,1,0,0,3},
            {4,0,0,3,8,0,0,0,0},
            {7,3,0,0,6,0,0,0,0}
    };

    public Sudoku(){
    }

    public void start(int val,int ligne,int colonne){
        boolean colon = dansLaColonne(val,colonne);;
        boolean line = dansLaLigne(val,ligne);
        boolean carre= dansLeCarre(val,ligne,colonne);

        if (colon || line || carre){
            System.out.println("Impossible de mettre la valeur ici, reessayer autre part");
            faute++;
            toMoreFault();
            return;
        }

        grid[colonne][ligne] = val;
    }

    public boolean dansLaColonne(int val,int ligne){
        System.out.println("colonne");
        for (int i=0; i < 9;i++){
            System.out.println(grid[i][ligne]);
            if (grid[i][ligne] == val){
                return true;
            }
        }

        return false;
    }

    public boolean dansLaLigne(int val,int colonne){
        System.out.println("ligne");
        for (int i=0; i < 9;i++){
            System.out.println(grid[colonne][i]);
            if (grid[colonne][i] == val){
                return true;
            }
        }
        return false;
    }

    public boolean dansLeCarre(int val,int ligne,int colonne){
        int pointGauche = 3*(colonne/3);
        int pointHaut = 3*(ligne/3);
        for (int c=pointGauche; c<pointGauche+3; c++) {
            for (int l = pointHaut; l < pointHaut + 3; l++) {
                if (grid[l][c] == val) {
                    return true;
                }
            }
        }
        return false;
    }

    public void affiche(){
        int returnLine = 0;
        for (int c = 0; c < 9;c++){
            for (int l =0;l < 9; l++){
                returnLine++;
                System.out.print(grid[c][l]+ "|");
                if (returnLine == 9){
                    System.out.println("\n");
                    returnLine = 0;
                }
            }
        }
    }

    public void toMoreFault(){
        if (faute == 5){
            throw new RuntimeException("Vous avez fait trop erreur");
        }
    }

    @Override
    public String toString() {
        return "Sudoku{" +
                "grid=" + Arrays.deepToString(grid) +
                '}';
    }
}
