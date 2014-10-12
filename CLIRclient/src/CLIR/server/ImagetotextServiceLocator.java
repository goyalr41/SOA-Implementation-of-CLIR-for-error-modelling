/**
 * ImagetotextServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CLIR.server;

public class ImagetotextServiceLocator extends org.apache.axis.client.Service implements CLIR.server.ImagetotextService {

    public ImagetotextServiceLocator() {
    }


    public ImagetotextServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ImagetotextServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for imagetotext
    private java.lang.String imagetotext_address = "http://localhost:12080/CLIRserver/services/imagetotext";

    public java.lang.String getimagetotextAddress() {
        return imagetotext_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String imagetotextWSDDServiceName = "imagetotext";

    public java.lang.String getimagetotextWSDDServiceName() {
        return imagetotextWSDDServiceName;
    }

    public void setimagetotextWSDDServiceName(java.lang.String name) {
        imagetotextWSDDServiceName = name;
    }

    public CLIR.server.Imagetotext getimagetotext() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(imagetotext_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getimagetotext(endpoint);
    }

    public CLIR.server.Imagetotext getimagetotext(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CLIR.server.ImagetotextSoapBindingStub _stub = new CLIR.server.ImagetotextSoapBindingStub(portAddress, this);
            _stub.setPortName(getimagetotextWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setimagetotextEndpointAddress(java.lang.String address) {
        imagetotext_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (CLIR.server.Imagetotext.class.isAssignableFrom(serviceEndpointInterface)) {
                CLIR.server.ImagetotextSoapBindingStub _stub = new CLIR.server.ImagetotextSoapBindingStub(new java.net.URL(imagetotext_address), this);
                _stub.setPortName(getimagetotextWSDDServiceName());
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
        if ("imagetotext".equals(inputPortName)) {
            return getimagetotext();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server.CLIR", "imagetotextService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server.CLIR", "imagetotext"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("imagetotext".equals(portName)) {
            setimagetotextEndpointAddress(address);
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
