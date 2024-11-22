import java.util.*;
import java.util.stream.Collectors;

public class Banque {
    private Map<String, Compte> comptes = new HashMap<>();

    public void ajouterCompte(Compte compte) {
        if (comptes.containsKey(compte.getRib())) {
            throw new IllegalArgumentException("Le RIB existe déjà.");
        }
        comptes.put(compte.getRib(), compte);
    }

    public Compte rechercherCompte(String rib) {
        return comptes.get(rib);
    }

    public void supprimerCompte(String rib) {
        comptes.remove(rib);
    }

    public boolean transferer(String ribSource, String ribCible, double montant) {
        Compte source = rechercherCompte(ribSource);
        Compte cible = rechercherCompte(ribCible);

        if (source == null || cible == null || !source.isEtat() || !cible.isEtat() || source.getSolde() < montant) {
            System.out.println("Transfert échoué.");
            return false;
        }

        source.retirer(montant);
        cible.deposer(montant);
        System.out.println("Transfert réussi.");
        return true;
    }

    public List<Compte> getComptesAvecSoldeNegatif() {
        return comptes.values().stream()
                .filter(compte -> compte.getSolde() < 0)
                .collect(Collectors.toList());
    }

    public List<CompteEpargne> getComptesEpargneRecents() {
        return comptes.values().stream()
                .filter(c -> c instanceof CompteEpargne)
                .map(c -> (CompteEpargne) c)
                .filter(c -> c.getDateCreation().getTime() > System.currentTimeMillis() - 3L * 365 * 24 * 60 * 60 * 1000)
                .collect(Collectors.toList());
    }

    public void afficherTousLesComptes() {
        comptes.values().forEach(System.out::println);
    }
}
