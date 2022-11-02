/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ipsl.projet_appdistr;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.RMIService;

/**
 *
 * @author Dell
 */
public class ServerRMI {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            RMIService rs= new RMIService();
            System.out.println(rs.toString());
            Naming.rebind("rmi://localhost:1099/RK", rs);
        } catch (RemoteException ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
