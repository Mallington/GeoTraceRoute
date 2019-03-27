package com.company;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Hop extends MasterLookupInfo implements Serializable {

    private int hopID;
    private String routerAdress = null;
    private String routerIP = null;

    private double time1;
    private double time2;
    private double time3;



    public Hop(String hopData) {
        super();
        List<String> dataPieces = splitData(hopData);

        if(dataPieces.size()>8){
            hopID = Integer.parseInt(dataPieces.get(0));
            routerAdress = dataPieces.get(1);
            routerIP = dataPieces.get(2).replaceAll("[(]|[)]","");

            extractTimes(dataPieces);

            super.lookup(routerIP);
        }
    }

    private List<String> splitData(String hopData){
        return Arrays.asList(hopData.split("(  )|( )"));
    }

    private void extractTimes(List<String> dataPieces){
        int time = 1;

        for(int i= 4; i< dataPieces.size(); i++){
            if(dataPieces.get(i).contains("ms")){
                try {
                    double hopTime = time1 = Double.parseDouble(dataPieces.get(i - 1));

                    switch (time) {
                        case 1:
                            time1 = hopTime;
                            break;
                        case 2:
                            time2 = hopTime;
                            break;
                        case 3:
                            time3 = hopTime;
                            break;
                    }
                    time++;
                }
                catch (Exception e){
                    System.out.println("Failed to parse: "+dataPieces.get(i-1));
                }
            }
        }
    }

    public int getHopID() {
        return hopID;
    }

    public String getRouterAdress() {
        return routerAdress;
    }

    public String getRouterIP() {
        return routerIP;
    }

    public double getTime1() {
        return time1;
    }

    public double getTime2() {
        return time2;
    }

    public double getTime3() {
        return time3;
    }

    @Override
    public String toString(){
        String app = "";

        app+=routerAdress+" ("+routerIP+")"+"  ["+time1+", "+time2+", "+time3+"] Coordinates: ";

        LookupInfo info = getExtremeAPIData();

        if(info !=null){
            app+=info.latitude+", "+info.longitude;
        }
        else{
            app+="No lookup data";
        }
        return app;
    }
}
