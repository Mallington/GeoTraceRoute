package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    /*Collects all of the captured groups from a regex formula and puts it in a list*/
    public static List<String> convertToArray(String toSplit, String patternRegex) {

        Pattern pattern = Pattern.compile(patternRegex);
        List<String> splitUpList = new ArrayList<String>();
        Matcher matcher = pattern.matcher(toSplit);

        while (matcher.find()) {
            splitUpList.add(matcher.group());
        }

        return splitUpList;
    }

    public static String getHeader(String traceRouteDump){
        List<String> header = Util.convertToArray(traceRouteDump, "(?:traceroute to .+ [(])[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}(?:[)], [0-9]+ hops max, [0-9]+ byte packets)");

        if (header.size() > 0) {
            return header.get(0);
        }
        return null;
    }

    public static List<String> getIndividualOutputs(String tracert){
        return Arrays.asList(tracert.split("<TOSPLIT>"));
    }

    public static List<String> getHeaderInfo(String header){
      //  List<String> info = new ArrayList<String>();

        header = header.replaceAll("[)], 30 hops max, 60 byte packets","");
        header = header.replaceAll("traceroute to ", "");

        List<String> info = Arrays.asList(header.split("\\s[(]"));
        return info;
    }

    public static List<String> getHops(String tracert){
        return convertToArray(tracert, "([0-9]+.*ms)|(([*] )+)[*]");
    }

    public static List<TraceRoute> parseTraceRoutesFromFile(String filename) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(filename)));
        List<TraceRoute> routes = new ArrayList<TraceRoute>();

        for(String element : Util.getIndividualOutputs(text)){
            TraceRoute rt = new TraceRoute(element);
            if(rt.isValidTraceRoute()){
                routes.add(rt);
            }
        }
        return routes;
    }

    public static String getStringFromURL(String URL){
        System.out.println("GET: "+URL);

        String app = "";
        try {

            Thread.sleep(0);

            java.net.URL url = new URL(URL);

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                app+=line;
            }
            in.close();

            System.out.println("Response: "+app);

            return app;
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
            return null;
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
