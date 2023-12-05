import java.sql.SQLException;
import java.util.ArrayList;

public interface IClienteSQL {

	public ArrayList<Membro> mensagem() throws SQLException;
	void inserir(Membro membro) throws SQLException;
	
	

}
