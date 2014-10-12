/**
 * FileUploader.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CLIR.server;

public interface FileUploader extends java.rmi.Remote {
    public void fileUpload(byte[] myFile, java.lang.String filename, java.lang.String author, java.lang.String type) throws java.rmi.RemoteException;
}
