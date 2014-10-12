package CLIR.server;

public class FileUploaderProxy implements CLIR.server.FileUploader {
  private String _endpoint = null;
  private CLIR.server.FileUploader fileUploader = null;
  
  public FileUploaderProxy() {
    _initFileUploaderProxy();
  }
  
  public FileUploaderProxy(String endpoint) {
    _endpoint = endpoint;
    _initFileUploaderProxy();
  }
  
  private void _initFileUploaderProxy() {
    try {
      fileUploader = (new CLIR.server.FileUploaderServiceLocator()).getFileUploader();
      if (fileUploader != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fileUploader)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fileUploader)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fileUploader != null)
      ((javax.xml.rpc.Stub)fileUploader)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public CLIR.server.FileUploader getFileUploader() {
    if (fileUploader == null)
      _initFileUploaderProxy();
    return fileUploader;
  }
  
  public void fileUpload(byte[] myFile, java.lang.String filename, java.lang.String author, java.lang.String type) throws java.rmi.RemoteException{
    if (fileUploader == null)
      _initFileUploaderProxy();
    fileUploader.fileUpload(myFile, filename, author, type);
  }
  
  
}