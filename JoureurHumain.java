public class JoureurHumain {
    private  String prenom;
    
        public JoureurHumain (String prenom ){
            this.prenom = prenom;
    
        }
        public String getPrenom(){
               return prenom;
    }
    

    
        public void setPrenom(String prenom){
            this. prenom = prenom;
        }

        public  void affiche(){
            System.out.println("prenom : " + prenom);
        }



    
}
