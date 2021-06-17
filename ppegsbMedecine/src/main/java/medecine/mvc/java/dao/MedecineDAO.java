package medecine.mvc.java.dao;

import java.util.List;

import medecine.mvc.java.model.Medecine;


public interface MedecineDAO {
	
    List<Medecine> get();
	
	Medecine get(int id);
	
    boolean save(Medecine medecine);

	boolean delete(int id);
	
	boolean update(Medecine medecine);
}
