package main.java.br.com.arida.ufc.mydbaas.core.controller.api.common;

import br.com.caelum.vraptor.Result;
import main.java.br.com.arida.ufc.mydbaas.core.repository.common.AbstractMetricRepository;

public abstract class AbstractMetricQuery<T extends AbstractMetricRepository> {

	protected Result result;
	protected T metricRepository;
	
	public AbstractMetricQuery(Result result) {
		this.result = result;
	}
	
	/**
	 * Method to requests about the last collection of a particular metric
	 * @param metricName - Metric name
	 * @param resourceType - Resource type
	 * @param metricType - Metric type
	 * @param resourceID - Resource ID
	 * @param startDatetime - Start time
	 * @param endDatetime - End time
	 * Return json of the metric
	 */
	public abstract void getMetricSingle(String metricName, String resourceType, int queryType, int resourceID, String startDatetime, String endDatetime);
	
	/**
	 * Method to requests collections of a particular metric
	 * @param metricName - Metric name
	 * @param resourceType - Resource type
	 * @param metricType - Metric type
	 * @param resourceID - Resource ID
	 * @param startDatetime - Start time
	 * @param endDatetime - End time
	 * Return a json of the metric list
	 */
	public abstract void getMetricCollection(String metricName, String resourceType, int resourceID, String startDatetime, String endDatetime);
}
