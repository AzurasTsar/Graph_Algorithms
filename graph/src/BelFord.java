/*
 * 
 * nathan mccloud
 * t cormen introduction to algorithms p651
 * 
 */

package graph;
/* computes shortest paths between source vertex and all other 
 * vertices in a weighted graph G, allows for negative edge weights but not negative cycles */
class BelFord {
	
	static boolean bellmanFord(MyGraph g, Vertex source)
	{
		g.intializeSingleSource(source);
		for(int i=0; i<g.getVertSize(); i++)
			for(Edge e: g.getEdges())
				g.relax(e);
		for(Edge e: g.getEdges())
			if(e.getDest().getDist()>(e.getSource().getDist()+e.getWeight()))
			{
				System.out.println("Negative-Weight Cycle Detected");
				return false;
			}
		g.printDists(source);
		return true;
	}
	
	
	public static void main(String[] args){
		 //test case
		 MyGraph graph=new MyGraph(true,true,5);
		 
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
		 
		 graph.addEdge(new Edge(v0,v1,6));
		 graph.addEdge(new Edge(v0,v2,7));
		 graph.addEdge(new Edge(v1,v2,8));
		 graph.addEdge(new Edge(v1,v3,-4));
		 graph.addEdge(new Edge(v1,v4,5)); 
		 graph.addEdge(new Edge(v2,v3,9));
		 graph.addEdge(new Edge(v2,v4,-3));
		 graph.addEdge(new Edge(v3,v0,2));
		 graph.addEdge(new Edge(v3,v4,7));
		 graph.addEdge(new Edge(v4,v1,-2));
		 System.out.println("Testin belford");
		 bellmanFord(graph,v0);
		
	}

}
