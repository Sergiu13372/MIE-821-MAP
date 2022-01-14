package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import cars.Car;
import repository.CarsRepositoryFile;
import repository.CarsRepositorySerialization;

public class Main {

	public static void main(String[] args) {


		//CarsRepositoryFile fileRepo = new CarsRepositoryFile("cars.txt");
		CarsRepositorySerialization serRepo = new CarsRepositorySerialization("carsBytes.txt");
	
		//serRepo.add(new Car(0, "Audi", "TT", 210, 1500, "2005", false, "null"));
		//serRepo.add(new Car(1, "Audi", "A4", 200, 1000, "2001", true, "20.05.2022"));
		//serRepo.add(new Car(2, "Volkswagen", "Golf", 180, 1100, "2004", true, "19.11.2021"));
		
		
		Car car1 = new Car(0, "Renault", "Clio", 160, 1500, "2005", false, "null");
		Car car2 = new Car(1, "Saab", "9-4", 194, 3000, "2001", true, "20.05.2022");
		Car car3 = new Car(2, "Ram", "Duallie", 175, 4100, "2004", true, "19.11.2021");
		Car car4 = new Car(3, "Nissan", "Navara", 175, 2500, "2005", false, "null");
		Car car5 = new Car(4, "GMC", "Pickup", 175, 4000, "2001", true, "20.05.2022");
		Car car6 = new Car(5, "Volkswagen", "Golf", 180, 1100, "2004", true, "19.11.2021");
		Car car7 = new Car(6, "Nissan", "Micra", 165, 1500, "2007", false, "null");
		Car car8 = new Car(7, "Bentley", "FlyingSpurr", 250, 100000, "2010", true, "20.05.2022");
		Car car9 = new Car(8, "Lexus", "Ls-300", 230, 12100, "2012", true, "19.11.2021");
		Car car10 = new Car(9, "Acura", "NSX", 270, 10500, "2005", false, "null");
		Car car11 = new Car(10, "Porsche", "Cayenne", 220, 1000, "2006", true, "20.05.2022");
		Car car12 = new Car(11, "Ford", "Focus", 180, 1100, "2004", true, "19.11.2021");
		Car car13 = new Car(12, "Subaru", "Forester", 200, 1500, "2005", false, "null");
		Car car14 = new Car(13, "Renault", "Megane", 200, 1000, "2001", true, "20.05.2022");
		Car car15 = new Car(14, "Volkswagen", "Bora", 200, 1100, "2003", true, "19.11.2021");
		Car car16 = new Car(15, "Nissan", "S14", 250, 1500, "1992", false, "null");
		Car car17 = new Car(16, "Porsche", "Panamera", 250, 15000, "2010", true, "20.05.2022");
		Car car18 = new Car(17, "Porsche", "911", 290, 110000, "2021", true, "19.11.2021");
		Car car19 = new Car(18, "Nissan", "Micra", 165, 1200, "2004", false, "null");
		

		serRepo.add(car1);
		serRepo.add(car2);		
		serRepo.add(car3);
		serRepo.add(car4);		
		serRepo.add(car5);
		serRepo.add(car6);		
		serRepo.add(car7);
		serRepo.add(car8);		
		serRepo.add(car9);
		serRepo.add(car10);		
		serRepo.add(car11);
		serRepo.add(car12);		
		serRepo.add(car13);
		serRepo.add(car14);	
		serRepo.add(car15);		
		serRepo.add(car16);
		serRepo.add(car17);		
		serRepo.add(car18);
		serRepo.add(car19);	
		
		List<Car> carsList = Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10,
										   car11, car12, car13, car14, car15, car16, car17, car18, car19);
		
		//All Nissan cars
		System.out.println("\nNissan cars are:");
		carsList.stream()
			.filter(c -> c.getManufacturer().startsWith("Nissan"))
			.forEach(System.out::println);
		
		//All Porsche cars
		System.out.println("\nPorsche cars are:");
		carsList.stream()
			.filter(c -> c.getManufacturer().startsWith("Porsche"))
			.forEach(System.out::println);
		
		//All cars after 2010
		System.out.println("\nCars after 2010 are:");
		carsList.stream()
			.filter(c -> Integer.parseInt(c.getManufacturing_year()) > 2010)
			.forEach(System.out::println);
		
		//All prices for Nissan Micras
		System.out.println("\nPrices for Micras are:");
		carsList.stream()
			.filter(c -> c.getModel().startsWith("Micra"))
			.map(cm -> cm.getPrice())
			.forEach(System.out::println);
		
		//All years for Volkswagens are:
		System.out.println("\nYears for Volkswagens are:");
		carsList.stream()
			.filter(c -> c.getManufacturer().startsWith("Volkswagen"))
			.map(cm -> cm.getManufacturing_year())
			.forEach(System.out::println);
		
		//Sum of prices for Nissan models is:
		System.out.println("\nSum of prices for Nissan models is:");
		int sum = carsList.stream()
			.filter(c -> c.getManufacturer().startsWith("Nissan"))
			.mapToInt(cm -> (int)cm.getPrice())
			.sum();
		System.out.println(sum);
		
		//All manufacturers are:
		System.out.println("\nAll manufacturers are:");
		carsList.stream()
			.map(cm -> cm.getManufacturer())
			.distinct()
			.forEach(System.out::println);
	}
}