package interfaces;

import java.io.IOException;
import java.util.List;

import entities.Magasin;

public interface IProduitMigration {
	public void insertCSVtoDB(List<Magasin> magasin) throws IOException;
}
