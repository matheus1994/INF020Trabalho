package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMIServidor extends Remote {
	
	public String mostraMensagem(String txt) throws RemoteException;
	public Double adicao(Double a, Double b) throws RemoteException;


}
