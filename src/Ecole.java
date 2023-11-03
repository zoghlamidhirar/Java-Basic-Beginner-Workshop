import java.util.ArrayList;
import java.util.List;
public class Ecole {
    private String NomEcole;
    public Etudiant[] etudiants;
    private int nbr_etudiants;

    public String getNomEcole() {
        return NomEcole;
    }

    public void setNomEcole(String nomEcole) {
        NomEcole = nomEcole;
    }

    public Ecole(String nomEcole) {
        NomEcole = nomEcole;
        this.etudiants = new Etudiant[500];
    }

    public int rechercherEtudiant(Etudiant e) {
        int i=0;
        while (etudiants[i]!=e && i<499){
            i++;
        }
        if (i<499) return i;
        else return -1;

        /*
        for (int i = 0; i < nbr_etudiants; i++) {
            if (etudiants[i].equals(e)) {
                return i;
            }
        }
        return -1;
         */
    }

    public boolean ajouterEtudiant(Etudiant e) throws EtudiantExisteException {

        /*
        int i=0;
        while (etudiants[i]!=e && i<500){
            i++;
        }
        if (i<500) {
            etudiants[i]=e;
            return true; //ajout effectué
        }
        else {
            System.out.println("Can't ADD!!!");
            return false;
        }
         */
        boolean test=false;
        int i;
        i = rechercherEtudiant(e);

        if (i == -1) {
            etudiants[nbr_etudiants] = e;
            nbr_etudiants++;
            test=true;
        } else {
            throw new EtudiantExisteException("Cet étudiant existe déjà");

        }
        return test;

        /*
        if (rechercherEtudiant(e) == -1) {
            etudiants[nbr_etudiants] = e;
            nbr_etudiants++;
        } else {
            throw new EtudiantExisteException("Cet étudiant existe déjà");
        }
         */
    }

    public float getMoyenneDes3A(){
        float total_moyennes=0;
        int somme=0;
        for(int i=0; i<500;i++){
            if (etudiants[i] instanceof Etudiant3eme E3A) {
                total_moyennes+=E3A.getMoyenne();
                somme++;
            }
        }
        return total_moyennes/somme;
        /*
          float moy_3A = 0;
        int nbr_etudiants_3A = 0;
        for (int i = 0; i < nbr_etudiants; i++) {
            if (etudiants[i] instanceof Etudiant3eme) {
                moy_3A += etudiants[i].moyenne;
                nbr_etudiants_3A++;
            }
        }
        return moy_3A / nbr_etudiants_3A;
         */
    }

    public float moyenneSalaireAlternants(){
        float total_salaire=0;
        int somme=0;
        for(int i=0; i<500;i++){
            if (etudiants[i] instanceof EtudiantAlternance EAL) {
                total_salaire+= EAL.getSalaire();
                somme++;
            }
        }
        float v = total_salaire / somme;
        return v;
    }

    // TODO 18 : redéfinir la méthode toString() permet de retourner le nom de l’école et les informations de tous les étudiants.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom: ").append(NomEcole).append(" - Etudiants: \n");
        for (int i = 0; i < 499; i++) {
            if (etudiants[i] != null) {
                sb.append(etudiants[i].toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void changerEcole(Etudiant etd, Ecole e){
        /*
        int i;

        if(-1!=rechercherEtudiant(etd)){

            //suppression de l etudiant de l ecole courante
            //ou bien tout simplement le rendre cette case à NULL .. pas besoin du décalage
            for (int j=rechercherEtudiant(etd); j<500;j++){
                etudiants[j]=etudiants[j+1];
            }
            etudiants[499]=null; //dimension du tableau fixe ..

            //ajout de cet etudiant à la nouvelle ecole
            int k=0;
            while(e.etudiants[k]!=etd && k<500) k++;

            if (k<500){
                System.out.println("can't ADD!!!!!");
            }else{
                e.etudiants[k]=etd;
            }

        }else{
            System.out.println("can't fiiinndd it !!!");
        }
         */
        int position = rechercherEtudiant(etd);
        if (position != -1) {
            try {
                e.ajouterEtudiant(etd);
            } catch (EtudiantExisteException ex) {
                System.out.println(ex.getMessage());
            }
            for (int i = position; i < 499; i++) {
                etudiants[i] = etudiants[i + 1];
                etudiants[499] = null;
            }
        } else {
            System.out.println("Cet étudiant n'éxiste pas");
        }

    }

    /*
    // TODO 22 : Modifier la méthode changerEcole(Etudiant etd, Ecole e) qui permet à un étudiant de changer son école.
public void changerEcole(Etudiant etd, Ecole e) {
        int position = rechercherEtudiant(etd);
        if (position != -1) {
            try {
                e.ajouterEtudiant(etd);
            } catch (EtudiantExisteException ex) {
                System.out.println(ex.getMessage());
            }
            for (int i = position; i < nbr_etudiants; i++) {
                etudiants[i] = etudiants[i + 1];
                etudiants[nbr_etudiants] = null;
                nbr_etudiants--;
            }
        } else {
            System.out.println("Cet étudiant n'éxiste pas");
        }
    }
     */


}
