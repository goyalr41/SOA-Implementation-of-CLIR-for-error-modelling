/**
 * FileUploaderService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CLIR.server;

public interface FileUploaderService extends javax.xml.rpc.Service {
    public java.lang.String getFileUploaderAddress();

    public CLIR.server.FileUploader getFileUploader() throws javax.xml.rpc.ServiceException;

    public CLIR.server.FileUploader getFileUploader(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
