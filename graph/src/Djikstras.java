/*
 * 
 * nathan mccloud
 * t cormen introduction to algorithms p648
 * 
 */

package graph;
/* computes shortest paths between source vertex and all other vertices in a weighted graph G */
import java.util.HashSet;

class Djikstras {
	
	static final int INF=10000;
	
	static void printSet(HashSet<Vertex> fuck2)
	{
		for(Vertex v: fuck2)
			System.out.print(v.getLabel()+" ");
		System.out.println();	
	}

	private static Vertex minDistVertex(HashSet<Vertex> g)
	{
		int t=INF;
		Vertex min=null;
		for(Vertex v: g)
			if(v.getDist()<=t)/*<= to handle unreachable vertices*/
			{
				t=v.getDist();
				min=v;
			}
		g.remove(min);
		return min;
	}

	static void djikstras(MyGraph graph, Vertex source)
	{
		HashSet<Vertex> vset=new HashSet<Vertex>(graph.getVerts());
		graph.intializeSingleSource(source);

		while(!vset.isEmpty())
		{
			Vertex u=minDistVertex(vset);
			for(Vertex v: graph.getOutNeighbors(u))
					graph.relax(u,v);
		}
		
		graph.printDists(source);
		
	}

	public static void main(String[] args) {
		//test case
		 MyGraph graph=new MyGraph(true, true, 5);
		 
		 Vertex v0=new Vertex('s');
		 Vertex v1=new Vertex('t');
		 Vertex v2=new Vertex('y');
		 Vertex v3=new Vertex('z');
		 Vertex v4=new Vertex('x');
		 
		 graph.addVertex(v0);
		 graph.addVertex(v1);
		 graph.addVertex(v2);
		 graph.addVertex(v3);
		 graph.addVertex(v4);
		 
		 graph.addEdge(new Edge(v0,v1,10));
		 graph.addEdge(new Edge(v0,v2,5));
		 graph.addEdge(new Edge(v1,v2,2));
		 graph.addEdge(new Edge(v1,v4,1));
		 graph.addEdge(new Edge(v2,v1,3));
		 graph.addEdge(new Edge(v2,v3,2));
		 graph.addEdge(new Edge(v2,v4,9));
		 graph.addEdge(new Edge(v3,v0,7));
		 graph.addEdge(new Edge(v3,v4,6));
		 graph.addEdge(new Edge(v4,v3,4));


		 //graph.makeunDirected();
		 //graph.makeUnweighted();
		 djikstras(graph, v0);
		 
		// graph.printVerts();
		// graph.printEdges();

	}

}
