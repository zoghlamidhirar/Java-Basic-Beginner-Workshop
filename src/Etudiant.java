import java.util.Objects;

public abstract class Etudiant {
    protected int id;
    protected String nom;
    protected String prenom;
    protected float moyenne;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public float getMoyenne() {
        return moyenne;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public Etudiant(int id, String nom, String prenom, float moyenne) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Etudiant) {
            Etudiant e = (Etudiant) o;
            if (e.getNom().equals(this.nom) && e.getId() == this.id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getPrenom(), getMoyenne());
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + moyenne +
                '}';
    }

    public abstract void ajouterUneAbsence();



}
