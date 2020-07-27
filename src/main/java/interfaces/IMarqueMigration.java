package interfaces;

import java.io.IOException;
import java.util.List;

import entities.Magasin;
import entities.Marque;
public interface IMarqueMigration {
	public List<Marque> extraire();
	public void insertCSVtoDB(List<Magasin> magasin) throws IOException;
}
