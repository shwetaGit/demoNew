package hrapp.app.server.bean;
import java.util.LinkedHashMap;

import com.spartan.pluggable.logger.alarms.AppAlarm;

public final class ResponseBean extends BeanAdapter {
	
	private final AppAlarm alarm;
	private final LinkedHashMap<String, Object> response;

	public ResponseBean(final AppAlarm _alarm) {
		response = new LinkedHashMap<String, Object>();
		alarm = _alarm;
		deriveStatus();
	}
	
	private void deriveStatus() {
		if(alarm == null) {
			response.put("success", false);
		} else {
			if (alarm.getAlarmStatus() >= 100 && alarm.getAlarmStatus() <= 299) {
				response.put("success", true);
			} else {
				response.put("success", false);
			}
		}
	}
	
	
	
	public AppAlarm getAlarm() {
		return alarm;
	}

	public void add(String key, Object value) {
		response.put(key, value);
	}

	public ResponseBean addAlarm(com.spartan.pluggable.logger.alarms.AppAlarm _appAlarm) {
		response.put("alarm", _appAlarm);
		if (_appAlarm.getAlarmStatus() >= 100 && _appAlarm.getAlarmStatus() <= 299) {
			response.put("success", true);
		} else {
			response.put("success", false);
		}
		
		return this;
	}

	public LinkedHashMap<String, Object> getResponse() {
		return response;
	}
	
	

	@Override
	public String toString() {
		return "ResponseBean [response=" + response + "]";
	}

}
