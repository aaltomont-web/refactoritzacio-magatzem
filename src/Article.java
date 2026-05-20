public class Article {
    public String nom;
    public int diesPerVendre;
    public int qualitat;
    
 // Modificació de prova per a la neteja del codi

    public Article(String nom, int diesPerVendre, int qualitat) {
        this.nom = nom;
        this.diesPerVendre = diesPerVendre;
        this.qualitat = qualitat;
    }

    @Override
    public String toString() {
        return this.nom + ", " + this.diesPerVendre + ", " + this.qualitat;
    }
}