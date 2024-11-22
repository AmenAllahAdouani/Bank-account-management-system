import lombok.ToString;

import java.util.Date;

@ToString(callSuper = true)
public class CompteCourant extends Compte {
    private static final double SOLDE_MINIMUM = -900;

    public CompteCourant(String rib, double solde, Date dateCreation, boolean etat) {
        super(rib, solde, dateCreation, etat);
    }

    @Override
    public boolean retirer(double montant) {
        if (getSolde() - montant < SOLDE_MINIMUM) {
            return false;
        }
        return super.retirer(montant);
    }
}

