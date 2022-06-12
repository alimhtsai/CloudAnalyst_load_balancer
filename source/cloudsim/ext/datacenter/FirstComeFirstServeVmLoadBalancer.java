package cloudsim.ext.datacenter;

import java.util.Map;
import java.util.Iterator;

//import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

/**
 * This class implements {@link VmLoadBalancer} with a Round Robin policy.
 * 
 * @author Bhathiya Wickremasinghe
 *
 */
public class FirstComeFirstServeVmLoadBalancer extends VmLoadBalancer {
	
	private Map<Integer, VirtualMachineState> vmStatesList;
	private int currVm = -1;

	public FirstComeFirstServeVmLoadBalancer(Map<Integer, VirtualMachineState> vmStatesList){
		super();
		
		this.vmStatesList = vmStatesList;
	}

	/* (non-Javadoc)
	 * @see cloudsim.ext.VMLoadBalancer#getVM()
	 */
	public int getNextAvailableVm(){
		int temp = -1;
		if (vmStatesList.size()>0) {
			for (Iterator<Integer> itr = vmStatesList.keySet().iterator(); itr.hasNext();) {
				temp = itr.next();
				VirtualMachineState state = vmStatesList.get(temp);
				if (state.equals(VirtualMachineState.AVAILABLE)) {
					allocatedVm(temp);
					break;
				}
			}
		}
		return temp;
	}
}
