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
	
	Vertex(Character c){
		this.label=c;
		visited=false;
	}
	
	Character getLabel()
	{
		return this.label;
	}
	
	void setLabel(Character c)
	{
		this.label=c;
	}
	
	int getDist()
	{
		return this.distance;
	}
	
	void setDist(int i)
	{
		this.distance=i;
	}
	
	Vertex getPrev()
	{
		return this.prev;
	}
	
	void setPrev(Vertex v)
	{
		this.prev=v;
	}
}
