package com.company;

import java.io.Serializable;

public class MasterLookupInfo implements Serializable {
    //Metadata

    private LookupInfo extremeAPIData;
    private LookupInfo whoIsAPIData;

    public void lookup(String ip){
        extremeAPIData = new WhoIsAPI(ip, WhoIsAPI.EXTREME_LOOKUP_API);
        whoIsAPIData = new WhoIsAPI(ip, WhoIsAPI.WHO_IS_API);
    }

    public LookupInfo getExtremeAPIData() {
        return extremeAPIData;
    }

    public LookupInfo getWhoIsAPIData() {
        return whoIsAPIData;
    }
}
