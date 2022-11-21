import java.util.Scanner;
import java.sql.*;

public class Employee extends Thread {

	public static void main(String[] args) {

		try {
			Scanner s = new Scanner(System.in);
			System.out.print("User Name : ");
			String name = s.next();
			System.out.print("Password : ");
			String password = s.next();

			String s_name = "";
			String s_pass = "";
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademodb", "root", "");
			Statement st = c.createStatement();
			ResultSet r = st.executeQuery("select * from admin");

			while (r.next()) {
				s_name = r.getString(1);
				s_pass = r.getString(2);
			}

			if (name.equals(s_name) && password.equals(s_pass)) {
				System.out.print(
						"\n1)Modify the employee info \n2)Modify the client info \n3)Project Details \n4)Logout \nSelect : ");

				int choice1 = s.nextInt();

				if (choice1 == 1) {
					System.out.print(
							"\n1) Add employee \n2) Update employee\n3) Print employee\n4) Delete employee \n5)Logout \nSelect : ");
					int choice2 = s.nextInt();
					if (choice2 == 1) {
						System.out.print("\nEmployee Name : ");
						String ename = s.next();
						System.out.print("Employee ID : ");
						int e_id = s.nextInt();
						System.out.print("Employee Title : ");
						String title = s.next();
						System.out.print("Employee DOB : ");
						String e_dob = s.next();
						System.out.print("Employee DOJ : ");
						String e_doj = s.next();
						System.out.print("Emloyee Address : ");
						String address = s.next();
						System.out.print("Emloyee City : ");
						String city = s.next();
						System.out.print("Emloyee Pincode : ");
						int pincode = s.nextInt();
						System.out.print("Employee Phone Number : ");
						long mobile_no = s.nextLong();
						System.out.print("Emloyee State : ");
						String state = s.next();
						System.out.print("Employee Email ID : ");
						String mail_id = s.next();
						System.out.print("Emloyee Pan Number : ");
						String pan_no = s.next();

						PreparedStatement p = c
								.prepareStatement("insert into employee_info values(?,?,?,?,?,?,?,?,?,?,?,?)");

						p.setString(1, ename);
						p.setInt(2, e_id);
						p.setString(3, title);
						p.setString(4, e_dob);
						p.setString(5, e_doj);
						p.setString(6, address);
						p.setString(7, city);
						p.setInt(8, pincode);
						p.setLong(9, mobile_no);
						p.setString(10, state);
						p.setString(11, mail_id);
						p.setString(12, pan_no);
						p.executeUpdate();

						System.out.println("\nData Saved...");
					}

					else if (choice2 == 2) {
						System.out.print(
								"\nEnter the column number to update \n1) Name \n2) Title \n3) Mobile No \n4) Address \n5) Pin No \nSelect : ");
						int choice3 = s.nextInt();
						if (choice3 == 1) {
							PreparedStatement p = c.prepareStatement("update employee_info set name=? where e_id=?");
							System.out.print("\nUpdate name : ");
							String uid = s.next();
							System.out.print("Modifier id : ");
							int sn = s.nextInt();
							p.setString(1, uid);
							p.setInt(2, sn);
							p.executeUpdate();
							System.out.println("\nData update SuccessFully...");
						}

						else if (choice3 == 2) {
							PreparedStatement p = c.prepareStatement("update employee_info set title=? where e_id=?");
							System.out.print("\nUpdate employee title : ");
							String stitle = s.next();
							System.out.print("Modifier id : ");
							int sn = s.nextInt();
							p.setString(1, stitle);
							p.setInt(2, sn);
							p.executeUpdate();
							System.out.println("\nData update SuccessFully...");
						}

						else if (choice3 == 3) {
							PreparedStatement p = c.prepareStatement("update employee_info set mail_id=? where e_id=?");
							System.out.print("\nUpdate email ID : ");
							String uid = s.next();
							System.out.print("Modifier id : ");
							int sn = s.nextInt();
							p.setString(1, uid);
							p.setInt(2, sn);
							p.executeUpdate();
							System.out.println("\nData update SuccessFully...");
						}

						else if (choice3 == 4) {
							PreparedStatement p = c
									.prepareStatement("update employee_info set mobile_no=? where e_id=?");
							System.out.print("\nUpdate mobile number : ");
							int uid = s.nextInt();
							System.out.print("Modifier id : ");
							int sn = s.nextInt();
							p.setInt(1, uid);
							p.setInt(2, sn);
							p.executeUpdate();
							System.out.println("\nData update SuccessFully...");
						}

						else if (choice3 == 5) {
							PreparedStatement p = c.prepareStatement("update employee_info set address=? where e_id=?");
							System.out.print("\nUpdate address : ");
							String uid = s.next();
							System.out.print("Modifier id : ");
							int sn = s.nextInt();
							p.setString(1, uid);
							p.setInt(2, sn);
							p.executeUpdate();
							System.out.println("\nData update SuccessFully...");
						}

						else if (choice3 == 6) {
							PreparedStatement p = c.prepareStatement("update employee_info set pincode=? where e_id=?");
							System.out.print("\nUpdate pincode : ");
							int uid = s.nextInt();
							System.out.print("Modifier id : ");
							int sn = s.nextInt();
							p.setInt(1, uid);
							p.setInt(2, sn);
							p.executeUpdate();
							System.out.println("\nData update SuccessFully...");
						}

						else {
							System.out.println("\nInvalid ...");
						}
					}

					else if (choice2 == 3) {
						Statement stt = c.createStatement();
						ResultSet rs = stt.executeQuery("select * from employee_info");
						while (rs.next()) {
							System.out.println("\nEmployee Name : " + rs.getString(1));
							System.out.println("Employee ID : " + rs.getInt(2));
							System.out.println("Employee Title : " + rs.getString(3));
							System.out.println("Employee DOB : " + rs.getString(4));
							System.out.println("Employee DOJ : " + rs.getString(5));
							System.out.println("Employee Location : " + rs.getString(6));
							System.out.println("Employee City : " + rs.getString(7));
							System.out.println("Employee Pincode : " + rs.getInt(8));
							System.out.println("Employee Mobile No : " + rs.getLong(9));
							System.out.println("Employee State : " + rs.getString(10));
							System.out.println("Employee MailID : " + rs.getString(11));
							System.out.println("Employee Pan : " + rs.getString(12));
						}
					}

					else if (choice2 == 4) {
						System.out.print("Enter the name to delete :");
						String dn = s.next();
						PreparedStatement p = c.prepareStatement("delete from employee_info where ename=?");
						p.setString(1, dn);
						p.executeUpdate();
						System.out.println("Deleted Successfully... ");
					}

					else if (choice2 == 5) {
						Employee e = new Employee();
						e.setName("Logout");
						e.suspend();
						System.out.println("Loged out...");
					}

					else {
						System.out.println("Invalid Choice...");
					}

				}

				else if (choice1 == 2) {
					System.out.print(
							"\n1 : Add client info\n2 : Update client info\n3 : Print client info\n4 : Delete client info \n5 : Logout \nSelect : ");
					int fch = s.nextInt();
					if (fch == 1) {
						System.out.print("\nClient ID : ");
						int pid = s.nextInt();
						System.out.print("Client Name : ");
						String pcom = s.next();
						System.out.print("Client Address : ");
						String ps = s.next();
						PreparedStatement p = c.prepareStatement("insert into client_info values(?,?,?)");
						p.setInt(1, pid);
						p.setString(2, pcom);
						p.setString(3, ps);
						p.executeUpdate();
						System.out.println("\nUpdate completed...");
					}

					else if (fch == 2) {
						System.out.print("\nEnter the column number to update \n1) Name \n2) Address \nSelect : ");
						int chs = s.nextInt();

						if (chs == 1) {
							PreparedStatement p = c.prepareStatement("update client_info set c_name=? where c_id=?");
							System.out.print("\nUpdate client name : ");
							String uid = s.next();
							System.out.print("Modifier id : ");
							int sn = s.nextInt();
							p.setString(1, uid);
							p.setInt(2, sn);
							p.executeUpdate();
							System.out.println("\nData update SuccessFully...");
						}

						else if (chs == 2) {
							PreparedStatement p = c.prepareStatement("update client_info set address=? where c_id=?");
							System.out.print("\nUpdate Address : ");
							String uid = s.next();
							System.out.print("Modifier id : ");
							int sn = s.nextInt();
							p.setString(1, uid);
							p.setInt(2, sn);
							p.executeUpdate();
							System.out.println("\nData update SuccessFully...");
						}
					}

					else if (fch == 3) {
						Statement stt = c.createStatement();
						ResultSet rs = stt.executeQuery("select * from client_info");
						while (rs.next()) {
							System.out.println("\nClient ID : " + rs.getInt(1));
							System.out.println("Client Name : " + rs.getString(2));
							System.out.println("Client Location : " + rs.getString(3));
						}
					}

					else if (fch == 4) {
						System.out.print("/nEnter the name to delete : ");
						String dn = s.next();
						PreparedStatement p = c.prepareStatement("delete from client_info where c_name=?");
						p.setString(1, dn);
						p.executeUpdate();
						System.out.println("Deleted Successfully... ");
					}

					else if (fch == 5) {
						Employee e = new Employee();
						e.setName("Logout");
						e.suspend();
						System.out.println("Loged out...");
					}

					else {
						System.out.println("Invalid...");
					}
				}

				else if (choice1 == 3) {
					Statement stt = c.createStatement();
					ResultSet rs = stt.executeQuery("select * from employee_info,client_info");
					while (rs.next()) {
						System.out.println("\nEmployee Name : " + rs.getString(1));
						System.out.println("Employee ID : " + rs.getInt(2));
						System.out.println("Employee Title : " + rs.getString(3));
						System.out.println("Employee DOB : " + rs.getString(4));
						System.out.println("Employee DOJ : " + rs.getString(5));
						System.out.println("Employee Location : " + rs.getString(6));
						System.out.println("Employee City : " + rs.getString(7));
						System.out.println("Employee Pincode : " + rs.getInt(8));
						System.out.println("Employee Mobile No : " + rs.getLong(9));
						System.out.println("Employee State : " + rs.getString(10));
						System.out.println("Employee MailID : " + rs.getString(11));
						System.out.println("Employee Pan : " + rs.getString(12));
						System.out.println("\nClient ID : " + rs.getInt(13));
						System.out.println("Client Name : " + rs.getString(14));
						System.out.println("Client Location : " + rs.getString(15));
					}
				}

				else if (choice1 == 4) {
					Employee e = new Employee();
					e.setName("Logout");
					e.suspend();
					System.out.println("Loged out...");
				}

				else {
					System.out.println("Invalid...");
				}
			}
			c.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}
