package CLIR.server;

public class PrecalculationProxy implements CLIR.server.Precalculation {
  private String _endpoint = null;
  private CLIR.server.Precalculation precalculation = null;
  
  public PrecalculationProxy() {
    _initPrecalculationProxy();
  }
  
  public PrecalculationProxy(String endpoint) {
    _endpoint = endpoint;
    _initPrecalculationProxy();
  }
  
  private void _initPrecalculationProxy() {
    try {
      precalculation = (new CLIR.server.PrecalculationServiceLocator()).getPrecalculation();
      if (precalculation != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)precalculation)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)precalculation)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (precalculation != null)
      ((javax.xml.rpc.Stub)precalculation)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public CLIR.server.Precalculation getPrecalculation() {
    if (precalculation == null)
      _initPrecalculationProxy();
    return precalculation;
  }
  
  public void doit() throws java.rmi.RemoteException{
    if (precalculation == null)
      _initPrecalculationProxy();
    precalculation.doit();
  }
  
  
}