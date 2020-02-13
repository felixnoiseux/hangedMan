import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pendu pendu = new Pendu();
        PenduAffichage penduAffichage = new PenduAffichage();

        while(!pendu.ChargerFichierMots("D:\\Cegep\\Session_6\\Tutorat\\MarieClaire\\TP1\\Mots.txt")){
            System.out.println("Chargement des mots...");
        }


        pendu.ChoisirMot();
        pendu.setNbPartiesGagnees(0);
        pendu.setNbPartiesPerdues(0);
        pendu.setPartiesCorps((byte)0);

        do{
            System.out.println("Jeu du pendu:      Gagnees:" + pendu.getNbPartiesGagnees() + " Perdues:" + pendu.getNbPartiesPerdues() );

            //Afficher Pendu


            System.out.println(penduAffichage.getAffichage(pendu.getPartiesCorps()));
            System.out.println("Mot a trouver: " + pendu.getMotActuel());
            System.out.println("Lettre restante:" + pendu.getLettresRestantes());
            System.out.println("Lettre demande:" + pendu.getLettresDemandees());
            System.out.println("Entrez une lettre ou le mot que vous pensez avoir trouve");
            String userInput = reader.readLine();

            if(userInput.length() > 1){
                if(!pendu.ValiderMot(userInput)){
                    pendu.setPartiesCorps((byte)(pendu.getPartiesCorps() + 1));
                }
            }
            else{
                if(!pendu.ValiderLettre(userInput.charAt(0))){
                    pendu.setPartiesCorps((byte)(pendu.getPartiesCorps() + 1));
                }
            }

        }while (pendu.getEtatPartie() != Pendu.EtatsPartie.EnCours);


        System.out.println("Vous avez quitte le jeu");
        System.out.println(pendu.getReponse());
    }


}
