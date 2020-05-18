package Graphs;

/**
 * 
 * @author wilson.soto
 * @since 20.06.16
 *
 */
public class Execution {

	public static void main(String[] args) {
		
		GraphAdyList g = new GraphAdyList(10, true);
		
		g.insertVertex(5);
		
		g.insertEdge(0, 1);
		g.insertEdge(1, 2);
		g.insertEdge(2, 3);
		g.insertEdge(3, 4);
		g.insertEdge(3, 1);
		g.insertEdge(4, 3);
		g.insertEdge(4, 2);
		
		System.out.println(g.degreeIn(3));
		System.out.println(g.degreeOut(3));
		System.out.println(g.incidence(3));
		
		g.printGraph();
		
		g.deleteEdge(4, 2);
		g.insertEdge(4, 0);
		g.deleteEdge(1, 2);
		g.insertEdge(2, 1);
		
		g.printGraph();
		
		g.deleteVertex(3);
		
		g.printGraph();

	}

}
