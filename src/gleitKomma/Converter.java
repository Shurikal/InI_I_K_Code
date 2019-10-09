package gleitKomma;

public class Converter {
    double xmin,xmax,ymin,ymax;
    int sHeight, sWidth;

    public Converter(){
    }

    public void setXmin(double xmin){
        this.xmin = xmin;
    }

    public void setXmax(double xmax){
        this.xmax = xmax;
    }

    public void setsHeight(int sHeight) {
        this.sHeight = sHeight;
    }

    public void setsWidth(int sWidth) {
        this.sWidth = sWidth;
    }

    public void setYmin(double ymin) {
        this.ymin = ymin;
    }

    public void setYmax(double ymax) {
        this.ymax = ymax;
    }


    public int calcX(double x){
        x = (x / (xmax - xmin)) * sWidth - (xmin / (xmax - xmin) * sWidth);
        return (int)x;
    }

    public int calcY(double y){
        y = (y / (ymax - ymin)) * sHeight - (ymin / (ymax - ymin) * sHeight) - sHeight;
        return (int)-y;
    }
}

