package com.walgreens.nice.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.walgreens.nice.dao.NiceDao;
import com.walgreens.nice.domain.HealthReport;
import com.walgreens.nice.domain.Query;
import com.walgreens.nice.domain.Record;

@Repository("niceDaoImpl")
public class NiceDaoImpl implements NiceDao {

	@Override
	public List<Query> retrieveQueries() {
		List<Query> queries = new ArrayList<Query>();
		queries.add(new Query("PW1PIA-NSLS01", "OK",
				"OK", Calendar.getInstance().getTime(),
				"OK", "OK", "OK"));
		queries.add(new Query("PW1PIA-NSLS02", "OK",
				"OK", Calendar.getInstance().getTime(),
				"OK", "OK", "OK"));
		queries.add(new Query("PW1PIA-NSLS03", "OK",
				"OK", Calendar.getInstance().getTime(),
				"OK", "OK", "OK"));
		
		return queries;
	}

	@Override
	public List<Record> executeQuery(Query query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HealthReport> listReports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HealthReport retrieveReport(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
