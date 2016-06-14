package io.minlee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by minlee on 6/14/16.
 */
public class DataScraper {

    private String title, voterTurnoutPercent;
    private String democratCandidateName, democratCandidateVotePercent;
    private String republicanCandidateName, republicanCandidateVotePercent;

    private int numOfDistrictsReported;
    private char sussexReport, newCastleReport, kentReport;


    private String input;

    private SpecialElection2016Results specialElection2016Results;

    public DataScraper(String input){
        this.input = input;
        title = scrapeTitle();
        numOfDistrictsReported = scrapeDistricts();
        newCastleReport = scrapeCountryReporting("New Castle");
        kentReport = scrapeCountryReporting("Kent");
        sussexReport = scrapeCountryReporting("Sussex");
        voterTurnoutPercent = scrapeVoterTurnout();
        democratCandidateName = scrapeCandidateName("DEMOCRATIC");
        democratCandidateVotePercent = scrapeVotePercent(democratCandidateName);
        republicanCandidateName = scrapeCandidateName("REPUBLICAN");
        republicanCandidateVotePercent = scrapeVotePercent(republicanCandidateName);
        specialElection2016Results = new SpecialElection2016Results(title, numOfDistrictsReported, newCastleReport, kentReport, sussexReport,
                voterTurnoutPercent, democratCandidateName, democratCandidateVotePercent,
                republicanCandidateName, republicanCandidateVotePercent);
    }

    private String scrapeTitle(){
        String line = "";
        String regex = "(\\w+\\s)+Election";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while(m.find()){
            line = m.group();
            break;
        }
        return line;
    }

    private int scrapeDistricts(){
        int numberOfDistricts = 0;
        String line = "";
        String regex = "((\\d+)(\\s)of(\\s)(\\d+))\\sDistricts Reporting";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while(m.find()){
            line = m.group();
            break;
        }
        p = Pattern.compile("\\d+");
        m = p.matcher(line);
        while(m.find()){
            numberOfDistricts = Integer.parseInt(m.group());
            break;
        }
        return numberOfDistricts;
    }


    private char scrapeCountryReporting(String county){
        char countryReported = '0';
        String line = "";
        String regex = county+"(\\s+):\\s(Y|N)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while(m.find()){
            line = m.group();
            break;
        }
        countryReported = line.charAt(line.length()-1);
        return countryReported;
    }

    private String scrapeVoterTurnout(){
        String line = "";
        String regex = "(?<=(Statewide Voter Turnout =))\\s(\\d+)(\\s*)(\\.(\\s*)((\\d)(\\s*))*)?%";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while(m.find()){
            line = m.group();
            break;
        }
        return line.replaceAll("\\s","");
    }

    private String scrapeCandidateName(String party){
        String line = "";
        String regex = party+" PARTY ; ; ; ; ;\n\\s*";
        regex = "(("+regex+"))(\\w+\\s(\\w*\\s)*\\w+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while(m.find()){
            line = m.group();
            break;
        }
        p = Pattern.compile("(\\w+\\s(\\w*\\s)*\\w+)");
        m = p.matcher(line);
        while(m.find()){
            line = m.group();
        }
        return line;
    }

    private String scrapeVotePercent(String candidateName){
        String line = "";
        String regex = candidateName+"\\s;\\s\\d+\\s;\\s\\d+\\s;\\s\\d+\\s;\\s+\\d+((\\.)?\\d+)?+\\s%";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while(m.find()){
            line = m.group();
            break;
        }
        p = Pattern.compile("\\d+((\\.)?\\d+)?+\\s%");
        m = p.matcher(line);
        while(m.find()){
            line = m.group();
            break;
        }
        return line.replaceAll("\\s","");
    }

    public SpecialElection2016Results getSpecialElection2016Results(){
        return specialElection2016Results;
    }
}
