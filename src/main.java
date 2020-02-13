import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PenduAffichage penduAffichage = new PenduAffichage();
        Pendu pendu = new Pendu();


        while(!pendu.ChargerFichierMots("D:\\Cegep\\Session_6\\Tutorat\\MarieClaire\\TP1\\Mots.txt")){
            System.out.println("Chargement des mots...");
        }


        while(true) {
            pendu.ChoisirMot();
            pendu.setPartiesCorps((byte) 0);

            do {
                System.out.println("Jeu du pendu:      Gagnees:" + pendu.getNbPartiesGagnees() + " Perdues:" + pendu.getNbPartiesPerdues());
                System.out.println(penduAffichage.getAffichage(pendu.getPartiesCorps()));
                System.out.println("Mot a trouver: " + pendu.getMotActuel());
                System.out.println("Lettre restante:" + pendu.getLettresRestantes());
                System.out.println("Lettre demande:" + pendu.getLettresDemandees());
                System.out.println("Entrez une lettre ou le mot que vous pensez avoir trouve");
                String userInput = reader.readLine();

                if (userInput.length() > 1) {
                    if (!pendu.ValiderMot(userInput)) {
                        pendu.setPartiesCorps((byte) (pendu.getPartiesCorps() + 1));
                        System.out.println("Pas le bon mot ! Appuyer ENTRER pour continuer");
                        reader.readLine();
                    }
                } else {
                    if (!pendu.ValiderLettre(userInput.charAt(0))) {
                        pendu.setPartiesCorps((byte) (pendu.getPartiesCorps() + 1));
                    }
                }
                //Runtime.getRuntime().exec("cls");

            } while (pendu.getEtatPartie() == Pendu.EtatsPartie.EnCours);

            if(pendu.getEtatPartie() == Pendu.EtatsPartie.Gagnant){
                pendu.setNbPartiesGagnees(pendu.getNbPartiesGagnees() + 1);
                System.out.println("Jeu du pendu:      Gagnees:" + pendu.getNbPartiesGagnees() + " Perdues:" + pendu.getNbPartiesPerdues());
                System.out.println(penduAffichage.getAffichage(pendu.getPartiesCorps()));
                System.out.println("Mot a trouver: " + pendu.getMotActuel());
                System.out.println("Lettre restante:" + pendu.getLettresRestantes());
                System.out.println("Lettre demande:" + pendu.getLettresDemandees());
                System.out.println("Bravo! Vous avec trouvé le bon mot.");
                System.out.println("Voulez-vous recommencer (o/n)?");

                boolean choixValide = false;
                do{
                    String userInput = reader.readLine();
                    if(userInput.toLowerCase().equals("o")){
                        choixValide = true;
                        pendu.setEtatPartie(Pendu.EtatsPartie.EnCours);
                        continue;
                    }
                    else if(userInput.toLowerCase().equals("n")){
                        choixValide = true;
                        System.exit(0);
                    }
                    System.out.println("Veuillez entrer un bon choix (o/n)");
                }while (!choixValide);
            }
            else if (pendu.getEtatPartie() == Pendu.EtatsPartie.Perdu){
                pendu.setNbPartiesPerdues(pendu.getNbPartiesPerdues() + 1);
                System.out.println("Jeu du pendu:      Gagnees:" + pendu.getNbPartiesGagnees() + " Perdues:" + pendu.getNbPartiesPerdues());
                System.out.println(penduAffichage.getAffichage(pendu.getPartiesCorps()));
                System.out.println("Mot a trouver: " + pendu.getMotActuel());
                System.out.println("Lettre restante:" + pendu.getLettresRestantes());
                System.out.println("Lettre demande:" + pendu.getLettresDemandees());
                System.out.println("Partie perdue! Le nombre d'essais a ete atteint");
                System.out.println("Le mot etait : " + pendu.getReponse());
                System.out.println("Voulez-vous recommencer (o/n)?");

                boolean choixValide = false;
                do{
                    String userInput = reader.readLine();
                    if(userInput.toLowerCase().equals("o")){
                        choixValide = true;
                        pendu.setEtatPartie(Pendu.EtatsPartie.EnCours);
                        continue;
                    }
                    else if(userInput.toLowerCase().equals("n")){
                        choixValide = true;
                        System.exit(0);
                    }
                    System.out.println("Veuillez entrer un bon choix (o/n)");
                }while (!choixValide);

            }
        }
    }
}
