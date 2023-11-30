public class PointCPD54 extends AbstractPointCP{

	private double x;
	private double y;

	public PointCPD54(char type, double xOrRho, double yOrTheta)
	{
		if(type != 'C' && type != 'P')
			throw new IllegalArgumentException();
	 	else if(type == 'C') {
	 		x = xOrRho;
	 		y = yOrTheta;
	 		rho = (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
	 		theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
	 	}
	 	else {
	 		rho = xOrRho;
	 		theta = yOrTheta;
	 		x = (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
	 		y = (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
	 	}
	}

	@Override //Overrides abstract method of parent
	public double getX() {
		return x;
	}

	@Override  //Overrides abstract method of parent
	public double getY() {
		return y;
	}

	public double getDistance(PointCPD54 pointB)
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
		public PointCPD54 rotatePoint(double rotation)
		{
		 double radRotation = Math.toRadians(rotation);
		 double X = getX();
		 double Y = getY();

		 return new PointCPD54('C',
		   (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
		   (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}

}
