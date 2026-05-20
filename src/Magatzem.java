class Magatzem {
    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
            Article art = articles[i];

            // 1. Clàusula de salvaguarda: El Martell no canvia mai
            if (art.nom.equals("Martell de Thor (Llegendari)")) {
                continue;
            }

            // 2. Gestionar la Qualitat segons el tipus d'article
            if (art.nom.equals("Formatge Gidurat")) {
                if (art.qualitat < 50) art.qualitat++;
            } else if (art.nom.equals("Entrades per al Concert del Trobador")) {
                actualitzarEntrades(art);
            } else {
                if (art.qualitat > 0) art.qualitat--;
            }

            // 3. Decrementar els dies per vendre
            art.diesPerVendre--;

            // 4. Lògica extra si l'article ha caducat
            if (art.diesPerVendre < 0) {
                gestionarCaducitat(art);
            }
        }
    }

    private void actualitzarEntrades(Article art) {
        if (art.qualitat < 50) {
            art.qualitat++;
            if (art.diesPerVendre < 11 && art.qualitat < 50) art.qualitat++;
            if (art.diesPerVendre < 6 && art.qualitat < 50) art.qualitat++;
        }
    }

    private void gestionarCaducitat(Article art) {
        if (art.nom.equals("Formatge Gidurat")) {
            if (art.qualitat < 50) art.qualitat++;
        } else if (art.nom.equals("Entrades per al Concert del Trobador")) {
            art.qualitat = 0;
        } else {
            if (art.qualitat > 0) art.qualitat--;
        }
    }
}