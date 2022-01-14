package seminar3;

import repository.*;

/*
public class TestMain {
	public static void main(String[] args) {
		RequestRepository test = new RequestRepository();
		test.add(new ComputerRepairRequest(1, "A A", "Address A", "072222", "Asus", "13/10/2020", "Broken display"));
		test.add(new ComputerRepairRequest(2, "B B", "Address B", "072222", "Acer", "10/10/2020", "Faulty keyboard"));
		for (ComputerRepairRequest first : test.findAll())
			System.out.println(first);
		
		RepairedFormRepository test2 = new RepairedFormRepository();
		test2.add(new RepairedForm(1,
				new ComputerRepairRequest(1, "A A", "Address A", "072222", "Asus", "13/10/2020", "Broken display"),
				"Cleaned Computer", 5, "17/9/2021", "Gigel"));
		test2.add(new RepairedForm(2,
				new ComputerRepairRequest(1, "A A", "Address A", "072222", "Asus", "13/10/2020", "Broken display"),
				"Cleaned Computer", 5, "17/9/2021", "Gigel"));
		for (RepairedForm first : test2.findAll())
			System.out.println(first);
	}
}*/

public class TestMain{
	public static void main(String[] arg){
		RequestRepositoryFile reqRepo = new RequestRepositoryFile("requests.txt");
		reqRepo.add(new ComputerRepairRequest(1, "A A", "Address A", "072222", "Asus", "13/10/2020", "Broken display"));
		reqRepo.add(new ComputerRepairRequest(2, "B B", "Address B", "072222", "Acer", "10/10/2020", "Faulty keyboard"));
		reqRepo.add(new ComputerRepairRequest(3, "C D", "Address X", "072222", "Acer", "10/10/2020", "Faulty brain"));
	}
}