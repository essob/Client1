package Client1;
import java.io.*;

public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    private String request;
    private double minPrice;
    private double maxPrice;
    
    public Request(String request) {
        this.request = request;
    }
    
    public Request(String request, double minPrice, double maxPrice) {
        this.request = request;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getRequest() {
        return request;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }
}
