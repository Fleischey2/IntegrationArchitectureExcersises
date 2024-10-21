package de.hbrs.ia.code;

import de.hbrs.ia.database.MongoDBControl;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerformanceRecord;

import java.util.ArrayList;
import java.util.List;

public class ManagePersonalControl implements ManagePersonal {
    private MongoDBControl mongoDBControl = new MongoDBControl();

    @Override
    public void createSalesMan(SalesMan record) {
        mongoDBControl.addSalesMan(record.toDocument());

    }

    @Override
    public void addSocialPerformanceRecord(SocialPerformanceRecord record, SalesMan salesMan) {
        record.setSid(salesMan.getId());
        mongoDBControl.addSocialPerformanceRecord(record.toDocument());
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        return mongoDBControl.getSalesManById(sid);
    }

    @Override
    public List<SalesMan> readAllSalesMen() {
        return mongoDBControl.getAllSalesMen();
    }

    @Override
    public void deleteSalesMan(int sid) {
        mongoDBControl.deleteSalesMan(sid);
    }

    @Override
    public List<SocialPerformanceRecord> readSocialPerformanceRecord(SalesMan salesMan) {
        return mongoDBControl.getSocialPerformanceRecordsBySID(salesMan.getId());
    }

    @Override
    public void deletePerformanceRecords(int sid) {
        mongoDBControl.deletePerformanceRecords(sid);
    }

}
