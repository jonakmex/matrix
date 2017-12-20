package com.walgreens.nice.dao;

import java.util.List;

import com.walgreens.nice.domain.HealthReport;
import com.walgreens.nice.domain.Query;
import com.walgreens.nice.domain.Record;

public interface NiceDao {
	List<Query> retrieveQueries();
	List<Record> executeQuery(Query query);
	List<HealthReport> listReports();
	HealthReport retrieveReport(String fileName);
}
