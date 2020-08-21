/*
 * 
 * nathan mccloud
 * https://en.wikipedia.org/wiki/Topological_sorting
 * (Kahn's Algorithm)
 * 
 */

package graph;
/* computes and returns a random topological sorting of a given directed graph, ie a linear 
 * ordering of vertices in which for every directed edge ij, 
 * i comes before j in the ordering*/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TopSort {
	
	 //TODO:
	/* return a set of every possible topological ordering of a given graph,
	 * as well as whether it is unique/forms a Hamiltonian path
	 */
	static List<Vertex> topSort(MyGraph g)
	{
		Random rand = new Random();
		//set of all possible topological ordering
		//Set<Queue<Vertex>> orderings = new HashSet<Queue<Vertex>>();
		
		//list of sorted vertices
		List<Vertex> sortedList = new ArrayList<Vertex>(g.getVertSize());
		System.out.println(g.getVertSize());
		
		//list of nodes(vertices) with no incoming edge
		List<Vertex> startVerts = new ArrayList<Vertex>(g.getVerts()); 
		
		//finding it this way should
		//preserve linear time complexity
		for(Edge e: g.getEdges())
			if(startVerts.contains(e.getDest()))
				startVerts.remove(e.getDest());
		
		//for(Vertex v: startVerts)
		//	System.out.println(v.getLabel());
		
		while(!startVerts.isEmpty())
		{
			int r = rand.nextInt(startVerts.size());
			//System.out.println("r: " + r);
			Vertex v = startVerts.remove(r);
			sortedList.add(v);
			for(Vertex n: g.getOutNeighbors(v))
			{
				g.removeEdge(v, n);
				if(n.preSize() == 0)
					startVerts.add(n);
			}
		}
		if(!g.getEdges().isEmpty()){
			System.out.println("Detected a cycle");
			g.printEdges();
			return null; //custom exception?
		}
		
		return sortedList;
	}
	
	
	public static void main(String[] args)
	{
		MyGraph graph = new MyGraph(true, false, 8);
		
		Vertex v0 = new Vertex('5');
		Vertex v1 = new Vertex('2');
		Vertex v2 = new Vertex('0');
		Vertex v3 = new Vertex('4');
		Vertex v4 = new Vertex('1');
		Vertex v5 = new Vertex('3');
		
		graph.addEdge(new Edge(v0, v1));
		graph.addEdge(new Edge(v0, v2));
		graph.addEdge(new Edge(v3, v2));
		graph.addEdge(new Edge(v3, v4));
		graph.addEdge(new Edge(v1, v5));
		graph.addEdge(new Edge(v5, v4));
		List<Vertex> vList = topSort(graph);

		System.out.println("Sorted Vertices:");
		for(Vertex v:vList)
			System.out.println(v.getLabel());
	}

}
