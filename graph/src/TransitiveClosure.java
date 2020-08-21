/*
 * 
 * nathan mccloud
 * t cormen introduction to algorithms p698
 * 
 */

package graph;
/* computes whether there exists a path between all pairs of vertices i,j in a directed graph G */
public class TransitiveClosure {
	
	static void newLine()
	{
		System.out.println();
	}
	
	static void space()
	{
		System.out.print("  ");
	}

	static void transClose(MyGraph g)
	{
		int c=0;
		int V=g.getVertSize();
		Vertex numVerts[]=new Vertex[V];
		int closMatrix[][]=new int[V][V];
		
		for(Vertex v: g.getVerts())
		{	
			numVerts[c]=v;
			c++;
		}
		
		for(int i=0; i<V; i++)
			for(int j=0; j<V; j++)
				if(i == j || g.getEdge(numVerts[i],numVerts[j]) != null)
					closMatrix[i][j]=1;
				else
					closMatrix[i][j]=0;
		
		for(int k=0; k<V; k++)
			for(int i=0; i<V; i++)
				for(int j=0; j<V; j++)
					closMatrix[i][j]=(closMatrix[i][j] | (closMatrix[i][k] & closMatrix[k][j]) );
		
		space();
		for(int i=0; i<V; i++)
			System.out.print(" "+numVerts[i].getLabel());
		newLine();
		space();
		for(int i=0; i<V; i++)
			System.out.print(" -");
		newLine();
		for(int m=0; m<V; m++)
		{
			System.out.print(numVerts[m].getLabel()+ "| ");
			for(int l=0; l<V; l++)
				System.out.print(closMatrix[m][l]+" ");
			newLine();
		}

	}

	public static void main(String[] args) {
		//test case
		MyGraph g=new MyGraph(true,false,4);
		
		Vertex v0=new Vertex('a');
		Vertex v1=new Vertex('b');
		Vertex v2=new Vertex('c');
		Vertex v3=new Vertex('d');
		
		Edge e0=new Edge(v1,v3,-2);
		Edge e1=new Edge(v1,v2, 2);
		Edge e2=new Edge(v2,v1,-1);
		Edge e3=new Edge(v3,v2,4);
		Edge e4=new Edge(v3,v0,3);
		
		g.addEdge(e0);
		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		
		transClose(g);
	}

}
