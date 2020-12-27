//Author Cesar Augusto Rodriguez
public class Vecteur {
    private double[] value = new double[0];
    private int ind;

    public Vecteur(double[] elements) {

        int Tama = elements.length;
        double [] tp = new double [Tama];
        for(int i=0; i<Tama; i++){

            tp[i]=elements[i];
        }
        this.value = tp;
    }
    /**
     * Permet de changer la valeur à l'index donné (commence à 0,
     * comme dans un tableau)
     *
     * */
    public void setElement(int index, double valeur) {

                this.value[index] = valeur;
    }
    /**
     *  Retourne la valeur à l'index demandé
     *
     * */
    public double getElement(int index) {
        this.ind = index;
        return this.value[ind];
    }
    /**
     * Calcule le produit scalaire avec un autre vecteur
     *
     * */
    public double dotProduct(Vecteur v) {
        if(value.length == v.value.length ){
          double subtotal = 0;
            for (int i = 0; i < value.length; i += 2) {

                if (i == value.length - 1) {
                    subtotal += (v.getElement(i) * value[i]);
                } else {
                    subtotal += (v.getElement(i) * value[i]) + (v.getElement(i + 1) * value[i + 1]);
                }
            }
            return subtotal; }
        else
            System.err.println("Erreur dans les dimensions des vecteurs");
        return Double.NaN;

    };
    /**
     * Affiche le contenu du vecteur
     * */
    public void afficher() {
        String concat = "{";
        for (int i = 0; i < value.length; i++) {

            concat = concat + String.valueOf(value[i]);
            if (i < this.value.length - 1) {
                concat = concat + ", ";
            }
        }
        System.out.println(concat + "}");
    };
}