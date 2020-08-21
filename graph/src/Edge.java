/*
 * 
 * nathan mccloud
 * updated jan 2019
 * 
 */

package graph;

public class Edge {
	
	private Vertex source;
	private Vertex dest;
	private int weight;
	

	Edge(Vertex s, Vertex d){
		this.source=s;
		this.dest=d;
		this.weight=0;
	}
	
	Edge(Vertex s, Vertex d, int w){
		this.source=s;
		this.dest=d;
		this.weight=w;
	}
	
	Vertex getSource()
	{
		return this.source;
	}
	
	Vertex getDest()
	{
		return this.dest;
	}
	
	void setSource(Vertex v)
	{
		this.source=v;
	}
	
	void setDest(Vertex v)
	{
		this.dest=v;
	}
	
	int getWeight()
	{
		return this.weight;
	}
	
	void setWeight(int w)
	{
		this.weight=w;
	}
	
	@Override 
	public String toString()
	{
		return "("+this.getSource().getLabel()+","+this.getDest().getLabel()+") "+this.getWeight();
	}
}
