package serveur;

public class Serveur {
    private static Serveur serveur;

    public static Serveur getInstance() {
        if(serveur == null) serveur = new Serveur();
        return serveur;
    }

    private Serveur() {
    }

    public  void start() {
        AppServeur appServeur = new TomcatServeur();
        appServeur.create();
        appServeur.configure();
        appServeur.start();
    }
}
