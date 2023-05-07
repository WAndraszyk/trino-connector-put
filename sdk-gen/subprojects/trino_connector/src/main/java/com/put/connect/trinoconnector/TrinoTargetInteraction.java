/* *************************************************** */

/* (C) Copyright IBM Corp. 2022                        */

/* *************************************************** */
package com.put.connect.trinoconnector;

import com.ibm.connect.sdk.api.Record;
import com.ibm.connect.sdk.api.RowBasedTargetInteraction;
import com.ibm.wdp.connect.common.sdk.api.models.CustomFlightAssetDescriptor;

@SuppressWarnings({ "PMD.AvoidDollarSigns", "PMD.ClassNamingConventions" })
public class TrinoTargetInteraction extends RowBasedTargetInteraction<TrinoConnector>
{
    protected TrinoTargetInteraction(TrinoConnector connector, CustomFlightAssetDescriptor asset)
    {
        super();
        this.setConnector(connector);
        this.setAsset(asset);
    }

    @Override
    public void putRecord(Record record)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public CustomFlightAssetDescriptor putSetup() throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CustomFlightAssetDescriptor putWrapup() throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
