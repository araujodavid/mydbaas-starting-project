package main.java.br.com.arida.ufc.mydbaas.core.repository.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractMetricRepository {
	
	private List<String> tables;

	public abstract boolean saveMetric(Object metric, String recordDate, int machine, int host, int dbms, int database) throws Exception;	
	
	public abstract boolean createMetricTable(Object metric);
	
	public abstract String makeCreateTableCommand(Object metric, List<Field> fields);
	
	public abstract String makeInsertCommand(Object metric, List<Field> fields, int machine, int host, int dbms, int database);
	
	public abstract List<String> getMetricTables();
	
	public abstract Object queryMetric(String sql, Class<?> metricClass) throws Exception;
	
	public abstract List<Object> queryMetrics(String sql, Class<?> metricClass) throws Exception;
	
	public abstract String makeQueryCommand(Class<?> metricClass, int queryType, String resourceType, int resourceID, int queryRange, String startDatetime, String endDatetime);
	
	protected abstract boolean insertMetric(Object metric, String recordDate, int machine, int host, int dbms, int database) throws Exception;
	
	/**
	 * Method to recover the fields of a given metric object
	 * @param metric - given metric object
	 * @return the list of class fields
	 */
	public List<Field> getMetricFields(Object metric) {
		List<Field> fields = new ArrayList<Field>();		
		//Gets the class of the metric
		Class<?> clazz = metric.getClass();		
		//Gets fields from the class
		fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
		
		return fields;
	}//getMetricFields()
	
	/**
	 * Method to recover the fields of a given metric class
	 * @param metricClass - given metric class
	 * @return the list of class fields
	 */
	public List<String> getMetricTableFields(Class<?> metricClass) {
		List<String> tableFields = new ArrayList<String>();	
		for (Field metricField : metricClass.getDeclaredFields()) {
			tableFields.add(metricField.getName().toLowerCase().replaceAll(metricClass.getSimpleName().toLowerCase(), ""));
		}		
		return tableFields;
	}//getMetricFields()
	
	/**
	 * Method that checks if there is the table of a given metric.	
	 * @param metric - given metric object
	 * @return whether the table exists or not
	 */
	public boolean checkTable(Object metric) {
		String clazzName = metric.getClass().getSimpleName().toLowerCase();
		for (String table : this.tables) {
			if (table.equals(clazzName+"_metric")) {
				return true;
			}
		}
		return false;
	}//checkTable()
}
