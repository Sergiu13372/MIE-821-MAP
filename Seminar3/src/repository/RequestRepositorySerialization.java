package repository;

import java.io.*;
import java.util.*;
import seminar3.ComputerRepairRequest;
import repository.AbstractRepository;

public class RequestRepositorySerialization extends AbstractRepository<ComputerRepairRequest, Integer>{
    private String filename;
  
	private void writeToFile(){
		try(ObjectOutputStream e = new ObjectOutputStream (new FileOutputStream(filename))){
			e.writeObject(elem);
		}
		catch(IOException r){
			throw new RepositoryException("message " + r);
		}
	}
	
	private void readFromFile (){
		try(ObjectInputStream in= new ObjectInputStream (new FileInputStream(filename))){
			elem = (Map<Integer, ComputerRepairRequest>) in.readObject();
		}
		catch(IOException|ClassNotFoundException err){
			throw new RepositoryException("Error reading from file: " + err);
		}
	}
}