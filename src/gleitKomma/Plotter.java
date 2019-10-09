package gleitKomma;


public class Plotter {

    private double xmin,xmax;
    private double ymin,ymax;

    private double[][] data;

    public double f(double x){
        double y;
        y = Math.min(x*x,1);
        return y;
    }

    public void setXmin(double xmin){
        this.xmin = xmin;
    }

    public void setXmax(double xmax){
        this.xmax = xmax;
    }

    public void calc(int size){
        data = new double[size+1][2];
        ymin = Double.POSITIVE_INFINITY;
        ymax = Double.NEGATIVE_INFINITY;
        double step = (xmax -xmin)/(double)size;
        int i = 0;
        for(double d = xmin;d <=xmax;d+=step){
            double cache = f(d);
            if(cache < ymin){
                ymin=cache;
            }
            if(cache > ymax){
                ymax = cache;
            }
            data[i][0] = d;
            data[i][1] = cache;
            i++;
        }
    }

    public double getYmin() {
        return ymin;
    }

    public double getYmax() {
        return ymax;
    }

    public double getXmax() {
        return xmax;
    }

    public double getXmin() {
        return xmin;
    }

    public double[][] getData(){
        return data;
    }
}
