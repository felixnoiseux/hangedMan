import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pendu {

     enum EtatsPartie {
        EnCours,
        Perdu,
        Gagnant
    }

    char[] _acMotActuel;
    List<Character> _lettresDemandees = new ArrayList<>();
    List<String> _mots = new ArrayList<>();
    Random _rnd = new Random();

    //region Proprietes

    EtatsPartie etatPartie = EtatsPartie.EnCours;
    String lettresDemandees;
    String lettresRestantes = "abcdefghijklmnopqrstuvwxyz";
    String motActuel;
    int nbPartiesGagnees = 0;
    int nbPartiesPerdues = 0;
    byte partiesCorps = 0;
    String reponse;

    public EtatsPartie getEtatPartie(){
        return etatPartie;
    }
    public void setEtatPartie(EtatsPartie nouvelEtat){
        this.etatPartie = nouvelEtat;
    }
    public String getLettresDemandees(){

        String lettreDemande = "";
        for(int i = 0; i < _lettresDemandees.size(); i++)
        {
            lettreDemande += _lettresDemandees.get(i);
        }
        lettresDemandees = lettreDemande;
        return lettresDemandees;
    }
    public String getLettresRestantes(){
        for(int i = 0; i < this.lettresRestantes.length(); i++){

            for(int ii = 0; ii < this._lettresDemandees.size(); ii++){
                if(this.lettresRestantes.charAt(i) == _lettresDemandees.get(ii)){
                    String replaceString = this.lettresRestantes.replace(this.lettresRestantes.charAt(i), '_');
                    this.lettresRestantes = replaceString;
                }
            }

        }
        return lettresRestantes;
    }
    public void setLettresRestantes(String nouvelLettres){
        this.lettresRestantes = nouvelLettres;
    }
    public String getMotActuel(){

        motActuel = "";
        for(int i = 0; i < _acMotActuel.length; i++){
            motActuel += _acMotActuel[i] + " ";
        }

        return motActuel;
    }
    public int getNbPartiesGagnees(){
        return  nbPartiesGagnees;
    }
    public void setNbPartiesGagnees(int nouvelPartiesGagnees){
        this.nbPartiesGagnees = nouvelPartiesGagnees;
    }
    public int getNbPartiesPerdues(){
        return  nbPartiesPerdues;
    }
    public void setNbPartiesPerdues(int nouvelPartiesPerdues){
        this.nbPartiesPerdues = nouvelPartiesPerdues;
    }
    public byte getPartiesCorps(){
        return partiesCorps;
    }
    public void setPartiesCorps(byte nouveauNb){
        this.partiesCorps = nouveauNb;
    }
    public String getReponse(){
        return reponse;
    }
    public void setReponse(String nouvelleReponse){
        this.reponse = nouvelleReponse;
    }
    //endregion

    //region Methodes

    private void VerifierFinPartie(){
        String reponseUtilisateur = new String(_acMotActuel);
        if(reponseUtilisateur.equals(reponse)){
            etatPartie = EtatsPartie.Gagnant;
        }
        else if(getPartiesCorps() == (byte)6){
            etatPartie = EtatsPartie.Perdu;
        }
    }

    public boolean ChargerFichierMots(String nomFichier){
        try {
            File myObj = new File(nomFichier);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                _mots.add(data);
            }
            myReader.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
    public void ChoisirMot(){
        //Choisir mot
        this.reponse = _mots.get(_rnd.nextInt(_mots.size()));

        //Afficher Reponse pour test
        System.out.println(this.reponse);

        //Definir mot Actuel
        _acMotActuel = new char[this.reponse.length()];

        for(int i = 0; i < this.reponse.length(); i++){
            _acMotActuel[i] = '_';
        }
    }
    private String ConvertirTableauString(char[] acTableau){
        return "";
    }
    public  boolean ValiderLettre(char cLettre){


        //Nettoyage de la lettre
        String sLettre = Character.toString(cLettre);
        sLettre = sLettre.toLowerCase();
        sLettre = sLettre.replaceAll("[èéêë]","e");
        sLettre = sLettre.replaceAll("[ûù]","u");
        sLettre = sLettre.replaceAll("[ïî]","i");
        sLettre = sLettre.replaceAll("[àâ]","a");
        sLettre = sLettre.replaceAll("ô","o");
        cLettre = sLettre.charAt(0);


        if(_lettresDemandees.contains(cLettre)){
            return true;
        }
        else{
            boolean estBonneLettre = false;
            _lettresDemandees.add(cLettre);

            for(int i = 0; i < reponse.length(); i++){

                //Nettoyage de la reponse
                String reponseNettoye = reponse.toLowerCase();
                reponseNettoye = reponseNettoye.replaceAll("[èéêë]","e");
                reponseNettoye = reponseNettoye.replaceAll("[ûù]","u");
                reponseNettoye = reponseNettoye.replaceAll("[ïî]","i");
                reponseNettoye = reponseNettoye.replaceAll("[àâ]","a");
                reponseNettoye = reponseNettoye.replaceAll("ô","o");

                if(reponseNettoye.charAt(i) == cLettre){
                    String replaceString = this.lettresRestantes.replace(cLettre,'_');
                    this.lettresRestantes = replaceString;

                    _acMotActuel[i] = reponse.charAt(i);

                    estBonneLettre = true;
                }
            }

            if(estBonneLettre){
                VerifierFinPartie();
                return true;
            }
        }

        VerifierFinPartie();
        return false;
    }
    public boolean ValiderMot(String mot){

        if(mot.equals("QUITTER")){
            System.exit(0);
        }
        //Nettoyage du mot;
        mot = mot.toLowerCase();
        mot = mot.replaceAll("[èéêë]","e");
        mot = mot.replaceAll("[ûù]","u");
        mot = mot.replaceAll("[ïî]","i");
        mot = mot.replaceAll("[àâ]","a");
        mot = mot.replaceAll("ô","o");

        //Nettoyage de la reponse
        String reponseNettoye = reponse.toLowerCase();
        reponseNettoye = reponseNettoye.replaceAll("[èéêë]","e");
        reponseNettoye = reponseNettoye.replaceAll("[ûù]","u");
        reponseNettoye = reponseNettoye.replaceAll("[ïî]","i");
        reponseNettoye = reponseNettoye.replaceAll("[àâ]","a");
        reponseNettoye = reponseNettoye.replaceAll("ô","o");

        if(mot.equals(reponseNettoye)){
            _acMotActuel = reponse.toCharArray();
            VerifierFinPartie();
            return true;
        }


        return false;
    }
    //endregion
}
