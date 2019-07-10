package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Banar;

public interface AdmBanarService {

	//导航管理
	public List<Banar> findBanar();//查找导航
	public boolean deleteBanar(int nbanarid);//删除导航
	public boolean addBanar(Banar banar);//添加导航
	public Banar findBanarByid(int banarid);
	public boolean updateBanar(Banar banar);//更新导航
}
