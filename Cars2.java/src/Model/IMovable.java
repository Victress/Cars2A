package Model;

public interface IMovable {
    /**
     * Interface to move cars.
     * Connected with Model.Saab95 and Model.Volvo240.
     *
     * @return
     */
    void move();
    void turnLeft();
    void turnRight();
    void setX (double x);
    void setY(double y);
    double getX ();
    double getY ();

}