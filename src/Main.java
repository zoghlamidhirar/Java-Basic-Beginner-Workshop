
public class Main {
    public static void main(String[] args) {
        Etudiant3eme e1 = new Etudiant3eme(123, "Ben Foulen", "Foulen", 12.3f, "Math");
        Etudiant3eme e2 = new Etudiant3eme(123, "Ben Foulen", "Foulen", 12.3f, "Math");
        Etudiant3eme e3 = new Etudiant3eme(435, "Mahmoudi", "Karim", 16.5f, "Tech");
        Etudiant3eme e4 = new Etudiant3eme(657, "Ben Rebii", "Rahma", 10.7f, "Web");
        EtudiantAlternance e5 = new EtudiantAlternance(879, "Sifi", "Hichem", 19.2f, 1200);
        EtudiantAlternance e6 = new EtudiantAlternance(112, "Mrabet", "Ali", 14.6f, 700);
        Ecole ec = new Ecole("Esprit");
        Ecole ec2 = new Ecole("ISI");
        try {
            ec.ajouterEtudiant(e1);
        } catch (EtudiantExisteException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ec.ajouterEtudiant(e2);
        } catch (EtudiantExisteException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ec.ajouterEtudiant(e3);
        } catch (EtudiantExisteException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ec.ajouterEtudiant(e4);
        } catch (EtudiantExisteException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ec.ajouterEtudiant(e5);
        } catch (EtudiantExisteException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            ec.ajouterEtudiant(e6);
        } catch (EtudiantExisteException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(ec);
        System.out.println("-------------------------------------------------");
        e3.ajouterUneAbsence();
        System.out.println(e3);
        System.out.println("-------------------------------------------------");
        e5.ajouterUneAbsence();
        System.out.println(e5);
        System.out.println("-------------------------------------------------");
        System.out.println("Moyenne 3A: " + ec.getMoyenneDes3A());
        System.out.println("Moyenne salaire Alternants: " + ec.moyenneSalaireAlternants());
        System.out.println("-------------------------------------------------");
        ec.changerEcole(e6, ec2);
        System.out.println(ec);
        System.out.println("-------------------------------------------------");
        System.out.println(ec2);

    }

}
