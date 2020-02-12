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

    EtatsPartie etatPartie;
    String lettresDemandees;
    String lettresRestantes;
    String motActuel;
    int nbPartiesGagnees;
    int nbPartiesPerdues;
    byte partiesCorps;
    String reponse;

    public EtatsPartie getEtatPartie(){
        return etatPartie;
    }
    public void setEtatPartie(EtatsPartie nouvelEtat){
        this.etatPartie = nouvelEtat;
    }
    public String getLettresDemandees(){

        this.lettresDemandees = _lettresDemandees.toString();
        return lettresDemandees;
    }
    public String getLettresRestantes(){
        this.lettresRestantes = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < this.lettresRestantes.length(); i++){

            for(int ii = 0; ii < this._lettresDemandees.size(); i++){
                if(this.lettresRestantes.charAt(i) == _lettresDemandees.get(ii)){
                    this.lettresRestantes.replace(this.lettresRestantes.charAt(i), '_');
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
        return false;
    }
    public boolean ValiderMot(String mot){
        return false;
    }
    //endregion
}
