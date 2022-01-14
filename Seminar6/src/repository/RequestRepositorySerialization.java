package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import exceptions.RepositoryException;
import model.ComputerRepairRequest;

public class RequestRepositorySerialization extends AbstractRepository<ComputerRepairRequest, Integer>{
	private String filename;

	public RequestRepositorySerialization(String filename) {
		this.filename = filename;
		readFromFile();
	}
	
	private void readFromFile ()
	{
		try(ObjectInputStream in= new ObjectInputStream (new FileInputStream(filename)))
	    {	
	    	elem = (Map<Integer, ComputerRepairRequest>) in.readObject();
	  	}
	    catch(Exception err)
	    {
	    	throw new RepositoryException("Error reading from file: "+err);
	    }
	}

    @Override
    public void add(ComputerRepairRequest obj) {
        try {
            super.add(obj);
            writeToFile();
        } catch (RuntimeException e) {
            throw new RepositoryException("Object wasn’t added" + e + " "+obj);
        }
    }

    @Override
    public void delete(ComputerRepairRequest obj) {
        try {
            super.delete(obj);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not deleted" + ex +" "+obj);
        }
    }
    
    @Override
    public void update(ComputerRepairRequest obj, Integer id) {
        try {
            super.update(obj, id);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not updated" + ex + " "+obj);
        }
    }
    
    public void writeToFile()
    {
		try(ObjectOutputStream e=new ObjectOutputStream(new FileOutputStream(filename))){
        		e.writeObject(elem);
    		}
    	catch(IOException r){
    		throw new RepositoryException("message " + r);
   			}
	 }
	  
}
    	