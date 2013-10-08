package main.java.br.com.arida.ufc.mydbaas.core.controller.api.common;

import main.java.br.com.arida.ufc.mydbaas.common.resource.DBMS;
import main.java.br.com.arida.ufc.mydbaas.common.resource.DBaaS;
import main.java.br.com.arida.ufc.mydbaas.common.resource.Database;
import main.java.br.com.arida.ufc.mydbaas.common.resource.Host;
import main.java.br.com.arida.ufc.mydbaas.common.resource.VirtualMachine;

public interface InterfaceResourceManager {

	public void addDBaaS(DBaaS resource);
	
	public void updateDBaaS(DBaaS resource);
	
	public void getHosts(int identifier);
	
	public void addHost(Host resource);
	
	public void updateHost(Host resource);
	
	public void getMachines(int identifier, String ownerType);
	
	public void addMachine(VirtualMachine resource);
	
	public void updateMachine(VirtualMachine resource);
	
	public void getDBMSs(int identifier, String ownerType);
	
	public void addDBMS(DBMS resource);
	
	public void updateDBMS(DBMS resource);
	
	public void getDatabases(int identifier);
	
	public void addDatabase(Database resource);
	
	public void updateDatabase(Database resource);
	
	public void getResourceByID(int resourceId, String resourceType);
}
