package graphs.undirectedgraphs;

public class undirectedgraph {

    /*
        Types of data structures for Matrix:

                            Is Edge ?       List Edge       List Numbers

        Adjacent Matrix - V x V matrix

        Edge List - List of all edges - (A,B) (A,C) (C,D)

        Adjacency List - Each vertex with a list of neighbors -> A to B, D

        Runtime for Graphs:
        Linear Time = O(|V| * |E|)
        Dense Graphs: |E| = |V| ^ 2
        Sparse Graphs: |E| = |V|
     */
    /*
        Explore(v) {
            visited(v) = true;
            for(v, w) that are edges {
                if(!visited(w)) {

                }
            }
        }

        DFS(Graph) {
            for all v of V {
                mark as unvisited
            }
            connectedComponents = 1
            for all v of V {
                if not visited(v) {
                    // ***Explore start - Explore(v)***
                    visited(V) = true
                    PREVISITFUNCTION(V)
                    connectedComponents(V) = connectedComponents
                    for(all edges from V) {
                        if(other end of E not visited) {
                            explore(other end)
                        }
                    }
                    POSTVISITFUNCTION(V)
                    connectedComponents = connectedComponents + 1
                    // ***Explore end***
                }
            }
        }

        PREVISITFUNCTION(V) { pre(V) = clock; clock++; }
        POSTVISITFUNCTION(V) { post(V) = clock; clock++; }

        Components(Graph) {
            DiscoveredNodes = {S}
            while (there is an edge 'e' leaving and unexplored) {
                add end of 'e' vertex to Discovered nodes
            }
            return DiscoveredNodes;
        }
    */
}
