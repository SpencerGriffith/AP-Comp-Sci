
/**
 * Write a description of class IrregularPolygon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon
{
    private ArrayList<Point2D.Double> myPolygon;
    private SketchPad myPaper;
    private DrawingTool myPencil;
    // constructors
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
        myPaper = new SketchPad(500,500);
        myPencil = new DrawingTool(myPaper);
    }

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }


    public void draw()
    {
        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        for(int i=0; i<myPolygon.size(); i++)
        {
            if(i<myPolygon.size()-1) {
                x1 = myPolygon.get(i).getX();
                y1 = myPolygon.get(i).getY();
                x2 = myPolygon.get(i+1).getX();
                y2 = myPolygon.get(i+1).getY();
            }
            else {
                x1= myPolygon.get(i).getX();
                y1 = myPolygon.get(i).getY();
                x2 = myPolygon.get(0).getX();
                y2 = myPolygon.get(0).getY();
            }
            myPencil.up();
            myPencil.move(x1,y1);
            myPencil.down();
            myPencil.move(x2,y2);
        }
    }

    public double perimeter()
    {
        double perimeter = 0;
        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        double distance = 0;
        for(int i=0; i<myPolygon.size(); i++)
        {
            if(i<myPolygon.size()-1) {
                x1 = myPolygon.get(i).getX();
                y1 = myPolygon.get(i).getY();
                x2 = myPolygon.get(i+1).getX();
                y2 = myPolygon.get(i+1).getY();
            }
            else {
                x1= myPolygon.get(i).getX();
                y1 = myPolygon.get(i).getY();
                x2 = myPolygon.get(0).getX();
                y2 = myPolygon.get(0).getY();
            }
            distance = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
            perimeter += distance;
        }
        return perimeter;
    }

    public double area()
    {
        double x = 0;
        double y = 0;
        double x0 = 0;
        double y1 = 0;
        double y0 = 0;
        double x1 = 0;
        for(int i=0; i<myPolygon.size(); i++)
        {            
            if(i<myPolygon.size()-1) {
                x0 = myPolygon.get(i).getX();
                y1 = myPolygon.get(i+1).getY();
                y0 = myPolygon.get(i).getY();
                x1 = myPolygon.get(i+1).getX();
                x += x0*y1;
                y += y0*x1;            
            }
            else {
                x0= myPolygon.get(i).getX();
                y0 = myPolygon.get(i).getY();
                x1 = myPolygon.get(0).getX();
                y1 = myPolygon.get(0).getY();
                x += x0*y1;
                y += y0*x1; 
            }
        }
        return Math.abs((x-y)/2);
    }

    public String getName() {
        return "Spencer Griffith";    
    }
}

