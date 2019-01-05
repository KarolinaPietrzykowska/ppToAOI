package application.model;

public class AoiCoordinate
{
	private String partNumber;
	private String referenceDesignator;
	private float angle;
	private float x;
	private float y;
	
	public AoiCoordinate(String partNumber, String referenceDesignator, float angle, float x, float y)
	{
		this.partNumber = partNumber;
		this.referenceDesignator = referenceDesignator;
		this.angle = angle;
		this.x = x;
		this.y = y;
	}

	public String getPartNumber()
	{
		return partNumber;
	}

	public String getReferenceDesignator()
	{
		return referenceDesignator;
	}

	public float getAngle()
	{
		return angle;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}
}
