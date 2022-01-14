package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import exceptions.RepositoryException;
import model.RepairedForm;

public class RepairedFormRepositorySerialization extends AbstractRepository<RepairedForm, Integer>
{
	private String filename;
	private RequestRepositorySerialization reqRepository;
	
	public RepairedFormRepositorySerialization(String filename, RequestRepositorySerialization reqRepository)
    {
    	this.filename = filename;
    	this.reqRepository = reqRepository;
//        readFromFile();
	}
	
	
	private void writeToFile(){
    	try(ObjectOutputStream e=new ObjectOutputStream(new FileOutputStream(filename)))
        {
        	e.writeObject(elem);
        }
    	catch(IOException r){
    		throw new RepositoryException("message " + r);
    	}
	}


	private void readFromFile ()
	{
		try(ObjectInputStream in= new ObjectInputStream (new FileInputStream(filename)))
	    {	
	    	elem = (Map<Integer, RepairedForm>) in.readObject();
	  	}
	    catch(IOException|ClassNotFoundException err)
	    {
	    	throw new RepositoryException("Error reading from file: "+err);
	    }
	}

    @Override
    public void add(RepairedForm obj) {
        try {
            super.add(obj);
            writeToFile();
        } catch (RuntimeException e) {
            throw new RepositoryException("Object wasn’t added" + e + " "+obj);
        }
    }

    @Override
    public void delete(RepairedForm obj) {
        try {
            super.delete(obj);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not deleted" + ex +" "+obj);
        }
    }
    
        @Override
    public void update(RepairedForm obj, Integer id) {
        try {
            super.update(obj, id);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not updated" + ex + " "+obj);
        }
    }
    
  
}
