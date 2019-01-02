/*
 * 
 * nathan mccloud
 * updated jan 2019
 * 
 */

package graph;

public class Vertex {
	private Character label;
	private int distance;
	private Vertex prev;
	boolean visited;
	
	public Vertex(Character c){
		this.label=c;
		visited=false;
	}
	
	public Character getLabel()
	{
		return this.label;
	}
	
	public void setLabel(Character c)
	{
		this.label=c;
	}
	
	public int getDist()
	{
		return this.distance;
	}
	
	public void setDist(int i)
	{
		this.distance=i;
	}
	
	public Vertex getPrev()
	{
		return this.prev;
	}
	
	public void setPrev(Vertex v)
	{
		this.prev=v;
	}
}
