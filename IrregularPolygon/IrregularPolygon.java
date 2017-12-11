
/**
 * Write a description of class IrregularPolygon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
//import gpdraw.*;            // for DrawingTool
import java.awt.geom.Line2D; // for Line2D
import java.io.*;

public class IrregularPolygon{
    private ArrayList <Point2D.Double> myPolygon;
    private int numPoint=0;

    // constructors
    public IrregularPolygon() { 

    }

    public static void main() {
        String line = null;
        String fileName = "coords.txt";        
        IrregularPolygon polygon = new IrregularPolygon();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null) {
                double x= Double.valueOf(line.substring(0,line.indexOf(",")));
                double y= Double.valueOf(line.substring(line.indexOf(",")+1));
                Point2D.Double aPoint = new Point2D.Double(x,y);
                polygon.add(aPoint);
            }   

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  

        }
    }
    // public methods
    public void add(Point2D.Double aPoint) { 
        myPolygon.add(aPoint);
        numPoint++;
    }

    public void draw() { 

    }

    public double perimeter() { 
        double perimeter = 0.0;
        if (myPolygon.size() > 0) {
            for (int pos = 0; pos < myPolygon.size(); pos++)
            {
                Point2D.Double myPoint  = (Point2D.Double)myPolygon.get(pos);
                Point2D.Double nextPoint = (Point2D.Double)myPolygon.get((pos + 1) % myPolygon.size());
                double x = nextPoint.getX() - myPoint.getX();
                double y = nextPoint.getY() - myPoint.getY();
                perimeter += Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2));
            }
        }
        return perimeter;
    }

    public double area() { 
        double area=0;
        double total=0;
        int xPos, yPos;
        double myX, myY;
        for (xPos = 0, yPos = 1; xPos < (myPolygon.size() - 1) && yPos < myPolygon.size(); xPos ++, yPos ++)
        {
            myX = ((Point2D.Double)(myPolygon.get(xPos))).getX();
            myY = ((Point2D.Double)(myPolygon.get(yPos))).getY();
            total += myX * myY;
        }
        total += ((( Point2D.Double )(myPolygon.get(myPolygon.size() - 1))).getX()) * 
        ((( Point2D.Double )(myPolygon.get(0))).getY() );

        for (yPos = 0, xPos = 1; yPos < (myPolygon.size() - 1) && xPos < myPolygon.size(); xPos ++, yPos ++)
        {
            myX = ((Point2D.Double)(myPolygon.get(xPos))).getX();
            myY = ((Point2D.Double)(myPolygon.get(yPos))).getY();
            total -= myX * myY;
        }
        total -= ((( Point2D.Double )(myPolygon.get(myPolygon.size() - 1))).getY() ) * 
        ((( Point2D.Double )(myPolygon.get(0))).getX() );
        area = total / 2;    
        return Math.abs(area);
    }

}

