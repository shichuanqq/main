package com.example.service.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataBaseContextHolder.getDataBaseType();
        if (typeKey.equals(DataBaseContextHolder.WRITE)) {
            return typeKey;
        }
        return DataBaseContextHolder.READ;

    }
}
