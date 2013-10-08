package main.java.br.com.arida.ufc.mydbaas.core.controller.api.common;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.DefaultStatus;

public abstract class AbstractResourceManager implements InterfaceResourceManager {

	protected Result result;
	protected DefaultStatus status;
	
	public AbstractResourceManager(Result result, DefaultStatus status) {
		this.result = result;
		this.status = status;
	}
}
