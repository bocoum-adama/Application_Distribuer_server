/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Dell
 */
public class NewClass {
    
public static double doNothing(int n)
{
n = n + 8;
return (double) 12/n;
}
    public static void main(String[] args) throws RemoteException {
int n = 13;
System.out.print(doNothing(n));
System.out.print(','+n);


    }
    
}
