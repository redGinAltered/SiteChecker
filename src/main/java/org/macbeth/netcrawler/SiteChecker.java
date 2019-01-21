package org.macbeth.netcrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class SiteChecker {


    @Autowired
    private SiteRepo siteRepo;

    private Date date;


    public void checkAllSites(String[] args) {

        if(args.length>0){
            date = Date.valueOf(args[0]);
        } else {
            date = Date.valueOf(LocalDate.now());
        }

        List<Site> sites = siteRepo.findAll(); //only with certain date

        for (Site s: sites){

            if(s.getUrl() == null){
                System.out.println("ID = "+s.getId()+" -> url is null");
                continue;
            }

            if(s.getLastCheck() == null || s.getLastCheck().compareTo(date) == -1){

                Thread thread = new Thread(()-> {

                        try {
                            checkSite(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                });
                thread.start();
            }
        }

    }

    private void checkSite(Site s) throws IOException{


        URL url = new URL(s.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        s.setStatus(responseCode);
        s.setLastCheck(date);
        siteRepo.save(s);


        connection.disconnect();
    }
}
