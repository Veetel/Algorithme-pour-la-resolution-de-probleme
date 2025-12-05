package roadTrip;
import java.io.Filereader;
import java.lang.StringBuilder;


public class GraphParser{
    private List<City> villes;
    private List<Edge> graph;

    public GraphParser() {
        this.villes = new ArrayList<>();
        Filereader file = new Filereader("us_capitals.txt");
        StringBuilder ligne;
        for (int i=1; i<=48; i++) {
            ligne = new StringBuilder(11);
            char c = file.read();

            while (c!='\n') {
                ligne.append(c);
                c = file.read();
            }

            int id = Integer.ParseInt(ligne.subSequence(0,1));
            int sep = ligne.lastIndexOf(" ");
            int x = Integer.ParseInt(ligne.subSequence(2,sep));
            int y = Integer.ParseInt(ligne.subString(sep+1));

            this.villes.add(new City(id, x, y));
        }

        for (City c1 : this.villes) {
            for (City c2 : this.villes) {
                if (c1 != c2) {
                    this.graph.add(new Edge(c1, c2, Math.sqrt(Math.pow(c1.x − c2.x,2) + Math.pow(c1.y − c2.y,2))));
                }
            }
        }
    }

    public List<Edge> getEdges() {
        return this.graph;
    }
    

    private Class City{
        int id;
        int x;
        int y;

        public City(int i, int x, int y) {
            this.id = i;
            this.x = x;
            this.y = y;
        }
    }
}