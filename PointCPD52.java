public class PointCPD52 extends AbstractPointCP{


	//Constructs polar coordinate object
	public PointCPD52(double rho, double theta)
	{
		this.rho = rho;
		this.theta = theta;
	}

	@Override  //Overrides abstract method of parent
	public double getX() {
		return (Math.cos(Math.toRadians(theta)) * rho);
	}

	@Override  //Overrides abstract method of parent
	public double getY() {
		return (Math.sin(Math.toRadians(theta)) * rho);
	}

	/**
		* Calculates the distance in between two points using the Pythagorean
		* theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
		*
		* @param pointA The first point.
		* @param pointB The second point.
		* @return The distance between the two points.
	*/
	public double getDistance(PointCPD52 pointB)
	{
		// Obtain differences in X and Y, sign is not important as these values
			 // will be squared later.
			 double deltaX = getX() - pointB.getX();
			 double deltaY = getY() - pointB.getY();

	 return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	/**
		* Rotates the specified point by the specified number of degrees.
		* Not required until E2.30
		*
		* @param point The point to rotate
		* @param rotation The number of degrees to rotate the point.
		* @return The rotated image of the original point.
	*/
	public PointCPD52 rotatePoint(double rotation)
	{
		double radRotation = Math.toRadians(rotation);
			 double X = getX();
			 double Y = getY();

			 double newX = (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y);
			 double newY = (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y);

			 return new PointCPD52(
			   	(Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2))),
	   			(Math.toDegrees(Math.atan2(newY, newX))));
	}

}
