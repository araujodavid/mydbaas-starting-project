package main.java.br.com.arida.ufc.mydbaas.core.controller.api.common;

public interface InterfacePoolQuery {

	public void poolConnection();
	
	public void poolMetric(String metricsType);
	
	public void poolDBaaS();
	
	public void poolHost();
	
	public void poolVirtualMachine();
	
	public void poolDBMS();
	
	public void poolDatabase();
}
