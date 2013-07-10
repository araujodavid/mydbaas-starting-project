package main.java.br.com.arida.ufc.mydbaas.agent.entity;

import java.util.Properties;
import main.java.br.com.arida.ufc.mydbaas.agent.entity.common.LoadMetric;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.StatementStatus;

/**
 * @author Daivd Araújo - @araujodavid
 * @version 1.0
 * @since July 9, 2013
 */
public class StatementStatusMetric extends StatementStatus implements LoadMetric {

	private static StatementStatusMetric uniqueInstance;
	
	private StatementStatusMetric() {}

	public static StatementStatusMetric getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new StatementStatusMetric();
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
