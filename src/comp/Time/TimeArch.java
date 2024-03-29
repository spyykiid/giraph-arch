package comp.Time;


import edu.uci.isr.myx.fw.AbstractMyxSimpleBrick;
import edu.uci.isr.myx.fw.IMyxName;
import edu.uci.isr.myx.fw.MyxUtils;

import edu.umkc.time.ITime;

import org.apache.giraph.time.Time;

public class TimeArch extends AbstractMyxSimpleBrick implements ITime
{
    public static final IMyxName msg_ITime = MyxUtils.createName("edu.umkc.time.ITime");


	private ITimeImp _imp;

    public TimeArch (){
		_imp = getImplementation();
		if (_imp != null){
			_imp.setArch(this);
		} else {
			System.exit(1);
		}
	}
    
    protected ITimeImp getImplementation(){
        try{
			return new TimeImp();    
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void init(){
        _imp.init();
    }
    
    public void begin(){
        _imp.begin();
    }
    
    public void end(){
        _imp.end();
    }
    
    public void destroy(){
        _imp.destroy();
    }
    
	public Object getServiceObject(IMyxName arg0) {
		if (arg0.equals(msg_ITime)){
			return this;
		}        
		return null;
	}
  
    //To be imported: Time
    public Time getTime ()   {
		return _imp.getTime();
    }    
}