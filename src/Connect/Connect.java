package Connect;

import Class.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Connect {
	private Connection connect = getConnect();

	public List<Book> getBook() {
		List<Book> books = new ArrayList<Book>();
		try {
			String sql = "SELECT * FROM book";
			PreparedStatement stm = connect.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString(1));
				book.setName(rs.getString(2));
				book.setCategory_id(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setYear(rs.getString(5));
				book.setCondition(rs.getString(6));
				book.setQuantily(rs.getString(7));
				book.setPrice(rs.getString(8));
				books.add(book);
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return books;

	}

	public List<Account> getAccount() {
		List<Account> listAccount = new ArrayList<Account>();

		try {
			String sql = "SELECT * FROM account";
			PreparedStatement stm = connect.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getString(1));
				account.setName(rs.getString(2));
				account.setEmail(rs.getString(3));
				account.setAddress(rs.getString(4));
				account.setDate(rs.getString(5));
				account.setPass(rs.getString(6));
				account.setPhone(rs.getString(7));
				account.setRule(rs.getString(8));
				listAccount.add(account);
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return listAccount;

	}

	public List<Category> getCategory() {
		List<Category> listCategory = new ArrayList<Category>();

		try {
			String sql = "SELECT * FROM category";
			PreparedStatement stm = connect.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getString(1));
				category.setName(rs.getString(2));
				category.setDescription(rs.getString(3));
				listCategory.add(category);
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return listCategory;
	}

	public SqlResult addBook(Book book) {

		SqlResult sqlResult = new SqlResult();
		String s;
		try {
			String Id = getIndex("book") + "";
			String sql = "INSERT INTO book  VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			stm.setString(2, book.getName());
			stm.setString(3, book.getCategory_id());
			stm.setString(4, book.getAuthor());
			stm.setString(5, book.getYear());
			stm.setString(6, book.getCondition());
			stm.setString(7, book.getCondition());
			stm.setString(8, book.getPrice());
			stm.execute();
			s = "1";
			sqlResult.setIndex(Id);
			sqlResult.setStatus(s);
		} catch (Exception e) {
			// TODO: handle exception
			s = "2";
			sqlResult.setIndex("0");
			sqlResult.setStatus(s);
		}
		return sqlResult;
	}

	public SqlResult addCategory(Category category) {

		SqlResult sqlResult = new SqlResult();
		String s;
		try {
			String Id = getIndex("category") + "";
			String sql = "INSERT INTO category  VALUES (?,?,?)";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			stm.setString(2, category.getName());
			stm.setString(3, category.getDescription());
			stm.execute();
			s = "1";
			sqlResult.setIndex(Id);
			sqlResult.setStatus(s);
		} catch (Exception e) {
			// TODO: handle exception
			s = "2";
			sqlResult.setIndex("0");
			sqlResult.setStatus(s);
		}
		return sqlResult;
	}

	public SqlResult addAccount(Account account) {
		SqlResult sqlResult = new SqlResult();
		try {
			Integer Id = getIndex("account");
			String sql = "INSERT INTO account  VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setInt(1, Id);
			stm.setString(2, account.getName());
			stm.setString(3, account.getEmail());
			stm.setString(4, account.getAddress());
			stm.setString(5, account.getDate());
			stm.setString(6, account.getPass());
			stm.setString(7, account.getPhone());
			stm.setString(8, account.getRule());
			stm.execute();
			sqlResult.setIndex(Id.toString());
			sqlResult.setStatus("1");
		} catch (Exception e) {
			// TODO: handle exception
			sqlResult.setIndex("0");
			sqlResult.setStatus("2");
		}
		return sqlResult;
	}

	public String updateAccount(Account account) {

		String s;
		try {
			String Id = account.getId();
			String sql = "UPDATE account SET  id= ?, name= ?, email = ?, address = ?, date= ?, pass=?, phone=?, rule =?  WHERE id = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			stm.setString(2, account.getName());
			stm.setString(3, account.getEmail());
			stm.setString(4, account.getAddress());
			stm.setString(5, account.getDate());
			stm.setString(6, account.getPass());
			stm.setString(7, account.getPhone());
			stm.setString(8, account.getRule());
			stm.setString(9, Id);
			stm.execute();
			s = "1";
		} catch (Exception e) {
			// TODO: handle exception
			s = "2";
			System.out.println(e);
		}
		return s;
	}

	public Integer getMailAccout(String email) {
		Integer count = 0;
		try {
			String sql = "SELECT * FROM account WHERE email = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				count = count + 1;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(count);
		return count;

	}

	public Account getAccountLogin(String email) {
		Account account = new Account();
		try {
			String sql = "SELECT * FROM account WHERE email = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				account.setId(rs.getString(1));
				account.setName(rs.getString(2));
				account.setEmail(rs.getString(3));
				account.setAddress(rs.getString(4));
				account.setDate(rs.getString(5));
				account.setPass(rs.getString(6));
				account.setPhone(rs.getString(7));
				account.setRule(rs.getString(8));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return account;

	}

	public String updateCategory(Category category) {

		String s;
		try {
			String Id = category.getId();
			String sql = "UPDATE category SET  id= ?, name= ?, description = ? WHERE id = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			stm.setString(2, category.getName());
			stm.setString(3, category.getDescription());
			stm.setString(4, Id);
			stm.execute();
			s = "1";
		} catch (Exception e) {
			// TODO: handle exception
			s = "2";
		}
		return s;
	}

	public Integer getIndex(String tabel) {

		Integer index = 0;
		try {
			String sql = "SELECT * FROM " + tabel + " ORDER BY id DESC LIMIT 1";

			PreparedStatement stm = connect.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				index = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

		return index + 1;
	}

	public Integer getCountbook(String Id) {
		Integer count = 0;
		try {
			String sql = "SELECT * FROM book WHERE category_id= ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				count = count + 1;
			}
		} catch (Exception e) {

			// TODO: handle exception
		}
		return count;
	}

	public String updateBook(Book book) {

		String s;
		try {
			String Id = book.getId();
			System.out.println(Id);
			String sql = "UPDATE book SET  id= ? ,name= ?, category_id = ?, author = ?, year =?, condition_b=?, Quantily =?, Price =? WHERE id = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			stm.setString(2, book.getName());
			stm.setString(3, book.getCategory_id());
			stm.setString(4, book.getAuthor());
			stm.setString(5, book.getYear());
			stm.setString(6, book.getCondition());
			stm.setString(7, book.getQuantily());
			stm.setString(8, book.getPrice());
			stm.setString(9, Id);
			stm.execute();
			s = "1";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			s = "2";
		}
		return s;
	}

	public String deleteBook(String id) {

		String s;
		try {
			String Id = id;
			String sql = "DELETE FROM book WHERE id = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			stm.execute();
			s = "1";
		} catch (Exception e) {
			// TODO: handle exception
			s = "2";
		}
		return s;
	}

	public String deleteCategory(String id) {

		String s;
		try {
			String Id = id;
			String sql = "DELETE FROM category WHERE id = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			stm.execute();
			s = "1";
		} catch (Exception e) {
			// TODO: handle exception
			s = "2";
		}
		return s;
	}

	public String detleteAccount(String id) {

		String s;
		try {
			String Id = id;
			String sql = "DELETE FROM account WHERE id = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, Id);
			stm.execute();
			s = "1";
		} catch (Exception e) {
			// TODO: handle exception
			s = "2";
		}
		return s;
	}

	public Connection getConnect() {
		Connection conn = null;
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/library";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}

	public static void main(String[] args) {
		Connect connect = new Connect();
		System.out.println(connect.getCountbook("3"));
	}
}