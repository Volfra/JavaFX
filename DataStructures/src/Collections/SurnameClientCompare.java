package Collections;

import java.util.Comparator;

/** 
* @author wilsonsoto
* @since 29.05.20
*/
public class SurnameClientCompare implements Comparator<Client> {

	@Override
	public int compare(Client o1, Client o2) {
		return o1.getSurname().compareTo(o2.getSurname());
	}

}
