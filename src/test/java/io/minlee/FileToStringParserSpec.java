package io.minlee;

import static org.junit.Assert.*;
import org.junit.Test;

import javax.swing.text.BadLocationException;
import java.io.IOException;

/**
 * Created by minlee on 6/14/16.
 */
public class FileToStringParserSpec {

    @Test
    public void testParsedString() throws IOException, BadLocationException {
        FileToStringParser fileToStringParser = new FileToStringParser();

        String expectedValue = "Special Election ;\n" +
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
        String actualValue = fileToStringParser.getInputData();
        assertEquals(expectedValue,actualValue);
    }
}
