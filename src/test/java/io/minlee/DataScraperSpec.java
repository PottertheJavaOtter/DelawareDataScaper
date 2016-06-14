package io.minlee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by minlee on 6/14/16.
 */
public class DataScraperSpec {
    DataScraper dataScraper;
    @Before
    public void initialize(){
        String testValue = "Special Election ;\n" +
                "( Official Results ) ;\n" +
                "Election Date: 05/24/16 ;\n" +
                "19 of 19 Districts Reporting = 100 % ;\n" +
                "Last Updated: 05/26/16 01:15 PM ;\n" +
                "Absentee Votes Reported ;\n" +
                "New Castle : Y ;\n" +
                "Kent       : N ;\n" +
                "Sussex     : N ;\n" +
                "Statewide Voter Turnout = 3 . 5 9 % ;\n" +
                "Office/Party/Candidate ; Votes/District Totals ; Machine/Votes ; Absentee/Votes ; Total/Votes ; Percent ;\n" +
                "COUNTY COUNCIL DISTRICT 1 ; 19 of 19 Districts Reported ; ;\n" +
                "     DEMOCRATIC PARTY ; ; ; ; ;\n" +
                "         KENNETH R WOODS ; 734 ; 43 ; 777 ;  70.3 % ;\n" +
                "     REPUBLICAN PARTY ; ; ; ; ;\n" +
                "         DOUGLAS M SUITER ; 305 ; 23 ; 328 ;  29.6 % ;\n";
        dataScraper = new DataScraper(testValue);
    }
    @Test
    public void scrapeTitleTest(){
        SpecialElection2016Results specialElection2016Results = dataScraper.getSpecialElection2016Results();
        String expectedString = String.format("%s,%d,%c,%c,%c,%s,%s,%s,%s,%s",
                "Special Election", 19, 'Y', 'N', 'N',
                "3.59%", "KENNETH R WOODS", "70.3%",
                "DOUGLAS M SUITER", "29.6%");
        String actualString = specialElection2016Results.toString();
        Assert.assertEquals(expectedString, actualString);
    }
}
