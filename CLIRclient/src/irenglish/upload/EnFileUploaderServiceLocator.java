/**
 * EnFileUploaderServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package irenglish.upload;

public class EnFileUploaderServiceLocator extends org.apache.axis.client.Service implements irenglish.upload.EnFileUploaderService {

    public EnFileUploaderServiceLocator() {
    }


    public EnFileUploaderServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EnFileUploaderServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EnFileUploader
    private java.lang.String EnFileUploader_address = "http://localhost:13080/CLIRserver1/services/EnFileUploader";

    public java.lang.String getEnFileUploaderAddress() {
        return EnFileUploader_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EnFileUploaderWSDDServiceName = "EnFileUploader";

    public java.lang.String getEnFileUploaderWSDDServiceName() {
        return EnFileUploaderWSDDServiceName;
    }

    public void setEnFileUploaderWSDDServiceName(java.lang.String name) {
        EnFileUploaderWSDDServiceName = name;
    }

    public irenglish.upload.EnFileUploader getEnFileUploader() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EnFileUploader_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEnFileUploader(endpoint);
    }

    public irenglish.upload.EnFileUploader getEnFileUploader(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            irenglish.upload.EnFileUploaderSoapBindingStub _stub = new irenglish.upload.EnFileUploaderSoapBindingStub(portAddress, this);
            _stub.setPortName(getEnFileUploaderWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEnFileUploaderEndpointAddress(java.lang.String address) {
        EnFileUploader_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (irenglish.upload.EnFileUploader.class.isAssignableFrom(serviceEndpointInterface)) {
                irenglish.upload.EnFileUploaderSoapBindingStub _stub = new irenglish.upload.EnFileUploaderSoapBindingStub(new java.net.URL(EnFileUploader_address), this);
                _stub.setPortName(getEnFileUploaderWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EnFileUploader".equals(inputPortName)) {
            return getEnFileUploader();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://upload.irenglish", "EnFileUploaderService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://upload.irenglish", "EnFileUploader"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EnFileUploader".equals(portName)) {
            setEnFileUploaderEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
