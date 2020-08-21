/*
 * 
 * nathan mccloud
 * updated july 2020
 * 
 */

package graph;
 
import java.util.*;

public class MyGraph {
	
	static final int INF=10000;

	private boolean directed, weighted;
	private ArrayList<Edge> edges;
	private HashSet<Vertex> vertices;
	private HashSet<Vertex> outneighbors;
	
	MyGraph(boolean directed, boolean weighted, int vertices){
		this.directed=directed;
		this.weighted=weighted;
		this.edges=new ArrayList<Edge>();
		this.vertices=new HashSet<Vertex>(vertices);
		this.outneighbors=new HashSet<Vertex>();
	}
	
	ArrayList<Edge> getEdges()
	{
		return this.edges;
	} 
	
	HashSet<Vertex> getVerts()
	{
		return this.vertices;
	} 
	
	void addVertex(Vertex v)
	{
		vertices.add(v);
	}
	
	void addEdge(Edge e)
	{
		edges.add(e);
		if(!vertices.contains(e.getSource()))
		{
			vertices.add(e.getSource());
		}
		
		if(!vertices.contains(e.getDest()))
		{
			vertices.add(e.getDest());

		}
		e.getDest().addPre(e.getSource());

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
		return INF; //if no edge found mark INF
	}
	
	Edge getEdge(Vertex v0, Vertex v1)
	{
		for(Edge e: edges)
			if(e.getSource()==v0 && e.getDest()==v1)
				return e;
		return null;
	}
	
	boolean removeEdge(Vertex v0, Vertex v1)
	{
		Edge e;
		if((e = this.getEdge(v0, v1)) != null)
		{
			this.edges.remove(e);	
			v1.removePre(v0);
			return true;
		}
		return false;
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
	
	int getVertSize()
	{
		return vertices.size();
	}
	
	void printDists(Vertex source)
	{
		for(Vertex v: this.vertices)
			System.out.println("node: "+
			v.getLabel()+" distance from "+
			source.getLabel()+": "+v.getDist());
	}
	
	void makeUnweighted()
	{
		this.weighted=false;
		for(Edge e: edges)
			e.setWeight(0);
	}
	
	boolean isWeighted()
	{
		return this.weighted;
	}
	
	boolean isDirected()
	{
		return this.directed;
	}
	
	void printEdges()
	{
		for(Edge e: this.edges)
			System.out.println(e.toString());
	}

}
