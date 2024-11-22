import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    private String rib;
    private double solde;
    private Date dateCreation;
    private boolean etat;

    public void deposer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif.");
        }
        solde += montant;
    }

    public boolean retirer(double montant) {
        if (!etat || montant <= 0) {
            return false;
        }
        solde -= montant;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return Objects.equals(rib, compte.rib);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rib);
    }
}
