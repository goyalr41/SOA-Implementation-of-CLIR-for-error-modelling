/**
 * PrecalculationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package CLIR.server;

public class PrecalculationServiceLocator extends org.apache.axis.client.Service implements CLIR.server.PrecalculationService {

    public PrecalculationServiceLocator() {
    }


    public PrecalculationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PrecalculationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Precalculation
    private java.lang.String Precalculation_address = "http://localhost:13080/CLIRserver1/services/Precalculation";

    public java.lang.String getPrecalculationAddress() {
        return Precalculation_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PrecalculationWSDDServiceName = "Precalculation";

    public java.lang.String getPrecalculationWSDDServiceName() {
        return PrecalculationWSDDServiceName;
    }

    public void setPrecalculationWSDDServiceName(java.lang.String name) {
        PrecalculationWSDDServiceName = name;
    }

    public CLIR.server.Precalculation getPrecalculation() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Precalculation_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPrecalculation(endpoint);
    }

    public CLIR.server.Precalculation getPrecalculation(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CLIR.server.PrecalculationSoapBindingStub _stub = new CLIR.server.PrecalculationSoapBindingStub(portAddress, this);
            _stub.setPortName(getPrecalculationWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPrecalculationEndpointAddress(java.lang.String address) {
        Precalculation_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (CLIR.server.Precalculation.class.isAssignableFrom(serviceEndpointInterface)) {
                CLIR.server.PrecalculationSoapBindingStub _stub = new CLIR.server.PrecalculationSoapBindingStub(new java.net.URL(Precalculation_address), this);
                _stub.setPortName(getPrecalculationWSDDServiceName());
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
        if ("Precalculation".equals(inputPortName)) {
            return getPrecalculation();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server.CLIR", "PrecalculationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server.CLIR", "Precalculation"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Precalculation".equals(portName)) {
            setPrecalculationEndpointAddress(address);
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
