/*
 * Create a new version of the Circle class where the draw method will be overloaded three times: 
 * 1. Using the one parameter color of String type.
 * 2. Using the one parameter scale of float type.
 * 3. Using two parameters color and scale of String and float type.
 */
 
/**
 * @author Bogdan Kurchak
 */
class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int[] getXYPair() {
        return new int[]{this.x, this.y};
    }
    
    public double distance() {
        return Math.sqrt(Math.pow(-this.x, 2) 
                + Math.pow(-this.y, 2));
    }
    
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow((x - this.x), 2) 
                + Math.pow((y - this.y), 2));
    }
    
    public double distance(Point point) {
        return Math.sqrt(Math.pow((point.x - this.x), 2) 
                + Math.pow((point.y - this.y), 2));
    }
}
