package irhindi.upload;

public class HinFileUploaderProxy implements irhindi.upload.HinFileUploader {
  private String _endpoint = null;
  private irhindi.upload.HinFileUploader hinFileUploader = null;
  
  public HinFileUploaderProxy() {
    _initHinFileUploaderProxy();
  }
  
  public HinFileUploaderProxy(String endpoint) {
    _endpoint = endpoint;
    _initHinFileUploaderProxy();
  }
  
  private void _initHinFileUploaderProxy() {
    try {
      hinFileUploader = (new irhindi.upload.HinFileUploaderServiceLocator()).getHinFileUploader();
      if (hinFileUploader != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hinFileUploader)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hinFileUploader)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hinFileUploader != null)
      ((javax.xml.rpc.Stub)hinFileUploader)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public irhindi.upload.HinFileUploader getHinFileUploader() {
    if (hinFileUploader == null)
      _initHinFileUploaderProxy();
    return hinFileUploader;
  }
  
  public boolean fileUpload(byte[] myFile, java.lang.String filename, java.lang.String error, int query) throws java.rmi.RemoteException{
    if (hinFileUploader == null)
      _initHinFileUploaderProxy();
    return hinFileUploader.fileUpload(myFile, filename, error, query);
  }
  
  
}