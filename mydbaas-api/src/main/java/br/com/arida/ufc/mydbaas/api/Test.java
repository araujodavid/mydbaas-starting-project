package main.java.br.com.arida.ufc.mydbaas.api;

import java.util.List;

import main.java.br.com.arida.ufc.mydbaas.api.client.MyDBaaSClient;
import main.java.br.com.arida.ufc.mydbaas.api.query.MyMetrics;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.ActiveConnection;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.Size;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Cpu;
import main.java.br.com.arida.ufc.mydbaas.common.resource.DBMS;
import main.java.br.com.arida.ufc.mydbaas.common.resource.Database;
import main.java.br.com.arida.ufc.mydbaas.common.resource.VirtualMachine;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyDBaaSClient client = new MyDBaaSClient("");
		MyMetrics myMetrics = new MyMetrics(client);
		
		Database database = new Database();
		
		List<Object> sizes = myMetrics.getMetricCollection(Size.class, database, MyMetrics.RESOURCE_TYPE_DATABASE, null, null);

	}

}
