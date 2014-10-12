package CLIR.server;

public class ImagetotextProxy implements CLIR.server.Imagetotext {
  private String _endpoint = null;
  private CLIR.server.Imagetotext imagetotext = null;
  
  public ImagetotextProxy() {
    _initImagetotextProxy();
  }
  
  public ImagetotextProxy(String endpoint) {
    _endpoint = endpoint;
    _initImagetotextProxy();
  }
  
  private void _initImagetotextProxy() {
    try {
      imagetotext = (new CLIR.server.ImagetotextServiceLocator()).getimagetotext();
      if (imagetotext != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)imagetotext)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)imagetotext)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (imagetotext != null)
      ((javax.xml.rpc.Stub)imagetotext)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public CLIR.server.Imagetotext getImagetotext() {
    if (imagetotext == null)
      _initImagetotextProxy();
    return imagetotext;
  }
  
  public void maint() throws java.rmi.RemoteException{
    if (imagetotext == null)
      _initImagetotextProxy();
    imagetotext.maint();
  }
  
  
}