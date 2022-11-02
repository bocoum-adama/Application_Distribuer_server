/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import metier.produit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class RMIService extends UnicastRemoteObject implements ProduitInterface {

    public RMIService() throws RemoteException {
        super();
    }

    @Override
    public String VerifierProduit(String nom) throws RemoteException {

        String requete = "select count(id) as Numb from produit where nom='" + nom + "'";
        ResultSet lst = null;
        try {
            Statement st = dbUtils.getConnection().createStatement();
            lst = st.executeQuery(requete);
        } catch (Exception ex) {
            Logger.getLogger(RMIService.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (lst.next()) {
                return lst.getString("Numb");

            }
        } catch (SQLException ex) {
            Logger.getLogger(RMIService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<String> afficherProduits() throws RemoteException {
        String requete = "select nom, count(id) as Numb from produit GROUP BY nom";
        List<String> li = new ArrayList<>();
        ResultSet lst = null;
        try {
            Statement st = dbUtils.getConnection().createStatement();
            lst = st.executeQuery(requete);
        } catch (Exception ex) {
            Logger.getLogger(RMIService.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (lst.next()) {
                String st =lst.getString("nom")+" : "+lst.getString("Numb");
                li.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMIService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }

}
