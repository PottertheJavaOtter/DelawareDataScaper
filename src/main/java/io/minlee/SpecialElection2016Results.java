package io.minlee;

/**
 * Created by minlee on 6/14/16.
 */
public class SpecialElection2016Results {


    private String title, voterTurnoutPercent;
    private String democratCandidateName, democratCandidateVotePercent;
    private String republicanCandidateName, republicanCandidateVotePercent;

    private int numOfDistrictsReported;
    private char sussexReport, newCastleReport, kentReport;


    public SpecialElection2016Results(String title, int numOfDistrictsReported, char newCastleReport, char kentReport, char sussexReport,
                                      String voterTurnoutPercent, String democratCandidateName, String democratCandidateVotePercent,
                                      String republicanCandidateName, String republicanCandidateVotePercent){
        this.title = title;
        this.numOfDistrictsReported = numOfDistrictsReported;
        this.newCastleReport = newCastleReport;
        this.kentReport = kentReport;
        this.sussexReport = sussexReport;
        this.voterTurnoutPercent = voterTurnoutPercent;
        this.democratCandidateName = democratCandidateName;
        this.democratCandidateVotePercent = democratCandidateVotePercent;
        this.republicanCandidateName = republicanCandidateName;
        this.republicanCandidateVotePercent = republicanCandidateVotePercent;
    }

    public String toString(){
        String stringRepresentation = String.format("%s,%d,%c,%c,%c,%s,%s,%s,%s,%s",
                title, numOfDistrictsReported, newCastleReport, kentReport, sussexReport,
                voterTurnoutPercent, democratCandidateName, democratCandidateVotePercent,
                republicanCandidateName, republicanCandidateVotePercent);
        return stringRepresentation;
    }
}
