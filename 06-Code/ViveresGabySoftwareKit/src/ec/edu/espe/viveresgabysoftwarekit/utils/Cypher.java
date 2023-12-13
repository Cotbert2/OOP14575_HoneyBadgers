package ec.edu.espe.viveresgabysoftwarekit.utils;

public class Cypher {

    private int cypherLevel = 0;
    public Cypher(int cypherLevel){
        this.cypherLevel = cypherLevel;
    }

        public String cypherMessage(String cadToCypher) {
            String cypherMessage = "";
            char[] letters = cadToCypher.toCharArray();
            for (char letter : letters) {
                letter += cypherLevel;
                cypherMessage += letter;
            }
            return cypherMessage;
        }

        public String decypherMessage(String cadToCypher) {
            String decypherMessage = "";
            char[] letters = cadToCypher.toCharArray();
            for (char letter : letters) {
                letter -= cypherLevel;
                decypherMessage += letter;
            }
            return decypherMessage;
        }
}
