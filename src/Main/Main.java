package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import Connect.*;
import Class.*;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable tableBook;
	private JTable tableCategory;
	private JTable tableAccount;
	private JScrollPane PanelBook;
	private JScrollPane PanelAccount;
	private JScrollPane PanelCateory;
	private JPanel panelActionBook;
	private JPanel panelActionAccount;
	private JPanel panelActionCategory;
	private JPanel PanelInfoBook, PanelInfoCategory, PanelInfoAccount;
	private JTextField TFbookID;
	private JTextField TFbookName;
	private JTextField TFbookAuthor;
	private JTextField TFbookPrice;
	private JTextField TFbookCount;
	private JTextField TFbookCon;
	private JTextField TFbookYear;
	private JLabel lblNewLabel;
	private JLabel lblTn;
	private JLabel lblThLoi;
	private JLabel lblTcGi;
	private JLabel lblGi;
	private JLabel lblSLng;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_1;
	private JTextField TFCategoryID;
	private JLabel lblNewLabel_2;
	private JTextField TFCategoryDes;
	private JTextField TFCategoryName;
	private JLabel lblTn_1;
	private JTextField TFAccountID;
	private JTextField TFAccountName;
	private JTextField TFAccountEmail;
	private JTextField TFAccountAddress;
	private JTextField TFAccountDate;
	private JTextField TFAccountPass;
	private JTextField TFAccountPhone;
	private JComboBox CBBookType;
	private JComboBox CBAccountRule;
	private JLabel lblVaiTr;
	private List<Book> listBook;
	private List<Category> listCategory;
	private DefaultTableModel modelBook, modelCategory, modelAccount;
	private Connect connect = new Connect();
	private String[] Category;
	private List<Account> listAccount;
	private DefaultComboBoxModel<String> modelCombobox;
	private JButton BTaddBook, BTeditBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		getView();
	}
	public static void getView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void UpdateTable() {
		String colCategory[] = { "ID", "Tên", "Mô tả" };
		String colAccount[] = { "ID", "Tên", "Email", "Địa Chỉ", "Ngày sinh", "Mật khẩu", "SĐT", "Rule" };
		String colBook[] = { "ID", "Tên", "Thể Loại", "Tác Giả", "Năm", "Trạng thái", "Số lượng", "Giá" };
		listCategory = new ArrayList<Category>();
		listAccount = new ArrayList<Account>();
		listBook = new ArrayList<Book>();
		listCategory = connect.getCategory();
		listBook = connect.getBook();
		listAccount = connect.getAccount();
		modelBook = new DefaultTableModel(colBook, 0);

		modelCategory = new DefaultTableModel(colCategory, 0);
		modelAccount = new DefaultTableModel(colAccount, 0);
		for (int i = 0; i < listCategory.size(); i++) {
			Object[] obj = { listCategory.get(i).getId(), listCategory.get(i).getName(),
					listCategory.get(i).getDescription(), };
			modelCategory.addRow(obj);
		}
		for (int i = 0; i < listBook.size(); i++) {
			String k = listBook.get(i).getCategory_id();
			Category catefind = listCategory.stream().filter(category -> k.equals(category.getId())).findAny()
					.orElse(null);
			Object[] obj = { listBook.get(i).getId(), listBook.get(i).getName(), catefind.getName(),
					listBook.get(i).getAuthor(), listBook.get(i).getYear(), listBook.get(i).getCondition(),
					listBook.get(i).getQuantily(), listBook.get(i).getPrice(), };
			modelBook.addRow(obj);
		}
		for (int i = 0; i < listAccount.size(); i++) {
			Object[] obj = { listAccount.get(i).getId(), listAccount.get(i).getName(), listAccount.get(i).getEmail(),
					listAccount.get(i).getAddress(), listAccount.get(i).getDate(), listAccount.get(i).getPass(),
					listAccount.get(i).getPhone(), listAccount.get(i).getRule(), };
			modelAccount.addRow(obj);
		}
		List<String> catgoryList = new ArrayList<>();
		for (int i = 0; i < listCategory.size(); i++) {
			catgoryList.add(listCategory.get(i).getName());
		}
		Category = catgoryList.toArray(new String[0]);
		modelCombobox = new DefaultComboBoxModel<String>(Category);
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		UpdateTable();
		setBounds(100, 100, 944, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelBook = new JScrollPane();
		PanelBook.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PanelBook.setBounds(11, 25, 905, 303);
		contentPane.add(PanelBook);
		tableBook = new JTable(modelBook);
		tableBook.isCellEditable(0, 0);

		PanelBook.setViewportView(tableBook);

		PanelCateory = new JScrollPane();
		PanelCateory.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PanelCateory.setBounds(11, 25, 905, 303);
		contentPane.add(PanelCateory);
		tableCategory = new JTable(modelCategory);
		PanelCateory.setViewportView(tableCategory);

		PanelAccount = new JScrollPane();
		PanelAccount.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PanelAccount.setBounds(11, 25, 905, 303);
		contentPane.add(PanelAccount);
		tableAccount = new JTable(modelAccount);
		PanelAccount.setViewportView(tableAccount);

		JPanel actionChangeAdmin = new JPanel();
		actionChangeAdmin.setLayout(null);
		actionChangeAdmin.setBounds(11, 350, 226, 70);
		contentPane.add(actionChangeAdmin);
		String Layouts[] = { "Quản lý Sách", "Quản lý Danh mục Sách", "Quản lý Tài khoản" };
		JComboBox actionChangeCB = new JComboBox(Layouts);
		actionChangeCB.setBounds(10, 11, 202, 45);
		actionChangeAdmin.add(actionChangeCB);
		panelActionBook = new JPanel();
		panelActionBook.setLayout(null);
		panelActionBook.setBounds(247, 350, 669, 70);
		contentPane.add(panelActionBook);
		BTaddBook = new JButton("Th\u00EAm S\u00E1ch");
		BTaddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBookTF() == true) {
					Book bookAdd = new Book();
					bookAdd.setId(TFbookID.getText());
					bookAdd.setName(TFbookName.getText());
					String category_idCB = CBBookType.getSelectedItem().toString();
					Category catefindID = listCategory.stream()
							.filter(category -> category_idCB.equals(category.getName())).findAny().orElse(null);
					bookAdd.setCategory_id(catefindID.getId());
					bookAdd.setAuthor(TFbookAuthor.getText());
					bookAdd.setYear(TFbookYear.getText());
					bookAdd.setCondition(TFbookCon.getText());
					bookAdd.setQuantily(TFbookCount.getText());
					bookAdd.setPrice(TFbookPrice.getText());
					SqlResult sqlresult = new SqlResult();
					sqlresult = connect.addBook(bookAdd);
					System.out.println(sqlresult.getStatus());
					if (sqlresult.getStatus() == "1") {
						UpdateTable();
						tableBook.setModel(modelBook);
						JOptionPane.showMessageDialog(contentPane, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Thêm thất bại");
					}
				}

			}
		});
		BTaddBook.setBounds(29, 11, 118, 48);
		panelActionBook.add(BTaddBook);

		JButton btnXemSch = new JButton("Xem S\u00E1ch");
		btnXemSch.setVisible(false);
		btnXemSch.setBounds(176, 11, 118, 48);
		panelActionBook.add(btnXemSch);

		BTeditBook = new JButton("S\u1EEDa S\u00E1ch");
		BTeditBook.setEnabled(false);

		BTeditBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBookTF() == true) {
					Book bookAdd = new Book();
					bookAdd.setId(TFbookID.getText());
					bookAdd.setName(TFbookName.getText());
					String category_idCB = CBBookType.getSelectedItem().toString();
					Category catefindID = listCategory.stream()
							.filter(category -> category_idCB.equals(category.getName())).findAny().orElse(null);
					bookAdd.setCategory_id(catefindID.getId());
					bookAdd.setAuthor(TFbookAuthor.getText());
					bookAdd.setYear(TFbookYear.getText());
					bookAdd.setCondition(TFbookCon.getText());
					System.out.println(TFbookCon.getText());
					bookAdd.setQuantily(TFbookCount.getText());
					bookAdd.setPrice(TFbookPrice.getText());
					if (connect.updateBook(bookAdd) == "1") {
						UpdateTable();
						tableBook.setModel(modelBook);
						JOptionPane.showMessageDialog(contentPane, "Chỉnh sửa thành công");
					}
				}

			}
		});
		BTeditBook.setBounds(323, 11, 118, 48);
		panelActionBook.add(BTeditBook);

		JButton BTdeletBook = new JButton("X\u00F3a S\u00E1ch");
		BTdeletBook.setEnabled(false);
		BTdeletBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (connect.deleteBook(TFbookID.getText().toString()) == "1") {
					UpdateTable();
					tableBook.setModel(modelBook);
					JOptionPane.showMessageDialog(contentPane, "Xóa thành công");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Xóa thất bại");
				}

			}
		});
		BTdeletBook.setBounds(470, 11, 165, 48);
		panelActionBook.add(BTdeletBook);

		panelActionCategory = new JPanel();
		panelActionCategory.setLayout(null);
		panelActionCategory.setBounds(247, 350, 669, 70);
		contentPane.add(panelActionCategory);

		JButton BTaddCategory = new JButton("Th\u00EAm Th\u1EC3 Lo\u1EA1i");
		BTaddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkCategoryTF() == true) {
					Category categoryAdd = new Category();
					categoryAdd.setId(TFCategoryID.getText());
					categoryAdd.setName(TFCategoryName.getText());
					categoryAdd.setDescription(TFCategoryDes.getText());
					SqlResult sqlResult = new SqlResult();
					sqlResult = connect.addCategory(categoryAdd);
					if (sqlResult.getStatus() == "1") {
						UpdateTable();
						tableCategory.setModel(modelCategory);
						CBBookType.setModel(modelCombobox);
						JOptionPane.showMessageDialog(contentPane, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Thêm thất bại");
					}
				}

			}
		});
		BTaddCategory.setBounds(29, 11, 118, 48);
		panelActionCategory.add(BTaddCategory);

		JButton BTviewCategory = new JButton("Xem Th\u1EC3 Lo\u1EA1i");
		BTviewCategory.setBounds(176, 11, 118, 48);
		panelActionCategory.add(BTviewCategory);

		JButton BTeditCategory = new JButton("S\u1EEDa Th\u1EC3 Lo\u1EA1i");
		BTeditCategory.setEnabled(false);
		BTeditCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkCategoryTF() == true) {
					Category categoryEdit = new Category();
					categoryEdit.setId(TFCategoryID.getText());
					categoryEdit.setName(TFCategoryName.getText());
					categoryEdit.setDescription(TFCategoryDes.getText().toString());
					String resultUpdate = connect.updateCategory(categoryEdit);
					if (resultUpdate == "1") {
						UpdateTable();
						tableCategory.setModel(modelCategory);
						tableBook.setModel(modelBook);
						CBBookType.setModel(modelCombobox);
						JOptionPane.showMessageDialog(contentPane, "Sửa thành công");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Sửa thất bại");
					}
				}

			}
		});
		BTeditCategory.setBounds(323, 11, 118, 48);
		panelActionCategory.add(BTeditCategory);

		JButton BTdeleteCategory = new JButton("X\u00F3a Th\u1EC3 Lo\u1EA1i");
		BTdeleteCategory.setEnabled(false);
		BTdeleteCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = TFCategoryID.getText().toString();
				Integer count = connect.getCountbook(Id);
				if (count > 0) {
					JOptionPane.showMessageDialog(contentPane,
							"Danh mục này đang chứa " + count + " quyển sách, nên không thể xóa ");
				} else {
					String resuleDelete = connect.deleteCategory(Id);
					if (resuleDelete == "1") {
						BTdeleteCategory.setEnabled(false);
						BTeditCategory.setEnabled(false);
						UpdateTable();
						tableCategory.setModel(modelCategory);
						CBBookType.setModel(modelCombobox);
						
						JOptionPane.showMessageDialog(contentPane, "Xóa thành công");
						
					} else {
						JOptionPane.showMessageDialog(contentPane, "Xóa thất bại");
					}
				}
			}
		});
		BTdeleteCategory.setBounds(470, 11, 168, 48);
		panelActionCategory.add(BTdeleteCategory);

		panelActionAccount = new JPanel();
		panelActionAccount.setLayout(null);
		panelActionAccount.setBounds(247, 350, 669, 70);
		contentPane.add(panelActionAccount);

		JButton BTaddAccount = new JButton("Th\u00EAm T\u00E0i Kho\u1EA3n");
		BTaddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checkAccontTF() == true) {
					if(connect.getMailAccout(TFAccountEmail.getText()) < 1) {
						Account accountAdd = new Account();
						accountAdd.setId(TFAccountID.getText());
						accountAdd.setName(TFAccountName.getText());
						accountAdd.setDate(TFAccountDate.getText());
						accountAdd.setEmail(TFAccountEmail.getText());
						accountAdd.setAddress(TFAccountAddress.getText());
						accountAdd.setPass(TFAccountPass.getText());
						accountAdd.setPhone(TFAccountPhone.getText());
						accountAdd.setRule(CBAccountRule.getSelectedItem().toString());
						SqlResult sqlResult = new SqlResult();
						sqlResult = connect.addAccount(accountAdd);
						if (sqlResult.getStatus() == "1") {
							UpdateTable();
							tableAccount.setModel(modelAccount);
							JOptionPane.showMessageDialog(contentPane, "Thêm tài khoản thành công");
						} else {
							JOptionPane.showMessageDialog(contentPane, "Thêm tài khoản thất bại");
						}
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Email đã tồn tại");
					}
				}
			}
		});
		BTaddAccount.setBounds(23, 11, 138, 48);
		panelActionAccount.add(BTaddAccount);

		JButton btnXemTiKhon = new JButton("Xem T\u00E0i Kho\u1EA3n");
		btnXemTiKhon.setBounds(184, 11, 138, 48);
		panelActionAccount.add(btnXemTiKhon);

		JButton BTeditAccount = new JButton("S\u1EEDa T\u00E0i Kho\u1EA3n");
		BTeditAccount.setEnabled(false);
		
		BTeditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkAccontTF() == true) {
					Account accounEdit = new Account();
					accounEdit.setId(TFAccountID.getText());
					accounEdit.setName(TFAccountName.getText());
					accounEdit.setDate(TFAccountDate.getText());
					accounEdit.setEmail(TFAccountEmail.getText());
					accounEdit.setAddress(TFAccountAddress.getText());
					accounEdit.setPass(TFAccountPass.getText());
					accounEdit.setPhone(TFAccountPhone.getText());
					accounEdit.setRule(CBAccountRule.getSelectedItem().toString());
					String updateResult = connect.updateAccount(accounEdit);
					if (updateResult == "1") {
						UpdateTable();
						tableAccount.setModel(modelAccount);
						JOptionPane.showMessageDialog(contentPane, "Sửa thành công");
					} else {

						JOptionPane.showMessageDialog(contentPane, "Sửa thất bại");
					}
				}
			}
		});
		BTeditAccount.setBounds(345, 11, 138, 48);
		panelActionAccount.add(BTeditAccount);

		JButton BTdeleteAccount = new JButton("Xóa Tài Khoản");
		BTdeleteAccount.setEnabled(false);
		BTdeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Id = TFAccountID.getText();
				String resultDelete = connect.detleteAccount(Id);
				if (resultDelete == "1") {
					BTdeleteAccount.setEnabled(false);
					BTeditAccount.setEnabled(false);
					UpdateTable();
					tableAccount.setModel(modelAccount);
					JOptionPane.showMessageDialog(contentPane, "Xóa tài khoản thành công");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Xóa tài khoản thất bại");
				}
			}
		});
		BTdeleteAccount.setBounds(506, 11, 138, 48);
		panelActionAccount.add(BTdeleteAccount);

		PanelInfoBook = new JPanel();
		PanelInfoBook.setVisible(false);
		PanelInfoBook.setBounds(11, 431, 907, 173);
		contentPane.add(PanelInfoBook);
		PanelInfoBook.setLayout(null);

		TFbookID = new JTextField();
		TFbookID.setEditable(false);
		TFbookID.setColumns(10);
		TFbookID.setBounds(8, 35, 216, 42);
		PanelInfoBook.add(TFbookID);

		TFbookName = new JTextField();
		TFbookName.setColumns(10);
		TFbookName.setBounds(232, 36, 216, 41);
		PanelInfoBook.add(TFbookName);

		TFbookAuthor = new JTextField();
		TFbookAuthor.setColumns(10);
		TFbookAuthor.setBounds(680, 36, 216, 41);
		PanelInfoBook.add(TFbookAuthor);

		TFbookPrice = new JTextField();
		TFbookPrice.setColumns(10);
		TFbookPrice.setBounds(680, 109, 216, 41);
		PanelInfoBook.add(TFbookPrice);

		TFbookCount = new JTextField();
		TFbookCount.setColumns(10);
		TFbookCount.setBounds(456, 109, 216, 41);
		PanelInfoBook.add(TFbookCount);

		TFbookCon = new JTextField();
		TFbookCon.setColumns(10);
		TFbookCon.setBounds(232, 109, 216, 41);
		PanelInfoBook.add(TFbookCon);

		TFbookYear = new JTextField();
		TFbookYear.setColumns(10);
		TFbookYear.setBounds(8, 108, 216, 42);
		PanelInfoBook.add(TFbookYear);

		lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(9, 16, 46, 14);
		PanelInfoBook.add(lblNewLabel);

		lblTn = new JLabel("Tên");
		lblTn.setBounds(233, 16, 46, 14);
		PanelInfoBook.add(lblTn);

		lblThLoi = new JLabel("Thể loại");
		lblThLoi.setBounds(456, 16, 46, 14);
		PanelInfoBook.add(lblThLoi);

		lblTcGi = new JLabel("Tác giả");
		lblTcGi.setBounds(680, 16, 46, 14);
		PanelInfoBook.add(lblTcGi);

		lblGi = new JLabel("Giá");
		lblGi.setBounds(680, 88, 46, 14);
		PanelInfoBook.add(lblGi);

		lblSLng = new JLabel("Số lượng");
		lblSLng.setBounds(456, 88, 46, 14);
		PanelInfoBook.add(lblSLng);

		lblNewLabel_6 = new JLabel("Trạng thái");
		lblNewLabel_6.setBounds(233, 88, 111, 14);
		PanelInfoBook.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Năm phát hành");
		lblNewLabel_7.setBounds(9, 88, 97, 14);
		PanelInfoBook.add(lblNewLabel_7);

		CBBookType = new JComboBox(modelCombobox);
		CBBookType.setBounds(455, 35, 216, 42);
		PanelInfoBook.add(CBBookType);

		PanelInfoCategory = new JPanel();
		PanelInfoCategory.setBounds(11, 431, 907, 173);
		contentPane.add(PanelInfoCategory);
		PanelInfoCategory.setLayout(null);

		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(11, 11, 46, 14);
		PanelInfoCategory.add(lblNewLabel_1);

		TFCategoryID = new JTextField();
		TFCategoryID.setEditable(false);
		TFCategoryID.setColumns(10);
		TFCategoryID.setBounds(10, 30, 216, 42);
		PanelInfoCategory.add(TFCategoryID);

		lblNewLabel_2 = new JLabel("Mô tả");
		lblNewLabel_2.setBounds(11, 83, 97, 14);
		PanelInfoCategory.add(lblNewLabel_2);

		TFCategoryDes = new JTextField();
		TFCategoryDes.setColumns(10);
		TFCategoryDes.setBounds(10, 103, 887, 42);
		PanelInfoCategory.add(TFCategoryDes);

		TFCategoryName = new JTextField();
		TFCategoryName.setColumns(10);
		TFCategoryName.setBounds(234, 31, 663, 41);
		PanelInfoCategory.add(TFCategoryName);

		lblTn_1 = new JLabel("Tên");
		lblTn_1.setBounds(235, 11, 46, 14);
		PanelInfoCategory.add(lblTn_1);

		PanelInfoAccount = new JPanel();
		PanelInfoAccount.setBounds(11, 431, 907, 173);
		contentPane.add(PanelInfoAccount);
		PanelInfoAccount.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(11, 11, 46, 14);
		PanelInfoAccount.add(lblNewLabel_3);

		TFAccountID = new JTextField();
		TFAccountID.setEditable(false);
		TFAccountID.setColumns(10);
		TFAccountID.setBounds(10, 30, 216, 42);
		PanelInfoAccount.add(TFAccountID);

		JLabel lblTn_2 = new JLabel("Tên");
		lblTn_2.setBounds(235, 11, 46, 14);
		PanelInfoAccount.add(lblTn_2);

		TFAccountName = new JTextField();
		TFAccountName.setColumns(10);
		TFAccountName.setBounds(234, 31, 216, 41);
		PanelInfoAccount.add(TFAccountName);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(458, 11, 46, 14);
		PanelInfoAccount.add(lblEmail);

		TFAccountEmail = new JTextField();
		TFAccountEmail.setColumns(10);
		TFAccountEmail.setBounds(458, 31, 216, 41);
		PanelInfoAccount.add(TFAccountEmail);

		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(682, 11, 46, 14);
		PanelInfoAccount.add(lblaCh);

		TFAccountAddress = new JTextField();
		TFAccountAddress.setColumns(10);
		TFAccountAddress.setBounds(682, 31, 216, 41);
		PanelInfoAccount.add(TFAccountAddress);

		TFAccountDate = new JTextField();
		TFAccountDate.setColumns(10);
		TFAccountDate.setBounds(10, 103, 216, 42);
		PanelInfoAccount.add(TFAccountDate);

		JLabel lblNewLabel_7_1 = new JLabel("Ngày sinh");
		lblNewLabel_7_1.setBounds(11, 83, 97, 14);
		PanelInfoAccount.add(lblNewLabel_7_1);

		JLabel lblNewLabel_6_1 = new JLabel("mật khẩu");
		lblNewLabel_6_1.setBounds(235, 83, 111, 14);
		PanelInfoAccount.add(lblNewLabel_6_1);

		TFAccountPass = new JTextField();
		TFAccountPass.setColumns(10);
		TFAccountPass.setBounds(234, 104, 216, 41);
		PanelInfoAccount.add(TFAccountPass);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(458, 83, 104, 14);
		PanelInfoAccount.add(lblSinThoi);

		TFAccountPhone = new JTextField();
		TFAccountPhone.setColumns(10);
		TFAccountPhone.setBounds(458, 104, 216, 41);
		PanelInfoAccount.add(TFAccountPhone);
		String ruleAccount[] = { "admin", "guest" };
		CBAccountRule = new JComboBox(ruleAccount);
		CBAccountRule.setBounds(684, 103, 212, 40);
		PanelInfoAccount.add(CBAccountRule);

		lblVaiTr = new JLabel("Vai trò");
		lblVaiTr.setBounds(684, 84, 104, 14);
		PanelInfoAccount.add(lblVaiTr);

		tableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BTeditBook.setEnabled(true);
				BTdeletBook.setEnabled(true);
				TableModel tm = tableBook.getModel();
				TFbookID.setText(tm.getValueAt(tableBook.getSelectedRow(), 0).toString());
				TFbookName.setText((String) tm.getValueAt(tableBook.getSelectedRow(), 1));
				CBBookType.setSelectedItem((String) tm.getValueAt(tableBook.getSelectedRow(), 2));
				TFbookAuthor.setText((String) tm.getValueAt(tableBook.getSelectedRow(), 3));
				TFbookYear.setText((String) tm.getValueAt(tableBook.getSelectedRow(), 4));
				TFbookCon.setText((String) tm.getValueAt(tableBook.getSelectedRow(), 5));
				TFbookCount.setText((String) tm.getValueAt(tableBook.getSelectedRow(), 6));
				TFbookPrice.setText((String) tm.getValueAt(tableBook.getSelectedRow(), 7));
			}
		});
		tableAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BTeditAccount.setEnabled(true);;
				BTdeleteAccount.setEnabled(true);
				TableModel tm = tableAccount.getModel();
				TFAccountID.setText((String) tm.getValueAt(tableAccount.getSelectedRow(), 0));
				TFAccountName.setText((String) tm.getValueAt(tableAccount.getSelectedRow(), 1));
				TFAccountEmail.setText((String) tm.getValueAt(tableAccount.getSelectedRow(), 2));
				TFAccountAddress.setText((String) tm.getValueAt(tableAccount.getSelectedRow(), 3));
				TFAccountDate.setText((String) tm.getValueAt(tableAccount.getSelectedRow(), 4));
				TFAccountPass.setText((String) tm.getValueAt(tableAccount.getSelectedRow(), 5));
				TFAccountPhone.setText((String) tm.getValueAt(tableAccount.getSelectedRow(), 6));
				CBAccountRule.setSelectedItem((String) tm.getValueAt(tableAccount.getSelectedRow(), 7));
			}
		});
		tableCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BTeditCategory.setEnabled(true);
				BTdeleteCategory.setEnabled(true);
				TableModel tm = tableCategory.getModel();
				TFCategoryID.setText((String) tm.getValueAt(tableCategory.getSelectedRow(), 0));
				TFCategoryName.setText((String) tm.getValueAt(tableCategory.getSelectedRow(), 1));
				TFCategoryDes.setText((String) tm.getValueAt(tableCategory.getSelectedRow(), 2));
			}
		});
		setLayoutBook();

		actionChangeCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Integer chose = (Integer) actionChangeCB.getSelectedIndex();
					switch (chose) {
					case 0:
						setLayoutBook();
						break;
					case 1:
						setLayoutCategory();
						break;
					case 2:
						setLayoutAccount();

						break;
					}

				}
			}
		});
	}

	private Boolean checkBookTF() {
		if (TFbookName.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập tên");
			return false;
		}
		if (TFbookAuthor.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập Tác giả");
			return false;
		}
		if (TFbookYear.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập Năm xuất bản");
			return false;
		}
		if (TFbookCon.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập hiện trạng");
			return false;
		}
		if (TFbookCount.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập số lượng");
			return false;
		}
		if (TFbookPrice.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập giá");
			return false;
		}
		return true;

	}

	private Boolean checkAccontTF() {
		if (TFAccountName.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập tên");
			return false;
		}
		String Regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
		if (TFAccountEmail.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập Email");
			return false;
		}
		Boolean b = TFAccountEmail.getText().matches(Regex);
		if (b == false) {
			JOptionPane.showMessageDialog(contentPane, "Email sai định dạng");
			return false;
		}

		if (TFAccountAddress.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập Địa chỉ");
			return false;
		}
		if (TFAccountDate.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập ngày sinh");
			return false;
		}
		if (TFAccountPass.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập Mật khẩu");
			return false;
		}
		if (TFAccountPhone.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập SĐT");
			return false;
		}
		return true;

	}

	private Boolean checkCategoryTF() {
		if (TFCategoryName.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập tên");
			return false;
		}
		if (TFCategoryDes.getText().length() == 0) {
			JOptionPane.showMessageDialog(contentPane, "Nhập mô tả");
			return false;
		}
		return true;
	}

	private void setLayoutBook() {
		PanelAccount.setVisible(false);
		PanelCateory.setVisible(false);
		panelActionBook.setVisible(true);
		panelActionAccount.setVisible(false);
		panelActionCategory.setVisible(false);
		PanelInfoAccount.setVisible(false);
		PanelInfoCategory.setVisible(false);
		PanelInfoBook.setVisible(true);
		PanelBook.setVisible(true);
	}

	private void setLayoutCategory() {
		PanelBook.setVisible(false);
		PanelAccount.setVisible(false);
		PanelCateory.setVisible(true);
		panelActionBook.setVisible(false);
		panelActionAccount.setVisible(false);
		panelActionCategory.setVisible(true);
		PanelInfoAccount.setVisible(false);
		PanelInfoCategory.setVisible(true);
		PanelInfoBook.setVisible(false);
	}

	private void setLayoutAccount() {
		PanelBook.setVisible(false);
		PanelAccount.setVisible(true);
		PanelCateory.setVisible(false);
		panelActionBook.setVisible(false);
		panelActionAccount.setVisible(true);
		panelActionCategory.setVisible(false);
		PanelInfoAccount.setVisible(true);
		PanelInfoCategory.setVisible(false);
		PanelInfoBook.setVisible(false);
	}
}
