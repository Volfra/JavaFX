package Collections;

/** 
* @author wilsonsoto
* @since 29.05.20
*/
public class Client implements Comparable<Client> {
	
	private int ID;
	private String name;
	private String surname;
	private int edad;
	private double tall;
	
	public Client(int iD, String name, String surname, int edad, double tall) {
		super();
		ID = iD;
		this.name = name;
		this.surname = surname;
		this.edad = edad;
		this.tall = tall;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getTall() {
		return tall;
	}
	public void setTall(double tall) {
		this.tall = tall;
	}
	@Override
	public String toString() {
		return "Client [ID=" + ID + ", name=" + name + ", surname=" + surname + ", edad=" + edad + ", tall=" + tall
				+ "]";
	}
	@Override
	// Used to sort clients by age 
	public int compareTo(Client o) {
		return this.edad - o.edad;
	}
}
