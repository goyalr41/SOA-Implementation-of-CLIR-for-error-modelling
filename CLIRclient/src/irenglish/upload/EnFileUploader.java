/**
 * EnFileUploader.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package irenglish.upload;

public interface EnFileUploader extends java.rmi.Remote {
    public boolean fileUpload(byte[] myFile, java.lang.String filename, java.lang.String error, int query) throws java.rmi.RemoteException;
}
