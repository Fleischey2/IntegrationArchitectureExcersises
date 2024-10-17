package de.hbrs.ia.code;

import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerformanceRecord;

import java.util.List;

public class ManagePersonalControl implements ManagePersonal {

    private List<SalesMan> allSalesMen;

    @Override
    public void createSalesMan(SalesMan record) {
        allSalesMen.add(record);
    }


    @Override
    public SalesMan readSalesMan(int sid) {
        for(SalesMan salesMan : allSalesMen) {

            if(sid == salesMan.getId()) {
                return salesMan;
            }

        }
        return null;
    }

    @Override
    public List<SalesMan> readAllSalesMen() {
        return allSalesMen;
    }

    @Override
    public SalesMan deleteSalesMan(int sid) {
        for(SalesMan salesMan : allSalesMen) {

            if(sid == salesMan.getId()) {
                allSalesMen.remove(salesMan);
                return salesMan;
            }

        }
        return null;
    }

}
