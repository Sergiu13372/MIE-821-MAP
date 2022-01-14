package repository;
import seminar3.ComputerRepairRequest;

import java.io.*;

public class RequestRepositoryFile extends AbstractRepository<ComputerRepairRequest, Integer>{
	private String filename;
	public RequestRepositoryFile(String filename){
		this.filename=filename;
		readFromFile();
	}
	private void readFromFile(){
		try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
			String line = reader.readLine();
			while((line==reader.readLine())!=false){
				String[] el=line.split(";");
				if(el.length!=7){
					System.err.println("Not a valid number of atributes " + line);
					continue;
				}
				try{
					int Id=Integer.parseInt(el[0]);
					ComputerRepairRequest c=new
							ComputerRepairRequest(Id,el[1],el[2],el[3],el[4],el[5],el[6]);
					super.add(c);
				}catch(NumberFormatException n){
					System.err.println("The ID is not a valid number " + el[0]);
				}
			}
		}catch(IOException ex){
			throw new RepositoryException("Error reading" + ex);
		}
	}
	@Override
	public void add(ComputerRepairRequest obj) {
		try{
			super.add(obj);
			writeToFile();
		}
		catch(RuntimeException e){
			throw new RepositoryException("Object wasn’t added " + e + " " + obj);
		}
	}
	private void writeToFile() {
		try(PrintWriter pw = new PrintWriter(filename)) {
			for(ComputerRepairRequest el : findAll()) {
				String line = el.getID() + ";" + el.getOwnerName() + ";" + el.getOwnerAddress() +
				";" + el.getPhoneNumber() + ";" + el.getModel() + el.getDate() + ";" + el.getProblemDescription();
				pw.println(line);
			}
		}catch(IOException ex) {
			throw new RepositoryException("Error writing" + ex);
		}
	}
	@Override
	public void delete(ComputerRepairRequest obj){
		try{
			super.delete(obj);
			writeToFile();
		}
		catch(RuntimeException ex){
			throw new RepositoryException("Object was not deleted " + ex + " "  + obj);
		}
	}
	@Override
	public void update(ComputerRepairRequest obj, Integer Id){
		try{
			super.update(obj, Id);
			writeToFile();
		}
		catch(RuntimeException ex){
			throw new RepositoryException("Object was not updated " + ex + " " + obj);
		}
	}
}