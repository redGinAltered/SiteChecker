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

//
//    @Value("${check.date}")
//    private Date date;

    @Autowired
    private SiteRepo siteRepo;

    public void CheckAllSites(String[] args) throws IOException {

        Date date;

        if(args.length>0){
            date = Date.valueOf(args[0]);
        } else {
            date = Date.valueOf(LocalDate.now());
        }

        List<Site> sites = siteRepo.findAll();//

        for (Site s: sites){

            URL url = new URL(s.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();

            if(s.getLastCheck() == null || s.getLastCheck().compareTo(date) == -1){
                s.setStatus(responseCode);
                s.setLastCheck(date);
                System.out.println(responseCode);
                siteRepo.save(s);
            }
            connection.disconnect();


        }

    }
}
