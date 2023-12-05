import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteSQL implements IClienteSQL{
	
	private static final String DRIVER = "org.hsqldb.jdbc.JDBCDriver";
	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "";
	private static final String INSERIR = "INSERT INTO grupo(id, posicao) values(?, ?)";
	private static final String LIDER = "SELECT*FROM grupo WHERE ID = ?";
	
	public ClienteSQL() throws SQLException, ClassNotFoundException{
		Class.forName(ClienteSQL.DRIVER);
	};
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(ClienteSQL.URI, ClienteSQL.USER, ClienteSQL.PWD);
	};

	public void inserir(Membro membro) throws SQLException {
		
		PreparedStatement stm = this.getConnection().prepareStatement(ClienteSQL.INSERIR);
		
		stm.setInt(0, membro.getID());
		stm.setString(0, membro.getPosicao());
		stm.execute();
		stm.close();
		
	}
	
	@Override
	public ArrayList<Membro> mensagem() throws SQLException{
		
		PreparedStatement stm = this.getConnection().prepareStatement(ClienteSQL.LIDER);
		stm.setInt(1, 0);
		stm.execute();
		ResultSet result = stm.executeQuery();
		ArrayList<Membro> membros = new ArrayList<Membro>();
		
		Membro membro = null;
		
		while(result.next()) {
			
			int id = result.getInt("id");
			String posicao = result.getString("posicao");
			
			membro = new Membro(id, posicao);
			
			membros.add(membro);
			
		}
		
		return membros;
	}
	
	
	
	

}
