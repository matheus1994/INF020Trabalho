package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServidorConcrete extends UnicastRemoteObject implements IRMIServidor{

	protected RMIServidorConcrete() throws RemoteException {
		super();
	}

	@Override
	public String mostraMensagem(String txt) throws RemoteException {
		return "Retorno RMI : "+ txt;
	}

	@Override
	public Double adicao(Double a, Double b) throws RemoteException {
		return a + b;
	}

}
