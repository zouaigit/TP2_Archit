
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements InterfaceUniversiteRepository {
	
	
	public Universite GetById(int universityId) throws SQLException {
		
		
		Connection connect=DBConnection.getConn(); 
		Statement stmt = connect.createStatement();
		System.out.println("LogBD : d�but recherche de id universit� dans la base de donn�e");
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
			
		System.out.println("LogBD : universit� r�cup�r�e");
		
		connect.close();
		return u;	
	
		
	}	
	
	
	public int GetNbrLivre(Universite univ) throws SQLException {

		int nbrLivre = 0;

		if (univ.getPack() == TypePackage.Standard)
	    {
			nbrLivre=10;
	    }
	    if (univ.getPack() == TypePackage.Premium)
	    {
	    	nbrLivre=20;
	    }
	    if (univ.getPack() == TypePackage.Illimit�)
	    {
	    	nbrLivre=0;
	    }

		return nbrLivre;
	}
	
	
	
	
}
