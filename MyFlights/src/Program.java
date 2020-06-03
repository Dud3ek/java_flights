import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello flights");
		DBConnection obj1 = new DBConnection();
		User user1 = new User();
		user1.Login("admin","adminPassNew");
		user1.Register("NewUser","newuserpass","Jan","Kowalski","jankowal@gmail.com");
		ArrayList<String> list1 = user1.ShowUserData();
		for (int i=0;i<list1.size();i++)
			System.out.println(list1.get(i));
		
	}

}
