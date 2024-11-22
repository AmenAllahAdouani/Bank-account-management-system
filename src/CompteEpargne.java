import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
public class CompteEpargne extends Compte {
    private double tauxInteret;
    private static final double SOLDE_MINIMUM = 10;

    public CompteEpargne(String rib, double solde, Date dateCreation, boolean etat, double tauxInteret) {
        super(rib, solde, dateCreation, etat);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public boolean retirer(double montant) {
        if (getSolde() - montant < SOLDE_MINIMUM) {
            return false;
        }
        return super.retirer(montant);
    }

    public void calculerInteret() {
        if (isEtat()) {
            setSolde(getSolde() + getSolde() * tauxInteret / 100);
        }
    }
}
