package Collections;

import java.util.Comparator;

/** 
* @author wilsonsoto
* @since 29.05.20
*/
public class TallClientCompare  implements Comparator<Client> {

	@Override
	public int compare(Client o1, Client o2) {
		if (o1.getTall() < o2.getTall()) return -1; 
        if (o1.getTall() > o2.getTall()) return 1; 
        else return 0; 
	}
}
