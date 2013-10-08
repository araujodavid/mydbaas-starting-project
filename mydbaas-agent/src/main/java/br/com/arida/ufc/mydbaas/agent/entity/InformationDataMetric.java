package main.java.br.com.arida.ufc.mydbaas.agent.entity;

import java.util.Properties;
import main.java.br.com.arida.ufc.mydbaas.agent.entity.common.LoadMetric;
import main.java.br.com.arida.ufc.mydbaas.common.metric.database.InformationData;

/**
 * @author Daivd Araújo - @araujodavid
 * @version 1.0
 * @since July 11, 2013
 */
public class InformationDataMetric extends InformationData implements LoadMetric {

	private static InformationDataMetric uniqueInstance;
	
	private InformationDataMetric() {}

	public static InformationDataMetric getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new InformationDataMetric();
	    }
	    return uniqueInstance;
	}
	
	@Override
	public void loadMetricProperties(Properties properties) {
		this.setUrl(properties.getProperty("server")+properties.getProperty("informationData.url"));
		this.setCyclo(Integer.parseInt(properties.getProperty("informationData.cycle")));
		this.setEnabledDBMSs(properties.getProperty("informationData.dbms"));	
	}
}
