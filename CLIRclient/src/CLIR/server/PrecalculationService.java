/**
 * PrecalculationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CLIR.server;

public interface PrecalculationService extends javax.xml.rpc.Service {
    public java.lang.String getPrecalculationAddress();

    public CLIR.server.Precalculation getPrecalculation() throws javax.xml.rpc.ServiceException;

    public CLIR.server.Precalculation getPrecalculation(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
