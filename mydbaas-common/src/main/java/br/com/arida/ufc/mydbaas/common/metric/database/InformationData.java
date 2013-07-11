package main.java.br.com.arida.ufc.mydbaas.common.metric.database;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.br.com.arida.ufc.mydbaas.common.metric.common.AbstractDatabaseMetric;

/**
 * @author David Araújo - @araujodavid
 * @version 1.0
 * @since July 11, 2013
 */
public class InformationData extends AbstractDatabaseMetric {

	private int informationDataDatabases;
	private int informationDataTables;
	
	public int getInformationDataDatabases() {
		return informationDataDatabases;
	}

	public void setInformationDataDatabases(int informationDataDatabases) {
		this.informationDataDatabases = informationDataDatabases;
	}

	public int getInformationDataTables() {
		return informationDataTables;
	}

	public void setInformationDataTables(int informationDataTables) {
		this.informationDataTables = informationDataTables;
	}

	@Override
	public String toString() {
		return "database";
	}

	@Override
	public List<InformationData> jsonToList(String json) {
		Gson gson = new Gson();
		List<InformationData> informationDataList = gson.fromJson(json, new TypeToken<List<InformationData>>(){}.getType());
		return informationDataList;
	}

}
