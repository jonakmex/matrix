package com.walgreens.nice.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.walgreens.nice.dao.NiceDao;
import com.walgreens.nice.domain.HealthReport;
import com.walgreens.nice.domain.Query;
import com.walgreens.nice.domain.Record;
import com.walgreens.nice.domain.ReportHeader;

@Service("niceService")
public class NiceServiceImpl implements NiceService {
	
	@Autowired
	private NiceDao niceDao;
	
	@Value("${job.destinationFolder}")
	private String destinationFolder;
	@Value("${job.baseFolder}")
	private String baseFolder;
	@Value("${success}")
	private String success;
	@Value("${warning}")
	private String warning;
	@Value("${danger}")
	private String danger;
	
	@Override
	public void startReport() {
		System.out.println("startReport...");
	}

	@Override
	public void executeReport() {
		System.out.println("executeReport..."+destinationFolder);
		SimpleDateFormat dt = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		HealthReport report = new HealthReport();
		report.setFileName(destinationFolder+dt.format(Calendar.getInstance().getTime())+".html");
		
		/*HEADER*/
		ReportHeader header = new ReportHeader();
		header.setGenerationDate(Calendar.getInstance().getTime());
		header.setPreparedBy("System");
		header.setReviewedBy("System");
		report.setReportHeader(header);
		/*--HEADER*/
		
		/*DETAILS*/
		List<Query> queries = niceDao.retrieveQueries();
		for(Query q : queries){
			List<Record> records = niceDao.executeQuery(q);
			
		}
		report.setQueries(queries);
		
		/*--DETAILS*/
		generateHtml(report);
	}
	
	
	
	private void generateHtml(HealthReport report){
		String content = "";
		try {
			content = IOUtils.toString(new FileInputStream(baseFolder+"template.html"), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SimpleDateFormat reportDate = new SimpleDateFormat("dd-MMM-YY");
		SimpleDateFormat reportTime = new SimpleDateFormat("HH:mm:ss");
		
		content = content.replace("${preparedBy}", report.getReportHeader().getPreparedBy());
		content = content.replace("${reviewedBy}", report.getReportHeader().getReviewedBy());
		content = content.replace("${executionDate}", reportDate.format(report.getReportHeader().getGenerationDate()));
		content = content.replace("${executionTime}", reportTime.format(report.getReportHeader().getGenerationDate()));
		content = content.replace("${statusMonitor}", "E");
		content = content.replace("${statusReporter}", "F");
		content = content.replace("${statusAlarms}", "G");
		content = content.replace("${alarmsColor}", "bgcolor='"+success+"' ");
		
		StringBuilder queriesTable = new StringBuilder("");
		
		for(Query q:report.getQueries()){
			queriesTable.append("<tr>");
			SimpleDateFormat queriesDate = new SimpleDateFormat("MM-dd-YYYY hh:mm a");
			queriesTable.append("<td>").append(q.getLoggerServer()).append("</td>");
			queriesTable.append("<td>").append(q.getRecordingStatus()).append("</td>");
			queriesTable.append("<td>").append(q.getPlaybackStatus()).append("</td>");
			queriesTable.append("<td>").append(queriesDate.format(q.getLastRecordedTime())).append("</td>");
			queriesTable.append("<td>").append(q.getVoiceArchiving()).append("</td>");
			queriesTable.append("<td>").append(q.getScreenArchiving()).append("</td>");
			queriesTable.append("<td ").append(q.getOverallStatus().compareToIgnoreCase("OK") == 0 ? "bgcolor='"+success+"' " : "bgcolor='"+danger+"' " ).append("></td>");
			
			queriesTable.append("</tr>");
		}
		
		content = content.replace("${queriesTable}", queriesTable.toString());
		
		try {
			IOUtils.write(content, new FileOutputStream(report.getFileName()), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
