package distsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ResShare extends Remote {
    // Method to get a message from the node
    String getMessage() throws RemoteException;

    // Method to send a message to another node
    String sendMessageToNode(String nodeName, String message) throws RemoteException;

    // Method to get the current value of a shared resource
    int getSharedResource() throws RemoteException;

    // Method to update the shared resource
    void updateSharedResource(int value) throws RemoteException;

    // Method to register a peer node
    void registerPeer(String nodeName, ResShare peer) throws RemoteException;

    // Method to get a peer node by name
    ResShare getPeer(String nodeName) throws RemoteException;
}
