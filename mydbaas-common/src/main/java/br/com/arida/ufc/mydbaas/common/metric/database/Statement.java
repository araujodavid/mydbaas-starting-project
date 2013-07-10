package main.java.br.com.arida.ufc.mydbaas.common.metric.database;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.br.com.arida.ufc.mydbaas.common.metric.common.AbstractDatabaseMetric;

/**
 * @author David Araújo - @araujodavid
 * @version 1.0
 * @since July 9, 2013
 */
public class Statement extends AbstractDatabaseMetric {

	private int statementInserts;
	private int statementSelects;
	private int statementUpdates;
	private int statementDeletes;
	
	public int getStatementInserts() {
		return statementInserts;
	}

	public void setStatementInserts(int statementInserts) {
		this.statementInserts = statementInserts;
	}

	public int getStatementSelects() {
		return statementSelects;
	}

	public void setStatementSelects(int statementSelects) {
		this.statementSelects = statementSelects;
	}

	public int getStatementUpdates() {
		return statementUpdates;
	}

	public void setStatementUpdates(int statementUpdates) {
		this.statementUpdates = statementUpdates;
	}

	public int getStatementDeletes() {
		return statementDeletes;
	}

	public void setStatementDeletes(int statementDeletes) {
		this.statementDeletes = statementDeletes;
	}

	@Override
	public String toString() {
		return "database";
	}
	
	@Override
	public List<Statement> jsonToList(String json) {
		Gson gson = new Gson();
		List<Statement> statementList = gson.fromJson(json, new TypeToken<List<Statement>>(){}.getType());
		return statementList;
	}
}
