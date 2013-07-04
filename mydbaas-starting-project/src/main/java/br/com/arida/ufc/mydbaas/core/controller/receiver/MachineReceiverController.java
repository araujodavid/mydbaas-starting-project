package main.java.br.com.arida.ufc.mydbaas.core.controller.receiver;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Cpu;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Disk;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Machine;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Memory;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Network;
import main.java.br.com.arida.ufc.mydbaas.common.metric.machine.Partition;
import main.java.br.com.arida.ufc.mydbaas.core.controller.receiver.common.AbstractReceiver;
import main.java.br.com.arida.ufc.mydbaas.core.repository.MetricRepository;
import main.java.br.com.arida.ufc.mydbaas.core.repository.VirtualMachineRepository;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.view.DefaultStatus;

/**
 * Class that handles requests sent by the monitoring agents about machine.
 * @author Daivd Araújo
 * @version 5.0
 * @since March 10, 2013 
 */
@Resource
@Path("/machine")
public class MachineReceiverController extends AbstractReceiver {
	
	private VirtualMachineRepository machineRepository;
	
	/**
	 * Constructor
	 * @param status
	 * @param metricRepository
	 * @param machineRepository
	 */
	public MachineReceiverController(DefaultStatus status, MetricRepository repository, VirtualMachineRepository machineRepository) {
		super(status, repository);
		this.machineRepository = machineRepository;
	}

	/**
	 * Method that receives information about the operating system and machine settings.
	 * @param metric - object relative to a metric
	 * @param machine - machine identifier where the metric was collected
	 */
	@Post("/info")
	public void information(Machine metric, int machine) {
		if (machineRepository.updateSystemInformation(metric, machine)) {
			status.accepted();
		}
	}
	
	/*
	 * To create a new method receiver is necessary to call the object "metric". 
     * Add the parameters: machine (int) and recordDate (String).
     * The monitoring agents will send the data in this format.
	 */
	
	/**
	 * Method that receives the collection of CPU.
	 * @param metric - object relative to a metric
	 * @param machine - machine identifier where the metric was collected
	 * @param recordDate - date when it was collected
	 */
	@Post("/cpu")
	public void cpu(List<Cpu> metric, int machine, String recordDate) {
		for (Cpu cpu : metric) {
			try {
				if (repository.saveMetric(cpu, recordDate, machine, 0, 0, 0)) {
					status.accepted();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
	}
	
	/**
	 * Method that receives collections of Memory.
	 * @param metric - object relative to a metric
	 * @param machine - machine identifier where the metric was collected
	 * @param recordDate - date when it was collected
	 */
	@Post("/memory")
	public void memory(Memory metric, int machine, String recordDate) {
		try {
			if (repository.saveMetric(metric, recordDate, machine, 0, 0, 0)) {
				status.accepted();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that receives collections of Disk.
	 * @param metric - object relative to a metric
	 * @param machine - machine identifier where the metric was collected
	 * @param recordDate - date when it was collected
	 */
	@Post("/disk")
	public void disk(Disk metric, int machine, String recordDate) {
		try {
			if (repository.saveMetric(metric, recordDate, machine, 0, 0, 0)) {
				status.accepted();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that receives the collection of Partitions.
	 * @param metric - object relative to a metric
	 * @param machine - machine identifier where the metric was collected
	 * @param recordDate - date when it was collected
	 */
	@Post("/partition")
	public void partition(List<Partition> metric, int machine, String recordDate) {
		for (Partition partition : metric) {
			try {
				if (repository.saveMetric(partition, recordDate, machine, 0, 0, 0)) {
					status.accepted();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}				
	}
	
	/**
	 * Method that receives collections of Network.
	 * @param metric - object relative to a metric
	 * @param machine - machine identifier where the metric was collected
	 * @param recordDate - date when it was collected
	 */
	@Post("/network")
	public void network(Network metric, int machine, String recordDate) {
		try {
			if (repository.saveMetric(metric, recordDate, machine, 0, 0, 0)) {
				status.accepted();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
