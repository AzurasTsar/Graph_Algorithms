/*
 * 
 * nathan mccloud
 * updated jan 2019
 * 
 */

package graph;
 
import java.util.*;

public class MyGraph {
	
	static final int INF=10000;

	boolean directed, weighted;
	ArrayList<Edge> edges;
	HashSet<Vertex> vertices;
	HashSet<Vertex> outneighbors;
	
	MyGraph(boolean directed, boolean weighted, int vertices){
		this.directed=directed;
		this.weighted=weighted;
		this.edges=new ArrayList<Edge>();
		this.vertices=new HashSet<Vertex>(vertices);
		this.outneighbors=new HashSet<Vertex>();
	}
	
	void addVertex(Vertex v)
	{
		vertices.add(v);
	}
	
	void addEdge(Edge e)
	{
		edges.add(e);
		if(!vertices.contains(e.getSource())||!vertices.contains(e.getDest()))
		{
			vertices.add(e.getSource());
			vertices.add(e.getDest());
		}
	}
	
	void intializeSingleSource(Vertex v)
	{
		for(Vertex vert: this.vertices)
			vert.setDist(INF);
		v.setDist(0);
	}
		
	HashSet<Vertex> getOutNeighbors(Vertex v)
	{
		outneighbors.clear();
		for(Edge e: edges)
			if(e.getSource()==v)
				outneighbors.add(e.getDest());
		return outneighbors;
	}
	
	//relaxation with vertices
	void relax(Vertex u, Vertex v)
	{
		if (v.getDist()>(u.getDist()+length(u,v)))
		{
			v.setDist(u.getDist()+length(u,v));
			v.setPrev(u);
		}
			
	}
	
	//relaxation with edges
	void relax(Edge e)
	{
		if (e.getDest().getDist()>(e.getSource().getDist()+e.getWeight()))
		{
			e.getDest().setDist(e.getSource().getDist()+e.getWeight());
			e.getDest().setPrev(e.getSource());
		}
		
			
	}
	
	
	int length(Vertex s, Vertex d)
	{
		for(Edge e: this.edges)
			if(e.getSource()==s && e.getDest()==d)
				return e.getWeight();
		return 0;
	}
	
	void printVerts()
	{
		for(Vertex v: vertices)
			System.out.print(v.getLabel()+" ");
		System.out.println();	
	}
	
	void makeunDirected()
	{
		this.directed=false;
		int c=0;
		int numEdges=edges.size();
		Edge[] edgeArr=new Edge[numEdges];
		for(Edge e:edges)
		{
			Vertex i=e.getSource();
			Vertex j=e.getDest();
			Edge f=new Edge(j,i,e.getWeight());
			edgeArr[c]=f;
			c++;
			System.out.println(f.toString());
		}	
		
		for(int i=0; i<numEdges; i++)
			this.edges.add(edgeArr[i]);
	}
	
	void printDists(Vertex source)
	{
		for(Vertex v: this.vertices)
			System.out.println("node: "+v.getLabel()+" distance from "+source.getLabel()+": "+v.getDist());
	}
	
	void makeUnweighted()
	{
		this.weighted=false;
		for(Edge e: edges)
			e.setWeight(0);
	}
	
	void printEdges()
	{
		for(Edge e: edges)
			System.out.println(e.toString());
	}
	

}
