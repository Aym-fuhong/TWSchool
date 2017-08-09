package managerScore.models;

import javax.persistence.*;
import java.util.ArrayList;


public class Report {

    private String id;
    private ArrayList<ReportItem> reportItem;
    private float averageOfClass;
    private float medianOfClass;

    public ArrayList<ReportItem> getReportItem() {
        return reportItem;
    }

    public float getAverageOfClass() {
        return averageOfClass;
    }

    public float getMedianOfClass() {
        return medianOfClass;
    }

    public Report(ArrayList<ReportItem> reportItem, float averageOfClass, float medianOfClass) {
        this.reportItem = reportItem;
        this.averageOfClass = averageOfClass;
        this.medianOfClass = medianOfClass;
    }
}
