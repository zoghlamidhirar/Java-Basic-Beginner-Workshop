public class EtudiantAlternance extends Etudiant{
    private float salaire;

    public EtudiantAlternance(int id, String nom, String prenom, float moyenne, float salaire) {
        super(id, nom, prenom, moyenne);
        this.salaire = salaire;

    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public void ajouterUneAbsence(){
        this.salaire-=50;
    }

    //TODO 11:redéfinir la méthode toString() de la classe EtudiantAlternance.
    @Override
    public String toString() {
        return super.toString() + " Salaire= " + salaire;
    }
}
