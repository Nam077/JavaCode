package Class;

public class Book {
	private String id;
	private String name;
	private String category_id;
	private String author;
	private String year;
	private String condition;
	private String quantily;
	private String price;
	public Book(String id, String name, String category_id, String author, String year, String condition,
			String quantily, String price) {
		super();
		this.id = id;
		this.name = name;
		this.category_id = category_id;
		this.author = author;
		this.year = year;
		this.condition = condition;
		this.quantily = quantily;
		this.price = price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getQuantily() {
		return quantily;
	}
	public void setQuantily(String quantily) {
		this.quantily = quantily;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}