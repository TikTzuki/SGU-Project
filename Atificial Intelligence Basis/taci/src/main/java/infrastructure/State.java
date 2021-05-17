package infrastructure;

import java.util.List;

public interface State<T> extends Cloneable {

	List<State<T>> movation();
	
	boolean isSameState(T state);
	
	int calStateCost(T goalState);
}
