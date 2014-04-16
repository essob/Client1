package Client1;
import java.io.*;

import labd.Commodity;

public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    private String request;
    private Commodity[] commodities;
    
    public Response(String request, Commodity[] commodities) {
        this.request = request;
        this.commodities = commodities;
    }

    public String getRequest() {
        return request;
    }

    public Commodity[] getCommodities() {
        return commodities;
    }
}
