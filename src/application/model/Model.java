package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model
{
	private List<AoiCoordinate> listOfAoiCoordinates = new ArrayList<>();

	public List<AoiCoordinate> getListOfAoiCoordinates()
	{
		return listOfAoiCoordinates;
	}

	public void getPPfromFile(String path) throws FileNotFoundException
	{
		File file = new File(path);
		Scanner scn = new Scanner(file);

		while (scn.hasNextLine())
		{
			String line = scn.nextLine();
			String[] coordinatesOfElement = line.split(";");

			if (coordinatesOfElement[0].startsWith("#C"))
			{
				String partNumber = coordinatesOfElement[0].replaceAll("#C ", "");
				float angle = Float.parseFloat(coordinatesOfElement[2]) - 90;

				AoiCoordinate aoiCoordinate = new AoiCoordinate(partNumber, coordinatesOfElement[1], angle,
						Float.parseFloat(coordinatesOfElement[3]), Float.parseFloat(coordinatesOfElement[4]));

				addAoiLine(aoiCoordinate);
			}
		}
	}

	public void addAoiLine(AoiCoordinate aoiCoordinate)
	{
		listOfAoiCoordinates.add(aoiCoordinate);
	}

	public void saveAoiCoordinatesToFile(String path) throws FileNotFoundException
	{
		PrintWriter printwriter = new PrintWriter(path);

		for (int i = 0; i < listOfAoiCoordinates.size(); i++)
		{
			printwriter.print(listOfAoiCoordinates.get(i).getPartNumber() + "\t"
					+ listOfAoiCoordinates.get(i).getReferenceDesignator() + "\t"
					+ listOfAoiCoordinates.get(i).getAngle() + "\t" + listOfAoiCoordinates.get(i).getX() + "\t"
					+ listOfAoiCoordinates.get(i).getY() + "\r\n");
		}

		printwriter.close();
	}

}
