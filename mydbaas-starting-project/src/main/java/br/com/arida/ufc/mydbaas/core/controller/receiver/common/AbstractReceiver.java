package main.java.br.com.arida.ufc.mydbaas.core.controller.receiver.common;

import main.java.br.com.arida.ufc.mydbaas.core.repository.common.AbstractMetricRepository;
import br.com.caelum.vraptor.view.DefaultStatus;

/**
 * Abstract class for new Receivers
 * @author David Araújo
 * @version 2.0
 * @since March 29, 2013
 */
public abstract class AbstractReceiver<T extends AbstractMetricRepository> {

	protected DefaultStatus status;
	protected T repository;
	
	/**
	 * Default constructor for Receiver
	 * @param status
	 */
	public AbstractReceiver(DefaultStatus status, T repository) {
		this.status = status;
		this.repository = repository;
	}
}
