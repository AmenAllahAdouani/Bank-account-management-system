import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque();

        // Création lil les comptes
        CompteCourant cc1 = new CompteCourant("123", 1000, new Date(), true);
        CompteCourant cc2 = new CompteCourant("124", -800, new Date(), true);
        CompteEpargne ce1 = new CompteEpargne("456", 2000, new Date(), true, 3);

        // Ajout lil les comptes fl banque
        banque.ajouterCompte(cc1);
        banque.ajouterCompte(cc2);
        banque.ajouterCompte(ce1);

        // Affichage lil les comptes lkol
        System.out.println("Tous les comptes :");
        banque.afficherTousLesComptes();

        // Opérations
        cc1.deposer(500);
        System.out.println("Après dépôt sur le compte 123 :");
        banque.afficherTousLesComptes();

        cc1.retirer(300);
        System.out.println("Après retrait sur le compte 123 :");
        banque.afficherTousLesComptes();

        ce1.calculerInteret();
        System.out.println("Après calcul des intérêts sur le compte 456 :");
        banque.afficherTousLesComptes();

        // Transfert mabin les comptes
        banque.transferer("123", "124", 1000);
        System.out.println("Après transfert de 1000 de 123 à 124 :");
        banque.afficherTousLesComptes();

        // les comptes li fl rouge
        System.out.println("Comptes avec solde négatif :");
        banque.getComptesAvecSoldeNegatif().forEach(System.out::println);
    }
}
