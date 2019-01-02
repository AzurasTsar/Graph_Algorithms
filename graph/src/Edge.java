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
	

	public Edge(Vertex s, Vertex d, int w){
		this.source=s;
		this.dest=d;
		this.weight=w;
	}
	
	public Vertex getSource()
	{
		return this.source;
	}
	
	public Vertex getDest()
	{
		return this.dest;
	}
	
	public void setSource(Vertex v)
	{
		this.source=v;
	}
	
	public void setDest(Vertex v)
	{
		this.dest=v;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(int w)
	{
		this.weight=w;
	}
	
	@Override 
	public String toString()
	{
		return "("+this.getSource().getLabel()+","+this.getDest().getLabel()+") "+this.getWeight();
	}
}
