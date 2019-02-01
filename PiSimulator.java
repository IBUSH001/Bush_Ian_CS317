package piSimulator;

import java.util.Random;

/**
 * The following program is a simulation designed to calculate 
 * pi to two decimal places (3.14).
 * @author ibush001
 * @version January 20, 2019
 */
public class PiSimulator {
	
	public int games, darts;
	
	public PiSimulator(int games, int darts)
	{
		this.games = games;
		this.darts = darts;
	}

	
	public void run()
	{
		double[] gameRuns = new double[games];
		//double[] stdInputs = new double[games];
		double sum = 0;
		for(int i = 0; i < games; i++)
		{
			double n = simulatePi();
			gameRuns[i] = n;
			sum += n;
		}
		double mean = sum / games;
		
		double diffSum = 0;
		
		for(int i = 0; i < games; i++)
		{
			double d = gameRuns[i] - mean;
			diffSum += (d*d);
		}
		
		double sRaw = diffSum / games;
		double sDev = Math.sqrt(sRaw);
		System.out.println(mean);
		System.out.println(sDev);
	}

	
	
	public double simulatePi()
	{
		int nIn = 0, nTotal = 0;
		double x, y;
		double dist;
		
		for(int i = 0; i < darts; i++)
		{
			x = Math.random() - 0.5;
			y = Math.random() - 0.5;
			
			dist = Math.sqrt((x*x) + (y*y));
			if(dist < 0.5)
			{
				nIn++;
			}
			nTotal++;	
		}
		double piEstimate = 4.0 * ((double)nIn / (double) nTotal);
		//System.out.println(piEstimate);
		return piEstimate;
	}
	
	public static void main(String[] args)
	{
		new PiSimulator(10,100000).run();
	}
}
