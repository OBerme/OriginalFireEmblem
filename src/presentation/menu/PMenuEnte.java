package presentation.menu;

import java.awt.Component;
import java.util.List;

public class PMenuEnte extends PMenu implements IPMenuEnte<Integer, Integer>{

	public PMenuEnte(Component invoker) {
		super( invoker);
	}
	
	@Override
	public void disableOption(IPOption option) {
		gOptions.get(option.getOption()).setEnabled(false);
	}

}
