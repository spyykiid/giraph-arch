package edu.umkc;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import org.apache.giraph.scriptLoaderInterface.ScriptLoaderInterface;

public class GiraphArch extends AbstractMyxSimpleBrick
{
    public static final IMyxName msg_ScriptLoaderInterface = MyxUtils.createName("org.apache.giraph.scriptLoaderInterface.ScriptLoaderInterface");

    public ScriptLoaderInterface OUT_ScriptLoaderInterface;

	private IGiraphSingleImp _imp;

    public GiraphArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected IGiraphSingleImp getImplementation(){
        try{
			return new GiraphImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        OUT_ScriptLoaderInterface = (ScriptLoaderInterface) MyxUtils.getFirstRequiredServiceObject(this,msg_ScriptLoaderInterface);
        if (OUT_ScriptLoaderInterface == null){
 			System.err.println("Error: Interface org.apache.giraph.scriptLoaderInterface.ScriptLoaderInterface returned null");
			return;       
        }
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		return null;
	}
}