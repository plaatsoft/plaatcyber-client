package nl.plaatsoft.cyber.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Server {

	@WebMethod String getHelloWorldAsString(String name);

	@WebMethod public String getElements();
}
