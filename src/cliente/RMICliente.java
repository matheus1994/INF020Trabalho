package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import servidor.IRMIServidor;

public class RMICliente {
	
	public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
		
		String urlServidor = "rmi://localhost/RmiServidor";
		
		IRMIServidor serv = (IRMIServidor)Naming.lookup(urlServidor);
		System.out.println(serv.mostraMensagem("Olá Mundo RMI !!!"));
		System.out.println(serv.adicao(23.89, 34.25));								

	}

}
