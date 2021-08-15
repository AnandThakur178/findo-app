package net.codejava;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

public class SNSPublisher {

	private static final String TOPICARN="arn:aws:sns:us-east-1:216822507497:EmailTopic-RegUser";
	
	
	

	
	
	public static void publishMessage(String message,String subject)
	{
		AWSCredentials credentials=new BasicAWSCredentials("AKIATE65A47UXPG633NH","MQ2LRtVBKrSwI8909plItgVGB1KJKRR9eaqLES4m");
		AmazonSNSClient snsclient=(AmazonSNSClient) AmazonSNSClientBuilder.standard()
			    .withCredentials(new AWSStaticCredentialsProvider(credentials))
			    .withRegion("us-east-1")
			    .build();
		
		
		snsclient.publish(TOPICARN,message,subject);
		
	}
	
	
	
	
	
	
}
