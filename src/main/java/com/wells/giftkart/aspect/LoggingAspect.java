
package com.wells.giftkart.aspect;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect  {

	public void statTime()
	{
		System.out.println("start time is :  "+ Calendar.getInstance().getTime());
	}
	
	public void timer(ProceedingJoinPoint joinpoint)
	{
		long starttime=Calendar.getInstance().getTimeInMillis();
		try {
			joinpoint.proceed();
		long endtime=Calendar.getInstance().getTimeInMillis();
		
		System.out.println("time taken to execute method is: "+ (endtime - starttime));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
