package de.hbrs.ia.model;

import org.bson.Document;

// Implementation as nested classes / Document
// Other options would have been possible e.g.: One Class with all Attributes

public class SocialPerformanceRecord {

    private Record leadershipCompetence;
    private Record opennessToEmployee;
    private Record socialBehaviourToEmployee;
    private Record attitudeTowardsClient;
    private Record communicationSkills;
    private Record integrityToCompany;
    private Integer sid;
    private Integer totalBonus;
    private Double averageTargetValue;
    private Double averageActualTargetValue;
    private String remarks;
    private Integer yearOfPerformance;

    public int getTotalBonus() {

        return leadershipCompetence.getBonus()
                + opennessToEmployee.getBonus()
                + socialBehaviourToEmployee.getBonus()
                + attitudeTowardsClient.getBonus()
                + communicationSkills.getBonus()
                + integrityToCompany.getBonus();


    }

    public Double getAverageTargetValue() {
        return (((double) leadershipCompetence.getTargetValue()
                + (double) opennessToEmployee.getTargetValue()
                + (double) socialBehaviourToEmployee.getTargetValue()
                + (double) attitudeTowardsClient.getTargetValue()
                + (double) communicationSkills.getTargetValue()
                + (double) integrityToCompany.getTargetValue())
                / 6);


    }

    public Double getAverageActualTargetValue() {
        return (((double) leadershipCompetence.getActualValue()
                + (double) opennessToEmployee.getActualValue()
                + (double) socialBehaviourToEmployee.getActualValue()
                + (double) attitudeTowardsClient.getActualValue()
                + (double) communicationSkills.getActualValue()
                + (double) integrityToCompany.getActualValue())
                / 6);


    }

    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("LeadershipCompetence", this.leadershipCompetence.toDocument());
        document.append("OpennessToEmployee", this.opennessToEmployee.toDocument());
        document.append("SocialBehaviourToEmployee", this.socialBehaviourToEmployee.toDocument());
        document.append("AttitudeTowardsClient", this.attitudeTowardsClient.toDocument());
        document.append("CommunicationSkills", this.communicationSkills.toDocument());
        document.append("IntegrityToCompany", this.integrityToCompany.toDocument());
        document.append("sid", this.sid);
        document.append("totalBonus", this.getTotalBonus());
        document.append("averageTargetValue", this.getAverageTargetValue());
        document.append("remarks", this.remarks);
        document.append("averageActualTargetValue", this.getAverageActualTargetValue());
        document.append("yearOfPerformance", this.yearOfPerformance);

        return document;
    }


    public static class Record {

        private int targetValue;
        private int actualValue;
        private int bonus;

        public int getTargetValue() {
            return targetValue;
        }

        public void setTargetValue(int targetValue) {
            this.targetValue = targetValue;
        }

        public void setBonus(int bonus) {
            this.bonus = bonus;
        }

        public int getActualValue() {
            return actualValue;
        }

        public void setActualValue(int actualValue) {
            this.actualValue = actualValue;
        }

        public int getBonus() {
            return bonus;
        }

        public Document toDocument() {
            org.bson.Document document = new Document();
            document.append("targetValue", this.targetValue);
            document.append("actualValue", this.actualValue);
            document.append("bonus", this.bonus);
            return document;
        }
    }

    //Getter & Setter


    public Record getLeadershipCompetence() {
        return this.leadershipCompetence;
    }

    public void setLeadershipCompetence(Record leadershipCompetence) {
        this.leadershipCompetence = leadershipCompetence;
    }

    public Record getOpennessToEmployee() {
        return opennessToEmployee;
    }

    public void setOpennessToEmployee(Record opennessToEmployee) {
        this.opennessToEmployee = opennessToEmployee;
    }

    public Record getSocialBehaviourToEmployee() {
        return socialBehaviourToEmployee;
    }

    public void setSocialBehaviourToEmployee(Record socialBehaviourToEmployee) {
        this.socialBehaviourToEmployee = socialBehaviourToEmployee;
    }

    public Record getAttitudeTowardsClient() {
        return attitudeTowardsClient;
    }

    public void setAttitudeTowardsClient(Record attitudeTowardsClient) {
        this.attitudeTowardsClient = attitudeTowardsClient;
    }

    public Record getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(Record communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    public Record getIntegrityToCompany() {
        return integrityToCompany;
    }

    public void setIntegrityToCompany(Record integrityToCompany) {
        this.integrityToCompany = integrityToCompany;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getYearOfPerformance() {
        return yearOfPerformance;
    }

    public void setYearOfPerformance(Integer yearOfPerformance) {
        this.yearOfPerformance = yearOfPerformance;
    }
}
