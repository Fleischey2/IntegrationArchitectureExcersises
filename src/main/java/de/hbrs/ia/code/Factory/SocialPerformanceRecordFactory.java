package de.hbrs.ia.code.Factory;

import de.hbrs.ia.model.SocialPerformanceRecord;
import org.bson.Document;

public class SocialPerformanceRecordFactory {

    private static SocialPerformanceRecordFactory instance;

    public static SocialPerformanceRecordFactory getInstance() {

        if (instance == null) {
            return new SocialPerformanceRecordFactory();
        } else {

            return instance;
        }

    }

    public SocialPerformanceRecord getStandardPerformanceRecord() {

        SocialPerformanceRecord socialPerformanceRecord = new SocialPerformanceRecord();

        SocialPerformanceRecord.Record leadershipCompetence = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue(4);
        leadershipCompetence.setActualValue(1);
        leadershipCompetence.setBonus(100);

        SocialPerformanceRecord.Record opennessToEmployee = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue(4);
        leadershipCompetence.setActualValue(2);
        leadershipCompetence.setBonus(200);

        SocialPerformanceRecord.Record socialBehaviourToEmployee = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue(4);
        leadershipCompetence.setActualValue(3);
        leadershipCompetence.setBonus(300);

        SocialPerformanceRecord.Record attitudeTowardsClient = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue(4);
        leadershipCompetence.setActualValue(4);
        leadershipCompetence.setBonus(400);

        SocialPerformanceRecord.Record communicationSkills = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue(4);
        leadershipCompetence.setActualValue(1);
        leadershipCompetence.setBonus(500);

        SocialPerformanceRecord.Record integrityToCompany = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue(4);
        leadershipCompetence.setActualValue(2);
        leadershipCompetence.setBonus(600);

        socialPerformanceRecord.setLeadershipCompetence(leadershipCompetence);
        socialPerformanceRecord.setOpennessToEmployee(opennessToEmployee);
        socialPerformanceRecord.setSocialBehaviourToEmployee(socialBehaviourToEmployee);
        socialPerformanceRecord.setAttitudeTowardsClient(attitudeTowardsClient);
        socialPerformanceRecord.setCommunicationSkills(communicationSkills);
        socialPerformanceRecord.setIntegrityToCompany(integrityToCompany);

        socialPerformanceRecord.setRemarks("Everything alright. Good Job!");
        socialPerformanceRecord.setYearOfPerformance(2024);

        return socialPerformanceRecord;
    }

    public SocialPerformanceRecord convertFromDocument(Document document) {

        SocialPerformanceRecord socialPerformanceRecord = new SocialPerformanceRecord();

        Document documentLeader = (Document) document.get("LeadershipCompetence");
        SocialPerformanceRecord.Record leadershipCompetence = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue((Integer) documentLeader.get("targetValue"));
        leadershipCompetence.setActualValue((Integer) documentLeader.get("actualValue"));
        leadershipCompetence.setBonus((Integer) documentLeader.get("bonus"));

        Document documentOpeness = (Document) document.get("OpennessToEmployee");
        SocialPerformanceRecord.Record opennessToEmployee = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue((Integer) documentOpeness.get("targetValue"));
        leadershipCompetence.setActualValue((Integer) documentOpeness.get("actualValue"));
        leadershipCompetence.setBonus((Integer) documentOpeness.get("bonus"));

        Document documentSocial = (Document) document.get("SocialBehaviourToEmployee");
        SocialPerformanceRecord.Record socialBehaviourToEmployee = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue((Integer) documentSocial.get("targetValue"));
        leadershipCompetence.setActualValue((Integer) documentSocial.get("actualValue"));
        leadershipCompetence.setBonus((Integer) documentSocial.get("bonus"));

        Document documentAttitide = (Document) document.get("AttitudeTowardsClient");
        SocialPerformanceRecord.Record attitudeTowardsClient = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue((Integer) documentAttitide.get("targetValue"));
        leadershipCompetence.setActualValue((Integer) documentAttitide.get("actualValue"));
        leadershipCompetence.setBonus((Integer) documentAttitide.get("bonus"));

        Document documentCommunuication = (Document) document.get("CommunicationSkills");
        SocialPerformanceRecord.Record communicationSkills = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue((Integer) documentCommunuication.get("targetValue"));
        leadershipCompetence.setActualValue((Integer) documentCommunuication.get("actualValue"));
        leadershipCompetence.setBonus((Integer) documentCommunuication.get("bonus"));

        Document documentIntegrity = (Document) document.get("IntegrityToCompany");
        SocialPerformanceRecord.Record integrityToCompany = new SocialPerformanceRecord.Record();
        leadershipCompetence.setTargetValue((Integer) documentIntegrity.get("targetValue"));
        leadershipCompetence.setActualValue((Integer) documentIntegrity.get("actualValue"));
        leadershipCompetence.setBonus((Integer) documentIntegrity.get("bonus"));

        socialPerformanceRecord.setLeadershipCompetence(leadershipCompetence);
        socialPerformanceRecord.setOpennessToEmployee(opennessToEmployee);
        socialPerformanceRecord.setSocialBehaviourToEmployee(socialBehaviourToEmployee);
        socialPerformanceRecord.setAttitudeTowardsClient(attitudeTowardsClient);
        socialPerformanceRecord.setCommunicationSkills(communicationSkills);
        socialPerformanceRecord.setIntegrityToCompany(integrityToCompany);

        socialPerformanceRecord.setSid((Integer) document.get("sid"));
        socialPerformanceRecord.setRemarks((String) document.get("remarks"));
        socialPerformanceRecord.setYearOfPerformance((Integer) document.get("yearOfPerformance"));


        return socialPerformanceRecord;

}

}
