package main.java.br.com.arida.ufc.mydbaas.agent.entity;

import java.util.Properties;
import main.java.br.com.arida.ufc.mydbaas.agent.entity.common.LoadMetric;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.Statement;

/**
 * @author Daivd Araújo - @araujodavid
 * @version 1.0
 * @since July 9, 2013
 */
public class StatementMetric extends Statement implements LoadMetric {

	private static StatementMetric uniqueInstance;
	
	private StatementMetric() {}

	public static StatementMetric getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new StatementMetric();
	    }
	    return uniqueInstance;
	}
	
	@Override
	public void loadMetricProperties(Properties properties) {
		this.setUrl(properties.getProperty("server")+properties.getProperty("statement.url"));
		this.setCyclo(Integer.parseInt(properties.getProperty("statement.cycle")));
		this.setEnabledDBMSs(properties.getProperty("statement.dbms"));
		this.setEnabledDatabases(properties.getProperty("statement.databases"));
	}

}
