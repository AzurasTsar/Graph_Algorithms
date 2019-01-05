/*
 * 
 * nathan mccloud
 * https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm#Algorithm
 * 
 */

package graph;

class FloydWarshall {

	static final int INF=10000;
	
	static void newLine()
	{
		System.out.println();
	}
	
	static void floydWarshall(MyGraph graph)
	{
		int c=0;
		int V=graph.getVerts();
		int distMatrix[][]=new int[V][V];
		Vertex verts[]=new Vertex[V];
		for(Vertex v: graph.vertices)
		{
			verts[c]=v;
			c++;
		}	
		
		for(int i=0; i<V; i++)
			for(int j=0; j<V; j++)
				distMatrix[i][j]=INF;
		
		for(int u=0; u<V; u++)
			for(int v=0; v<V; v++)
			{
				if(u==v)
					distMatrix[u][v]=0;
				else
					distMatrix[u][v]=graph.length(verts[u], verts[v]);
			}
		
		for(int k=0; k<V; k++)
			for(int i=0; i<V; i++)
				for(int j=0; j<V; j++)
					if(distMatrix[i][j]>(distMatrix[i][k]+distMatrix[k][j]))
						distMatrix[i][j]=(distMatrix[i][k]+distMatrix[k][j]);		
		
		for(Vertex v: graph.vertices)
			System.out.print("  " + v.getLabel());
		
		newLine();
		
		for(int i=0; i<V; i++)
			System.out.print("  "+"_");
		
		newLine();
	
		for(int u=0; u<V; u++)
		{	
			System.out.print(verts[u].getLabel()+"| ");
			for(int v=0; v<V; v++)
				System.out.print(distMatrix[u][v]+"  ");		
			newLine();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		MyGraph g=new MyGraph(true,true,4);
	
		Vertex v0=new Vertex('a');
		Vertex v1=new Vertex('b');
		Vertex v2=new Vertex('c');
		Vertex v3=new Vertex('d');
		
		Edge e0=new Edge(v0,v2,-2);
		Edge e1=new Edge(v2,v3, 2);
		Edge e2=new Edge(v3,v1,-1);
		Edge e3=new Edge(v1,v0,4);
		Edge e4=new Edge(v1,v2,3);
		
		g.addEdge(e0);
		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		
		floydWarshall(g);
	}

}
