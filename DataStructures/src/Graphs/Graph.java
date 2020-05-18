package Graphs;

/**
 * 
 * @author Wilson Soto
 * @since 20.06.16
 *
 */
public interface Graph {

	/**
	 * @param n
	 */
	public void insertVertex(int n);
	
	/**
	 * @param v
	 */
	public void deleteVertex(int v);
	
	/**
	 * 
	 * @param i
	 * @param j
	 */
	public void insertEdge(int i, int j);
	
	/**
	 * 
	 * @param i
	 * @param j
	 */
	public void deleteEdge(int i, int j);
	
	/**
	 * 
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * @param i
	 * @param j
	 */
	public boolean existEdge(int i, int j);

	/**
	 * 
	 * @param i
	 * @param j
	 */
	public int degreeIn(int i);

	/**
	 * 
	 * @param i
	 * @param j
	 */
	public int degreeOut(int i);

	/**
	 * 
	 * @param i
	 */
	public int incidence (int i);

	/**
	 * 
	 */
	public int size();
		
}
