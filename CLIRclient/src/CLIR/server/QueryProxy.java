package CLIR.server;

public class QueryProxy implements CLIR.server.Query {
  private String _endpoint = null;
  private CLIR.server.Query query = null;
  
  public QueryProxy() {
    _initQueryProxy();
  }
  
  public QueryProxy(String endpoint) {
    _endpoint = endpoint;
    _initQueryProxy();
  }
  
  private void _initQueryProxy() {
    try {
      query = (new CLIR.server.QueryServiceLocator()).getQuery();
      if (query != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)query)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)query)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (query != null)
      ((javax.xml.rpc.Stub)query)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public CLIR.server.Query getQuery() {
    if (query == null)
      _initQueryProxy();
    return query;
  }
  
  public byte[] query(java.lang.String data, java.lang.String lang1, java.lang.String trans) throws java.rmi.RemoteException{
    if (query == null)
      _initQueryProxy();
    return query.query(data, lang1, trans);
  }
  
  
}