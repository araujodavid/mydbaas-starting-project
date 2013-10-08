package main.java.br.com.arida.ufc.mydbaas.api.util;

import java.util.List;

import main.java.br.com.arida.ufc.mydbaas.api.client.MyDBaaSClient;
import main.java.br.com.arida.ufc.mydbaas.api.query.MyMetrics;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.ActiveConnection;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.Size;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Cpu;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Memory;
import main.java.br.com.arida.ufc.mydbaas.common.resource.DBMS;
import main.java.br.com.arida.ufc.mydbaas.common.resource.Database;
import main.java.br.com.arida.ufc.mydbaas.common.resource.VirtualMachine;

public class Teste {
	
	
	//(1)
	MyDBaaSClient client = new MyDBaaSClient("localhost:8080/mydbaas");
	VirtualMachine virtualMachine = (VirtualMachine) client.resourceLookupByID(10, "machine");
	DBMS dbms = (DBMS) client.resourceLookupByID(1, "dbms");
	Database database = (Database) client.resourceLookupByID(3, "database");

	
	
	//(4)
	MyMetrics myMetrics = new MyMetrics(client);
	
	//(5)
	Memory memory = (Memory) myMetrics.getMetricSingle(Memory.class, virtualMachine, MyMetrics.RESOURCE_TYPE_VM, null, null);
	ActiveConnection activeConnection = (ActiveConnection) myMetrics.getMetricSingle(ActiveConnection.class, dbms, MyMetrics.RESOURCE_TYPE_DBMS, null, null);	
	
	//(6)
	List<Object> cpus = myMetrics.getMetricMulti(Cpu.class, virtualMachine, MyMetrics.RESOURCE_TYPE_VM, null, null);
	
	//(7)
	List<Object> sizes1 = myMetrics.getMetricCollection(Size.class, database, MyMetrics.RESOURCE_TYPE_DATABASE, "15-06-2013", null);
	List<Object> sizes2 = myMetrics.getMetricCollection(Size.class, database, MyMetrics.RESOURCE_TYPE_DATABASE, null, "15-06-2013");
	List<Object> sizes3 = myMetrics.getMetricCollection(Size.class, database, MyMetrics.RESOURCE_TYPE_DATABASE, "15-06-2013 15:30:00", "11-08-2013");
	
	
}
