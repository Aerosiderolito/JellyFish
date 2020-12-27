//Author Cesar Augusto Rodriguez
public class Matrice {
    private double[][] Matrix;
    private double init = 0;
    /**
     * constructeur d'une matrice de dimension lignes X cols
     * */
    public Matrice(int lignes, int cols) {
        double[][] tempoMatrix = new double[lignes][cols];
        if (lignes != 0) {
            for (int i = 0; i < lignes; i++) {

                for (int j = 0; j < cols; j++) {

                    tempoMatrix[i][j] = init;

                }
            }
            this.Matrix = tempoMatrix;
        } else {
            for (int i = 0; i < cols; i++) {
                tempoMatrix[0][i] = init;
                this.Matrix = tempoMatrix;
            }

        }
    }
    /**
     * fonction pour additioner un scalaire a chaque element de la matrice
     *
     * */

    public void additionnerScalaire(double n) {

        for (int i = 0; i < Matrix.length; i++) {

            for (int j = 0; j < Matrix[0].length; j++) {

                Matrix[i][j] = Matrix[i][j] + n;

            }

        }
    }
    /**
     * fonction permettant de multiplier chaque element par un constate
     *
     * */

    public void multiplierScalaire(double n) {

        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {

                Matrix[i][j] = Matrix[i][j] * n;
            }
        }
    }
    /**
     * fonction permettant de faire un produit scalaire de matrices
     *
     * */
    public Matrice dotProduct(Matrice m) {
        int colSizeM2 = m.Matrix[0].length;
        int lineSizeM2 = m.Matrix.length;
        int colSize = Matrix[0].length;
        int lineSize = Matrix.length;

        if (colSize == lineSizeM2) {

            double[][] arr = new double[lineSize][colSizeM2];
            Matrice tempo = new Matrice(lineSize, colSizeM2);

            for (int i = 0; i < lineSize; i++) {
                for (int j = 0; j < colSizeM2; j++) {
                    for (int l = 0; l < colSize; l++) {

                        arr[i][j] += ((getCell(i, l)) * (m.getCell(l, j)));
                    }

                }

            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    tempo.setCell(i, j, arr[i][j]);
                }
            }
            return tempo;
        } else {
            System.err.println("Erreur dans les dimensions des matrices");
            return null;
        }

    }
    /**
     *fonction returnant une cellule(ligne,colonne) donne en parametres
     *
     **/
    public double getCell(int ligne, int col) {
        return Matrix[ligne][col];
    }
    /**
     * place un valeur donne de la celulle
     *
     * */

    public void setCell(int ligne, int col, double valeur) {
        Matrix[ligne][col] = valeur;

    }
    /**
     * permet d'acceder a une ligne
     *
     * */
    public Vecteur getLine(int ligne) {

        double[] temp = Matrix[ligne];
        Vecteur agua = new Vecteur(temp);
        return agua;
    }
    /**
     * Permet d'acceder a une colonne
     *
     * */
    public Vecteur getCol(int col) {
        int lineSize = Matrix.length;
        double[] fuego = new double[Matrix.length];
        for (int i = 0; i < lineSize; i++) {

            fuego[i] = getCell(i, col);
        }

        Vecteur colo = new Vecteur(fuego);


        return colo;
    }
    /**
     * processus permettant d'afficher une matrice
     * **/

    public void afficher() {

        int colSize = Matrix[0].length;
        int lineSize = Matrix.length;

        for (int i = 0; i < lineSize; i++) {
            String temp = "";
            for (int j = 0; j < colSize; j++) {

                temp = temp + " " + toString().valueOf(getCell(i, j));

            }
            System.out.println("[" + temp + " ]");
        }
    }
    /**
     * fonction returnant une matrice transposee
     * **/
    public Matrice transpose() {
        int colSize = Matrix[0].length;
        int lineSize = Matrix.length;
        Matrice owo = new Matrice(colSize, lineSize);
        double[][] newCol = new double[colSize][lineSize];
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < lineSize; j++) {
                newCol[i][j] = Matrix[j][i];
                owo.setCell(i, j, newCol[i][j]);
            }
        }

        return owo;
    }
    /**
     * returne une matrice identite de taille n
     *
     * **/
    public static Matrice identite(int n) {

        Matrice ident = new Matrice(n, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    ident.setCell(i, j, 1);
                } else
                    ident.setCell(i, j, 0);
            }
        }
        return ident;
    }
}