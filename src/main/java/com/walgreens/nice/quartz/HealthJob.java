package com.walgreens.nice.quartz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.quartz.CronExpression;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.walgreens.nice.service.NiceService;

/**
 * 
 * @author jgomez6t
 * This class evaluates if the job needs to be executed
 * It reads the execution conditions from configuration file
 *
 */
public class HealthJob extends QuartzJobBean {
	
	private NiceService niceService;
	
	public void setNiceService(NiceService niceService) {
		this.niceService = niceService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		String jobCron = "";
		Date nextExecution = Calendar.getInstance().getTime();
		Properties prop = new Properties();
		InputStream config = null,store = null;
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		
		try {
			Date lastExecution = new Date();
			config = new FileInputStream("src\\main\\resources\\config.properties");
			store = new FileInputStream("src\\main\\resources\\execution.properties");
			prop.load(config);
			prop.load(store);
			jobCron = prop.getProperty("job.cron");
			lastExecution = prop.getProperty("job.lastexecution") == null ? null : dt.parse(prop.getProperty("job.lastexecution"));
			CronExpression cronExpression = new CronExpression(jobCron);
			
			nextExecution = lastExecution == null ? Calendar.getInstance().getTime() : cronExpression.getNextValidTimeAfter(lastExecution);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (store != null) {
				try {
					store.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (config != null) {
				try {
					config.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Date executionTime = Calendar.getInstance().getTime();
		if(nextExecution.compareTo(executionTime) <= 0){
			prop = new Properties();
			System.out.println("Executing at "+dt.format(executionTime));
			niceService.executeReport();
						
			OutputStream output = null;
			try {
				
				output = new FileOutputStream("src\\main\\resources\\execution.properties");

				// set the properties value
				prop.setProperty("job.cron", jobCron);
				prop.setProperty("job.lastexecution", dt.format(executionTime));
				// save properties to project root folder
				prop.store(output, null);

			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}
		else{
			System.out.println("Now: "+dt.format(executionTime));
			System.out.println("Next: "+dt.format(nextExecution));
		}
	}

}
