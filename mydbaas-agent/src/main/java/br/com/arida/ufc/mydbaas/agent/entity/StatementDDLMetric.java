package main.java.br.com.arida.ufc.mydbaas.agent.entity;

import java.util.Properties;
import main.java.br.com.arida.ufc.mydbaas.agent.entity.common.LoadMetric;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.StatementDDL;

public class StatementDDLMetric extends StatementDDL implements LoadMetric {

	private static StatementDDLMetric uniqueInstance;
	
	private StatementDDLMetric() {}

	public static StatementDDLMetric getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new StatementDDLMetric();
	    }
	    return uniqueInstance;
	}
	
	@Override
	public void loadMetricProperties(Properties properties) {
		this.setUrl(properties.getProperty("server")+properties.getProperty("statementDDL.url"));
		this.setCyclo(Integer.parseInt(properties.getProperty("statementDDL.cycle")));
		this.setEnabledDBMSs(properties.getProperty("statementDDL.dbms"));
		this.setEnabledDatabases(properties.getProperty("statementDDL.databases"));
	}
}
