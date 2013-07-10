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
public class StatementStatus extends AbstractDatabaseMetric {

	private int statementCommits;
	private int statementRollback;
	
	public int getStatementCommits() {
		return statementCommits;
	}

	public void setStatementCommits(int statementCommits) {
		this.statementCommits = statementCommits;
	}

	public int getStatementRollback() {
		return statementRollback;
	}

	public void setStatementRollback(int statementRollback) {
		this.statementRollback = statementRollback;
	}

	@Override
	public String toString() {
		return "database";
	}

	@Override
	public List<StatementStatus> jsonToList(String json) {
		Gson gson = new Gson();
		List<StatementStatus> statementStatusList = gson.fromJson(json, new TypeToken<List<StatementStatus>>(){}.getType());
		return statementStatusList;
	}
}
