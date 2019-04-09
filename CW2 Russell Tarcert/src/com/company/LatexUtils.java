package com.company;

public class LatexUtils {

    public static final String TABLE_HEADER = "\\begin{tabular}{ ||c|c|c|c||  }\n" +
            "\\hline\n" +
            "\\multicolumn{4}{||c||}{GPS data for route: <IP>(<Address>)} \\\\" +
            "\\hline\n" +
            "Router IP & Router Address & GPS 1 (Who is) & GPS 2(Extreme Lookup )\\\\\n" +
            "\\hline\n";
    public final static String TABLE_ROW = "<IP>&<Address> &<GPS 1 Lat>, <GPS 1 Long>& <GPS 2 Lat>, <GPS 2 Long>\\\\\n";
    public final static String TABLE_END = "\\hline\n" +
            "\\end{tabular}";
    public final static String SUB_SECTION = "\\*subsection <title>";

    public static String createSectionTitle(String title){
        return new String(SUB_SECTION).replace("<title>", title);
    }
    public static String createGPSCoordinatesTable(TraceRoute traceRoute){
        String app = TABLE_HEADER;

        app = app.replaceFirst("<destination IP>", traceRoute.getDestinationIP() +"("+traceRoute.getDestinationAddress()+")");

        for(Hop hop : traceRoute.getHopList()) app+=generateRow(hop);

        app+=TABLE_END;

        return app;
    }

    private static String generateRow(Hop hop){
        String row = LatexUtils.TABLE_ROW;

        if(hop !=null) {
            row = row.replaceFirst("<IP>", hop.getRouterIP());
            row = row.replaceFirst("<Address>", hop.getRouterAdress());
            //row = row.replaceFirst("<time>", ((hop.getTime1()+hop.getTime2()+hop.getTime3())/3.0)+"ms" );
            row = row.replaceFirst("<GPS 1 Lat>", hop.getWhoIsAPIData().getLatitude() + "");
            row = row.replaceFirst("<GPS 1 Long>", hop.getWhoIsAPIData().getLongitude() + "");
            row = row.replaceFirst("<GPS 2 Lat>", hop.getExtremeAPIData().getLatitude() + "");
            row = row.replaceFirst("<GPS 2 Long>", hop.getExtremeAPIData().getLongitude() + "");
        }
        else{
            row = row.replaceFirst("<IP>", "NO DATA");
            row = row.replaceFirst("<Address>", "NO DATA");
            //row = row.replaceFirst("<time>", ((hop.getTime1()+hop.getTime2()+hop.getTime3())/3.0)+"ms" );
            row = row.replaceFirst("<GPS 1 Lat>", "NO DATA");
            row = row.replaceFirst("<GPS 1 Long>", "NO DATA");
            row = row.replaceFirst("<GPS 2 Lat>", "NO DATA");
            row = row.replaceFirst("<GPS 2 Long>", "NO DATA");
        }
        return row;
    }

    public static void main(String args[]){

    }

}
