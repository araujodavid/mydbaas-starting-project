package main.java.br.com.arida.ufc.mydbaas.agent.entity;

import java.util.Properties;
import main.java.br.com.arida.ufc.mydbaas.agent.entity.common.LoadMetric;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.StatementTCL;

/**
 * @author Daivd Araújo - @araujodavid
 * @version 1.0
 * @since July 9, 2013
 */
public class StatementTCLMetric extends StatementTCL implements LoadMetric {

	private static StatementTCLMetric uniqueInstance;
	
	private StatementTCLMetric() {}

	public static StatementTCLMetric getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new StatementTCLMetric();
	    }
	    return uniqueInstance;
	}
	
	@Override
	public void loadMetricProperties(Properties properties) {
		this.setUrl(properties.getProperty("server")+properties.getProperty("statementStatus.url"));
		this.setCyclo(Integer.parseInt(properties.getProperty("statementStatus.cycle")));
		this.setEnabledDBMSs(properties.getProperty("statementStatus.dbms"));
		this.setEnabledDatabases(properties.getProperty("statementStatus.databases"));
	}

}
