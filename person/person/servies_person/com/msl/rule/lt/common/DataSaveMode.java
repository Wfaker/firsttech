package com.msl.rule.lt.common;

public class DataSaveMode {
	private boolean saveData;
	
	private boolean saveJson;
	
	public DataSaveMode(int mode) {
		init(mode);
	}
	
	/**
	 * 1--数据保存，默认设置
	 * 2--不保存JSON报文
	 * 3--不保存所有数据
	 * @param mode
	 */
	private void init(int mode) {
		switch (mode) {
			case 1:
				saveData = true;
				saveJson = true;
				break;
			case 2:
				saveData = true;
				saveJson = false;
				break;
			case 3:
				saveData = false;
				saveJson = false;
				break;
			default:
				saveData = true;
				saveJson = true;
				break;
		}
	}

	public boolean isSaveData() {
		return saveData;
	}

	public boolean isSaveJson() {
		return saveJson;
	}
	
}
