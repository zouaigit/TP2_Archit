
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class EtudiantRepository implements InterfaceEtudiantRepository {
	
	
	public void add(InterfaceEtudiant E) throws SQLException
	{

		//connexion avec la base de donn�e
		Connection connect=DBConnection.getConn();
		
		//cr�er statment
		Statement stmt = connect.createStatement();
		
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() +"','"+ E.getPwd()+ "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		
		// executer requete sql
		int rs = stmt.executeUpdate(sql);
		
		//process the result set
		if (rs == 1){
				System.out.println("log : ajout dans la BD r�ussi de l'�tudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
				System.out.println("log : Echec de l'ajout dans la BD de l'�tudiant  du Matricule" + E.getMatricule());
			}
		connect.close();
	 }


	public boolean Exists(String email) throws SQLException	
	{

		Connection connect=DBConnection.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		ResultSet rs = stmt.executeQuery(sql);  //remplacer stmt.excute(sql)
		
		if (rs.next()){
			System.out.println("logBD--- :email existe dans la BD  " + email);
			connect.close();
			return true;
			}
		System.out.println("logBD--- : email n'existe pas " + email);	
		connect.close();
		return false;
	}
	
	public boolean Exists(int mat) throws SQLException	
	{
		
		Connection connect=DBConnection.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule="+ mat;
		ResultSet rs = stmt.executeQuery(sql);  
		
		if (rs.next()){
			System.out.println("logBD--- :etudiant avec ce matricule existe d�ja dans la BD  " + mat);
			connect.close();
			return true;
			}
		System.out.println("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		connect.close();
		return false;
	}

	
	
	
	/* Posiblit� de creer une fonction verifier mail + matricule � propos des responsabilit�s de la m�thode inscription dans  EtudiantService transmises � EtudiantRepository pour Q12
	public boolean VerifierEmailMat(int Mat, String Email) throws SQLException	
	{
		return ( Exists(Email) || Exists(Mat) || Email == null || Email.length() == 0 );

	}
	
	*/
	
	
	
	
	
	
	
}
