import java.io.*;
import java.util.Random;

public class PointCPD2Test
{
	public static void main(String[] args) throws IOException
	{
		int loopSize = 100000000;
		Random random = new Random();
		Double min = 0.0;
		Double maxTheta = 360.0;

		//Calculates distance time loop

		PointCPD2 pointA = getInput();
		PointCPD2 pointB = getInput();
		long startTime = System.currentTimeMillis(); //timer is initiated, logging begins
		for(int i = 0; i < loopSize; i++)
		{
			double distance = pointA.getDistance(pointB);
		}
		long stopTime = System.currentTimeMillis(); //timer is halted, logging stops
		//computes time difference - reports the difference as time taken to execute the block
		long distanceTime = stopTime - startTime;
		System.out.println("Distance time is: " + distanceTime);

		//calculates rotation time loop
		pointA = getInput();
		startTime = System.currentTimeMillis(); //timer is initiated, logging begins
		double theta = (Math.random() * ((maxTheta - min) + 1)) + min;   // This Will Create A Random Number Inbetween Your Min And MaxTheta.
		for(int i = 0; i < loopSize; i++)
		{
			pointA = pointA.rotatePoint(theta);
		}
		stopTime = System.currentTimeMillis(); //timer is halted, logging stops
		//computes time difference - reports the difference as time taken to execute the block
		long rotationTime = stopTime - startTime;
		System.out.println("Rotation time is: " + rotationTime);
	}


	/**
	   * This method obtains input from the user and verifies that
	   * it is valid.  When the input is valid, it returns a PointCP
	   * object.
	   *
	   * @return A PointCP constructed using information obtained
	   *         from the user.
	   * @throws IOException If there is an error getting input from
	   *         the user.
	   */
	private static PointCPD2 getInput() throws IOException
	{
		Random random = new Random();
		Double min = 0.0;
		Double maxRho = 200.0;
		Double maxTheta = 360.0;
        double rho = (Math.random() * ((maxRho - min) + 1)) + min;   // This Will Create A Random Number Inbetween Your Min And MaxRho.
        double theta = (Math.random() * ((maxTheta - min) + 1)) + min;   // This Will Create A Random Number Inbetween Your Min And MaxTheta.

	   	return new PointCPD2(rho, theta);

  	}
}

