package com.company;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    static String GOOGLE_API_KEY = "DO_NOT_STEAL_MY_KEY";

    static String containerLocation = "/Users/mathew/Documents/GitHub/GeoTraceRoute/CW2 Russell Tarcert/src/com/company/russelCapture.trc";

    public static void main(String[] args) throws IOException {

        TraceRouteContainer traceRoutes = loadCapture(containerLocation);

        String app = "";
        int n =1;
        for(TraceRoute r :traceRoutes) {
            //app+= LatexUtils.createSectionTitle("Trace Route Dump"+(n++))+"\n";
            app+=LatexUtils.createGPSCoordinatesTable(r)+"\n";
        }

        System.out.println(app);



    }

    public static TraceRouteContainer loadCapture(String dir) throws IOException {
        TraceRouteContainer data = null;

        Load load = new Load(new File(dir));

        try {
            data = (TraceRouteContainer) load.load();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load");
        }
        return data;
    }


    public static void newCapture(String dir) throws IOException {
        List<TraceRoute> traceRoutes = Util.parseTraceRoutesFromFile("/Users/mathew/IntelliJ Java/CW2 Russell Tarcert/src/com/company/routes.txt");

        TraceRouteContainer container = new TraceRouteContainer();

        for(TraceRoute rt : traceRoutes) {
            container.add(rt);
        }

        Save save = new Save(new File(dir));

        if(save.write(container)){
            System.out.println("Container Saved");
        }
        else{
            System.out.println("Container Save Failed");
        }

        System.out.println(container);
    }

    public static void lookup(TraceRoute trace, String API, String color){
        int i =0;
        WhoIsAPI whoLookup = new WhoIsAPI(trace.getDestinationIP(), API);
        System.out.println(whoLookup.getLatitude()+", "+whoLookup.getLongitude()+", "+(i++)+"| "+whoLookup.getCity()+", "+color);

        for(Hop hop : trace.getHopList()){
            if(hop !=null) {
                whoLookup = new WhoIsAPI(hop.getRouterIP(), API);

               // System.out.println(hop.getRouterIP());
                System.out.println(whoLookup.getLatitude()+", "+whoLookup.getLongitude()+", "+(i++)+"| "+whoLookup.getCity()+", "+color);

                //System.out.println(whoLookup.getLatitude() + ", " + whoLookup.getLongitude() + ", " + whoLookup.getCity() + ", #FFFF00");

                //System.out.println(hop.getRouterAdress()+", "+hop.getRouterIP()+" Location: "+whoLookup.getLatitude() + ", " + whoLookup.getLongitude() + "; City:" + whoLookup.getCity() +" ISP:"+ whoLookup.getIsp());

            }
        }
    }
}
