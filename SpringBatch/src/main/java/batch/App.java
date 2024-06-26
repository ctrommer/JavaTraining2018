package batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main( String[] args ) {

		String[] quelle = { "batch-job-mensch.xml" };

		try ( ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( quelle ) ) {

			JobLauncher jobLauncher = ( JobLauncher ) context.getBean("jobLauncher");
			Job job = ( Job ) context.getBean("menschBatchJob");
	
			JobExecution jobExecution = jobLauncher.run( job, new JobParameters() );
			System.out.println( "Batch Job Status: " + jobExecution.getStatus() );

		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}

		System.out.println( "Batch complete" );
	}
}