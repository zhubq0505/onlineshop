package java.com.hky.onlineshop.enums;

public enum ProductStateEnum {
	OFFLINE(-1, "商品非法"), DOWN(0, "商品下架"), SUCESS(1, "操作成功"),
	INNER_ERROR(-1001, "操作失败"), EMPTY(-1002, "商品为空");
	private int state;
	private String stateInfo;
	
	private ProductStateEnum(int state, String stateInfo){
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	public static ProductStateEnum stateOf(int index){
		for(ProductStateEnum state:values()){
			if(state.getState() == index){
				return state;
			}
		}
		return null;
	}
}
