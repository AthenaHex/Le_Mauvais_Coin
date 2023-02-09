package entities;

public class Announcement {
	private int id;
	private String title;
	private float price;
	private String type;
	private String description;
	private int idCustomer;
	public Announcement(int id, String title, float price, String type, String description, int idCustomer) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.type = type;
		this.description = description;
		this.idCustomer = idCustomer;
	}
	
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public float getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
}
