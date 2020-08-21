/*
 * 
 * nathan mccloud
 * updated july 2020
 * 
 */

package graph;

import java.util.HashSet;

public class Vertex<E> {
	
	private Character label;
	private int distance;
	private Vertex prev;
	boolean visited;
	private HashSet<Vertex> pre;
	E data; //TODO: handle generic data
	
	Vertex(Character c){
		this.label=c;
		visited=false;
		this.pre = new HashSet<Vertex>();
	}
	
	Character getLabel()
	{
		return this.label;
	}
	
	void addPre(Vertex v)
	{
		this.pre.add(v);
	}
	
	void removePre(Vertex v)
	{
		//catch null reference exception or return boolean?
		//if()
		this.pre.remove(v);
	}
	
	int preSize()
	{
		return this.pre.size();
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
