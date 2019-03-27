package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TraceRoute extends MasterLookupInfo implements Serializable {
    private boolean validTraceRoute = false;
    private List<Hop> hopList = new ArrayList<>();
    private String destinationAddress = null;
    private String destinationIP = null;

    public TraceRoute(String traceRouteDump) {
        super();
        String header = Util.getHeader(traceRouteDump);
        if(header !=null){

            parseHeader(header);
            addHops(traceRouteDump);

            validTraceRoute = true;
            super.lookup(destinationIP);
        }

    }

    public boolean isValidTraceRoute() {
        return validTraceRoute;
    }
    private void parseHeader(String header){
        List<String> info = Util.getHeaderInfo(header);
        destinationAddress = info.get(0);
        destinationIP = info.get(1);
    }

    private void addHops(String traceRouteDump){
        List<String> hops = Util.getHops(traceRouteDump);

        for(String hop: hops){
            if(hop.contains("*")){
                hopList.add(null);
            }
            else{
                hopList.add(new Hop(hop));
            }
        }
    }

    @Override
    public String toString(){
        String app = "Destination: "+destinationAddress+", "+destinationIP+"\n";
        for(int i =0; i< hopList.size(); i++){
            Hop hop = hopList.get(i);
            if(hop!=null){
                app+="Hop ["+i+"]: "+hop;
            }
            else{
                app+="Hop ["+i+"]: "+"No Hop Data";
            }
            app+="\n";
        }
        return app;
    }


    public String getDestinationAddress() {
        return destinationAddress;
}

    public String getDestinationIP() {
        return destinationIP;
    }

    public List<Hop> getHopList() {
        return hopList;
    }
}
