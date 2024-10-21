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

    private Document toDocument(){
        org.bson.Document document = new Document();
        document.append("LeadershipCompetence", this.leadershipCompetence);
        document.append("OpennessToEmployee", this.opennessToEmployee);
        document.append("SocialBehaviourToEmployee", this.socialBehaviourToEmployee);
        document.append("AttitudeTowardsClient", this.attitudeTowardsClient);
        document.append("CommunicationSkills", this.communicationSkills);
        document.append("IntegrityToCompany", this.integrityToCompany);

        return document;
    }


    private class Record {

        private int targetValue;
        private int actualValue;
        private int bonus;

        public int getTargetValue() {
            return targetValue;
        }

        public void setTargetValue(int targetValue) {
            this.targetValue = targetValue;
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

}
