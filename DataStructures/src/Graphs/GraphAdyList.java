package Graphs;

/**
 * 
 * @author Wilson Soto
 * @since 20.06.16
 *
 */
public class GraphAdyList implements Graph {

	boolean diGraph;
	int maxVertex;
	int numVertex;
	List listAdy [];

	public GraphAdyList (boolean d) {
		maxVertex = numVertex = 0;
		diGraph = d;
	}

	public GraphAdyList (int n, boolean d) {
		diGraph = d;
		maxVertex = n;
		numVertex = 0;
		listAdy = new List[n];
	}
	
	public void insertVertex(int n) {
		if (n > maxVertex - numVertex)
			System.out.println ("Error");
		else {
			for (int i = numVertex; i < numVertex + n; i++)
				listAdy[i]= new List();
			numVertex += n;
		}
	}

	public void deleteVertex(int v) {
		
		if (v > listAdy.length)
			System.out.println("Error");
		else {
			listAdy[v].firstNode = null;
			for (int i=0; i<listAdy.length; i++)
				if (existEdge(i, v))
					deleteEdge(i,v);
		}
	}

	public void insertEdge(int i, int j) {
		if (i>=numVertex && j>=numVertex)
			System.out.println("Error");
		else {
			listAdy[i].add(listAdy[i].size, j);
			if (!diGraph)
				listAdy[j].add(listAdy[j].size, i);
		}

	}

	public void deleteEdge(int i, int j) {
		if (i>= numVertex && j>=numVertex)
			System.out.println("Error");
		else {
			listAdy[i].remove (listAdy[i].indexOf(j));
			if (!diGraph)
				if (listAdy[j].indexOf(i)!=-1)
					listAdy[j].remove (listAdy[j].indexOf(i));
		}
	}

	public boolean isEmpty() {
		
		for (int i=0; i<listAdy.length; i++)
			if (listAdy[i]!=null)
				return false;
		return true;
		
	}

	public boolean existEdge(int i, int j) {
		if (listAdy[i]==null)
			return false;
		ListNode aux = listAdy[i].firstNode;
		while (aux!=null) {
			if (aux.element.equals(j))
				return true;
			aux = aux.next;
		}		
		return false;
	}

	public int degreeIn(int v) {
		int dgIn = 0;
		for (int i = 0; i < numVertex; i++)
			if (i != v)
				if (listAdy[i].indexOf(v)!=-1)
					dgIn++;
		return dgIn;
	}

	public int degreeOut(int i) {
		int dgOut = 0;
		ListNode aux = listAdy[i].firstNode;
		while (aux != null){
			dgOut++;
			aux = aux.next;
		}
		return dgOut;
	}

	public int incidence(int i) {
		if (!diGraph)
			return degreeIn (i);
		else return degreeIn (i) + degreeOut (i);
	}

	public int size() {	
		int size = 0;
		for (int i=0; i<numVertex; i++)
			size += numElementos (listAdy[i]);
		if (!diGraph)
			size = size / 2;
		return size;
	}

	public int numElementos (List lista) {
		ListNode aux = lista.firstNode;
		int resul = 0;
		while (aux != null) {
			resul += 1;
			aux = aux.next;
		}
		return resul;
	}
		
	public void printGraph () {
		System.out.println("Number maximum of vertices: " + maxVertex + "\n");
		System.out.println("the graph has " + numVertex + " vertex: \n");
		for (int i = 0; i < numVertex; i++) {
			System.out.print ("Vertex " + i + ": ");
			toString (listAdy [i]);
		}
	}
	
	public void toString (List lista) {
		ListNode aux;
		aux = lista.firstNode;
		String str = "";
		while (aux != null) {
			str += aux.element +", ";
			aux = aux.next;
		}
		if (str.length()>1)
			str = str.substring(0, str.length()-2);
		System.out.println ("["+str+"]");
	}

}
