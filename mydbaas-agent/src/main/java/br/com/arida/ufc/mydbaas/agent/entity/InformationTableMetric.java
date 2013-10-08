package main.java.br.com.arida.ufc.mydbaas.agent.entity;

import java.util.Properties;
import main.java.br.com.arida.ufc.mydbaas.agent.entity.common.LoadMetric;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.InformationTable;

/**
 * @author Daivd Araújo - @araujodavid
 * @version 1.0
 * @since July 11, 2013
 */
public class InformationTableMetric extends InformationTable implements LoadMetric {

	private static InformationTableMetric uniqueInstance;
	
	private InformationTableMetric() {}

	public static InformationTableMetric getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new InformationTableMetric();
	    }
	    return uniqueInstance;
	}
	
	@Override
	public void loadMetricProperties(Properties properties) {
		this.setUrl(properties.getProperty("server")+properties.getProperty("informationTable.url"));
		this.setCyclo(Integer.parseInt(properties.getProperty("informationTable.cycle")));
		this.setEnabledDBMSs(properties.getProperty("informationTable.dbms"));
		this.setEnabledDatabases(properties.getProperty("informationTable.databases"));
	}
}
