import java.io.Serializable;

public class Score  implements Serializable {
    private int score;
    private String nom;

    public int getScore() {
        return score;
    }

    public String getNom() {
        return nom;
    }

    public Score(String nom, int score) {
        this.score = score;
        this.nom = nom;
    }
}
