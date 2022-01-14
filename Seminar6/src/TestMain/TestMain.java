package TestMain;
import model.*;
import repository.*;

public class TestMain {
	public static void main(String[] args){
//		RequestRepository test = new RequestRepository();
//		test.add(new ComputerRepairRequest(1,"A A","Address A","072222","Asus","13/10/2020","Broken display"));
//		test.add(new ComputerRepairRequest(2,"B B","Address B","072222","Acer","10/10/2020","Faulty keyboard"));
//		for(ComputerRepairRequest first: test.findAll())
//			System.out.println(first);
//      
//      	RepairedFormRepository repairedFormRepo = new RepairedFormRepository();
//      	repairedFormRepo.add(new RepairedForm(1, test.findById(1), "Fixed the display", 500, "2021/10/25", "Some rando"));
//      	repairedFormRepo.add(new RepairedForm(2, test.findById(2), "Changed the keyboard", 100, "2021/09/20", "Another rando"));
//      	
//      	for(RepairedForm first: repairedFormRepo.findAll())
//			System.out.println(first);
		
//		RequestRepositoryFile file = new RequestRepositoryFile("D:\\laboratoare_licenta\\MAP\\sem3-822\\Sem3\\src\\requests.txt");
//		
//		file.add(new ComputerRepairRequest(4,"A A","Address A","072222","Asus","13/10/2020","Broken display"));
////		file.add(new ComputerRepairRequest(2,"B B","Address B","072222","Acer","10/10/2020","Faulty keyboard"));
//		for(ComputerRepairRequest elem:file.findAll()){
//			System.out.println(elem);
//		}
//		
//		System.out.println("After delete");
//		file.delete(file.findById(1));
//		for(ComputerRepairRequest elem:file.findAll()){
//			System.out.println(elem);
//		}
		
//		RequestRepositoryFile file = new RequestRepositoryFile("D:\\laboratoare_licenta\\MAP\\sem3-822\\Sem3\\src\\requests.txt");
//		
//		file.add(new ComputerRepairRequest(100,"A A","Address A","072222","Asus","13/10/2020","Broken display"));
//		file.add(new ComputerRepairRequest(200,"B B","Address B","072222","Acer","10/10/2020","Faulty keyboard"));
//		RepairedFormRepositoryFile repairedFormRepoFile = new RepairedFormRepositoryFile("D:\\laboratoare_licenta\\MAP\\sem3-822\\Sem3\\src\\repairedForms.txt", file);
//		repairedFormRepoFile.add(new RepairedForm(3, file.findById(100), "Fixed the display", 500, "2021/10/25", "Some rando"));
//		repairedFormRepoFile.add(new RepairedForm(4, file.findById(200), "Changed the keyboard", 100, "2021/09/20", "Another rando"));
		
		RequestRepositorySerialization fileRepoS = new RequestRepositorySerialization("D:\\laboratoare_licenta\\MAP\\sem3-822\\Sem3\\src\\requestSerialization");
		for(ComputerRepairRequest el: fileRepoS.findAll())
			System.out.println(el);
		
		RepairedFormRepositorySerialization formRepoS = new RepairedFormRepositorySerialization("D:\\laboratoare_licenta\\MAP\\sem3-822\\Sem3\\src\\repairedFormSerialization", fileRepoS);
		formRepoS.add(new RepairedForm(1, fileRepoS.findById(3), "Fixed the display", 500, "2021/10/25", "Some rando"));
		formRepoS.add(new RepairedForm(2, fileRepoS.findById(4), "Changed the keyboard", 100, "2021/09/20", "Another rando"));
		for(RepairedForm el: formRepoS.findAll())
			System.out.println(el);
	}
}