
import java.util.ArrayList;
import java.util.List;


public class AfficherComposit implements IJournal {
    
    private List< IJournal> journals = new ArrayList< IJournal>();


	
  public void outPut_Msg(String message) {


		for( IJournal j : journals){
			j.outPut_Msg(message);
		}
	}

  public void add( IJournal journal){
		journals.add(journal);
	}

  public void remove( IJournal journal){
		journals.remove(journal);
	}
    
 

}
