/**
 * Created by Alexandr on 10.08.2016.
 */
public class TestResultFileds {
    private String nameOfCurrentSite;
    private String testLocations;
    private int countOfVisits;
    private boolean resultOfCheking;

   public TestResultFileds(){}

    public TestResultFileds(String nameOfCurrentSite, String  testLocations, int countOfVisits, boolean resultOfCheking){
        this.countOfVisits = countOfVisits;
        this.nameOfCurrentSite = nameOfCurrentSite;
        this.resultOfCheking = resultOfCheking;
        this.testLocations = testLocations;
    }

    public String getTestLocations() {
        return testLocations;
    }

    public String getNameOfCurrentSite() {
        return nameOfCurrentSite;
    }

    public int getCountOfVisits() {
        return countOfVisits;
    }

    public boolean isResultOfCheking() {
        return resultOfCheking;
    }

    public void setNameOfCurrentSite(String nameOfCurrentSite) {
        this.nameOfCurrentSite = nameOfCurrentSite;
    }

    public void setTestLocations(String testLocations) {
        this.testLocations = testLocations;
    }

    public void setCountOfVisits(int countOfVisits) {
        this.countOfVisits = countOfVisits;
    }

    public void setResultOfCheking(boolean resultOfCheking) {
        this.resultOfCheking = resultOfCheking;
    }
}
