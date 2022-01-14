package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import exceptions.RepositoryException;
import model.RepairedForm;

public class RepairedFormRepositoryFile extends AbstractRepository<RepairedForm, Integer> {
    private String filename;
    private RequestRepositoryFile reqRepository;

    public RepairedFormRepositoryFile(String filename, RequestRepositoryFile reqRepo) {
        this.filename = filename;
        this.reqRepository = reqRepo;//new RequestRepositoryFile("D:\\laboratoare_licenta\\MAP\\sem3-822\\Sem3\\src\\requests.txt");
        readFromFile();
    }

    private void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(";");
                if (el.length != 6) {System.err.println("Not a valid number of atributes" + line);
                    continue;
                }
                try {
                    int Id = Integer.parseInt(el[0]);
                    int price = Integer.parseInt(el[3]);
                    RepairedForm c = new RepairedForm(Id, reqRepository.findById(Integer.parseInt(el[1])), el[2], price, el[4], el[5]);
                    super.add(c);
                } catch (NumberFormatException n) {
                    System.err.println("The ID is not a valid number" + el[0]);
                }
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error reading" + ex);
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

    private void writeToFile() {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (RepairedForm el : findAll()) {
                String line = el.getID() + ";"+el.getComputerRepairRequest().getID()+";"+el.getServices() + ";"+el.getPrice() +";"+el.getDate() + ";" + el.getEmployee() ;
              		  
              	pw.println(line);
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error writing" + ex);
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
    