package de.hbrs.ia.code.Factory;

import de.hbrs.ia.model.SalesMan;
import org.bson.Document;

public class SalesManFactory {

    private static SalesManFactory instance;

    public static SalesManFactory getInstance() {

        if (instance == null) {
            return new SalesManFactory();
        } else {

            return instance;
        }

    }

    public SalesMan getStandardSalesMan(int sid){

        SalesMan salesMan = new SalesMan("Max","MusterMann",sid );
        return salesMan;

    }

    public SalesMan convertFromDocument(Document document){
        SalesMan salesMan = getStandardSalesMan(-1);
        salesMan.setFirstname((String) document.get("firstname"));
        salesMan.setLastname((String) document.get("lastname"));
        salesMan.setId((Integer) document.get("sid"));
        return salesMan;
    }
}
