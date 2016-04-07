package smallworld;

import edu.princeton.cs.StdDraw;
import edu.princeton.cs.StdOut;
import java.awt.Color;
import java.util.Stack;

public class AllPaths<Vertex> {

    private Stack<String> path  = new Stack<String>();   // the current path
    private SET<String> onPath  = new SET<String>();     // the set of vertices on the path

    public AllPaths(Graph G, String s, String t) {
        enumerate(G, s, t);
    }
    
    
    
    // use DFS
    private void enumerate(Graph G, String v, String t) {

        // add node v to current path from s
        path.push(v);
        onPath.add(v);

        // found path from s to t - currently prints in reverse order because of stack
        if (v.equals(t)) 
            StdOut.println(path);

        // consider all neighbors that would continue path with repeating a node
        else {
            for (String w : G.adjacentTo(v)) {
                if (!onPath.contains(w)) enumerate(G, w, t);
            }
        }

        // done exploring from v, so remove from path
        path.pop();
        onPath.delete(v);
    }

    public static void main(String[] args) {
        Graph G = new Graph();
        G.addEdge("Eagle","Snake");
        G.addEdge("Snake","Mice");
        G.addEdge("Mice","Grasshopper");
        G.addEdge("Grasshopper","Grass");
        G.addEdge("Eagle","Fungi");
        G.addEdge("Sun","Grass");
        G.addEdge("Snake","Grasshopper");
        G.addEdge("Mice","Grass");
        G.addEdge("Fungi","Grasshopper");
        G.addEdge("Fungi","Grass");
        G.addEdge("Fungi", "Mice");
        G.addEdge("Eagle","Mice");
        G.addEdge("Eagle","Grasshopper");

        

StdOut.println(G);
        //new AllPaths(G, "A", "G");
        StdOut.println();
        //new AllPaths(G, "B", "F");
        
        APframe apf = new APframe(G);
        //apf.setVisible(true);
        
    }

}