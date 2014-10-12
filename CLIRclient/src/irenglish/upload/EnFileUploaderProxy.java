package irenglish.upload;

public class EnFileUploaderProxy implements irenglish.upload.EnFileUploader {
  private String _endpoint = null;
  private irenglish.upload.EnFileUploader enFileUploader = null;
  
  public EnFileUploaderProxy() {
    _initEnFileUploaderProxy();
  }
  
  public EnFileUploaderProxy(String endpoint) {
    _endpoint = endpoint;
    _initEnFileUploaderProxy();
  }
  
  private void _initEnFileUploaderProxy() {
    try {
      enFileUploader = (new irenglish.upload.EnFileUploaderServiceLocator()).getEnFileUploader();
      if (enFileUploader != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)enFileUploader)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)enFileUploader)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (enFileUploader != null)
      ((javax.xml.rpc.Stub)enFileUploader)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public irenglish.upload.EnFileUploader getEnFileUploader() {
    if (enFileUploader == null)
      _initEnFileUploaderProxy();
    return enFileUploader;
  }
  
  public boolean fileUpload(byte[] myFile, java.lang.String filename, java.lang.String error, int query) throws java.rmi.RemoteException{
    if (enFileUploader == null)
      _initEnFileUploaderProxy();
    return enFileUploader.fileUpload(myFile, filename, error, query);
  }
  
  
}