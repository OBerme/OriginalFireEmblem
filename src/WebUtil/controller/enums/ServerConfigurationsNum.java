package WebUtil.controller.enums;

public enum ServerConfigurationsNum {
	MIN_ID_NUMBER(0),
	MAX_ID_NUMBER(999),
	SERVER_PORT(6666),
	
	WAIT_CLIENT_PORT(6667);

	private Integer value;
	ServerConfigurationsNum(Integer value) {
        this.value = value;
    }
	
	public Integer getNum() {
		return value;
	}
	
	
	
}
