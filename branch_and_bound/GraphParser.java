package branch_and_bound;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GraphParser{
    private List<City> villes;
    private List<Edge> graph;

    public GraphParser() {
        this.villes = new ArrayList<>();
        try {
            FileReader file = new FileReader("us_capitals.txt");
            StringBuilder ligne;
            for (int i=1; i<=48; i++) {
                ligne = new StringBuilder(11);
                char c = (char)file.read();

                while (c!='\n') {
                    ligne.append(c);
                    c = (char)file.read();
                }

                int id = Integer.parseInt(ligne.substring(0,1));
                int sep = ligne.lastIndexOf(" ");
                int x = Integer.parseInt(ligne.substring(2,sep));
                int y = Integer.parseInt(ligne.substring(sep+1));

                this.villes.add(new City(id, x, y));
            }

            for (City c1 : this.villes) {
                for (City c2 : this.villes) {
                    if (c1 != c2) {
                        this.graph.add(new Edge(c1.id, c2.id, Math.sqrt(Math.pow(c1.x - c2.x,2) + Math.pow(c1.y - c2.y,2))));
                    }
                }
            }
            file.close();
        } catch(Exception e) {
            System.out.println("Error detected: File");
        }
    }

    public List<Edge> getEdges() {
        List<Edge> out = new ArrayList<>();
        out.addAll(this.graph); 
        return out;
    }
    

}
