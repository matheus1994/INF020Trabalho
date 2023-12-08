package servidor;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServidor {
	
	public static void main(String args[]) throws RemoteException, MalformedURLException, AlreadyBoundException {
		
		LocateRegistry.createRegistry(1099);
		
		RMIServidorConcrete serv = new RMIServidorConcrete();
		
		Naming.bind("RMI Servidor", serv);
		System.out.println("RmiServidor Conectado !!!");
		
	}

}
