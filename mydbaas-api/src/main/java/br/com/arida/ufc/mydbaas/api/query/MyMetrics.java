package main.java.br.com.arida.ufc.mydbaas.api.query;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import main.java.br.com.arida.ufc.mydbaas.api.client.MyDBaaSClient;
import main.java.br.com.arida.ufc.mydbaas.api.util.SendResquest;
import main.java.br.com.arida.ufc.mydbaas.common.metric.common.AbstractMetric;
import main.java.br.com.arida.ufc.mydbaas.common.resource.common.AbstractEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import com.google.gson.Gson;

/**
 * Class that controls access to resource metrics.
 * @author Daivd Araújo - @araujodavid
 * @version 2.0
 * @since May 8, 2013
 */
public class MyMetrics {
	
	public final static String RESOURCE_TYPE_HOST = "host";
	public final static String RESOURCE_TYPE_VM = "machine";
	public final static String RESOURCE_TYPE_DBMS = "dbms";
	public final static String RESOURCE_TYPE_DATABASE = "database";
	
	private MyDBaaSClient client;
	
	/**
	 * Default constructor
	 * @param client - MyDBaaSMonitorClient object
	 */
	public MyMetrics(MyDBaaSClient client) {
		this.client = client;
	}
	
	/**
	 * Method to requests about the last collection of a particular metric
	 * @param metricName
	 * @param resourceType
	 * @param resourceID
	 * @param startDatetime
	 * @param endDatetime
	 * @return an metric object
	 */
	public Object getMetricSingle(Class<?> metricClazz, Object resource, String resourceType, String startDatetime, String endDatetime) {
		Method getId = null;
		try {
			getId = AbstractEntity.class.getDeclaredMethod("getId", null);
		} catch (NoSuchMethodException e2) {
			e2.printStackTrace();
		} catch (SecurityException e2) {
			e2.printStackTrace();
		}
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("metricName", metricClazz.getName()));
		parameters.add(new BasicNameValuePair("resourceType", resourceType));
		parameters.add(new BasicNameValuePair("queryType", "0"));
		try {
			parameters.add(new BasicNameValuePair("resourceID", String.valueOf(getId.invoke(resource, null))));
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		if (startDatetime != null && !startDatetime.trim().equals("")) {
			parameters.add(new BasicNameValuePair("startDatetime", startDatetime));
		}
		if (endDatetime != null && !endDatetime.trim().equals("")) {
			parameters.add(new BasicNameValuePair("endDatetime", endDatetime));
		}
		
		HttpResponse response;
		String json = null;
		try {
			response = SendResquest.postRequest(this.client.getServerUrl()+"/metric/single", parameters, "UTF-8");
			json = SendResquest.getJsonResult(response);
			System.out.println(json);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Object metric = gson.fromJson(json, metricClazz);
		return metric;
	}
	
	/**
	 * Method to requests collections of a particular metric
	 * @param metricName
	 * @param resourceType
	 * @param resourceID
	 * @param startDatetime
	 * @param endDatetime
	 * @return json of the metric
	 */
	public List<Object> getMetricMulti(Class<?> metricClazz, Object resource, String resourceType, String startDatetime, String endDatetime) {
		Method getId = null;
		try {
			getId = AbstractEntity.class.getDeclaredMethod("getId", null);
		} catch (NoSuchMethodException e2) {
			e2.printStackTrace();
		} catch (SecurityException e2) {
			e2.printStackTrace();
		}
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("metricName", metricClazz.getName()));
		parameters.add(new BasicNameValuePair("resourceType", resourceType));
		parameters.add(new BasicNameValuePair("queryType", "1"));
		try {
			parameters.add(new BasicNameValuePair("resourceID", String.valueOf(getId.invoke(resource, null))));
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		if (startDatetime != null && !startDatetime.trim().equals("")) {
			parameters.add(new BasicNameValuePair("startDatetime", startDatetime));
		}
		if (endDatetime != null && !endDatetime.trim().equals("")) {
			parameters.add(new BasicNameValuePair("endDatetime", endDatetime));
		}
		
		HttpResponse response;
		String json = null;
		try {
			response = SendResquest.postRequest(this.client.getServerUrl()+"/metric/single", parameters, "UTF-8");
			json = SendResquest.getJsonResult(response);
			System.out.println(json);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Object> metricList = null;
		try {
			Object metric = metricClazz.newInstance();
			Method jsonToListMethod = AbstractMetric.class.getDeclaredMethod("jsonToList", String.class);
			metricList = (List<Object>) jsonToListMethod.invoke(metric, json);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return metricList;
	}
	
	/**
	 * Method to requests collections of a particular metric
	 * @param metricName
	 * @param resourceType
	 * @param resourceID
	 * @param startDatetime
	 * @param endDatetime
	 * @return a json of the metric list
	 */
	public List<Object> getMetricCollection(Class<?> metricClazz, Object resource, String resourceType, String startDatetime, String endDatetime) {
		Method getId = null;
		try {
			getId = AbstractEntity.class.getDeclaredMethod("getId", null);
		} catch (NoSuchMethodException e2) {
			e2.printStackTrace();
		} catch (SecurityException e2) {
			e2.printStackTrace();
		}
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("metricName", metricClazz.getName()));
		parameters.add(new BasicNameValuePair("resourceType", resourceType));
		
		try {
			parameters.add(new BasicNameValuePair("resourceID", String.valueOf(getId.invoke(resource, null))));
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		if (startDatetime != null && !startDatetime.trim().equals("")) {
			parameters.add(new BasicNameValuePair("startDatetime", startDatetime));
		}
		if (endDatetime != null && !endDatetime.trim().equals("")) {
			parameters.add(new BasicNameValuePair("endDatetime", endDatetime));
		}
		
		HttpResponse response;
		String json = null;
		try {
			response = SendResquest.postRequest(this.client.getServerUrl()+"/metric/multi", parameters, "UTF-8");
			json = SendResquest.getJsonResult(response);
			System.out.println(json);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

		List<Object> metricList = null;
		try {
			Object metric = metricClazz.newInstance();
			Method jsonToListMethod = AbstractMetric.class.getDeclaredMethod("jsonToList", String.class);
			metricList = (List<Object>) jsonToListMethod.invoke(metric, json);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return metricList;
	}
}
